import java.time.LocalDateTime;

public class CreditCardBudget extends Budget {

    public CreditCardBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        super();
        this.setBudgetTotal(amount);
        this.setDateTime(start, end);
    }

}
