import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String [] args ){
        System.out.println("Hello to the Collections of Java Course");

        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(">>Override toString() method in Collection class\n"+products); //Using overrided tostring method

        //Iterator Interface
        /*
         * Iterator Interface is useful
         * if we want to iterate and modify in the same collection
         * */
        System.out.println("\n>>>Using Iterator interface");
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()){
            Product prod = productIterator.next();
            if(prod.getWeight() > 20) {
                //System.out.println(prod);
            }
            else
                productIterator.remove();
        }
        System.out.println("All products after remove: " + products);

        System.out.println("size of the products:" + products.size());
        System.out.println("Products collection is empty? " + products.isEmpty());
        System.out.println("Products collection contains window? " + products.contains(window));
        System.out.println("Products collection contains door? " + products.contains(door));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.addAll(products);
        products.removeAll(otherProducts);
        System.out.println("After removeAll(): " + products);

        //using foreach
        /*
         * Foreach cannot be used in a collection
         * if we iterate and modify the same collection
         * */
        System.out.println("\n>>>Using foreach loop");
        for(Product prod : otherProducts){
            System.out.println(prod);
        }
    }
}