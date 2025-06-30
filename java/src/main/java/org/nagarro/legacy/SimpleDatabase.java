package org.nagarro.legacy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory database implementation for testing the legacy code
 */
public class SimpleDatabase implements Database {
    private Map<Integer, Map<String, Object>> invoices = new ConcurrentHashMap<>();
    private Map<Integer, Map<String, Object>> auxData = new ConcurrentHashMap<>();
    private Random random = new Random();

    public SimpleDatabase() {
        // Initialize with some sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Create some sample invoices
        for (int i = 0; i < 500; i++) {
            Map<String, Object> invoice = new HashMap<>();
            // Some invoices have amounts > 1000, some don't
            double amount = random.nextDouble() * 2000; // 0-2000 range
            invoice.put("amount", amount);
            invoice.put("id", i);
            invoice.put("status", "PENDING");
            invoices.put(i, invoice);
        }

        // Create some auxiliary data
        for (int i = 0; i < 50; i++) {
            Map<String, Object> aux = new HashMap<>();
            aux.put("id", i);
            aux.put("type", "auxiliary");
            auxData.put(i, aux);
        }
    }

    @Override
    public Map<String, Object> getInvoice(int id) {
        // Simulate occasional null returns
        if (random.nextDouble() < 0.05) { // 5% chance of null
            return null;
        }
        return invoices.get(id);
    }

    @Override
    public void updateInvoiceFlag(int id, boolean flag) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.02) { // 2% chance of error
            throw new Exception("Database connection error");
        }

        Map<String, Object> invoice = invoices.get(id);
        if (invoice != null) {
            invoice.put("flag", flag);
        }
    }

    @Override
    public Map<String, Object> getAux(int id) {
        // Simulate occasional null returns
        if (random.nextDouble() < 0.1) { // 10% chance of null
            return null;
        }
        return auxData.get(id);
    }

    @Override
    public void insertLog(int id, String message) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.03) { // 3% chance of error
            throw new Exception("Log insertion failed");
        }
        // In a real implementation, this would insert into a log table
        System.out.println("LOG: ID=" + id + ", Message=" + message);
    }

    @Override
    public void cleanupInvoice(int id) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.05) { // 5% chance of error
            throw new Exception("Cleanup operation failed");
        }
        // Remove the invoice
        invoices.remove(id);
    }

    @Override
    public void deleteAux(int id) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.04) { // 4% chance of error
            throw new Exception("Delete operation failed");
        }
        auxData.remove(id);
    }

    @Override
    public void insertSummary(int a, int b) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.02) { // 2% chance of error
            throw new Exception("Summary insertion failed");
        }
        // In a real implementation, this would insert into a summary table
        System.out.println("SUMMARY: a=" + a + ", b=" + b);
    }

    @Override
    public void saveReport(int c, int d) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.03) { // 3% chance of error
            throw new Exception("Report save failed");
        }
        // In a real implementation, this would save to a reports table
        System.out.println("REPORT: c=" + c + ", d=" + d);
    }

    @Override
    public void updateAux(int id, boolean value) throws Exception {
        // Simulate occasional database errors
        if (random.nextDouble() < 0.02) { // 2% chance of error
            throw new Exception("Auxiliary update failed");
        }

        Map<String, Object> aux = auxData.get(id);
        if (aux != null) {
            aux.put("updated", value);
        }
    }

    // Helper methods for testing
    public int getInvoiceCount() {
        return invoices.size();
    }

    public int getAuxDataCount() {
        return auxData.size();
    }
}
