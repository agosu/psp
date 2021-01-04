package strategy;

import common.Item;
import common.Packaging;
import common.Product;
import enums.Ingredients;
import enums.Materials;
import enums.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VeganProductionStrategy implements ProductionStrategy {

    private static final String PACKAGING_BASE = "vegan carton";
    private static final String PACKAGING_DECORATION = "vegan sticker";
    private static final Types TYPE = Types.VEGAN;
    private static final long PRECISION_COEFFICIENT = 3000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Materials.COTTON_VEGAN.toString(),
            Materials.LEATHER_REAL.toString(),
            Ingredients.MEAT_SOYA.toString(),
            Ingredients.SAUCE_VEGAN.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Materials.COTTON.toString(), Materials.SILK.toString()),
            Map.entry(Materials.LEATHER_REAL.toString(), Materials.LEATHER_REAL.toString()),
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_SOYA.toString()),
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_VEGAN.toString())
    );

    private static VeganProductionStrategy instance;

    public static VeganProductionStrategy getInstance() {
        if (instance == null) {
            instance = new VeganProductionStrategy();
        }
        return instance;
    }

    private VeganProductionStrategy() {}

    public List<Item> adjustItemList(List<Item> items) {
        List<Item> adjustedItems = new ArrayList<>();
        for(Item item : items) {
            adjustedItems.add(new Item(REPLACEMENTS.get(item.getName())));
        }
        return adjustedItems;
    }

    public long getPrecisionCoefficient() {
        return PRECISION_COEFFICIENT;
    }

    public void wrap(Product product) {
        product.setPackaging(new Packaging(PACKAGING_BASE, PACKAGING_DECORATION));
    }

    public Types getType() {
        return TYPE;
    }
}
