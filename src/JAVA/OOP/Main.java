package JAVA.OOP;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(1000); 
        Vending_Machine vm = new Vending_Machine(10, 3); // 음료 개수

        String want_juice = "Orange juice"; // 오렌지 주스 구매

        int pay = vm.buy(want_juice, customer.getChanges());

        if (pay == 0) { // 구매할 수 없음
            customer.resetting_juice(pay, null);
        }
        else {
            customer.resetting_juice(pay, want_juice);
        }

        System.out.println(customer); // 고객이 갖고있는 잔액, 음료
    }
}
