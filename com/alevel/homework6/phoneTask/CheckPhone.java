package com.alevel.homework6.phoneTask;

public class CheckPhone {
    public static void main(String[] args) {
        Phone phoneOne = new Phone("+380996661234", "Nokia 1100", 0.45);
        Phone phoneTwo = new Phone("+380996665678", "Samsung Galaxy S3", 0.32);
        Phone phoneThree = new Phone("+380996669000", "Motorola RAZR V3i", 0.59);

        System.out.println("Number is: " + phoneOne.number);
        System.out.println("Model is: " + phoneOne.model);
        System.out.println("Weight is: " + phoneOne.weight);
        System.out.println("-----------------------------------");

        System.out.println("Number is: " + phoneTwo.number);
        System.out.println("Model is: " + phoneTwo.model);
        System.out.println("Weight is: " + phoneTwo.weight);
        System.out.println("-----------------------------------");

        System.out.println("Number is: " + phoneThree.number);
        System.out.println("Model is: " + phoneThree.model);
        System.out.println("Weight is: " + phoneThree.weight);
        System.out.println("-----------------------------------");

        phoneOne.receiveCall("Michael");
        String firstPhoneNumber = phoneOne.getNumber();
        System.out.println("-----------------------------------");

        phoneTwo.receiveCall("John");
        String secondPhoneNumber = phoneTwo.getNumber();
        System.out.println("-----------------------------------");

        phoneThree.receiveCall("Sarah");
        String thirdPhoneNumber = phoneThree.getNumber();
        System.out.println("-----------------------------------");

    }
}
