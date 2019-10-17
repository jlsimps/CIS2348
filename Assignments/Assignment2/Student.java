public class Student {
    public static int studentCount;
    private String firstName;
    private String lastName;
    private String psID;
    private String classStanding;
    private String email;
    private String houseNumStreetName;
    private String city;
    private String state;
    private String zipCode;

    public Student () {
        studentCount ++;
    }

    public void setInfo(String firstName, String lastName, String psID, String classStanding, String email, String houseNumStreetName, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.psID = psID;
        this.classStanding = classStanding;
        this.email = email;
        this.houseNumStreetName = houseNumStreetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public void displayInfo() {
        System.out.printf("First Name: %s | Last Name: %s | PeopleSoft ID: %s | Class Standing: %s | Email: %s\n" +
                "Address: %s, %s, %s %s",
                firstName, lastName, psID, classStanding, email, houseNumStreetName, city, state, zipCode);
    }



}
