package org.nagarro.legacy;

import java.util.Objects;

/**
 * Invoice data class representing an invoice record
 */
public class Invoice {
    private int id;
    private double amount;
    private String status;

    public Invoice(int id, double amount) {
        this.id = id;
        this.amount = amount;
        this.status = "PENDING";
    }

    public Invoice(int id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id &&
                Double.compare(invoice.amount, amount) == 0 &&
                Objects.equals(status, invoice.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, status);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
