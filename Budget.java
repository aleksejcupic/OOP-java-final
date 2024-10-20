import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Budget extends FinancialObject {
    private double amount;
    private double total;
    private LocalDateTime start;
    private BudgetType type;
    private LocalDateTime end;
    private List<BudgetItem> budgetItems = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private boolean overBudget = false;

    protected Budget() {
        super();
    }

    public BudgetType getBudgetType() {
        return type;
    }

    public void setBudgetType(BudgetType type) {
        this.type = type;
    }

    public void setBudgetTotal(double amount) { 
        this.total = amount;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public double getTotal() {
        return total;
    }

    public void setDateTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public void addBudgetItem(BudgetItem budgetItem) {
        budgetItems.add(budgetItem);
    }

    public List<BudgetItem> getBudgetItems() {
        return budgetItems;
    }

    public void addTransaction(Transaction transaction) {
        LocalDateTime timestamp = transaction.getDateTime();
        if (timestamp.isBefore(end) && timestamp.isAfter(start)) {
            for (BudgetItem bi : budgetItems) {
                if (bi.getName().equals(transaction.getName())) {
                    transactions.add(transaction);
                    this.amount += transaction.getAmount();
                }
            }
        }
        this.checkBudget();
    }
    
    public void checkBudget() {
        double budgetAmount = 0.0;
        for (Transaction transaction : transactions) {
            budgetAmount += transaction.getAmount();
        }
        if (budgetAmount > this.amount) {
            this.overBudget = true;
            System.out.println(this.getName() + " is over budget.");
        } else {
            this.overBudget = false;
        }
    }

    public boolean isOverBudget() {
        return overBudget;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void removeTransaction(int budgetTransactionIndex) {
        transactions.remove(budgetTransactionIndex);
    }
}