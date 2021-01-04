package common;

import enums.Dishes;
import enums.Types;

import java.util.List;

public class Dish {
    private List<Ingredient> ingredients;
    private final Dishes NAME;
    private final Types TYPE;
    private Packaging packaging = null;

    public Dish(Dishes name, Types type) {
        this.NAME = name;
        this.TYPE = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public Dishes getName() {
        return NAME;
    }

    public Types getType() {
        return TYPE;
    }
}
