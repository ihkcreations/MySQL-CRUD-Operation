package mySQLOperations.models;

public class Student {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNo;

    public Student(String id, String name, String email, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
