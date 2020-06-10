package apitesting;

import java.util.ArrayList;

public class User {

    private String email;
    private String firstName;
    private String lastName;

    private ArrayList<Integer> mobile;
    private Address address;

    public User(String email, String firstName, String lastName, String line1, String city, String state, String zip){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = new ArrayList<Integer>();
        this.address = new Address(line1, city, state, zip);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Integer> getMobile() {
        return mobile;
    }

    public void setMobile(ArrayList<Integer> mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setMobileNumbers(int... mobileNumbers){
        for (int i = 0; i < mobileNumbers.length; i++){
            this.mobile.add(mobileNumbers[i]);
        }
    }
}
