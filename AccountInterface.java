import java.util.List;

public interface AccountInterface {
    public double getBalance();
    public void setAccountType(AccountType type);
    public AccountType getType();
    public void addTransaction(Transaction transaction);
    public List<Transaction> getTransactions();
    public void removeTransaction(int index);
}
