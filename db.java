import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

public class db {
    public static List<driver> drivers = new ArrayList<driver>();
    public static List<sponsor> Sponsors = new ArrayList<sponsor>();
    public static List<brand> Brands = new ArrayList<brand>();
    public static List<car> Cars = new ArrayList<car>();
    
    public static car  cars[] = new car[6];


    public static void fkdriverdata(){

        drivers.add(new driver("D001", "Max", "35", "Main Roard", "834723950", "73285725", "O+", 42676572, 8923936));
        drivers.add(new driver("D002", "Max", "38", "Green Roard", "764832963", "79265763", "A+", 42648682, 89239746));
        drivers.add(new driver("D003", "Max", "40", "Bar Roard", "567832963", "76465763", "B+", 42656890, 89247838));
        
    }

    public static void fksponsordata(){
        Sponsors.add(new sponsor("S001", "TATA", "Main Street Colombo", "Manufacture", 011322341 ));
        Sponsors.add(new sponsor("S002", "TOYOTA", "Green Road Galle", "Mechanical", 064566754));
        Sponsors.add(new sponsor("S003", "LANKA", "Beach Road Colombo", "Health", 011672043));
        

    }

    public static void fkbranddata(){
        Brands.add(new brand("B001", "TOYOTA", "Colombo", 011234321,Date.valueOf("1999-10-12")));
        Brands.add(new brand("B002", "SUZUKI", "Galle", 042255762,Date.valueOf("2000-11-23")));
        Brands.add(new brand("B003", "TATA", "Colombo", 011435674,Date.valueOf("1993-07-03")));

    }






}
