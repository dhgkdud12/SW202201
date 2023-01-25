package JAVA.OOP;

public class Vending_Machine {
    private int Orange_juice;
    private int Apple_juice;

    public Vending_Machine(int orange_juice, int apple_juice) {
        Orange_juice = orange_juice;
        Apple_juice = apple_juice;
    }

    private boolean Orange_possible(int pay) {

        if (Orange_juice > 0) { // 오렌지 주스가 있고

            if (pay >= 500) { // 돈이 500원이상 있다면
                return true; // 구매가능
            }
        }

        return false;
    }

    // 사과주스 판매가 가능한지 검사
    private boolean Apple_possible(int pay) {

        if (Apple_juice > 0) {

            if (pay >= 300) {
                return true;
            }

        }
        return false;
    }

    public int buy(String kind, int pay) { // 구매

        if(kind.equals("Orange juice")) {
            if(Orange_possible(pay)) {
                Orange_juice--;
                System.out.println("오렌지 주스가 정상적으로 구매되었습니다");
                return 500;
            }
            System.out.println("오렌지 주스를 구매하실 수 없습니다");
            return 0;
        }

        else if(kind.equals("Apple juice")) {
            if(Apple_possible(pay)) {
                Apple_juice--;
                System.out.println("사과 주스가 정상적으로 구매되었습니다");
                return 300;
            }
            System.out.println("사과 주스를 구매하실 수 없습니다");
            return 0;
        }

        System.out.println("없는 물품입니다");
        return 0;
    }
}
