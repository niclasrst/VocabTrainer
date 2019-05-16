package additional;

public class Vocab {
    public String l1, l2;

    public Vocab(String lang1, String lang2) {
        this.l1 = lang1;
        this.l2 = lang2;
    }

    public String getTranslation(String l1) {
        if (l1 ==this.l1) { return this.l2; }
        else if (l1 == this.l2) { return this.l1; }
        return "No given translation";
    }

    public String getVocab() {
        return this.l1 + "," + this.l2;
    }
}
