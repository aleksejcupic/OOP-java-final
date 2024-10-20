import java.util.List;

public class CoSignerAccount extends FinancialObject implements AccountInterface{
    Account realAccount;

    public CoSignerAccount(String name) {
        this.setName(name);
    }

    public void Proxy(Account realAccount) {
        this.realAccount = realAccount;
    }

    public boolean checkAccess(){
        if (this.realAccount.checkProxy(this) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getBalance() {
        if (checkAccess()) {
            return realAccount.getBalance();
        }
        return 0.0; // TODO
    }

    public void setAccountType(AccountType type) {
        if (checkAccess()) {
            realAccount.setAccountType(type);
        }
    }

    public AccountType getType() {
        if (checkAccess()) {
            return realAccount.getType();
        }
        return null;
    }

    public void addTransaction(Transaction transaction) {
        if (checkAccess()) {
            realAccount.addTransaction(transaction);
        }
    }

    public List<Transaction> getTransactions() {
        if (checkAccess()) {
            return realAccount.getTransactions();
        }
        return null;
    }

    public void removeTransaction(int index) {
        if (checkAccess()) {
            realAccount.removeTransaction(index);
        }
    }
}
