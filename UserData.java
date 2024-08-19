package Task81624;

public class UserData {
    private String userName;
    private String firstName;
    private String lastName;
    private String city;

    public UserData(String userName, String firstName, String lastName, String city) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setUserCity(String userCity) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User [userId=" + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
    }
}
