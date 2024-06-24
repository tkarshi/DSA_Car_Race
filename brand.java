// import java.time.DateTimeException;
import java.sql.Date;

public class brand {
    private String Brand_ID;
    private String Brand_Name, Location;
    private int Contact_Number;
    private Date Registered_Date;

    public String getBrand_ID() {
        return Brand_ID;
    }
    public void setBrand_ID(String brand_ID) {
        Brand_ID = brand_ID;
    }

    public String getBrand_Name() {
        return Brand_Name;
    }
    public void setBrand_Name(String brand_Name) {
        Brand_Name = brand_Name;
    }

    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }

    public int getContact_Number() {
        return Contact_Number;
    }
    public void setContact_Number(int contact_Number) {
        Contact_Number = contact_Number;
    }

    public Date getRegistered_Date() {
        return Registered_Date;
    }
    public void setRegistered_Date(Date registered_Date) {
        Registered_Date = registered_Date;
    }

    public brand(){

    }

    public brand(String Brand_ID,String Brand_Name, String Location, int Contact_Number, Date Registered_Date ){
        this.Brand_ID = Brand_ID;
        this.Brand_Name = Brand_Name;
        this.Location = Location;
        this.Contact_Number = Contact_Number;
        this.Registered_Date = Registered_Date;
    }

    public void display(){
        commancode.println("Brand ID:" + this.Brand_ID + ", Brand Name:" + this.Brand_Name + ", Location:" + this.Location + ",Contact Number:" + this.Contact_Number + ",Registered Date:" + Registered_Date );       
    }

    public static void displayAll(){
        for (brand b : db.Brands){
            b.display();
        }
    }

    public void save(){
        db.Brands.add(this);
        commancode.println("Insert Successfully");
        display();	
        brandrmenu();
    }

    public void save(String Brand_ID, String Brand_Name, String Location, int Contact_Number){
        this.Brand_ID = Brand_ID;
        this.Brand_Name = Brand_Name;
        this.Location = Location;
        this.Contact_Number = Contact_Number;
        save();
    }

    public void saveBrandDetails(){
        this.Brand_ID = commancode.input("Enter Brand ID: ");
        this.Brand_Name = commancode.input("Enter Brand Name: ");
        this.Location = commancode.input("Enter Location: ");
        this.Contact_Number = commancode.getInputInt("Enter Contact Number: ");
        save();
    }

    public void update(){
        brand b = searchBrandDetails(Brand_ID);
        if (b!= null){
           b.setBrand_Name(Brand_Name);
           b.setContact_Number(Contact_Number);
           b.setLocation(Location);
           commancode.println("Data Updated");
            
        }
        else{
            commancode.println("invalid data");
        }
    }

    public void search(String Brand_ID){
          brand b = searchBrandDetails(Brand_ID);
        if(b != null){
            b.display();
        }
        else{
            commancode.println("Invalid Brand ID");
        }
    }

    private static brand searchBrandDetails(String Brand_ID){
        for(brand b : db.Brands){
            if(b.getBrand_ID().equals(Brand_ID)){
                return b;
            }
        }
        return null;
    }
    public static brand getBrandObject(){
        displayAll();
        String Brand_ID = commancode.input("Enter the Brand ID:");
        return searchBrandDetails(Brand_ID);
    }

    public void brandrmenu(){
        commancode.println("Home > Brand");
        commancode.println("-------------");
        commancode.println("1 - Add Brand");
        commancode.println("2 - Update Brand Details");
        commancode.println("3 - Search Brand by Brand ID");
        commancode.println("4 - Go to Main Menu");

        String ch = commancode.input("What is your choice ?");

        switch(ch){
            case "1":
                 saveBrandDetails();
                 break;         
            case "2":
                search(Brand_ID);
                 break;
            case "3":
                update();
                break;
            case "4":
                 execute.MainMenu();           
            default:
                break;
        }
    }   
}
