import java.time.LocalDateTime;

public class BankBudget extends Budget {

    public BankBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        super();
        this.setName(name);
        this.setBudgetTotal(amount);
        this.setDateTime(start, end);
    }
}