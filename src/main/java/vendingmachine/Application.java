package vendingmachine;

import vendingmachine.system.VendingMachineSystem;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineSystem vendingMachine = new VendingMachineSystem();
        vendingMachine.start();
    }
}
