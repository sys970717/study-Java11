package io.sys1.test;

import io.sys1.test.study.inherit.SportsCar;

public class Application {
    public static void main(String[] args) {
        SportsCar sportsCar = new SportsCar();
        System.out.println("현재 속도: " + sportsCar.getSpeed());
        System.out.println("제조국 : " + SportsCar.NATION);
        sportsCar.upSpeed(10);
        System.out.println("현재 속도: " + sportsCar.getSpeed());
        sportsCar.upSpeed(10);
        System.out.println("현재 속도: " + sportsCar.getSpeed());
        sportsCar.downSpeed(19);
        System.out.println("현재 속도: " + sportsCar.getSpeed());
        sportsCar.downSpeed(1);
        System.out.println("현재 속도: " + sportsCar.getSpeed());
    }
}
