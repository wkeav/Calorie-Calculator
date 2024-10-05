import java.util.Scanner;
import java.lang.Math;

public class CalorieCalculator{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for information, asumming user is perfect
        System.out.println("Welcome to the Calorie Calculator! ");
        System.out.print("Enter your gender (M/F): ");
        String gender = keyboard.nextLine().toLowerCase();
        System.out.print("Enter your age: ");
        int age = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Enter your weight (kg): ");
        String weightInput = keyboard.nextLine();
        double weight = Double.parseDouble(weightInput);
        System.out.print("Enter your height (cm): ");
        String heightInput = keyboard.nextLine();
        double height = Double.parseDouble(heightInput); 
        System.out.print("Enter your activity level (sedentary/moderate/active): ");
        String activityLevel = keyboard.next().toLowerCase();

        // Calculate BMR
        double bmr;
        if (gender.equalsIgnoreCase("M")) {
            bmr = Math.round(88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age));
        } else if (gender.equalsIgnoreCase("F")) {
            bmr = Math.round(447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age));
        } else {
            System.out.println("Invalid gender input. Please enter M or F.");
            return;
        }

        // Calculate daily calorie needs based on user activity level
        double calorieNeeds;
        switch (activityLevel.toLowerCase()) {
            case "sedentary":
                calorieNeeds = Math.round(bmr * 1.2);
                break;
            case "moderate":
                calorieNeeds = Math.round(bmr * 1.55);
                break;
            case "active":
                calorieNeeds = Math.round(bmr * 1.725);
                break;
            default:
                System.out.println("Invalid activity level input.");
                return;
        }
        //Ask user if they want to be in a calorie deficit, maintenance or surplus 
        System.out.println("Would you like to be in a calorie deficit, maintenance, or surplus?");
        String goal = keyboard.next().toLowerCase();

        //Calculating user diet calorie depending on user goal
        switch(goal){
            case "deficit":
                calorieNeeds -= 500;  // Standard recommendation for a 500-calorie deficit per day
                System.out.println("You've chosen a calorie deficit for weight loss.");
                break;
            case "maintenance":
                // No change needed for maintenance
                System.out.println("You've chosen calorie maintenance.");
                break;
            case "surplus":
                calorieNeeds += 500;  // Standard recommendation for a 500-calorie surplus per day
                System.out.println("You've chosen a calorie surplus for muscle gain.");
                break;
            default:
                System.out.println("Invalid input. Please enter 'deficit', 'maintenance', or 'surplus'.");
                return;
        }



        // Display the results
        System.out.println("Your Basal Metabolic Rate (BMR) is: " + (int) bmr + " calories per day.");
        System.out.println("Your estimated daily calorie needs are: " + (int) calorieNeeds + " calories per day.");

        keyboard.close();
    }
}