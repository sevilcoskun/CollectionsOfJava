package main.sets;

import main.Product;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product> {
    //private final Set<Product> products = new HashSet<>();
    //private final Set<Product> products = new TreeSet<>(Product.BY_NAME);
    private final SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);


    public void isSuppliedBy(Supplier supplier){
        products.addAll(supplier.products());
    }

    public Set<Product> lightVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviestLightVanProduct);
    }

    public Set<Product> heavyVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.tailSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {
        for(Product product : products){
            if(product.getWeight() > 20){
                return product;
            }
        }
        return products.last();
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
