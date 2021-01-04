package templateMethod;

import common.Clothing;
import common.Event;
import common.Material;
import enums.Types;

import java.util.List;

public class VeganClothingFactoryCrazyEvents extends ClothingFactory {
    private static final Types TYPE = Types.VEGAN;

    Types getType() {
        return TYPE;
    }

    List<Material> adjustMaterialList(List<Material> materials) {
        return VeganProduction.adjustMaterialList(materials);
    }

    long getPrecisionCoefficient() {
        return VeganProduction.getPrecisionCoefficient();
    }

    void wrap(Clothing clothing) {
        VeganProduction.wrap(clothing);
    }

    public void organizeEvent(int budget, int numberOfAttendees) {
        Event event = CrazyEvents.createEvent(budget, numberOfAttendees);
        teamBuildingEvents.add(event);
    }
}

