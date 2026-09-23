import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {

    public static int calculateEditDistance(String firstWord, String secondWord) {
        int[][] table = new int[firstWord.length() + 1][secondWord.length() + 1];

        for (int row = 0; row < table.length; row++) {
            table[row][0] = row;
        }

        for (int column = 0; column < table[0].length; column++) {
            table[0][column] = column;
        }

        for (int row = 1; row < table.length; row++) {
            for (int column = 1; column < table[row].length; column++) {
                if (firstWord.charAt(row - 1) == secondWord.charAt(column - 1)) {
                    table[row][column] = table[row - 1][column - 1];
                } else {
                    int above = table[row - 1][column];
                    int left = table[row][column - 1];
                    int diagonal = table[row - 1][column - 1];
                    table[row][column] = Math.min(above, Math.min(left, diagonal)) + 1;
                }
            }
        }

        return table[firstWord.length()][secondWord.length()];
    }

    public static void updateCandidates(ArrayList<Word> candidates, Word newWord) {
        int position = 0;

        while (position < candidates.size()
                && newWord.editDistance > candidates.get(position).editDistance) {
            position++;
        }

        candidates.add(position, newWord);

        if (candidates.size() == 6) {
            candidates.remove(5);
        }
    }

    public static void spellCheckSentence(
            ArrayList<String> dictionary,
            String sentence,
            Scanner input) {

        sentence = sentence.toLowerCase();
        String[] words = sentence.split(" ");

        for (int index = 0; index < words.length; index++) {
            String currentWord = words[index];

            if (dictionary.contains(currentWord)) {
                continue;
            }

            ArrayList<Word> candidates = new ArrayList<>();

            for (String dictionaryWord : dictionary) {
                int distance = calculateEditDistance(currentWord, dictionaryWord);
                Word candidate = new Word(currentWord, dictionaryWord, distance);
                updateCandidates(candidates, candidate);
            }

            System.out.println("'" + currentWord + "' not in dictionary. Pick an option:");

            for (int i = 0; i < candidates.size(); i++) {
                System.out.println(i + ". Replace with '" + candidates.get(i).candidateWord + "'");
            }

            System.out.println("5. Add '" + currentWord + "' to dictionary");

            int choice;

            while (true) {
                try {
                    choice = Integer.parseInt(input.nextLine());

                    if (choice >= 0 && choice <= 5) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Invalid input handled below.
                }

                System.out.println("Invalid option. Try again.");
            }

            if (choice == 5) {
                dictionary.add(currentWord);
                System.out.println("'" + currentWord + "' added to dictionary");
            } else {
                String replacement = candidates.get(choice).candidateWord;
                words[index] = replacement;
                System.out.println("Replaced '" + currentWord + "' with '" + replacement + "'");
            }
        }

        System.out.print("The final sentence is: '");

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);

            if (i < words.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println("'");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> dictionary = Dictionary.getDictionary();

        while (true) {
            System.out.print("[Spell Checker]\n"
                    + "Enter a sentence to spell-check, or nothing to quit: ");

            String sentence = input.nextLine();

            System.out.println("You've entered '" + sentence + "'");

            if (sentence.isEmpty()) {
                System.out.println("Shutting off...");
                break;
            }

            spellCheckSentence(dictionary, sentence, input);
        }

        input.close();
    }
}
