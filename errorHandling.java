public class errorHandling {

    public static void HandleError(Exception ex){

        System.out.println(ex.getMessage());
    }
    
    public static void HandleError (StackOverflowError ex){

        System.out.println(ex.getMessage());
    }
}
