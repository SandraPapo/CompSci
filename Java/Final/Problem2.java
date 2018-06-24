abstract class Appointment {
    String description;
    int year;
    int month;
    int day;
    
    Appointment(String desc, int year, int month, int day) {
        this.description = desc;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    boolean occursOn(int year, int month, int day);
}

class OneTime extends Appointment {
    boolean occursOn(int year, int month, int day) {
        return year == this.year 
        && month == this.month 
        && day == this.day;
    }
}

class Daily extends Appointment {
    boolean occursOn(int year, int month, int day) {
        return true;
    }
}

class Monthly extends Appointment {
    boolean occursOn(int year, int month, int day) {
        return day == this.day;
    }
}

public class Tester {
    public static void main(String[] args) {
        Appointment[] appointments = new Appointment[]{
            new Appointment("LOL", 2017, 12, 20),
            new Appointment("LOL1", 2017, 11, 20),
            new Appointment("LOL2", 2017, 12, 21),
            new Appointment("LOL3", 2017, 10, 21)
        };
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = sc.nextInt();
        System.out.println("Enter a month");
        int month = sc.nextInt();
        System.out.println("Enter a day");
        int day = sc.nextInt();
        
        for (Appointment app : appointments) {
            if (app.occursOn(year, month, day)) {
                System.out.println(app.description);
            }
        }    
       }
    }
}