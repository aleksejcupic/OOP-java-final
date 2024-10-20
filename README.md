# OOP-java-final
Aleksej Cupic
Object Oriented Design Final Project
Financial Management System

My final project is a personal financial management system that helps users to manage their personal finances efficiently.
The program's main features include:
1.	Adding, removing, and updating financial accounts, such as bank accounts, credit cards, and investment accounts. Accounts can also have sub-types, such as a credit card account connected to a bank account. 
2.	Categorizing transactions by type, such as income, expenses, and savings, to their respective accounts. 
3.	Creating and tracking budgets for different categories of expenses.
4.	Automatically updating account balances and transaction history.
5.	Generating reports on account balances, cash flow, and net worth.
6.	Setting financial goals and tracking progress towards achieving them.
7.	Regular deposits and withdrawals to and from accounts. 

The FinancialManagementSystem class is a singleton and is what runs all methods. 
The FinancialObjectFactory is an abstract factory that contains the blueprints for the following 3 factories: Bank, CreditCard, Investment. Each of those factories implements their own methods for the 3 objects in the project: Accounts, Transactions, and Budgets. Those 3 objects are all builders. For accounts, there are also co-signer accounts that are a proxy for the original account. It implements a method that checks whether or not that co-signer account has access to the original account. The Budget class implements a state design pattern for whether or not the account is over budget or not. 

The Main class tests all the features of the project. An overview of it is as follows:
1.	Create the Financial Management System called “Aleksej’s Accounts”
2.	Create 3 accounts: a main bank account, and 2 sub accounts to the bank account: a credit card account and investment account
3.	Create instances of transactions, each of different types and amounts
4.	Create a budget plan for food for the bank account, with budget items for groceries and eating out
5.	Add transactions based on if they are income or expenses
6.	Generate reports including balance report, cash flow report, and net worth report
7.	Display budget progress 
8.	Set financial goals and check progress towards them
9.	Regular deposits and withdrawals to the accounts
10.	Create a Co-Signer account and add transactions through that proxy account
