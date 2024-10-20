import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class FinanceManagementSystem {

    private static FinanceManagementSystem instance;
    private static List<Account> accounts = new ArrayList<>();
    public String value;

    private FinanceManagementSystem(String value) {
        this.value = value;
    }

    public static FinanceManagementSystem getInstance(String value) {
        if (instance == null) {
            instance = new FinanceManagementSystem(value);
        }
        return instance;
    }

    public Account createAccount(String name, AccountType type) throws InvalidAccountTypeException {
        switch(type) {
            case BANK:
                BankAccount bankAccount = new BankAccount(name, type);
                accounts.add(bankAccount);
                return bankAccount;
            case CREDIT_CARD:
                CreditCardAccount creditCardAccount = new CreditCardAccount(name, type);
                accounts.add(creditCardAccount);
                return creditCardAccount;
            case INVESTMENT:
                InvestmentAccount investmentAccount = new InvestmentAccount(name, type);
                accounts.add(investmentAccount);
                return investmentAccount;
            default:
                throw new InvalidAccountTypeException();
        }
    }

    public void addTransaction(Account account, Transaction transaction) {
        account.addTransaction(transaction);
    }

    public void addTransaction(Account account, Transaction transaction, Budget budget) {
        account.addTransaction(transaction);
        budget.addTransaction(transaction);
    }

    public void generateBalanceReport(Account account) {
        System.out.println(account.getName() + ": " + account.getBalance());
    }

    public void generateCashFlowReport(Account account) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Transaction> transactions = account.getTransactions();
        for (Transaction t : transactions) {
            System.out.println(t.getName() + ": " + t.getDescription() + ", " + t.getAmount() + ", " + t.getDateTime().format(formatter));
        }
    }
    private double getNetWorth() {
        double netWorth = 0;
        for (Account a : accounts) {
            if (a.getParent() == null) {
                netWorth += a.getBalance();
            }

        }
        return netWorth;
    }

    public void generateNetWorthReport() {
        System.out.println("Net Worth of accounts in " + this.value + " is: " + getNetWorth());
    }

    public Budget createBudget(String name, BudgetType type, double amount, LocalDateTime start, LocalDateTime end) throws InvalidBudgetTypeException {
        switch(type) {
            case BANK:
                return new BankBudget(name, amount, start, end);
            case CREDIT_CARD:
                return new CreditCardBudget(name, amount, start, end);
            case INVESTMENT:
                return new InvestmentBudget(name, amount, start, end);
            default:
                throw new InvalidBudgetTypeException();
        }
    }

    public void addBudgetItem(Budget budget, BudgetItem budgetItem) {
        budget.addBudgetItem(budgetItem);
    }

    public FinancialGoal setFinancialGoal(String name, double amount) {
        return new FinancialGoal(name, amount);
    }

    public void displayBudget(Budget budget) {
        System.out.println(budget.getName() + ": " + budget.getTotal());
        for (BudgetItem bi : budget.getBudgetItems()) {
            System.out.println(bi.getName() + ": " + bi.getAmount());
        }
    }
    public void displayWorkingBudget(Budget budget) {
        System.out.println(budget.getName() + " has " + budget.getAmount() + " of " + budget.getTotal() + " left.");
        if (budget.isOverBudget() == true) {
            System.out.println("Budget " + budget.getName() + " is over budget");
        } 
    }

    public void trackProgress(FinancialGoal financialGoal) {
        System.out.println("You have " + getNetWorth() + " of " + financialGoal.amount + " for " + financialGoal.name);
    }

    public void deposit(Account account, double amount) {
        account.updateBalance(amount);
    }

    public void withdraw(Account account, double amount) {
        account.updateBalance(amount *= -1);
    }

    // public void undo(Account account) {
    //     int index = account.getTransactions().size() - 1;
    //     Transaction transaction = account.getTransactions().get(index);
    //     double amount = transaction.getAmount();
    //     account.updateBalance(amount *= -1);
    //     account.removeTransaction(index);
    // }

    // public void undo(Account account, Budget budget) {
    //     int accountTransactionIndex = account.getTransactions().size() - 1;
    //     Transaction transaction = account.getTransactions().get(accountTransactionIndex);
    //     double amount = transaction.getAmount();
    //     account.updateBalance(amount *= -1);
    //     account.removeTransaction(accountTransactionIndex);
    //     int budgetTransactionIndex = budget.getTransactions().size() - 1;
    //     Transaction transaction2 = budget.getTransactions().get(budgetTransactionIndex);
    //     double amount2 = transaction2.getAmount();
    //     budget.updateBalance(amount2 *= -1);
    //     budget.removeTransaction(budgetTransactionIndex);
    // }
}
