package io.sys1.test.study.overloading;

/**
 * 메서드 오버로딩, 생성자 오버로딩 예제 작성.
 * 매개변수의 타입으로 인한 생성자 오버로딩.
 * 매개변수 개수의 차이로 인한 생성자 오버로딩.
 */
public class Car {
    // 필드 == 클래스 멤버변수.
    private String company;
    private String model;
    private String color;
    private int maxSpeed;

    Car() {}
    // 문자열을 전달받는 생성자.
    Car(String company) {
        this.company = company;
    }
    // 정수를 전달받는 생성자.
    Car(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    Car(String company, String model, String color) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.maxSpeed = 90;
    }
}

