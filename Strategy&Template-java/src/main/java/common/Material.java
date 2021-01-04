package common;

import enums.Materials;

public class Material {
    private final Materials NAME;

    public Material(Materials name) {
        this.NAME = name;
    }

    public Materials getName() {
        return NAME;
    }
}
