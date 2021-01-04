package templateMethod;

import common.Clothing;
import common.Material;
import common.Packaging;
import enums.Materials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QualityProduction {
    private static final String PACKAGING_BASE = "expensive carton";
    private static final String PACKAGING_DECORATION = "silver ribbon";
    private static final long PRECISION_COEFFICIENT = 5000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Materials.COTTON_VEGAN.toString(),
            Materials.LEATHER_ARTIFICIAL.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Materials.COTTON.toString(), Materials.COTTON_VEGAN.toString()),
            Map.entry(Materials.LEATHER_REAL.toString(), Materials.LEATHER_ARTIFICIAL.toString())
    );

    public static List<Material> adjustMaterialList(List<Material> materials) {
        List<Material> adjustedMaterials = new ArrayList<>();
        for(Material material : materials) {
            adjustedMaterials.add(new Material(Materials.valueOf(REPLACEMENTS.get(material.getName().toString()))));
        }
        return adjustedMaterials;
    }

    public static long getPrecisionCoefficient() {
        return PRECISION_COEFFICIENT;
    }

    public static void wrap(Clothing clothing) {
        clothing.setPackaging(new Packaging(PACKAGING_BASE, PACKAGING_DECORATION));
    }
}
