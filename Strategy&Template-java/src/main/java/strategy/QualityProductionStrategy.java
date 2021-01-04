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

public class QualityProductionStrategy implements ProductionStrategy {

    private static final String PACKAGING_BASE = "expensive carton";
    private static final String PACKAGING_DECORATION = "silver ribbon";
    private static final Types TYPE = Types.QUALITY;
    private static final long PRECISION_COEFFICIENT = 5000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Materials.COTTON_VEGAN.toString(),
            Materials.LEATHER_ARTIFICIAL.toString(),
            Ingredients.MEAT_QUALITY.toString(),
            Ingredients.SAUCE_QUALITY.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Materials.COTTON.toString(), Materials.COTTON_VEGAN.toString()),
            Map.entry(Materials.LEATHER_REAL.toString(), Materials.LEATHER_ARTIFICIAL.toString()),
            Map.entry(Ingredients.SAUCE.toString(), Ingredients.SAUCE_QUALITY.toString()),
            Map.entry(Ingredients.MEAT.toString(), Ingredients.MEAT_QUALITY.toString())
    );

    private static QualityProductionStrategy instance;

    public static QualityProductionStrategy getInstance() {
        if (instance == null) {
            instance = new QualityProductionStrategy();
        }
        return instance;
    }

    private QualityProductionStrategy() {}

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
