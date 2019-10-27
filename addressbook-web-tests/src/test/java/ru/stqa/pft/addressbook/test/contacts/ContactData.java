package ru.stqa.pft.addressbook.test.contacts;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String companyName;
    private final String address;
    private final String workTel;
    private final String email;

    public ContactData(String firstName, String middleName, String lastName, String companyName, String address, String workTel, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.workTel = workTel;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkTel() {
        return workTel;
    }

    public String getEmail() {
        return email;
    }
}
