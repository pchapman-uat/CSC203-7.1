import java.util.Scanner;

class Stats{
    String name;
    String className;
    Scanner scan;
    String startTime;
    
    int fun;
    int cool;
    boolean need;
    int hours;
    float pass;
    boolean repeat;
    boolean friends;

    float score;
    Stats(String name, String className, String startTime, Scanner scan){
        this.name = name;
        this.className = className;
        this.startTime = startTime;
        this.scan = scan;
    }
    void setAll(){
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

    boolean predictTakeClass(float X){
        int need = this.need ? 1 : 2;
        int repeat = this.repeat ? 2 : 1;
        int friends = this.friends ? 2 : 1;
        float predict = ((this.fun +(this.cool/need) + this.hours * (this.pass/repeat * friends)) *X);
        this.score = predict;
        return predict >= 1;
    }
    void setFun(){
        System.out.println("How fun would you predict this class would be? (1-10)");
        int value = this.scan.nextInt();
        while(true){
            if(between(1, 10, value)) {
                this.fun = value;
                break;
            }
            else{
                System.out.println("Please enter a number between 1 and 10.");
                value = this.scan.nextInt();
            }
        }
    }

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

    void setNeed(){
        System.out.println("Do you need this class to graduate? (y/n)");
        String value = this.scan.nextLine();
        while(true){
            if(value.equals("y") || value.equals("n")) {
                if(value.equals("y")) this.need = true;
                else this.need = false;
                break;
            } else{
                System.out.println("Please enter y or n.");
                value = this.scan.nextLine();
            }
        }
    }

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

    void setPass() {
        System.out.println("What is the chance you will pass the class? (0.00-1.00)");
        float value = this.scan.nextFloat();
        while(true){
            if(value >= 0.00 && value <= 1.00) {
                this.pass = value;
                break;
            }
            else{
                System.out.println("Please enter a number between 0.00 and 1.00.");
                value = this.scan.nextFloat();
            }
        }
    }

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

    boolean between(int min, int max, int value){

        return min <= value && value <= max;
    }
    
}

class School{
    String name;
    String className;
    String[] description;
    String startTime;

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
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! Before we start, please enter your name:");
        String name = scan.nextLine();
        
        School school = new School();
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

        for(String s : school.description){
            System.out.println(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Stats stats = new Stats(name, school.className, "1:00pm", scan);;

        stats.setAll();

        boolean result = stats.predictTakeClass(0.07f);
        System.out.println("Your score is: " + stats.score);
        if(result){
            System.out.println(name + ", You should take this class!");
        } else {
            System.out.println(name + ", you should not take this class!");
        }

        scan.close();
    }
}