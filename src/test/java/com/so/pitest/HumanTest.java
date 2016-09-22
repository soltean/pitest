package com.so.pitest;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class HumanTest {

    @Test
    public void testHumanCannotLiftPlanes() {
        Human human = new Human();
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
    public void testHumanCanEatHisLimit() {
        Human human = new Human();
        int number = 5;
        human.eatChocolate(number);
        assertTrue("Human not full", human.getNumberOfChocolateEatenToday() == human.getNumberOfChocolatesCanEatPerDay());
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
