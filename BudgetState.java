public abstract class BudgetState {
    Budget budget;

    public BudgetState(Budget budget) {
        this.budget = budget;
    }

    // abstract methods for states (BudgetOverState, BudgetUnderState)
    public abstract void onAddTransaction();
    public abstract void onDeleteTransaction();
}
