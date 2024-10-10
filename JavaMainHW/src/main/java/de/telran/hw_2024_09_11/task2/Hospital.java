package de.telran.hw_2024_09_11.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Hospital {
    private final int maxCoupon = 8;
    private int curCoupon;
    private HashSet<String> coupons = new HashSet<String>();
    private LinkedHashSet<String> queue = new LinkedHashSet<String>();

    public Hospital() {
        this.curCoupon = 1;
    }

    public String getCoupon(String name){
        if (this.curCoupon <= this.maxCoupon) {
            System.out.println(name
                    + " get coupon for consultation. There are "
                    + (this.maxCoupon-this.curCoupon) + " free coupons.");
            this.curCoupon++;
            coupons.add(name);
            return name;
        }
        System.out.println("Sorry " + name +", no more coupons available!");
        return null;
    }

    public void takeQueuePlace(String name){
        if (coupons.contains(name)){
            queue.add(name);
            coupons.remove(name);
            System.out.println(name + ", you are " + queue.size());
        }
        else {
            System.out.println(name + ", you can't take a place without coupon!");
        }
    }

    public void consultClients(){
        String consultingName;
        int i =1;
        Iterator<String> client = queue.iterator();
        while (client.hasNext()) {
            String clientName = client.next();
            System.out.println("Consultation N" + i + " - " + clientName);
            client.remove();
            i++;
        }
    }

}
