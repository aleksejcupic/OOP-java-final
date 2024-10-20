import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account extends FinancialObject implements AccountInterface {
    private AccountType type;
    private static List<Transaction> transactions = new ArrayList<>();
    private CoSignerAccount proxy;

    protected Account() {
        super();
    }
    public void addProxy(CoSignerAccount proxy) {
        this.proxy = proxy;
    }

    public boolean checkProxy(CoSignerAccount proxy) {
        if (this.proxy == proxy) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public void setAccountType(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    public void addTransaction(Transaction transaction) {
        this.updateBalance(transaction.getAmount());
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void removeTransaction(int index) {
        transactions.remove(index);
    }
}
