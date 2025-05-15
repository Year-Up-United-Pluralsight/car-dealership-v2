package com.pluralsight;

public class ColorCodes {

    // GETS COLOR CODES
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";

    // RETURNS COLORED WORD
    public static String colorText(String color, String text) {
        String colorCode = switch (color.toLowerCase()) {
            case "black" -> BLACK;
            case "red" -> RED;
            case "green" -> GREEN;
            case "yellow" -> YELLOW;
            case "blue" -> BLUE;
            case "magenta" -> MAGENTA;
            case "cyan" -> CYAN;
            case "white" -> WHITE;
            case "bright red" -> BRIGHT_RED;
            case "bright green" -> BRIGHT_GREEN;
            default -> RESET;  // Resets if invalid color
        };
        return colorCode + text + RESET;  // (RESET reverts color back to normal at the end)
    }

// FORMERLY USED IN USER INTERFACE displayVehicles() FOR COLOR
//
//    String vin = String.format("%-10s", "VIN");
//    String year = String.format("%-10s", "Year");
//    String make = String.format("%-10s", "Make");
//    String model = String.format("%-10s", "Model");
//    String type = String.format("%-10s", "Type");
//    String color = String.format("%-10s", "Color");
//    String odometer = String.format("%-10s", "Odometer");
//    String price = String.format("%-10s", "Price");
//
//        System.out.print(ColorCodes.colorText("Red", "VIN        ") +
//                ColorCodes.colorText("Green", "YEAR        ") +
//                ColorCodes.colorText("Yellow", "MAKE        ") +
//                ColorCodes.colorText("Blue", "MODEL        ") +
//                ColorCodes.colorText("Magenta", "TYPE        ") +
//                ColorCodes.colorText("Cyan", "COLOR        ") +
//                ColorCodes.colorText("Bright Green", "ODOMETER        ") +
//                ColorCodes.colorText("Bright Red", "PRICE") + "\n");


}


