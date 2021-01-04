package templateMethod;

import common.Dish;
import common.Ingredient;
import common.Product;
import common.Utils;
import enums.Dishes;
import enums.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Restaurant {
    private Map<Dishes, List<Ingredient>> dishes = new HashMap<>();
    private List<Dishes> menu = new ArrayList<>();

    public Dish makeDish(Dishes name) throws InterruptedException{
        Dish dish = new Dish(name, getType());
        dish.setIngredients(adjustIngredientList(dishes.get(name)));
        Thread.sleep(getPrecisionCoefficient());
        wrap(dish);
        return dish;
    }

    public void addDishSelection(Dishes name, List<Ingredient> standardIngredients) {
        menu.add(name);
        dishes.put(name, standardIngredients);
    }

    public List<Dishes> getMenu() {
        return menu;
    }

    abstract Types getType();

    abstract List<Ingredient> adjustIngredientList(List<Ingredient> ingredients);

    abstract long getPrecisionCoefficient();

    abstract void wrap(Dish dish);
}
