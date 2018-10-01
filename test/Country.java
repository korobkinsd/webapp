package system.model;

public class Country {

    private String lang;

    public String getCountry() {
        return lang;
    }

    public void setCountry(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return  lang;
    }
}
