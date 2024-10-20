import java.time.LocalDateTime;

public class InvestmentBudget extends Budget {

    public InvestmentBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        super();
        this.setName(name);
        this.setBudgetTotal(amount);
        this.setDateTime(start, end);
    }
}
