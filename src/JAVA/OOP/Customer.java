package JAVA.OOP;

public class Customer {
    private int changes;
    private String hasJuice = null;

    public Customer(int changes) {
        this.changes = changes;
    }

    public int getChanges() {
        return changes;
    }

    public void setHasJuice(String hasJuice) {
        this.hasJuice = hasJuice;
    }
    
    public void resetting_juice(int changes, String hasJuice) {
        this.changes -= changes; // 금액 감소
        this.setHasJuice(hasJuice);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "잔액=" + changes +
                ", 갖고있는 음료='" + hasJuice + '\'' +
                '}';
    }
}
