package com.so.pitest;

public class Human {

    private final int numberOfChocolatesCanEatPerDay;
    private int numberOfChocolateEatenToday;

    public Human() {
        numberOfChocolatesCanEatPerDay = 5;
    }

    public boolean canTravelWithTheSpeedOfLight(int currentTravelSpeed) {
        return currentTravelSpeed >= 299792458;
    }

    public int getNumberOfAirplanesHeCanLift() {
        return 0;
    }

    public void eatChocolate(int numberOfChocolatesToEat) {
        if (numberOfChocolatesToEat + numberOfChocolateEatenToday > numberOfChocolatesCanEatPerDay) {
            throw new IllegalArgumentException("Can't eat that much");
        }
        numberOfChocolateEatenToday += numberOfChocolatesToEat;
    }

    public int getNumberOfChocolateEatenToday() {
        return numberOfChocolateEatenToday;
    }

    public int getNumberOfChocolatesCanEatPerDay() {
        return numberOfChocolatesCanEatPerDay;
    }
}
