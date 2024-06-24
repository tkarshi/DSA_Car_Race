import javax.naming.directory.SearchControls;

public class driver {

    private String Driver_Id;
    private String name;
    private String Age;
    private String Address;
    private String NIC;
    private String Licensce;
    private String Bloodgroup;
    private int Contact_Number;
    private int Emergency_contact;
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }
    public void setAge(String age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public String getDriver_Id() {
        return Driver_Id;
    }
    public void setDriver_Id(String driver_Id) {
        Driver_Id = driver_Id;
    }

    public int getContact_Number() {
        return Contact_Number;
    }
    public void setContact_Number(int contact_Number) {
        Contact_Number = contact_Number;
    }

    public String getNIC() {
        return NIC;
    }
    public void setNIC(String nIC) {
        NIC = nIC;
    }

    public String getLicensce() {
        return Licensce;
    }
    public void setLicensce(String licensce) {
        Licensce = licensce;
    }

    public int getEmergency_contact() {
        return Emergency_contact;
    }
    public void setEmergency_contact(int emergency_contact) {
        Emergency_contact = emergency_contact;
    }

    public String getBloodgroup() {
        return Bloodgroup;
    }
    public void setBloodgroup(String bloodgroup) {
        Bloodgroup = bloodgroup;
    }

    
    public void driverMenu(){

        commancode.println("Home > Driver");
        commancode.println("-------------");
        commancode.println("1 - Add Driver");
        commancode.println("2 - Update Driver Details");
        commancode.println("3 - Search Driver by Driver ID");
        commancode.println("4 - View Driver Details");
        commancode.println("5 - Delete Driver Details");
        commancode.println("6 Main Menu");

        String ch = commancode.input("What is your choice ?");

        switch(ch){
            case "1":
                // displayAll();
                 this.saveDriverDetails();
                 break;         
            case "2":
                update();
                 break;
            case "3":
                search(Driver_Id);
                break;
            case "4":
                displayAll();
                break;
            case "5":
                deleteDriver();
                break;
            case "6":
                execute.MainMenu();
                
            default:
                break;
        }
    }

    public driver(){

    }

   public  driver (String Driver_Id, String name, String Age, String Address, String Licensce, String NIC, String Bloodgroup, int Contact_Number, int Emergency_contact){

        this.name = name;
        this.Driver_Id = Driver_Id;
        this.Address = Address;
        this.Age = Age;
        this.Contact_Number = Contact_Number;
        this.Bloodgroup = Bloodgroup;
        this.Emergency_contact = Emergency_contact;
        this.NIC = NIC;
        this.Licensce =Licensce;
        //save();
       
    } 

    public void display(){

        commancode.println("Driver ID: " + this.Driver_Id + ", Driver Name: " + this.name + ", Age: " + this.Age + ", Address: " + this.Address + ", Licence: " + this.Licensce + ", Contact Number" + this.Contact_Number);
        commancode.println("NIC: " + this.NIC + ", Emergency Contact:" + this.Emergency_contact + ",Blood Group:" + this.Bloodgroup);
    }

    public static void displayAll(){
        for (driver d : db.drivers){
            d.display();
        }
    }

    public void save(){
        db.drivers.add(this);
        display();
        driverMenu();
    }

    public void save (String Driver_Id, String name, String Age, String Address, String Licensce, String NIC, String Bloodgroup, int Contact_Number, int Emergency_contact ){
        this.name = name;
        this.Driver_Id = Driver_Id;
        this.Address = Address;
        this.Age = Age;
        this.Contact_Number = Contact_Number;
        this.Bloodgroup = Bloodgroup;
        this.Emergency_contact = Emergency_contact;
        this.NIC = NIC;
        this.Licensce =Licensce;
        save();
    }
    
    public void saveDriverDetails(){
        this.Driver_Id = commancode.input("Enter Driver ID: ");
        this.name = commancode.input("Enter Driver Name: ");
        this.Address = commancode.input("Enter Driver Address: ");
        this.Age = commancode.input("Enter Driver Age: ");
        this.Bloodgroup = commancode.input("Enter Blood Group:");
        this.Contact_Number = commancode.getInputInt("Enter Contact Number: ");
        this.Emergency_contact = commancode.getInputInt("Emergency Contact Number:");
        this.NIC = commancode.input("NIC:");
        this.Licensce = commancode.input("Licensce:");
        save();
    }

    // public void update(String name, String Address){
    //     driver d = searchDriverDetails(Driver_Id);
    //     if (d!= null){
    //         d.setId(Driver_Id);
    //         d.setName(name);
    //         d.setAddress(Address);
    //         d.setAge(Age);
    //         d.setBloodgroup(Bloodgroup);
    //         d.setContact_Number(Contact_Number);
    //         d.setEmergency_contact(Emergency_contact);
    //         d.setNIC(NIC);
    //         d.setLicensce(Licensce);
    //         commancode.println("Data Updated");
    //     }
    //     else{
    //         commancode.println("invalid data");
    //     }
    // }

    public void search(String Driver_Id){
        driver d = searchDriverDetails(Driver_Id);
        if(d != null){
            d.display();
        }
        else{
            commancode.println("Invalid Driver ID");
        }
    }

    private static driver searchDriverDetails(String Driver_Id){
        for(driver d : db.drivers){
            if(d.getDriver_Id().equals(Driver_Id)){
                return d;
            }
        }
        return null;
    }
    
    public static driver getDriverObject(){
        displayAll();
        String Driver_Id = commancode.input("Enter the Driver ID:");
        return searchDriverDetails(Driver_Id);
    }
    // public void saveDriverDetails() {
    //     setId(commancode.input("Enter The Driver ID : ")); 
    //     setName(commancode.input("Enter The Course Name : "));
    //     db.drivers.add(this); 
    // }

    public void update(){

      getDriverObject();

    //   if(Driver_Id != null){
    //     String name = commancode.input("Enter the name:");

    //     System.out.println("The" + Driver_Id + "updated");
    //    }
        for (driver d : db.drivers) {  //CHECK EACH ID
 
            if( d.getDriver_Id().equals(Driver_Id)){
                d.setName(commancode.input("Enter the Driver Name: "));
                d.setAddress(Address);
                d.setAge(Age);
                d.setBloodgroup(Bloodgroup);
                d.setContact_Number(Contact_Number);
                d.setEmergency_contact(Emergency_contact);
                d.setLicensce(Licensce);
                d.setNIC(NIC);
                System.out.println("Driver Updated Successfully");

            }
            
        }
    }

    public void deleteDriver(){

        getDriverObject();
        for (driver d: db.drivers) {
            if(d.getDriver_Id().equals(Driver_Id)){
                db.drivers.remove("Deleted Successfully");
                break;
            }
            
        }
    }
   
    
}
