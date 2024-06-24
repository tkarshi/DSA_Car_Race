import java.util.Scanner;

public class commancode {

    private static Scanner input = new Scanner(System.in);

    public static void println(String message){
        System.out.println(message);
    }

    public static void print(String message){
        System.out.print(message);
    } 
    
    public static String input(String message){
        print(message);
        return input.nextLine();
    }
    public static int getInputInt(String message) { 
        commancode.print(message); 
        return Integer.parseInt(input.nextLine()); 
    } 

    public static String getWhatIsYourChoice() { //get choice function
        commancode.println("What is your choice ?");
        return input.nextLine(); //return the entered choice 
    }

    public static float getInputFloat(String message) { 
        commancode.print(message); 
        return Float.parseFloat(input.nextLine()); 
    } 


    

    
}
