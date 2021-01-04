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

public class VeganRestaurant extends Restaurant {
    private static final Types TYPE = Types.VEGAN;
    private static final String PACKAGING_BASE = "vegan carton";
    private static final String PACKAGING_DECORATION = "vegan sticker";
    private static final long PRECISION_COEFFICIENT = 3000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Ingredients.MEAT_SOYA.toString(),
            Ingredients.SAUCE_VEGAN.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_SOYA.toString()),
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_VEGAN.toString())
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
