package com.company;

public class Main {
    public static void main(String[] args){
        Person player = new Person(100);
        player.setValue(500);

        Car car = new Car();
        System.out.println(car);
        car.repairCar();

    }
}
