package additional;

public class Vocab {
    public String l1, l2;

    public Vocab(String lang1, String lang2) {
        this.l1 = lang1;
        this.l2 = lang2;
    }

    // TODO: 20.05.2019 Probably unnecessary
    public String getTranslation() {
        return this.l2;
    }

    public String getVocab() {
        return this.l1 + "," + this.l2;
    }
    public static Vocab fromString(String s) { return new Vocab(s.split(",")[0], s.split(",")[1]); }
}
