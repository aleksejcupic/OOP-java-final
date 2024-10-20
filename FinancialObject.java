import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class FinancialObject {
    private String name;
    private double balance;
    private List<FinancialObject> children = new ArrayList<>();
    private FinancialObject parent;

    protected FinancialObject() {}

    protected FinancialObject(String name) {
        this.name = name;
        this.balance = 0;
    }

    public FinancialObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    protected double getBalance() {
        return balance;
    }

    public List<FinancialObject> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void setParent(FinancialObject parent) {
        this.parent = parent;
    }

    public FinancialObject getParent() {
        return parent;
    }

    public void addChild(FinancialObject child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(FinancialObject child) {
        children.remove(child);
        child.setParent(null);
    }

    public void updateBalance(double amount) {
        balance += amount;
        if (parent != null) {
            parent.updateBalance(amount);
        }
    }
}
