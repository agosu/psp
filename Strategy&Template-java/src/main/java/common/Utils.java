package common;

import enums.*;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Item materialToItem(Material material) {
        return new Item(material.getName().toString());
    }

    public static List<Item> materialsToItems(List<Material> materials) {
        List<Item> items = new ArrayList<Item>();
        for(Material material : materials) {
            items.add(materialToItem(material));
        }
        return items;
    }

    public static Material itemToMaterial(Item item) {
        return new Material(Materials.valueOf(item.getName()));
    }

    public static  List<Material> itemsToMaterials(List<Item> items) {
        List<Material> materials = new ArrayList<Material>();
        for(Item item : items) {
            materials.add(itemToMaterial(item));
        }
        return materials;
    }

    public static Item ingredientToItem(Ingredient ingredient) {
        return new Item(ingredient.getName().toString());
    }

    public static List<Item> ingredientsToItems(List<Ingredient> ingredients) {
        List<Item> items = new ArrayList<>();
        for(Ingredient ingredient : ingredients) {
            items.add(ingredientToItem(ingredient));
        }
        return items;
    }

    public static Ingredient itemToIngredient(Item item) {
        return new Ingredient(Ingredients.valueOf(item.getName()));
    }

    public static List<Ingredient> itemsToIngredients(List<Item> items) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(Item item : items) {
            ingredients.add(itemToIngredient(item));
        }
        return ingredients;
    }

    public static Clothing productToClothing(Product product) {
        Clothing clothing = new Clothing(Clothings.valueOf(product.getNAME()), Types.valueOf(product.getTYPE()));
        clothing.setMaterials(itemsToMaterials(product.getParts()));
        clothing.setPackaging(product.getPackaging());
        return clothing;
    }

    public static Product clothingToProduct(Clothing clothing) {
        Product product = new Product(clothing.getName().toString(), clothing.getType().toString());
        product.setParts(materialsToItems(clothing.getMaterials()));
        product.setPackaging(clothing.getPackaging());
        return product;
    }

    public static Dish productToDish(Product product) {
        Dish dish = new Dish(Dishes.valueOf(product.getNAME()), Types.valueOf(product.getTYPE()));
        dish.setIngredients(itemsToIngredients(product.getParts()));
        dish.setPackaging(product.getPackaging());
        return dish;
    }

    public static Product dishToProduct(Dish dish) {
        Product product = new Product(dish.getName().toString(), dish.getType().toString());
        product.setParts(ingredientsToItems(dish.getIngredients()));
        product.setPackaging(dish.getPackaging());
        return product;
    }
}
