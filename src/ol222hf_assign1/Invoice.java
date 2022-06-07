/*
* Date: 2021-09-08.
* File Name: Invoice.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Represent an invoice.
 * 
 * @version 1 08 Sept 2021
 * @author Oskar Lövsveden
 */
public class Invoice {
    private String partNumber;
    private String description;
    private int quantity;
    private double pricePerItem;

    /**
     * Invoice constructor setting partNumber, description, quantity and
     * pricePerItem fields.
     * 
     * @param partNumber   A String representing a partNumber.
     * @param description  A String representing a description.
     * @param quantity     An int representing the quantity of items in the invoice.
     * @param pricePerItem A double representing a price per item.
     */
    public Invoice(String partNumber, String description, int quantity, double pricePerItem) {
        this.setPartNumber(partNumber);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setPricePerItem(pricePerItem);
    }

    /**
     * Get price per item in the invoice.
     * 
     * @return A double containing the price per item.
     */
    public double getPricePerItem() {
        return pricePerItem;
    }

    /**
     * Set price per item in the invoice.
     * 
     * @param pricePerItem A double representing the price per item.
     */
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem < 0.0 ? 0.0 : pricePerItem;
    }

    /**
     * Get quantity of items in the invoice.
     * 
     * @return An int containing the quantity of items.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity of items in the invoice.
     * 
     * @param quantity An int representing the quantity of items.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity < 0 ? 0 : quantity;
    }

    /**
     * Get description of item in the invoice.
     * 
     * @return A String containing the item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description for the item in the invoice.
     * 
     * @param description A String representing the item description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the part number of the item in the invoice.
     * 
     * @return A String containing the part number of the item.
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * Set part number for the item in the invoice.
     * 
     * @param partNumber A String representing the part number of the item.
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     * Calculates the invoice amount.
     * 
     * @return A double representing the invoice amount (quantity * price per item)
     */
    public double getInvoiceAmount() {
        return getQuantity() * getPricePerItem();
    }
}