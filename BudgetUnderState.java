public class BudgetUnderState extends BudgetState {

    public BudgetUnderState(Budget budget) {
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
