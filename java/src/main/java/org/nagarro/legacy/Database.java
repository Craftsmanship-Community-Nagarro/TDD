package org.nagarro.legacy;

import java.util.Map;

/**
 * Database interface for invoice management operations
 */
public interface Database {

    /**
     * Retrieves an invoice by ID
     * 
     * @param id the invoice ID
     * @return a map containing invoice data, or null if not found
     */
    Map<String, Object> getInvoice(int id);

    /**
     * Updates the flag status of an invoice
     * 
     * @param id   the invoice ID
     * @param flag the flag value to set
     * @throws Exception if database operation fails
     */
    void updateInvoiceFlag(int id, boolean flag) throws Exception;

    /**
     * Retrieves auxiliary data by ID
     * 
     * @param id the auxiliary data ID
     * @return a map containing auxiliary data, or null if not found
     */
    Map<String, Object> getAux(int id);

    /**
     * Inserts a log entry
     * 
     * @param id      the ID to log
     * @param message the log message
     * @throws Exception if database operation fails
     */
    void insertLog(int id, String message) throws Exception;

    /**
     * Cleans up an invoice by ID
     * 
     * @param id the invoice ID to cleanup
     * @throws Exception if database operation fails
     */
    void cleanupInvoice(int id) throws Exception;

    /**
     * Deletes auxiliary data by ID
     * 
     * @param id the auxiliary data ID to delete
     * @throws Exception if database operation fails
     */
    void deleteAux(int id) throws Exception;

    /**
     * Inserts summary data
     * 
     * @param a first parameter
     * @param b second parameter
     * @throws Exception if database operation fails
     */
    void insertSummary(int a, int b) throws Exception;

    /**
     * Saves a report
     * 
     * @param c first parameter
     * @param d second parameter
     * @throws Exception if database operation fails
     */
    void saveReport(int c, int d) throws Exception;

    /**
     * Updates auxiliary data
     * 
     * @param id    the ID to update
     * @param value the value to set
     * @throws Exception if database operation fails
     */
    void updateAux(int id, boolean value) throws Exception;
}
