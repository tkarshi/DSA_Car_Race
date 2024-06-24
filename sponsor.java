import javax.print.attribute.standard.MediaSize.NA;

public class sponsor {

    private String Sponsor_ID;
    private String  Name;
    private String Address;
    private String Type;
    private int Contact_Number;

    public String getSponsor_ID() {
        return Sponsor_ID;
    }
    public void setSponsor_ID(String sponsor_ID) {
        Sponsor_ID = sponsor_ID;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public int getContact_Number() {
        return Contact_Number;
    }
    public void setContact_Number(int contact_Number) {
        Contact_Number = contact_Number;
    }

    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }

    public void sponsormenu(){
        commancode.println("Home > Sponsor");
        commancode.println("-------------");
        commancode.println("1 - Add Sponsor");
        commancode.println("2 - Update Sponsor Details");
        commancode.println("3 - Search Sponsor by Sponsor ID");
        commancode.println("4 - Go to Main Menu");

        String ch = commancode.input("What is your choice ?");

        switch(ch){
            case "1":
                 saveSponsorDetails();
                 break;         
            case "2":
                search(Sponsor_ID);
                 break;
            case "3":
                update(Sponsor_ID,Name,Address,Type,Contact_Number);
                break;
            case "4":
                 execute.MainMenu();           
            default:
                break;
        }
    }

    public sponsor(){

    }

    public sponsor(String Sponsor_ID, String Name, String Address, String Type, int Contact_Number){
        this.Sponsor_ID = Sponsor_ID;
        this.Name = Name;
        this.Address = Address;
        this.Contact_Number = Contact_Number;
        this.Type = Type;
    }

    public void display(){
        commancode.println("Sponsor ID:" + this.Sponsor_ID + ", Sponsor Name:" + this.Name + ", Address:" + this.Address + ",Contact Number:" + this.Contact_Number);       
    }

    public static void displayAll(){
        for (sponsor s : db.Sponsors){
            s.display();
        }
    }

    public void save(){
        db.Sponsors.add(this);
        commancode.println("Insert Successfully");
        display();       
        sponsormenu();
    }

    public void save(String Sponsor_ID, String Name, String Address, String Type, int Contact_Number){
        this.Sponsor_ID = Sponsor_ID;
        this.Name = Name;
        this.Address = Address;
        this.Contact_Number = Contact_Number;
        this.Type = Type;
        save();
    }

    public void saveSponsorDetails(){
        this.Sponsor_ID = commancode.input("Enter Sponsor ID: ");
        this.Name = commancode.input("Enter Sponsor Name: ");
        this.Address = commancode.input("Enter Sponsor Address: ");
        this.Contact_Number = commancode.getInputInt("Enter Contact Number: ");
        this.Type = commancode.input("Enter Sponsor Type: ");
        save();
    }

    public void update(String Sponsor_ID, String Name, String Address, String Type, int Contact_Number){
        sponsor s = searchSponsorDetails(Sponsor_ID);
        if (s!= null){
            s.setSponsor_ID(Sponsor_ID);
            s.setName(Name);
            s.setAddress(Address);
            s.setContact_Number(Contact_Number);
            s.setType(Type);
            commancode.println("Data Updated");
        }
        else{
            commancode.println("invalid data");
        }
    }
    
    public void search(String Sponsor_ID){
        sponsor s = searchSponsorDetails(Sponsor_ID);
        if(s != null){
            s.display();
        }
        else{
            commancode.println("Invalid Sponsor ID");
        }
    }

    private static sponsor searchSponsorDetails(String Sponsor_ID){
        for(sponsor s : db.Sponsors){
            if(s.getSponsor_ID().equals(Sponsor_ID)){
                return s;
            }
        }
        return null;
    }
    public static sponsor getSponsorObject(){
        displayAll();
        String Sponsor_ID = commancode.input("Enter the Sponsor ID:");
        return searchSponsorDetails(Sponsor_ID);
    }



   





    
}
