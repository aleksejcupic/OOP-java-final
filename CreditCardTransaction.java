import java.time.LocalDateTime;

public class CreditCardTransaction extends Transaction {

    public CreditCardTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp) {
        super();
        this.setAmount(amount);
        this.setTransactionType(type);
        this.setDescription(description);
        this.setDateTime(timestamp);
    }   
}
