package io.sys1.test.study.inherit;

import io.sys1.test.study.overloading.Car;

/**
 * 스포츠카 클래스를 생성할 때 이전에 생성해둔 'Car' 클래스 상속받기.
 */
public class SportsCar extends Car {
    public SportsCar() {
        super();
    }

    // final 필드 사용 => 변하지 않는 값,
    // 하지만 메모리에 올려서 상수(static final) 로 사용할 값은 아니기에 final로 선언한다.
    final int maxSpeed = 200;

    // Setter 를 사용해 private 값 수정.
    public void upSpeed(int speed) {
        int onNowSpeed = this.getSpeed();
        if (onNowSpeed + speed >= this.maxSpeed) {
            this.setSpeed(this.maxSpeed);
            System.out.println("현재 속도가 이미 최고속도입니다.");
        } else {
            this.setSpeed(onNowSpeed + speed);
        }
    }

    public void downSpeed(int speed) {
        int onNowSpeed = this.getSpeed();
        if (onNowSpeed - speed <= 0) {
            this.setSpeed(0);
            setStartUp(false);
            System.out.println("시동 상태: " + this.getStartUp());
        } else {
            this.setSpeed(onNowSpeed - speed);
        }
    }
}


