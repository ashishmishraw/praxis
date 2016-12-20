package com.ashu.utils.exploratory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by ashishmishraw on 20/12/16.
 *
 * Example to understand various method reference passing in java 8
 *
 */
public class MethodReferences {

    public static void main(String args[]) {

        //method references is constructor reference with the syntax Class::new or
        //alternatively for generics, Class< T >::new. Please notice that the constructor has no arguments
        Car c1 = Car.create(Car::new);
        Car c2 = Car.create(Car::new);

        List<Car> cars = Arrays.asList(c1, c2);

        //Static method reference passed- Syntax is (Class::static_method) where method accepts only single argument
        cars.forEach(Car::collide);

        //Method reference passed over class <Type> - Syntax is (Class::method ) where method accepts no argument
        cars.forEach(Car::repair);

        Car c3 = Car.create(Car::new);
        //Method reference passed over an instance - Sytnax is (instance::method) where method accepts only single argument
        cars.forEach(c3::follow);

    }


    /**
     * Internal class Car
     */
    private static class Car {

        /**
         * Factpry method / constructor (not open - remember java 8 design?)
         */
        static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        /**
         * Static method
         *
         * @param car
         */
        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        /**
         * Instance method follow
         *
         * @param otherCar - follows other Car instance
         */
        public void follow(final Car otherCar) {
            System.out.println(this.toString() + " is following " + otherCar.toString());
        }

        /**
         * Instance method repair - to be invoked over current instance
         */
        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

        @Override
        public String toString() {
            return "car " + Math.abs(Math.random());
        }

    }

}