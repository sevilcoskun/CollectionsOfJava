package main.maps;

import java.util.ArrayList;
import java.util.List;

public class NativeProductLookupTable implements ProductLookupTable{

    private List<ProductMap> products = new ArrayList<ProductMap>();

    @Override
    public void addProduct(ProductMap productToAdd) throws IllegalAccessException {
        for(ProductMap product : products){
            if(product.getId() == productToAdd.getId()){
                throw new IllegalAccessException("Unable to add this product, because duplicate id for " + productToAdd);
            }
        }
        products.add(productToAdd);
    }

    @Override
    public ProductMap lookupById(final int id){

        for(ProductMap product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public void clear(){
        products.clear();
    }
}
