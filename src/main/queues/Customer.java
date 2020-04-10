package main.queues;

public class Customer {
    public static final Customer JACK = new Customer("Jack");
    public static final Customer JILL = new Customer("Jill");
    public static final Customer MARRY = new Customer("Marry");

    private final String name;

    public Customer(final String name) { this.name = name; }

    public void reply(final String message){
        System.out.printf("%s: %s\n",name, message);
    }


}