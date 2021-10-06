/*
* Date: 2021-09-08.
* File Name: InvoiceTest.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Represent an demo of the Invoice class.
 * 
 * @version 1 08 Sept 2021
 * @author Oskar Lövsveden
 */
public class InvoiceTest {
    public static void demo() {
        negativeQuantity();
        negativePricePerItem();
        positiveQtyAndPricePerItem();
    }

    /** Test Invoice using a negative quantity. */
    private static void negativeQuantity() {
        String partNumber = "123";
        String description = "hammer";
        int quantity = -1;
        double pricePerItem = 2.5;

        Invoice invoice = new Invoice(partNumber, description, quantity, pricePerItem);

        System.out.println("Intialize Invoice with quantity as a negative value: " + quantity);
        System.out.println("Quantity after initialization: " + invoice.getQuantity());
        System.out.println("Invoice amount: " + invoice.getInvoiceAmount() + "\n");
    }

    /** Test Invoice using a negative price per item. */
    private static void negativePricePerItem() {
        String partNumber = "456";
        String description = "screwdriver";
        int quantity = 5;
        double pricePerItem = -2.5;

        Invoice invoice = new Invoice(partNumber, description, quantity, pricePerItem);

        System.out.println("Intialize Invoice with price per item as a negative value: " + pricePerItem);
        System.out.println("Price per item after initialization: " + invoice.getPricePerItem());
        System.out.println("Invoice amount: " + invoice.getInvoiceAmount() + "\n");
    }

    /** Test Invoice using positive values for quantity and price per item. */
    private static void positiveQtyAndPricePerItem() {
        String partNumber = "789";
        String description = "pliers";
        int quantity = 5;
        double pricePerItem = 3.75;

        Invoice invoice = new Invoice(partNumber, description, quantity, pricePerItem);

        System.out.println("Intialize Invoice with price per item and quantity as positive values.");
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per item: " + pricePerItem);
        System.out.println("Quantity after initialization: " + invoice.getQuantity());
        System.out.println("Price per item after initialization: " + invoice.getPricePerItem());
        System.out.println("Invoice amount: " + invoice.getInvoiceAmount() + "\n");
    }
}
