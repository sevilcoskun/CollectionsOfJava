package main.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

import static main.queues.Category.*;
import static main.queues.Customer.*;

public class CategorisedHelpDesk {
    private Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category type){
        return enquiries.offer(new Enquiry(customer, type));
    }

    public void processPrinterEnquiry(){
        processEnquiry(
                enq -> enq.getCategory() == PRINTER,
                "Is it out of paper?");
    }

    public void processGeneralEnquiry(){
        processEnquiry(
                enq -> enq.getCategory() != PRINTER,
                "Have you tried turning it off and on again?");
    }

    public void processEnquiry(Predicate<Enquiry> enquiryPredicate, final String message){
        final Enquiry enquiry = enquiries.peek();
        if(enquiry != null && enquiryPredicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        }
        else{
            System.out.println("No work to do, let's have some coffee!");
        }
    }

    public static void main(String[] args) {
        CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();

        helpDesk.enquire(JACK, PHONE);
        helpDesk.enquire(JILL, PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
