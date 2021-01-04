package strategy;

import common.*;
import enums.Clothings;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClothingFactory {

    private Map<Clothings, List<Material>> clothings = new HashMap<Clothings, List<Material>>();
    private List<Clothings> catalog = new ArrayList<Clothings>();
    private ProductionStrategy productionStrategy = CheapProductionStrategy.getInstance();
    private EventStrategy eventStrategy = NormalEventStrategy.getInstance();
    private List<Event> teamBuildingEvents = new ArrayList<>();

    public ClothingFactory(ProductionStrategy productionStrategy, EventStrategy eventStrategy) {
        if (productionStrategy != null) {
            this.productionStrategy = productionStrategy;
        }
        if (eventStrategy != null) {
            this.eventStrategy = eventStrategy;
        }
    }

    public Clothing makeClothing(Clothings name) throws InterruptedException {
        Clothing clothing = new Clothing(name, productionStrategy.getType());
        clothing.setMaterials(collectMaterials(name));
        Thread.sleep(productionStrategy.getPrecisionCoefficient());
        Product product = Utils.clothingToProduct(clothing);
        productionStrategy.wrap(product);
        return Utils.productToClothing(product);
    }

    public List<Clothings> getCatalog() {
        return catalog;
    }

    public void addCatalogSelection(Clothings clothingName, List<Material> standardMaterials) {
        catalog.add(clothingName);
        clothings.put(clothingName, standardMaterials);
    }

    public void changeProductionStrategy(ProductionStrategy strategy) {
        this.productionStrategy = strategy;
    }

    public void changeEventStrategy(EventStrategy strategy) {
        this.eventStrategy = strategy;
    }

    public void organizeEvent(int budget, int numberOfAttendees) {
        Event event = new Event(budget, numberOfAttendees);
        event.setDateTime(LocalDateTime.of(2020, 12, 23, 12, 30));
        event.setType(eventStrategy.getType());
        String place = eventStrategy.getPlace(budget, numberOfAttendees);
        event.setPlace(place);
        event.setDressCode(eventStrategy.getDressCode(place));
        teamBuildingEvents.add(event);
    }

    public List<Event> getEvents() {
        return teamBuildingEvents;
    }

    private List<Material> collectMaterials(Clothings clothing) {
        return Utils
                .itemsToMaterials(
                        productionStrategy.adjustItemList(
                                Utils.materialsToItems(
                                        clothings.get(clothing)
                                )
                        )
                );
    }
}
