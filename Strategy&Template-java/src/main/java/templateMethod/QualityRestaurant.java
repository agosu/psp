package templateMethod;

import common.Dish;
import common.Ingredient;
import common.Packaging;
import enums.Ingredients;
import enums.Materials;
import enums.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QualityRestaurant extends Restaurant {
    private static final Types TYPE = Types.QUALITY;
    private static final String PACKAGING_BASE = "expensive carton";
    private static final String PACKAGING_DECORATION = "silver ribbon";
    private static final long PRECISION_COEFFICIENT = 5000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Ingredients.MEAT_QUALITY.toString(),
            Ingredients.SAUCE_QUALITY.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_QUALITY.toString()),
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_QUALITY.toString())
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
