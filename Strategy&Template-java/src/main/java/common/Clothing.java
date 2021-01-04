package common;

import enums.Clothings;
import enums.Types;

import java.util.List;

public class Clothing {

    private final Clothings NAME;
    private final Types TYPE;
    private Packaging packaging = null;
    private List<Material> materials;

    public Clothing(Clothings name, Types type) {
        this.NAME = name;
        this.TYPE = type;
    }

    public Clothings getName() {
        return NAME;
    }

    public Types getType() {
        return TYPE;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
