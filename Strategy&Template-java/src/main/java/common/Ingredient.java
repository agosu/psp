package common;

import enums.Ingredients;

public class Ingredient {
    private final Ingredients NAME;

    public Ingredient(Ingredients name) {
        this.NAME = name;
    }

    public Ingredients getName() {
        return NAME;
    }
}
