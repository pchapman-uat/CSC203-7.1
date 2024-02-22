// Import the Scanner class from the java.util package.
// This allows to recive the next line of input from the user.
import java.util.Scanner;

// This is a class that will store the stats of a class at the school.
class Stats{
    // Following values are header information
    // Scanner is saved here to allow for the user to input values.
    String name;
    String className;
    Scanner scan;
    String startTime;
    
    // Following values are the stats of the class predection.
    int fun;
    int cool;
    boolean need;
    int hours;
    float pass;
    boolean repeat;
    boolean friends;

    // This is the final score value.
    float score;
    // This is the constructer, as it has the same name as the class.
    // It will take in the name of the student, the class name, the start time, and the scanner object.
    Stats(String name, String className, String startTime, Scanner scan){
        this.name = name;
        this.className = className;
        this.startTime = startTime;
        this.scan = scan;
    }
    // This is a method that will run all of the other methods to set the values.
    void setAll(){
        // A blank print line is added for spacing
        System.out.println();
        this.setFun();
        System.out.println();
        this.setCool();
        System.out.println();
        this.setNeed();
        System.out.println();
        this.setHours();
        System.out.println();
        this.setPass();
        System.out.println();
        this.setRepeat();
        System.out.println();
        this.setFriends();
        System.out.println();
    }

    // This method will return a boolean value of if the user should take the class.
    // This method will take in a float value X.
    // X is the modifier for the score, and is used to make the prediction more accurate.
    boolean predictTakeClass(float X){
        // This formats a boolean as an integer.
        // "?" specifies that formating is being done
        // the part before the ":" is when the condition is true
        // the part after the ":" is when the condition is false

        // This can be writen as the following:
        /*
          if(this.need){
                need = 1;
            } else {
                need = 2;
            }
         */
        int need = this.need ? 1 : 2;
        int repeat = this.repeat ? 2 : 1;
        int friends = this.friends ? 2 : 1;
        // This is the formula for the prediction.
        float predict = ((this.fun +(this.cool/need) + this.hours * (this.pass/repeat * friends)) *X);
        this.score = predict;
        // This returns a boolean value of if the prediction is greater than 1.
        return predict >= 1;
    }
    // This method will set the fun value
    void setFun(){
        System.out.println("How fun would you predict this class would be? (1-10)");
        int value = this.scan.nextInt();
        // This while loop will keep asking the user for a value until it is between 1 and 10.
        while(true){
            // Using the between method to check if the value is between 1 and 10.
            if(this.between(1, 10, value)) {
                // Set the fun value and break out of the loop
                this.fun = value;
                break;
            }
            else{
                // Prompt the user to enter a value between 1 and 10.
                System.out.println("Please enter a number between 1 and 10.");
                value = this.scan.nextInt();
            }
        }
    }

    // This method will set the cool value
    // This method is identical to the setFun method, however it will set the cool value instead.
    void setCool(){
        System.out.println("How cool would you predict this class would be? (1-10)");
        int value = this.scan.nextInt();
        while(true){
            if(between(1, 10, value)) {
                this.cool = value;
                break;
            }
            else{
                System.out.println("Please enter a number between 1 and 10.");
                value = this.scan.nextInt();
            }
        }
    }

    // This method will set the need value
    void setNeed(){
        System.out.println("Do you need this class to graduate? (y/n)");
        String value = this.scan.nextLine();
        while(true){
            // This if statement checks if the value is equal to y or n.
            if(value.equals("y") || value.equals("n")) {
                // If the valuye is equal to y, then set the need value to true.
                if(value.equals("y")) this.need = true;
                // If the valuye is equal to n, then set the need value to false.
                else this.need = false;
                // Break out of the loop
                break;
            } else{
                // Prompt the user to enter y or n.
                System.out.println("Please enter y or n.");
                value = this.scan.nextLine();
            }
        }
    }

    // This method will set the hours value
    // This method is identical to the setFun and setCool method, however it uses values between 1-12
    void setHours(){
        System.out.println("This class starts at " + this.startTime);
        System.out.println("How many hours will this start after you wake up? (1-12)");;
        int value = this.scan.nextInt();
        while(true){
            if(between(1, 12, value)) {
                this.hours = value;
                break;
            }
            else{
                System.out.println("Please enter a number between 1 and 12.");
                value = this.scan.nextInt();
            }
        }
    }

    // This method will set the pass value
    void setPass() {
        System.out.println("What is the chance you will pass the class? (0.00-1.00)");
        float value = this.scan.nextFloat();
        while(true){
            // This if statement checks if the value is between 0.00 and 1.00.
            if(value >= 0.00 && value <= 1.00) {
                this.pass = value;
                break;
            }
            else{
                // Prompt the user to enter a value between 0.00 and 1.00.
                System.out.println("Please enter a number between 0.00 and 1.00.");
                value = this.scan.nextFloat();
            }
        }
    }

    // This method will set the repeat value
    // This method is identical to the setNeed method, however it will set the repeat value instead.
    void setRepeat(){
        System.out.println("Have you taken this class already? (y/n)");
        String value = this.scan.nextLine();
        while(true){
            if(value.equals("y") || value.equals("n")) {
                if(value.equals("y")) this.repeat = true;
                else this.repeat = false;
                break;
            } else{
                System.out.println("Please enter y or n.");
                value = this.scan.nextLine();
            }
        }
    }

    // This method will set the friends value
    // This method is identical to the setNeed and setRepeat method, however it will set the friends value instead.
    void setFriends(){
        System.out.println("Do you have any smart friends in this class? (y/n)");
        String value = this.scan.nextLine();
        while(true){
            if(value.equals("y") || value.equals("n")) {
                if(value.equals("y")) this.friends = true;
                else this.friends = false;
                break;
            } else{
                System.out.println("Please enter y or n.");
                value = this.scan.nextLine();
            }
        }
    }

    // This method will check if the value is between a min and a max
    boolean between(int min, int max, int value){
        return min <= value && value <= max;
    }
    
}

// This class will hold the school information
class School{
    String name;
    String className;
    String[] description;
    String startTime;

    // The following methods are not needed, however it allows for addional code to be added easily
    void setName(String name){
        this.name = name;
    }
    void setClassName(String className){
        this.className = className;
    }
    void setDescription(String[] description){
        this.description = description;
    }
    void setStartTime(String startTime){
        this.startTime = startTime;
    }
}

public class Main{
    public static void main(String[] args){
        // This is the scanner that will be used to get user input
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! Before we start, please enter your name:");
        String name = scan.nextLine();
        
        // Create a new school object
        School school = new School();
        // Set the values of the object
        school.setName("School of Splatting");
        school.setClassName("Splatoon 101");
        school.setDescription(
            new String[]
            {
                "This class will teach you how to play Splatoon.",
                "You will learn the basics of the game, and how to play with others.",
                "Please bring your controller and a friend, as we will have matches often!",
                "This class will be fun, and you will learn a lot!",
                "Happy Splatting!"
            }
        );
        school.setStartTime("1:00pm");

        System.out.println("Welcome to the " + school.name + " " + name + "!");
        System.out.println(name + ", you will be enrolled in " + school.className + ".");
        System.out.println("Here is a description of the class:");

        // Print all values of the description array
        for(String s : school.description){
            System.out.println(s);
            // A try catch statement is used to delay the output of the description.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Create a new Stats object
        Stats stats = new Stats(name, school.className, "1:00pm", scan);;

        // Set all values of the Stats object
        stats.setAll();

        // Predict if the user should take the class, returning a boolean
        boolean result = stats.predictTakeClass(0.07f);
        // Print the score
        System.out.println("Your score is: " + stats.score);
        // If the result is true, the user should take the class.
        // If the result is false, the user should not take the class.
        if(result){
            System.out.println(name + ", You should take this class!");
        } else {
            System.out.println(name + ", you should not take this class!");
        }

        // Close the scanner
        scan.close();
    }
}