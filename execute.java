

class execute{

    public static void main(String[] args) {

      System.out.println("Welcome to ABC PVT");
      System.out.println("------------------");
      System.out.println("   A     B B B   C C C");
      System.out.println("  A  A   BBBBB C ");
      System.out.println(" A AA A  B   B C");
      System.out.println("A      A B B B  C C C C");
           
      // String username;
      // String password;
    
      // username = commancode.input("Enter the username:");
      // password = commancode.input("Enter the password:");

      //String mergantcolor = "\u001B[35m";
     
//      if(username.equals("Admin@ABC") && password.equals("ABC0004")){
     
      System.out.println("Successfully Login");
      System.out.println("------------------");
      db.fkdriverdata();
      db.fkbranddata();
      db.fksponsordata();
      MainMenu();
  
//      }
//      else{
//       System.out.println("Login is not successful, Check the username and password");
       }

      // try{


      // }


      // catch(StackOverflowError ex){

      //       errorHandling.HandleError(ex);

      // } catch(Exception ex){

      // errorHandling.HandleError(ex);

      // }
      
      // finally{
             
      //       //system will run if the system faced error or not faced error
      // }
      
      // }


    

      // driver D = new driver(null, null, null, null, null, null, null, 0, 0);
      // d.drivermenu();
         
        public static void MainMenu(){
             
              
              commancode.println("Home > Main Menu");
              commancode.println("----------------");
              commancode.println("1 - Driver Menu");
              commancode.println("2 - Car Menu");
              commancode.println("3 - Winner List");
              commancode.println("4 - Sponsor Menu");
              commancode.println("5 - Brand Details");
              commancode.println("6 - Race Details");
  
              String choice = commancode.getWhatIsYourChoice();
  
          while (true) {
            switch(choice){
                  case "1":
                        new driver().driverMenu();
                        break;
                  case "2":
                        new car().carMenu();
                        break;
                  case "3":
                        new winner_list().display();
                        break;
                  case "4":
                        new sponsor().sponsormenu();
                        break;
                  case "5":
                        new brand().brandrmenu();                  
                  default:
                  commancode.print("Invalid choice");
                    break;
    
            }
          }
            
  
  }   

 
        
 }
