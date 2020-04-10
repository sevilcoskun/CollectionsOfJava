package main.queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static main.queues.Category.*;
import static main.queues.Customer.*;

public class PriorityHelpDesk {

    private  static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category){
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquires(){
        Enquiry enquiry;
        while((enquiry = enquiries.poll()) != null){
            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
        }
    }

    public static void main(String[] args){
        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(JACK, PHONE);
        helpDesk.enquire(JILL, PRINTER);
        helpDesk.enquire(MARRY, COMPUTER);

        helpDesk.processAllEnquires();
    }
}
