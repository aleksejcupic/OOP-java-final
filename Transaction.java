import java.time.LocalDateTime;

public class Transaction extends FinancialObject {
    private double amount;
    private TransactionType type;
    private String description;
    private LocalDateTime timestamp;

    public Transaction() {
        super();
    }

    public Transaction setName(String name) {
        super.setName(name);
        return this;
    }

    public double getAmount() {
        return amount;
    }
    public TransactionType getTransactionType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDateTime() {
        return timestamp;
    }
     
    public Transaction setAmount(double amount) {
        this.amount = amount;
        this.updateBalance(amount);
        return this;
    }

    public Transaction setTransactionType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Transaction setDescription(String description) {
        this.description = description;
        return this;
    }

    public Transaction setDateTime(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
