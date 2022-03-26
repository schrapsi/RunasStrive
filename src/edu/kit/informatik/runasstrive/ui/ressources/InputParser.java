package edu.kit.informatik.runasstrive.ui.ressources;

import java.util.HashSet;

/**
 * This Class is a Utility class to Parse the player input
 *
 * @author ucfoh
 * @version 1.0
 */
public final class InputParser {

    private InputParser() {
    }

    /**
     * This Method parses the Input
     *
     * @param input                   of the Player
     * @param amountOfExpectedNumbers expected numbers
     * @param upperRange              upper range of the allowed input
     * @param allowedDuplicates       if the input allows duplicates
     * @return the parsed numbers as Integer array
     * @throws IllegalArgumentException if the parsing failed
     */
    public static int[] parseInput(String input, int amountOfExpectedNumbers, int upperRange, boolean allowedDuplicates)
            throws IllegalArgumentException {

        preSplitCheck(input, amountOfExpectedNumbers);

        String[] inputSplit = input.split(",");
        int[] numbers = new int[amountOfExpectedNumbers];

        if (inputSplit.length != amountOfExpectedNumbers) {
            throw new IllegalArgumentException(("not enough numbers"));
        }
        for (String split : inputSplit) {
            if (split.equals("")) {
                throw new IllegalArgumentException(("empty splits are not allowed"));
            }
        }

        for (int i = 0; i < amountOfExpectedNumbers; i++) {
            char firstChar = inputSplit[i].charAt(0);
            if (firstChar == '0' || firstChar == '+' || firstChar == ' ') {
                throw new IllegalArgumentException("0, +, SPACE ist not allowed");
            }
            try {
                numbers[i] = Integer.parseInt(inputSplit[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Integer Parsing failed");
            }
        }
        rangeAndDuplicateCheck(numbers, upperRange, allowedDuplicates);

        return numbers;

    }

    /**
     * Special parsing for the Healing state because the amount of numbers is decided by the player.
     *
     * @param input      String player input
     * @param upperRange upper range of the allowed input
     * @return the parsed numbers as Integer array
     * @throws IllegalArgumentException if the parsing failed
     */
    public static int[] healingParser(String input, int upperRange)
            throws IllegalArgumentException {
        int counter = 0;
        for (char character : input.toCharArray()) {
            if (character == ',') {
                counter++;
            }
        }
        if (input.length() != (2 * counter) + 1) {
            throw new IllegalArgumentException("wrong comma input");
        }
        if (counter + 1 >= upperRange) {
            throw new IllegalArgumentException("to many numbers");
        }
        return parseInput(input, counter + 1, upperRange, false);

    }

    private static void preSplitCheck(String input, int amountOfExpectedNumbers) {

        int counter = 0;
        for (char character : input.toCharArray()) {
            if (character == ',') {
                counter++;
            }
        }
        if (input.equals("")) {
            throw new IllegalArgumentException("Input is required");
        }
        if (counter != amountOfExpectedNumbers - 1) {
            throw new IllegalArgumentException("Not enough or to many comma");
        }

    }

    private static void rangeAndDuplicateCheck(int[] numbers, int upperRange, boolean allowedDuplicates) {

        HashSet<Integer> cardSet = new HashSet<>();
        for (int number : numbers) {
            if (number > upperRange || number < 1) {
                throw new IllegalArgumentException("number is out of range");
            }
            cardSet.add(number);
        }

        if (!allowedDuplicates && cardSet.size() != numbers.length) {
            throw new IllegalArgumentException("Duplicates are not allowed");
        }

    }


}
