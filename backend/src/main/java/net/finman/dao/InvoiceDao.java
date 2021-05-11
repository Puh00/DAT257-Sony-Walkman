package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Invoice;
import net.finman.model.InvoiceItem;
import net.finman.model.Item;

import java.util.List;
import java.util.UUID;

public interface InvoiceDao {
    /**
     * Creates an invoice without invoice items.
     *
     * @param inv Invoice.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void createInvoice(Invoice inv) throws ResourceNotCreatedException;

    /**
     * Adds items to an invoice.
     *
     * @param serialNumber Serial number of the invoice associated with the seller.
     * @param seller       The seller of an invoice.
     * @param items        Items to be added to an invoice.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void addInvoiceItems(UUID serialNumber, String seller, List<InvoiceItem> items) throws ResourceNotCreatedException;

    /**
     * Returns all invoices related to a specific user. Both the invoices the user
     * has sent and the invoices the user has recieved. Changes nothing upon
     * failure.
     *
     * @param source Email of a user in the finman website
     * @return all invoices a user has sent or recieved.
     * @throws ResourceNotFoundException if the user doenst have any invoices or if
     *                                   the get-method fails for some reason.
     */
    List<Invoice> getInvoices(String source) throws ResourceNotFoundException;

    /**
     *
     * @param invoice An invoice
     * @param seller  Email of the organisation that sent the invoice
     * @return A list of items in an invoice
     * @throws ResourceNotFoundException if there wasn't any items found in an
     *                                   invoice or if the get-method fails.
     */
    List<InvoiceItem> getInvoiceItems(UUID invoice, String seller) throws ResourceNotFoundException;
}
