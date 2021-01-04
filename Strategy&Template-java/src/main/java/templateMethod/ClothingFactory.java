package templateMethod;

import common.*;
import enums.Clothings;
import enums.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ClothingFactory {

    private Map<Clothings, List<Material>> clothings = new HashMap<Clothings, List<Material>>();
    private List<Clothings> catalog = new ArrayList<Clothings>();
    List<Event> teamBuildingEvents = new ArrayList<>();

    public Clothing makeClothing(Clothings name) throws InterruptedException {
        Clothing clothing = new Clothing(name, getType());
        clothing.setMaterials(adjustMaterialList(clothings.get(name)));
        Thread.sleep(getPrecisionCoefficient());
        wrap(clothing);
        return clothing;
    }

    public void addCatalogSelection(Clothings name, List<Material> standardMaterials) {
        clothings.put(name, standardMaterials);
        catalog.add(name);
    }

    public List<Clothings> getCatalog() {
        return catalog;
    }

    abstract Types getType();

    abstract List<Material> adjustMaterialList(List<Material> materials);

    abstract long getPrecisionCoefficient();

    abstract void wrap(Clothing clothing);

    public abstract void organizeEvent(int budget, int numberOfAttendees);

    public List<Event> getEvents() {
        return teamBuildingEvents;
    }
}
