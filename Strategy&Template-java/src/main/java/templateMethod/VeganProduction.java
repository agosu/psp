package templateMethod;

import common.Clothing;
import common.Material;
import common.Packaging;
import enums.Materials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VeganProduction {
    private static final String PACKAGING_BASE = "vegan carton";
    private static final String PACKAGING_DECORATION = "vegan sticker";
    private static final long PRECISION_COEFFICIENT = 3000;

    private static final List<String> SUITABLE_ITEMS = List.of(
            Materials.COTTON_VEGAN.toString(),
            Materials.LEATHER_REAL.toString()
    );

    private static final Map<String, String> REPLACEMENTS = Map.ofEntries(
            Map.entry(Materials.COTTON.toString(), Materials.SILK.toString()),
            Map.entry(Materials.LEATHER_REAL.toString(), Materials.LEATHER_REAL.toString())
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
