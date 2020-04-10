package main.maps;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable{

    private final Map<Integer, ProductMap> idToProduct = new HashMap<>();

    @Override
    public void addProduct(ProductMap productToAdd) throws IllegalAccessException {
        final int id = productToAdd.getId();
        if(idToProduct.containsKey(id)){
            throw new IllegalAccessException("Unable to add this product, because duplicate id for " + productToAdd);
        }
        idToProduct.put(id, productToAdd);
    }

    @Override
    public ProductMap lookupById(int id) {
        return idToProduct.get(id);
    }

    @Override
    public void clear() {
        idToProduct.clear();
    }
}
