package de.telran.hw_2024_09_11.task1;

import java.util.Set;
import java.util.TreeSet;

public class GovernmentOffice {
    private String title;
    private int maxCoupon;
    private int curFreeCoupon;
    TreeSet<Integer> coupons = new TreeSet<Integer>();

    public GovernmentOffice(String title) {
        this.curFreeCoupon = 1;
        this.maxCoupon = 10;
        this.title = title;
        //coupons = new TreeSet<Integer>();
    }

    public GovernmentOffice(String title, int coupon) {
        this.curFreeCoupon = 1;
        this.title = title;
        if (coupon <= 10)
            this.maxCoupon = coupon;
        else {
            System.out.println("Maximum of coupons is 10 in "
                    + this.title);
            this.maxCoupon = 10;
        }
    }

    private int getCoupon(){
        if (this.curFreeCoupon > 10){
            System.out.println("No coupons available in "
                    + this.title);
            return 0;
        }
        System.out.println("Your coupon is <"
                + this.curFreeCoupon + "> in "
                + this.title);
        coupons.add(this.curFreeCoupon);
        return this.curFreeCoupon++;
    }

    public int getCouponFromMachine1(){
        return getCoupon();
    }

    public int getCouponFromMachine2(){
        return getCoupon();
    }

    public int getCouponOnline(){
        return getCoupon();
    }

    public void showProgress(){
        Integer curCoupon;
        do {
            curCoupon = coupons.pollFirst();
            if (curCoupon != null)
            System.out.println("Consult coupon N"
                    + curCoupon
                    + " in " + this.title);
        } while(curCoupon != null);
    }


}
