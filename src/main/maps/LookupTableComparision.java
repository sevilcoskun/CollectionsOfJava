package main.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparision {

    public static final int ITERATIONS = 5;
    private static final int NUMBER_OF_PRODUCTS = 20_000;

    private static final List<ProductMap> products = generateProducts();

    public static void main(String[] args) throws IllegalAccessException {
        runLookups(new NativeProductLookupTable());
        runLookups(new MapProductLookupTable());
    }

    private static List<ProductMap> generateProducts(){
        final List<ProductMap> products = new ArrayList<ProductMap>();
        final Random weightGenerator = new Random();
        for(int i = 0; i < NUMBER_OF_PRODUCTS; i++){
            products.add(new ProductMap(i, "Product" + i, 10 + weightGenerator.nextInt(10)));
        }
        Collections.shuffle(products);
        Collections.shuffle(products);
        //Collections.shuffle(products);
        return products;
    }

    private static void runLookups(final ProductLookupTable lookupTable) throws IllegalAccessException {
        final List<ProductMap> products = LookupTableComparision.products;
        System.out.println("Running loops with " + lookupTable.getClass().getSimpleName());

        for(int i = 0; i < ITERATIONS; i++){
            final long startTime = System.currentTimeMillis();

            for(ProductMap product : products){
                lookupTable.addProduct(product);
            }
            for(ProductMap product : products){
                final ProductMap result = lookupTable.lookupById(product.getId());
                if(result != product){
                    throw new IllegalAccessException("Lookup Table returned wrong");
                }
            }
            lookupTable.clear();
            System.out.println(System.currentTimeMillis() - startTime + "ms");
        }
    }
}
