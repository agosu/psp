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

public class CheapProductionStrategy implements ProductionStrategy {

    private static final String PACKAGING_BASE = "carton";
    private static final String PACKAGING_DECORATION = null;
    private static final Types TYPE = Types.CHEAP;
    private static final long PRECISION_COEFFICIENT = 1200;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Materials.COTTON_CHEAP.toString(),
            Materials.LEATHER_ARTIFICIAL.toString(),
            Ingredients.MEAT_CHEAP.toString(),
            Ingredients.SAUCE_CHEAP.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Materials.COTTON.toString(), Materials.COTTON_CHEAP.toString()),
            Map.entry(Materials.LEATHER_REAL.toString(), Materials.LEATHER_ARTIFICIAL.toString()),
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_CHEAP.toString()),
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_CHEAP.toString())
    );

    private static CheapProductionStrategy instance;

    public static CheapProductionStrategy getInstance() {
        if (instance == null) {
            instance = new CheapProductionStrategy();
        }
        return instance;
    }

    private CheapProductionStrategy() {}

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
