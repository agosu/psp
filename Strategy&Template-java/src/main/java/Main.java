import common.*;
import enums.Clothings;
import enums.Dishes;
import enums.Ingredients;
import enums.Materials;
import strategy.*;
import templateMethod.CheapClothingFactoryCrazyEvents;
import templateMethod.CheapRestaurant;

import java.util.List;

public class Main {
    public static void main(String []args) throws InterruptedException {
        strategyExample();
        templateMethodExample();
    }

    private static void strategyExample() throws InterruptedException {
        System.out.println("STRATEGY");
        ClothingFactory clothingFactory = new ClothingFactory(CheapProductionStrategy.getInstance(), null);
        clothingFactory.addCatalogSelection(Clothings.DRESS, List.of(new Material(Materials.COTTON), new Material(Materials.LEATHER_REAL)));
        //clothingFactory.getCatalog();
        showClothing(clothingFactory.makeClothing(Clothings.DRESS));
        clothingFactory.changeProductionStrategy(QualityProductionStrategy.getInstance());
        showClothing(clothingFactory.makeClothing(Clothings.DRESS));

        Restaurant restaurant = new Restaurant(CheapProductionStrategy.getInstance());
        restaurant.addDishSelection(Dishes.PIZZA, List.of(new Ingredient(Ingredients.MEAT), new Ingredient(Ingredients.SAUCE)));
        //restaurant.getMenu();
        showDish(restaurant.makeDish(Dishes.PIZZA));
        restaurant.changeStrategy(QualityProductionStrategy.getInstance());
        showDish(restaurant.makeDish(Dishes.PIZZA));

        clothingFactory.changeEventStrategy(CrazyEventStrategy.getInstance());
        clothingFactory.organizeEvent(500, 80);
        showEvents(clothingFactory.getEvents());
    }

    private static void templateMethodExample() throws InterruptedException {
        System.out.println("TEMPLATE METHOD");
        templateMethod.ClothingFactory clothingFactory = new CheapClothingFactoryCrazyEvents();
        clothingFactory.addCatalogSelection(Clothings.DRESS, List.of(new Material(Materials.COTTON), new Material(Materials.LEATHER_REAL)));
        //clothingFactory.getCatalog();
        showClothing(clothingFactory.makeClothing(Clothings.DRESS));
        clothingFactory.organizeEvent(211, 54);
        showEvents(clothingFactory.getEvents());

        templateMethod.Restaurant restaurant = new CheapRestaurant();
        restaurant.addDishSelection(Dishes.PIZZA, List.of(new Ingredient(Ingredients.MEAT), new Ingredient(Ingredients.SAUCE)));
        //restaurant.getMenu();
        showDish(restaurant.makeDish(Dishes.PIZZA));
    }

    private static void showClothing(Clothing clothing) {
        System.out.println("Showing a clothing...");
        System.out.println("Name: " + clothing.getName());
        System.out.println("Type: " + clothing.getType());
        System.out.println("Materials: ");
        for(Material material : clothing.getMaterials()) {
            System.out.println("    " + material.getName());
        }
        System.out.println("Packaging: ");
        System.out.println("    base: " + clothing.getPackaging().getBase());
        System.out.println("    decoration: " + clothing.getPackaging().getDecoration());
        System.out.println();
    }

    private static void showDish(Dish dish) {
        System.out.println("Showing a dish...");
        System.out.println("Name: " + dish.getName());
        System.out.println("Type: " + dish.getType());
        System.out.println("Ingredients: ");
        for(Ingredient ingredient : dish.getIngredients()) {
            System.out.println("    " + ingredient.getName());
        }
        System.out.println("Packaging: ");
        System.out.println("    base: " + dish.getPackaging().getBase());
        System.out.println("    decoration: " + dish.getPackaging().getDecoration());
        System.out.println();
    }

    private static void showEvents(List<Event> events) {
        System.out.println("Showing events...");
        for (Event event : events) {
            System.out.println("Type: " + event.getType());
            System.out.println("Place: " + event.getPlace());
            System.out.println("Dress code: " + event.getDressCode());
            System.out.println("Budget: " + event.getBudget());
            System.out.println("Number of attendees: " + event.getNumberOfAttendees());
            System.out.println();
        }
    }
}
