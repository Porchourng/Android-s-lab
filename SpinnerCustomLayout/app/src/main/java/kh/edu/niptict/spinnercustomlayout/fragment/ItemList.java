package kh.edu.niptict.spinnercustomlayout.fragment;

public class ItemList {
    private int flagCountry;
    private int nameCountry;

    public ItemList(int flagCountry, int nameCountry) {
        this.flagCountry = flagCountry;
        this.nameCountry = nameCountry;
    }

    public int getFlagCountry() {
        return flagCountry;
    }

    public void setFlagCountry(int flagCountry) {
        this.flagCountry = flagCountry;
    }

    public int getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(int nameCountry) {
        this.nameCountry = nameCountry;
    }
}
