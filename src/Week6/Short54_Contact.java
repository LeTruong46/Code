package Week6;

public class Short54_Contact {
    private int ID;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Short54_Contact(int ID, String firstName, String lastName, String group, String address, String phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString() {
        return ID + "\t" + firstName + " " + lastName + "\t" + group + "\t" + address + "\t" + phone;
    }
}
