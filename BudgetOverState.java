public class BudgetOverState extends BudgetState {

    public BudgetOverState(Budget budget) {
        super(budget);
    }

    @Override
    public void onAddTransaction() {
        budget.checkBudget();
    }

    @Override
    public void onDeleteTransaction() { 
        budget.checkBudget();
    }
}
