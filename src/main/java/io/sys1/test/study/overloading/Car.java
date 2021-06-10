package io.sys1.test.study.overloading;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 메서드 오버로딩, 생성자 오버로딩 예제 작성.
 * 매개변수의 타입으로 인한 생성자 오버로딩.
 * 매개변수 개수의 차이로 인한 생성자 오버로딩.
 */
@Getter
public class Car {
    public static final String NATION = "Korea";
    // 필드 == 클래스 멤버변수.
    private String company = "";
    private String model = "";
    private String color = "";
    private int speed = 0;
    private boolean startUp = false;

    // 문자열을 전달받는 생성자.
    Car(String company) {
        this.company = company;
    }

    // 정수를 전달받는 생성자.
    Car(int speed) {
        this.speed = speed;
    }

    Car(String company, String model, String color) {
        this.company = company;
        this.model = model;
        this.color = color;
        this.speed = 0;
    }

    public Car() {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStartUp(boolean startUp) {
        this.startUp = startUp;
    }

    public boolean getStartUp() {
        return startUp;
    }


    @Builder
    public Car(String company, String model, String color, int speed) {
        if (this.speed < 0 || (this.speed + speed) < 0) {
            this.startUp = false;
        } else {
            this.startUp = this.speed + speed > 0;
        }
    }

}

