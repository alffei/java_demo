package com.gd.talks.one;

/**
 * Switch 空指针简析
 * <p>
 * javac SwitchTest.java
 * <p>
 * javap -c SwitchTest
 */
public class SwitchTest {

    public static void main(String[] args) {
        String param = "1";
        switch (param) {
            case "1":
                System.out.println("1");
                break;
            default:
                System.out.println("default");
        }
    }
}
