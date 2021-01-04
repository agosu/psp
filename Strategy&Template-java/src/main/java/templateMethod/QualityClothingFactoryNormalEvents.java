package templateMethod;

import common.Clothing;
import common.Event;
import common.Material;
import enums.Types;

import java.util.List;

public class QualityClothingFactoryNormalEvents extends ClothingFactory {
    private static final Types TYPE = Types.QUALITY;

    Types getType() {
        return TYPE;
    }

    List<Material> adjustMaterialList(List<Material> materials) {
        return QualityProduction.adjustMaterialList(materials);
    }

    long getPrecisionCoefficient() {
        return QualityProduction.getPrecisionCoefficient();
    }

    void wrap(Clothing clothing) {
        QualityProduction.wrap(clothing);
    }

    public void organizeEvent(int budget, int numberOfAttendees) {
        Event event = NormalEvents.createEvent(budget, numberOfAttendees);
        teamBuildingEvents.add(event);
    }
}
