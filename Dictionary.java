import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    public static ArrayList<String> getDictionary(){
        return readDictFile();
    }

































/*
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
*/
    private static class EmptyCollectionException extends Exception{}

    private static ArrayList<String> readDictFile(){
        File dict = new File("src" + File.separator + "dictionary.txt");
        ArrayList<String> dictionary = new ArrayList<>(10000);

        try(Scanner sc = new Scanner(dict)){
            while(sc.hasNextLine()) dictionary.add(sc.nextLine());

            if(dictionary.isEmpty()) throw new EmptyCollectionException();
        }
        catch(FileNotFoundException e){
            System.err.println("'dictionary.txt' must be inside your 'src' folder.");
            System.exit(-1);
        }
        catch(EmptyCollectionException e){
            System.err.println("'dictionary.txt' is empty.");
            System.exit(-1);
        }
        catch(Exception e){
            System.err.println("An unknown error has occurred: " + e.getMessage());
            System.exit(-1);
        }

        return dictionary;
    }
}
