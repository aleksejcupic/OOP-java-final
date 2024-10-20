import java.time.LocalDateTime;

public class BankTransaction extends Transaction {

    public BankTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp) {
        super();
        this.setAmount(amount);
        this.setTransactionType(type);
        this.setDescription(description);
        this.setDateTime(timestamp);
    }
}
 