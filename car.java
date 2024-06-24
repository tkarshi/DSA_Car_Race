public class car {

    private float[] roundFinishTimeList = new float[3];
    private float totalTime;
    private String Car_ID;
    private String Car_Number;
    private String Car_color;

    private driver carDriver;
    private sponsor sponsorID;
    private brand branID;

    public String getCar_ID() {
        return Car_ID;
    }

    public void setCar_ID(String car_ID) {
        this.Car_ID = car_ID;
    }

    public driver getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(driver carDriver) {
        this.carDriver = carDriver;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public String getCar_Number() {
        return Car_Number;
    }

    public void setCar_Number(String car_Number) {
        Car_Number = car_Number;
    }

    public brand getBranID() {
        return branID;
    }

    public void setBranID(brand branID) {
        this.branID = branID;
    }

    public String getCar_color() {
        return Car_color;
    }

    public void setCar_color(String car_color) {
        Car_color = car_color;
    }

    public sponsor getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(sponsor sponsorID) {
        this.sponsorID = sponsorID;
    }

    public void carMenu() {
        commancode.println("Home > Car");
        commancode.println("-------------");
        commancode.println("1 - Add Car");
        commancode.println("2 - Update Car Details");
        commancode.println("3 - Delete Car Details");
        commancode.println("4 - Add Car Round Details");
        commancode.println("5 - Search Car by Car ID");
        commancode.println("6 - View all");
        commancode.println("7 - Go to Main Menu");
        String ch = commancode.input("What is your choice ?");
        switch (ch) {
            case "1":
                this.Save();
                break;
            case "2":
                update();
                break;
            case "3":
                delete();
                break;
            case "4":
                addRounds();
                break;
            case "5":
                search();
                break;
            case "6":
                displayAll();
                break;
            case "7":
                execute.MainMenu();
                break;
            default:
                break;
        }
    }

    public car() {

    }

    public car(String Car_ID, driver carDriver, String Car_color, String Car_Number, sponsor sponsorID, brand brandID) {

        this.Car_ID = Car_ID;
        this.carDriver = carDriver;
        this.Car_Number = Car_Number;
        this.Car_color = Car_color;
        this.branID = brandID;
        this.sponsorID = sponsorID;

    }

    // public void addRounds(){
    // int i = 0;
    // //System.out.println(getCarObject());
    // for(float f: routeFinishTimeList){

    // float fTime = commancode.getInputFloat("Enter the Round" + " " + (i+1) +
    // "reach time: ");
    // routeFinishTimeList[i++] = fTime;
    // totalTime += fTime;

    // }

    // }

    // -------------------------------------------------------------------------

    // List
    public void addRounds(int i) {

        car c = db.cars[i];
        String CarID = c.getCar_ID();
        System.out.println("CarID:" + CarID);
        float r1 = commancode.getInputFloat("Enter the R1:");
        float r2 = commancode.getInputFloat("Enter the R2:");
        float r3 = commancode.getInputFloat("Enter the R3:");
        c.roundFinishTimeList[0] = r1;
        c.roundFinishTimeList[1] = r2;
        c.roundFinishTimeList[2] = r3;
        this.totalTime = r1 + r2 + r3;
        System.out.println("Total Time of the" + CarID + " " + totalTime);

        // System.out.println("A - Prepare the Winner List");
        // System.out.println("B - View the total time of each car");
        // System.out.println("C - Return to Car Menu");
        // String ch = commancode.input("What is your choice ?");
        // switch(ch){
        // case "1":
        // winnerlist();
        // break;
        // case "2":
        // System.out.println("Total Time of the" + Car_ID + " " + this.totalTime);
        // break;
        // case "3":
        // carMenu();
        // break;
        // default:
        // break;

    }

    public void addRounds() {

        commancode.println("Enter the  Round results for Car..............");

        for (int i = 0; i < db.cars.length; i++) {
            this.totalTime = 0;
            addRounds(i);
        }

    }

    // ----------------------------------------------------------------

    // public void addRounds(){
    // for(int c =0; c<db.cars.length; c++){

    // car myCar = db.cars[c];
    // System.out.println("CarID:" +db.cars[c].getCar_ID());
    // float r1 = commancode.getInputFloat("Enter the R1:");
    // float r2 = commancode.getInputFloat("Enter the R2:");
    // float r3 = commancode.getInputFloat("Enter the R3:");
    // myCar.roundFinishTimeList[0]=r1;
    // myCar.roundFinishTimeList[1]=r2;
    // myCar.roundFinishTimeList[2]=r3;

    // myCar.totalTime = r1 + r2 + r3;

    // }

    // }

    public void winnerlist() {

        commancode.println("Enter the  Round results for Car..............");

        for (int i = 0; i < db.cars.length; i++) {
            // if(db.cars != null){
            // db.cars[i] = this;
            commancode.println("Car : " + db.cars[i].getCar_ID());
            this.totalTime = 0;
            addRounds();
            db.cars[i].setTotalTime(this.getTotalTime());

            // }
            // else{
            // commancode.println("Data is invalid");
            // }
        }

        commancode.println("Winner List");
    }

    public void display() {

        commancode.println("Car ID:" + Car_ID + ", Driver:" + carDriver.getDriver_Id() + ", Car Number:" + Car_Number
                + ",Car Color:" + Car_color);
        commancode.println(",Brand ID:" + branID.getBrand_ID() + ",Sponsor ID:" + sponsorID.getSponsor_ID());
    }

    public void displayAll(int index) {
        commancode.println((index + 1) + "Car ID:" + Car_ID + ", Driver:" + carDriver.getDriver_Id() + ", Car Number:"
                + Car_Number + ",Car Color:" + Car_color + ",Brand ID:" + branID.getBrand_ID() + ",Sponsor ID:"
                + sponsorID.getSponsor_ID());
        carMenu();
    }

    public static void displayAll() {
        for (car c : db.cars) {
            c.display();
        }
    }

    public void save() {

        try {
            for (int i = 0; i < db.cars.length; i++) {
                if (db.cars[i] == null) {
                    db.cars[i] = this;
                    commancode.println("Insert Successfully");
                    display();
                    break;
                }
            }

        }

        catch (StackOverflowError ex) {

            errorHandling.HandleError(ex);

        } catch (Exception ex) {

            errorHandling.HandleError(ex);

        }

        finally {

            // system will run if the system faced error or not faced error
        }

    }

    public void Save() {

        try {

            if (db.cars[db.cars.length - 1] != null) {
                commancode.println("Cannot enter the car details, the row is full");
                return;
            }
            this.Car_ID = commancode.input("Enter the Car ID: ");
            this.Car_Number = commancode.input("Enter the Car Number:");
            this.Car_color = commancode.input("Enter the Car Color:");
            this.carDriver = driver.getDriverObject();
            this.sponsorID = sponsor.getSponsorObject();
            this.branID = brand.getBrandObject();
            save();

        }

        catch (StackOverflowError ex) {

            errorHandling.HandleError(ex);

        } catch (Exception ex) {

            errorHandling.HandleError(ex);

        }

        finally {

            // system will run if the system faced error or not faced error
        }

    }

    public void update() {

        car c = searchCarDetails(commancode.input("Enter the Car ID:"));
        if (c != null) {
            c.setCarDriver(driver.getDriverObject());
            c.setTotalTime(totalTime);

            commancode.println("Data Updated");
        } else {
            commancode.println("Invalid data");
        }
    }

    public void search() {

        car c = searchCarDetails(commancode.input("Enter the Car ID:"));

        if (c != null) {
            c.display();
        } else {
            commancode.println("Invalid Car ID");
        }
    }

    private static car searchCarDetails(String Car_ID) {

        for (car c : db.cars) {
            System.out.println(c.getCar_ID());
            if (c.getCar_ID().equals(Car_ID)) {
                return c;
            }
        }
        return null;
    }

    private static void changeValueAfterDeleteDataInCarArray(int deletedIndexPosition) {

        for (int i = deletedIndexPosition; i < db.cars.length; i++) {

            if (i < db.cars.length - 1) {
                db.cars[i] = db.cars[i + 1];
                db.cars[i + 1] = null;
            }
        }
    }

    public static void delete() {

        boolean status = true;
        while (status) {
            String Car_ID = commancode.input("Enter the Car ID : ");
            for (int i = 0; i < db.cars.length; i++) {
                if (db.cars[i] != null) {
                    if (db.cars[i].getCar_ID().equals(Car_ID)) {
                        db.cars[i] = null;
                        commancode.println("Deleted Successfully");
                        changeValueAfterDeleteDataInCarArray(i);
                        status = false;

                    } else {
                        String ch = commancode.input("Invalid Data. t to try again, any other keys to exit : ");
                        if (!ch.equals("t")) {
                            status = false;
                        }
                        break;

                    }

                }
            }

        }

    }

    public static car getCarObject() {
        displayAll();
        String Car_Id = commancode.input("Enter the Car ID:");
        return searchCarDetails(Car_Id);
    }

}

// public void save (String Car_Id, String CarDriver, Float totalTime ){
// this.Car_ID = Car_ID;
// this.carDriver = carDriver;
// this.totalTime = totalTime;
// save();
// }

// public void saveCarDetails(){
// this.Car_ID = commancode.input("Enter Car ID: ");
// //this.carDriver =commancode.input("Enter Car ID: ");
// getCarDriver();
// this.Car_Number = commancode.input("Enter Car Number: ");
// this.totalTime = Float.parseFloat(commancode.input("Enter totalTime: "));
// save();
// }

// public void save(){
// db.Cars.add(this);
// System.out.println("Car Registered Successfully");
// //display();
// }
