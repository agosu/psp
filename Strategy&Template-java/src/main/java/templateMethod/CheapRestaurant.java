package templateMethod;

import common.Dish;
import common.Ingredient;
import common.Material;
import common.Packaging;
import enums.Ingredients;
import enums.Materials;
import enums.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheapRestaurant extends Restaurant {
    private static final Types TYPE = Types.CHEAP;
    private static final String PACKAGING_BASE = "carton";
    private static final String PACKAGING_DECORATION = null;
    private static final long PRECISION_COEFFICIENT = 1200;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Ingredients.MEAT_CHEAP.toString(),
            Ingredients.SAUCE_CHEAP.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_CHEAP.toString()),
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_CHEAP.toString())
    );

    Types getType() {
        return TYPE;
    }

    List<Ingredient> adjustIngredientList(List<Ingredient> ingredients) {
        List<Ingredient> adjustedIngredients = new ArrayList<>();
        for(Ingredient ingredient : ingredients) {
            adjustedIngredients.add(new Ingredient(Ingredients.valueOf(REPLACEMENTS.get(ingredient.getName().toString()))));
        }
        return adjustedIngredients;
    }

    long getPrecisionCoefficient() {
        return PRECISION_COEFFICIENT;
    }

    void wrap(Dish dish) {
        dish.setPackaging(new Packaging(PACKAGING_BASE, PACKAGING_DECORATION));
    }
}
