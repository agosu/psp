package strategy;

import common.Dish;
import common.Ingredient;
import common.Product;
import common.Utils;
import enums.Dishes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private Map<Dishes, List<Ingredient>> dishes = new HashMap<>();
    private List<Dishes> menu = new ArrayList<>();
    private ProductionStrategy productionStrategy;

    public Restaurant(ProductionStrategy strategy) {
        this.productionStrategy = strategy;
    }

    public Dish makeDish(Dishes name) throws InterruptedException {
        Dish dish = new Dish(name, productionStrategy.getType());
        dish.setIngredients(collectIngredients(name));
        Thread.sleep(productionStrategy.getPrecisionCoefficient());
        Product product = Utils.dishToProduct(dish);
        productionStrategy.wrap(product);
        return Utils.productToDish(product);
    }

    public void addDishSelection(Dishes dish, List<Ingredient> standardIngredients) {
        menu.add(dish);
        dishes.put(dish, standardIngredients);
    }

    public List<Dishes> getMenu() {
        return menu;
    }

    public void changeStrategy(ProductionStrategy strategy) {
        this.productionStrategy = strategy;
    }

    private List<Ingredient> collectIngredients(Dishes dish) {
        return Utils
                .itemsToIngredients(
                        productionStrategy.adjustItemList(
                                Utils.ingredientsToItems(
                                        dishes.get(dish)
                                )
                        )
                );
    }
}
