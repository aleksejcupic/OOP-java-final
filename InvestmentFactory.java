import java.time.LocalDateTime;

public class InvestmentFactory implements FinancialObjectFactory {
    @Override
    public Account createAccount(String name, AccountType type) {
        return new InvestmentAccount(name, type);
    }

    @Override
    public Transaction createTransaction(String description, TransactionType type, double amount, LocalDateTime timestamp) {
        return new InvestmentTransaction(description, type, amount, timestamp);
    }

    @Override
    public Budget createBudget(String name, double amount, LocalDateTime start, LocalDateTime end) {
        return new InvestmentBudget(name, amount, start, end);
    }
}
