import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int option;
        System.out.print("Welcome! What's your name?: ");
        String name = scanner.next();

        do{
            option = menu(scanner,name);
            switch (option) {
            case 1:
                bmi(scanner);
                break;

            case 2:
                temperatureConverter(scanner);
                break;
            case 3:
                interestCalculator(scanner);
                break;

            default:
                System.out.println("\nSee you soon!");
        }
        } while(option!=0);

        scanner.close();
    }
    static int menu (Scanner scanner, String name){

        int option;


        System.out.printf("Hello %s, you're in the menu!\n", name);
        System.out.print("Choose the tool you want to use:\n" +
                "Type 1 to use: BMI Calculator\n" +
                "Type 2 to use: Temperature Converter\n" +
                "Type 3 to use: Compound Interest Calculator\n" +
                "Type 0 to Exit\nEnter your choice: ");
        option = scanner.nextInt();

        while (option < 0 || option > 3) {
            System.out.print("Choose a valid option:\n" +
                    "Type 1 to use: BMI Calculator\n" +
                    "Type 2 to use: Temperature Converter\n" +
                    "Type 3 to use: Compound Interest Calculator\n" +
                    "Type 0 to Exit\nEnter your choice: ");
            option = scanner.nextInt();
        }
        return option;
    }
    static void bmi(Scanner scanner){
        Double weight;
        Double height;
        Double bmi;

        System.out.println("\nYou chose: BMI Calculator!!");

        System.out.print("Enter your weight in kgs: ");
        weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        height = scanner.nextDouble();

        bmi = weight / Math.pow(height, 2);

        if (bmi <= 18.5) {
            System.out.printf("Your BMI is: %.2f, you are underweight\n", bmi);
        } else if (bmi > 18.5 && bmi <= 24.9) {
            System.out.printf("Your BMI is: %.2f, you have a normal weight\n", bmi);
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.printf("Your BMI is: %.2f, you are overweight\n", bmi);
        } else if (bmi >= 30 && bmi <= 34.9) {
            System.out.printf("Your BMI is: %.2f, you have obesity class 1\n", bmi);
        } else if (bmi >= 34.9 && bmi <= 39.9) {
            System.out.printf("Your BMI is: %.2f, you have obesity class 2\n", bmi);
        } else {
            System.out.printf("Your BMI is: %.2f, you have obesity class 3\n", bmi);
        }
    }
    static void temperatureConverter(Scanner scanner){
        double temperature;
        double finalTemperature;

        System.out.println("\nYou chose: Temperature Converter!!");

        System.out.print("Type 1 to convert Celsius to Fahrenheit.\n" +
                "Type 2 to convert Fahrenheit to Celsius\n" +
                "Enter your choice: ");
        int tempOption = scanner.nextInt();

        while (tempOption != 1 && tempOption != 2) {
            System.out.println("\nPlease choose a valid option!!");
            System.out.print("Type 1 to convert Celsius to Fahrenheit.\n" +
                    "Type 2 to convert Fahrenheit to Celsius\n" +
                    "Enter your choice: ");
            tempOption = scanner.nextInt();
        }

        if (tempOption == 1) {
            System.out.print("Enter the temperature in Celsius: ");
            temperature = scanner.nextDouble();

            finalTemperature = ((temperature * 9) / 5) + 32;
            System.out.printf("The temperature in Fahrenheit is: %.2f°F\n", finalTemperature);

        } else {
            System.out.print("Enter the temperature in Fahrenheit: ");
            temperature = scanner.nextDouble();

            finalTemperature = (temperature - 32) * (5.0 / 9);
            System.out.printf("The temperature in Celsius is: %.2f°C\n", finalTemperature);
        }

    }
    static void interestCalculator(Scanner scanner){
        double finalAmount;
        int months;
        double initialAmount;
        double monthlyInterestRate;

        System.out.println("\nYou chose: Compound Interest Calculator!!");

        System.out.print("What is the initial amount you want to invest?: ");
        initialAmount = scanner.nextDouble();

        System.out.print("How many months will you leave the money invested?: ");
        months = scanner.nextInt();

        System.out.print("What is the monthly interest rate (%): ");
        monthlyInterestRate = scanner.nextDouble() / 100;

        finalAmount = initialAmount * Math.pow((1 + monthlyInterestRate), months);
        System.out.printf("With this investment, you will have: $%.2f", finalAmount);
    }
}
