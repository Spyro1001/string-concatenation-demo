package com.example;

import org.springframework.util.StopWatch;

import java.util.Scanner;

/**
 * This class demonstrates the differences between different concatenation strategies.
 *
 * LOOP_COUNT determines how many concatenation iterations each type of concatenation goes through
 * TEST_COUNT determines how many times the full set of tests is run.  Each TEST_COUNT iteration, the test
 * strings are doubled in size.
 */
public class
StringConcatenation {

    public static void main(String[] args) {

        // our test data
        String testString1 = "A";
        String testString2 = "B";
        String targetString = "";

        // loop counter for each test
        final int LOOP_COUNT = 500000;

        // determines how many times the suite of tests is run
        final int TEST_COUNT = 2;

        // need a stopwatch to time this!
        StopWatch sw = new StopWatch();

        System.out.println("All times shown are in milliseconds");
        System.out.println("    Loop Count: " + LOOP_COUNT);
        System.out.println("Test Run Count: " + TEST_COUNT + "\n");

        for (int counter = 1; counter <= TEST_COUNT; counter++) {

            System.out.println("\n***** TEST RUN " + counter + " *****");
            System.out.println("Test string length: " + testString1.length() + " characters.");

            /*
             * + concatenation test (static)
             * concatenating the same two string
             */
            targetString = "";
            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                targetString = testString1 + testString2;
            }
            sw.stop();

            System.out.println("+ concatenation static: " + sw.getLastTaskTimeMillis());

            /*
             * + concatenation test (incremental)
             * concatenating the same string back onto itself
             */
            targetString = "";
            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                targetString = targetString + testString1;
            }
            sw.stop();

            System.out.println("+ concatenation incremental: " + sw.getLastTaskTimeMillis());

            /*
             * += concatenation test
             */
            targetString = "";
            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                targetString += testString1;
            }
            sw.stop();

            System.out.println("+= concatenation: " + sw.getLastTaskTimeMillis());

            /*
             * method concatenation test
             */
            targetString = "";
            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                targetString = targetString.concat(testString1);
            }
            sw.stop();

            System.out.println("method concatenation: " + sw.getLastTaskTimeMillis());

            /*
             * StringBuilder concatenation test
             */
            targetString = "";
            StringBuilder sb = new StringBuilder();

            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                sb.append(testString1);
            }
            sw.stop();

            System.out.println("StringBuilder concatenation: " + sw.getLastTaskTimeMillis());

            /*
             * StringBuffer concatenation test
             */
            targetString = "";
            StringBuffer sbu = new StringBuffer();

            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {
                sbu.append(testString1);
            }
            sw.stop();

            System.out.println("StringBuffer concatenation: " + sw.getLastTaskTimeMillis());

            /*
             * empty loop - for reference
             */
            sw.start();
            for (int x = 1; x <= LOOP_COUNT; x++) {}
            sw.stop();

            System.out.println("Empty Loop: " + sw.getLastTaskTimeMillis());

            /*
             * Setup for next loop
             *
             * Double the size of the test string
             */
            testString1 = new StringBuilder().append(testString1).append(testString1).toString();
            testString2 = new StringBuilder().append(testString2).append(testString2).toString();

            if (counter != TEST_COUNT) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Hit ENTER to continue");
                String dontCare = scanner.nextLine();
            }

        }

    }

}
