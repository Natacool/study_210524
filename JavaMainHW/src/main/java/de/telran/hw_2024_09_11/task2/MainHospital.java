package de.telran.hw_2024_09_11.task2;

import java.util.HashSet;

public class MainHospital {
    public static void main(String[] args) {
        Hospital clinic = new Hospital();
        clinic.getCoupon("Ivanov");
        clinic.getCoupon("Petrova");
        clinic.getCoupon("Sidorov");
        clinic.getCoupon("Krasnova");
        clinic.getCoupon("Martinova");
        clinic.getCoupon("Nemov");
        clinic.getCoupon("Bezrodnii");
        clinic.getCoupon("Krasilnikova");
        clinic.getCoupon("Ivanova");

        clinic.takeQueuePlace("Ivanov");
        clinic.takeQueuePlace("Ivanova");
        clinic.takeQueuePlace("Sidorov");
        clinic.takeQueuePlace("Krasnova");
        clinic.takeQueuePlace("Nemov");
        clinic.takeQueuePlace("Petrova");
        clinic.takeQueuePlace("Petrova");
        clinic.takeQueuePlace("Martinova");
        clinic.takeQueuePlace("Bezrodnii");
        clinic.takeQueuePlace("Krasilnikova");

        clinic.consultClients();
    }
}
