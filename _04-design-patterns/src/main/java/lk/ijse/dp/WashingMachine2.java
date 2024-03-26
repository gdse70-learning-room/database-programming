package lk.ijse.dp;

public class WashingMachine2 {
    private static WashingMachine2 wm;  //1

    private WashingMachine2() {}    //2

    public static WashingMachine2 getInstance() {   //3
        if(wm == null) {
            wm = new WashingMachine2();
        }
        return wm;
    }
}


class Demo2 {
    public static void main(String[] args) {
        WashingMachine2 wm1 = WashingMachine2.getInstance();
        WashingMachine2 wm2 = WashingMachine2.getInstance();
        WashingMachine2 wm3 = WashingMachine2.getInstance();

//        new WashingMachine2();  //Illegal

        System.out.println("wm1 = " + wm1);
        System.out.println("wm2 = " + wm2);
        System.out.println("wm3 = " + wm3);


        /*new WashingMachine2();
        new WashingMachine2();
        new WashingMachine2();
        new WashingMachine2();*/
    }
}