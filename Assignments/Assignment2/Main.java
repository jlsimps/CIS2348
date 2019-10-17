import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Asking for number of entries to make and ensuring an actual number is entered with try/catch
        int numOfEntries = 0;
        boolean isNum = false;
        System.out.println("Welcome to the Department of ILT student data system!");
        while (!isNum) {
            try {
                System.out.println("How many entries would you like to make?");
                numOfEntries = input.nextInt();
                input.nextLine();
                isNum = true;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number!\n");
                input.nextLine();
            }
        }

        //Initializing Array of Student Class objects based on number of entries to make
        Student[] studentList = new Student[numOfEntries];
        for (int i = 0; i < numOfEntries; i++) {
            String email;
            studentList[i] = new Student();
            System.out.printf("DETAILS FOR STUDENT #%d\n", i+1);
            System.out.println("-----------------------------");

            //Getting First Name - Validating with RegEx
            String firstName;
            System.out.println("Please enter the student's first name: ");
            firstName = input.nextLine();
            while (!firstName.matches("^[a-zA-Z]+$")) {
                System.out.println("That's not a valid response, please enter letters only: ");
                firstName = input.nextLine();
            }

            //Getting Last Name - Validating with RegEx
            String lastName;
            System.out.println("Please enter the student's last name: ");
            lastName = input.nextLine();
            while (!lastName.matches("^[a-zA-Z]+$")) {
                System.out.println("That's not a valid response, please enter letters only: ");
                lastName = input.nextLine();
            }

            //Getting PeopleSoft ID Number - Validating with RegEx
            String psID;
            System.out.println("Please enter the student's PeopleSoft ID Number: ");
            psID = input.nextLine();
            while (!psID.matches("\\d{1,7}")) {
                System.out.println("That's not a valid response, please enter an ID containing only 7 digits or less: ");
                psID = input.nextLine();
            }

            //Getting Class Standing - Validating with Array of valid answers(ignoring case)
            String classStanding;
            String[] validStandings = new String[]{"freshman", "sophomore", "junior", "senior"};
            boolean isValidStanding = false;
            System.out.println("Please enter the student's class standing: (freshman, sophomore, junior, senior)");
            classStanding = input.nextLine();
            while (!Arrays.asList(validStandings).contains(classStanding.toLowerCase())) {
                System.out.println("Please enter a valid class standing! (freshman, sophomore, junior, senior):  ");
                classStanding = input.nextLine();
            }

            //Getting Email Address - Validating with RegEx
            System.out.println("Please enter the student's email address: ");
            email = input.nextLine();
            while (!email.matches("^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(com|edu|org|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$")) {
                System.out.println("Please enter a valid email address! (.com , .org , or .edu emails only): ");
                email = input.nextLine();
            }

            //Getting House Number and Street Name - Validating with RegEx (allowing optional second word for ln, st, rd, ect...)
            String houseNumStreetName;
            System.out.println("Please enter the student's house number followed by the street name: ");
            houseNumStreetName = input.nextLine();
            while (!houseNumStreetName.matches("^\\d+\\s+[A-Za-z]+(\\s+[A-Za-z]+)?")) {
                System.out.println("That's not a valid entry, please enter the house number followed by the street name: ");
                houseNumStreetName = input.nextLine();
            }

            //Getting City Name - Validating with RegEx (allowing optional second word for cities like Los Angeles, San Diego, ect...)
            String city;
            System.out.println("Please enter the student's city: ");
            city = input.nextLine();
            while (!city.matches("^[A-Za-z]+(\\s+[A-Za-z]+)?")) {
                System.out.println("Please enter a valid city name: ");
                city = input.nextLine();
            }

            //Getting State - Validating with Array of Valid States (ignoring case)
            String state;
            String[] validStates = new String[]{"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI",
                    "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND",
                    "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA",
                    "VT", "WA", "WI", "WV", "WY"};
            System.out.println("Please enter the student's state abbreviation (CA, FL, TX, ect.): ");
            state = input.nextLine();
            while (!Arrays.asList(validStates).contains(state.toUpperCase())) {
                System.out.println("Please enter a valid two letter abbreviation!");
                state = input.nextLine();
            }

            //Getting Zip Code - Validating with RegEx (accepts the forms XXXXX(5 digit), and XXXXX-XXXX(9 digit))
            String zipCode;
            System.out.println("Please enter the student's Zip code (use the form XXXXX for five digit zip and XXXXX-XXXX for nine digit zip): ");
            zipCode = input.nextLine();
            while (!zipCode.matches("^[0-9]{5}(?:-[0-9]{4})?$")) {
                System.out.println("That's not a valid answer. Please enter a 5 digit zip code in the form XXXXX, or a 9 digit zip code in the form XXXXX-XXXX: ");
                zipCode = input.nextLine();
            }

            //Using setter method to set the validated detials for each student
            studentList[i].setInfo(firstName, lastName, psID, classStanding, email, houseNumStreetName, city, state, zipCode);
            System.out.printf("Succesfully added %s to the system!\n\n", firstName);
        }

        //Printing Student details to the screen using getter method after entries are complete
        System.out.println("Student Details - Department of ILT");
        System.out.println("===================================");
        for (int i = 0; i < numOfEntries; i++) {
            System.out.printf("%d. ", i + 1);
            studentList[i].displayInfo();
            System.out.println("\n");
        }
        System.out.println("===================================");
        System.out.printf("TOTAL NUMBER OF STUDENTS: %d", Student.studentCount);


    }
}
