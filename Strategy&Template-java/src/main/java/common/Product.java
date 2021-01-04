package common;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private List<Item> parts = new ArrayList<>();
    private final String NAME;
    private final String TYPE;
    private Packaging packaging = null;

    public Product(String name, String type) {
        this.NAME = name;
        this.TYPE = type;
    }

    public List<Item> getParts() {
        return parts;
    }

    public void setParts(List<Item> parts) {
        this.parts = parts;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public String getNAME() {
        return NAME;
    }

    public String getTYPE() {
        return TYPE;
    }
}
