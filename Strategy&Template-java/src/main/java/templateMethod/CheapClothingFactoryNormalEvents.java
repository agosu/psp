package templateMethod;

import common.Clothing;
import common.Event;
import common.Material;
import enums.Types;

import java.util.List;

public class CheapClothingFactoryNormalEvents extends ClothingFactory {
    private static final Types TYPE = Types.CHEAP;

    Types getType() {
        return TYPE;
    }

    List<Material> adjustMaterialList(List<Material> materials) {
        return CheapProduction.adjustMaterialList(materials);
    }

    long getPrecisionCoefficient() {
        return CheapProduction.getPrecisionCoefficient();
    }

    void wrap(Clothing clothing) {
        CheapProduction.wrap(clothing);
    }

    public void organizeEvent(int budget, int numberOfAttendees) {
        Event event = NormalEvents.createEvent(budget, numberOfAttendees);
        teamBuildingEvents.add(event);
    }
}
