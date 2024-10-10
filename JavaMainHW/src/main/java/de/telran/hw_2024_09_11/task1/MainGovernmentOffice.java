package de.telran.hw_2024_09_11.task1;

public class MainGovernmentOffice {
    public static void main(String[] args) {
        GovernmentOffice office1 = new GovernmentOffice("Office1", 11);
        GovernmentOffice office2 = new GovernmentOffice("Office2", 4);  // short day

        office1.getCouponOnline();
        office1.getCouponOnline();
        office1.getCouponOnline();
        office1.getCouponFromMachine1();
        office1.getCouponFromMachine2();
        office1.getCouponFromMachine1();
        office1.showProgress();
        office1.getCouponFromMachine1();
        office1.getCouponFromMachine2();
        office1.getCouponFromMachine1();
        office1.getCouponFromMachine2();
        office1.getCouponFromMachine2();
        office1.getCouponFromMachine1();
        office1.getCouponFromMachine1();
        office1.showProgress();

        office2.getCouponFromMachine1();
        office2.getCouponFromMachine2();
        office2.getCouponFromMachine2();
        office2.getCouponFromMachine1();
        office2.getCouponFromMachine1();
        office2.getCouponFromMachine1();
        office2.getCouponFromMachine2();
        office2.getCouponFromMachine2();
        office2.getCouponFromMachine1();
        office2.getCouponFromMachine1();
        office2.showProgress();

    }
}
