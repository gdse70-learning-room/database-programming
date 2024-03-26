package lk.ijse.dp;

public class WashingMachine {
    void washClothes() {
        System.out.println("wash!");
    }
}


class Demo {
    public static void main(String[] args) {
        WashingMachine wm1 = new WashingMachine();
        WashingMachine wm2 = new WashingMachine();
        WashingMachine wm3 = new WashingMachine();

        System.out.println("wm1 = " + wm1);
        System.out.println("wm2 = " + wm2);
        System.out.println("wm3 = " + wm3);
    }
}