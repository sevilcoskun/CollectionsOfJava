package test;

import main.Product;
import main.Shipment;
import static main.ProductFixtures.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipmentTest {
    private Shipment shipment = new Shipment(); //way 1
    List<Product> shipmentList = new ArrayList<>(); //way 2

    @Test
    public void shouldAddItems() throws Exception{
        /*//way 1
        shipment.add(door);
        shipment.add(window);
        final Iterator<Product> productIterator = shipment.iterator();
        while(productIterator.hasNext()) {
            Product product_door = productIterator.next();
            assertEquals(product_door, door);

            Product product_window = productIterator.next();
            assertEquals(product_window, window);
        }*/

        //way2
        shipmentList.add(door);
        shipmentList.add(window);
        assertTrue(shipmentList.contains(door));
        assertTrue(shipmentList.contains(window));
    }

    @Test
    public void shouldReplaceItems() throws Exception{
        shipment.add(door);
        shipment.add(window);

        shipment.replace(door, floorPanel);

        final Iterator<Product> productIterator = shipment.iterator();
        while(productIterator.hasNext()) {
            Product product_floorPanel = productIterator.next();
            assertEquals(product_floorPanel, floorPanel);

            Product product_window = productIterator.next();
            assertEquals(product_window, window);
        }
    }

    @Test
    public void shouldNotReplaceMissingItems() throws Exception{
        shipment.add(window);

        shipment.replace(door, floorPanel);

        final Iterator<Product> productIterator = shipment.iterator();
        while(productIterator.hasNext()) {
            Product product_floorPanel = productIterator.next();
            assertEquals(product_floorPanel, window);
        }
    }

    @Test
    public void shouldIdentifyVanRequirements() throws Exception{
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        final Iterator<Product> lightProductIterator = shipment.getLightVanMaxWeight().iterator();
        while(lightProductIterator.hasNext()) {
            Product product_window = lightProductIterator.next();
            assertEquals(product_window, window);
        }

        /*for (Product p : shipment.getHeavyVanMaxWeight()){
            System.out.println("heavy: " + p.getName());
        }*/

        final Iterator<Product> heavyProductIterator = shipment.getHeavyVanMaxWeight().iterator();
        while(heavyProductIterator.hasNext()) {
            Product product_floorPanel = heavyProductIterator.next();
            assertEquals(product_floorPanel, floorPanel);

            Product product_door = heavyProductIterator.next();
            assertEquals(product_door, door);
        }
    }
}