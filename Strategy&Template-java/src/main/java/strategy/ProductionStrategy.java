package strategy;

import common.Item;
import common.Product;
import enums.Types;

import java.util.List;

public interface ProductionStrategy {
    List<Item> adjustItemList(List<Item> items);
    long getPrecisionCoefficient();
    void wrap(Product product);
    Types getType();
}
