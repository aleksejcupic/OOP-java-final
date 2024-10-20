import java.time.LocalDateTime;
import java.util.List;

/*
 * We first create an instance of the FinanceManagementSystem 
 * class and use it to create accounts, add transactions, 
 * generate reports, create budgets, set financial goals,
 * update account balances, and undo and redo actions. 
 */

public class Main {

    public static void main(String[] args) throws InvalidAccountTypeException, InvalidBudgetTypeException {
        // create instance of the finance management system
        System.out.println("Creating instance of the Financial Management System with name: Aleksej's Accounts");
        FinanceManagementSystem fms = FinanceManagementSystem.getInstance("Aleksej's Accounts");

        System.out.println();
        // create some accounts
        System.out.println("Creatings Accounts");
        System.out.println("Main Checking Account");
        Account checking = fms.createAccount("Checking", AccountType.BANK);
        System.out.println("    Sub-Account Credit Card");
        checking.addChild(fms.createAccount("Credit Card", AccountType.CREDIT_CARD));
        System.out.println("    Sub-Account Investment");
        checking.addChild(fms.createAccount("Investment", AccountType.INVESTMENT));

        System.out.println();
        // create some example transactions 
        System.out.println("Creating Sample Transactions");
        System.out.println("Income: Paycheck, $100.00");
        Transaction income = new Transaction()
                            .setAmount(100.0)
                            .setTransactionType(TransactionType.INCOME)
                            .setDateTime(LocalDateTime.now())
                            .setDescription("Work")
                            .setName("Paycheck");
        System.out.println("Food: Groceries, $-50.00");
        Transaction groceries = new Transaction()
                            .setAmount(-50.0)
                            .setTransactionType(TransactionType.EXPENSE)
                            .setDateTime(LocalDateTime.now())
                            .setDescription("Wegmann's")
                            .setName("Groceries");
        System.out.println("Food: Dinner, $-25.00");
        Transaction dinner = new Transaction()
                            .setAmount(-25.0)
                            .setTransactionType(TransactionType.EXPENSE)
                            .setDateTime(LocalDateTime.now())
                            .setDescription("McDonald's")
                            .setName("Dinner");
        System.out.println("Food: Coffee, $-10.00");
        Transaction coffee = new Transaction()
                            .setAmount(-10.0)
                            .setTransactionType(TransactionType.EXPENSE)
                            .setDateTime(LocalDateTime.now())
                            .setDescription("Starbucks")
                            .setName("Coffee");
        System.out.println("Income: Dividends, $500.00");      
        Transaction dividends = new Transaction()
                            .setAmount(500.0)
                            .setTransactionType(TransactionType.INCOME)
                            .setDateTime(LocalDateTime.now())
                            .setDescription("Apple Inc.")
                            .setName("Dividends"); 

        System.out.println();
        // gettting account children
        List<FinancialObject> children = checking.getChildren();
        CreditCardAccount creditCard = (CreditCardAccount)children.get(0);
        InvestmentAccount investment = (InvestmentAccount)children.get(1);

        // create an example budge
        System.out.println("Making Budget: 'Food' for main bank Account with amount of $250");
        Budget foodBudget = fms.createBudget("Food", BudgetType.BANK, 250, LocalDateTime.now().minusWeeks(1), LocalDateTime.now().plusWeeks(1));

        System.out.println("Adding sub-items to Food budget");
        // add budget items to the budget
        System.out.println("    Groceries: $200");
        fms.addBudgetItem(foodBudget, new BudgetItem("Groceries", 200.0));
        System.out.println("    Eating Out: $50");
        fms.addBudgetItem(foodBudget, new BudgetItem("Eating Out", 50.0));

        System.out.println();
        // add some transactions (income)
        System.out.println("Adding income transactions to FMS");
        fms.addTransaction(checking, income);
        fms.addTransaction(investment, dividends);

        System.out.println("Adding Food transaction to FMS (with budget)");
        // add some transaction (expenses to budget "Food")
        fms.addTransaction(checking, groceries, foodBudget);
        fms.addTransaction(creditCard, dinner, foodBudget);
        fms.addTransaction(creditCard, coffee, foodBudget);

        System.out.println();
        // generate reports
        System.out.println("Generating Balance Report:");
        fms.generateBalanceReport(checking);
        System.out.println();
        System.out.println("Generating Cash Flow Report:");
        fms.generateCashFlowReport(creditCard);
        System.out.println();
        System.out.println("Generating Net Worth Report:");
        fms.generateNetWorthReport();

        System.out.println();
        // generate budget summary
        System.out.println("Displaying Budget (without transactions):");
        fms.displayBudget(foodBudget);

        System.out.println("Displaying Budget (with transactions)");
        fms.displayWorkingBudget(foodBudget);

        System.out.println();
        // set a financial goal
        System.out.println("Setting retirement financial goal of $1,000,000");
        FinancialGoal retirement = fms.setFinancialGoal("Retirement", 1000000.0);

        System.out.println();
        // track progres of the goal
        System.out.println("Tracking Goal Progress:");
        fms.trackProgress(retirement);

        System.out.println();
        // update an account balance
        System.out.println("Depositing $200.00 to checking account");
        fms.deposit(checking, 200.0);
        System.out.println("Withdrawing $100 from checking acocunt");
        fms.withdraw(checking, 100.0);

        System.out.println();
        // create proxy account
        System.out.println("Creating Proxy Co-Signer Account to main checking account");
        CoSignerAccount coSignerAccount = new CoSignerAccount("Co-Signer");
        coSignerAccount.Proxy(checking);
        checking.addProxy(coSignerAccount);
        System.out.println("Creating new groceries transaction for Co-Signer account");
        Transaction groceries2 = new Transaction()
                                .setAmount(-50.0)
                                .setTransactionType(TransactionType.EXPENSE)
                                .setDateTime(LocalDateTime.now())
                                .setDescription("Star Market")
                                .setName("Groceries2");
        coSignerAccount.addTransaction(groceries2);
        System.out.println("Generating Cash Flow Report for main account after co-signer transaction:");
        fms.generateCashFlowReport(checking);
    }
}
