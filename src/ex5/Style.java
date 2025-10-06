package src.ex5;

class Style implements Cloneable {

    String primaryColor;
    String fontFamily;
    String logoPath;

    public Style(String color, String font, String logo) {
        this.primaryColor = color;
        this.fontFamily = font;
        this.logoPath = logo;
    }

    @Override
    protected Style clone() {
        return new Style(primaryColor, fontFamily, logoPath);
    }

    @Override
    public String toString() {
        return "Style{color=%s, font=%s, logo=%s}".formatted(primaryColor, fontFamily, logoPath);
    }
}
