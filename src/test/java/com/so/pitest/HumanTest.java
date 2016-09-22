package com.so.pitest;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HumanTest {

    @Test
    public void testHumanCapabilities() {
        Human human = new Human();
        assertTrue("Humans must be normal, cannot travel with the speed of light", !human.canTravelWithTheSpeedOfLight(1));
        assertTrue("Speedy Gonzales is not human", human.canTravelWithTheSpeedOfLight(299792458));
        assertTrue("Flash is not human", human.canTravelWithTheSpeedOfLight(999999999));
        assertTrue("Humans should not be able to lift planes", human.getNumberOfAirplanesHeCanLift() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHumanCannotEatMoreThanHisLimit() {
        Human human = new Human();
        human.eatChocolate(15);
    }

    @Test
    public void testHumanCanEatUnderHisLimit() {
        Human human = new Human();
        int number = 3;
        human.eatChocolate(number);
        assertTrue("Human not full", human.getNumberOfChocolateEatenToday() == number);
    }

    @Test
    public void testHumanCanEatUntilHeIsFull() {
        Human human = new Human();
        int number = 3;
        human.eatChocolate(number);
        assertTrue("Human not full", human.getNumberOfChocolateEatenToday() == number);
        assertTrue("Human can still eat", human.getNumberOfChocolatesCanEatPerDay() - human.getNumberOfChocolateEatenToday() == 2);
        human.eatChocolate(2);
        assertTrue("Human full", human.getNumberOfChocolateEatenToday() == human.getNumberOfChocolatesCanEatPerDay());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHumanCannotEatMoreThanHisLimitCase2() {
        Human human = new Human();
        human.eatChocolate(5);
        assertTrue("Human full", human.getNumberOfChocolateEatenToday() == human.getNumberOfChocolatesCanEatPerDay());
        human.eatChocolate(5);
    }


}
