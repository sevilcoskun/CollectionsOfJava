package main.maps;


public interface ProductLookupTable {

    void addProduct(ProductMap productToAdd) throws IllegalAccessException;

    ProductMap lookupById(int id);

    void clear();
}
