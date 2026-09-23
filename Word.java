public class Word {
    public String originalWord;
    public String candidateWord;
    public int editDistance;

    public Word(String originalWord, String candidateWord, int editDistance) {
        this.originalWord = originalWord;
        this.candidateWord = candidateWord;
        this.editDistance = editDistance;
    }
}
