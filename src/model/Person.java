package model;

import utils.MiscTools;

import java.time.LocalDate;

public class Person {

    protected String id;
    // Required parameters
    protected String authLevel;
    protected String nameFirst;
    protected String nameLast;
    protected LocalDate dateBirth;

    // Optional parameters
    protected String address1;
    protected String address2;
    protected String addressCity;
    protected LocalDate dateJoined;

    protected Person(PersonBuilder builder) {
        this.id = builder.id;
        this.authLevel = builder.authLevel;
        this.nameFirst = builder.nameFirst;
        this.nameLast = builder.nameLast;
        this.dateBirth = builder.dateBirth;
        this.address1 = builder.address1;
        this.address2 = builder.address2;
        this.addressCity = builder.addressCity;
        this.dateJoined = builder.dateJoined;
    }

    public String getId() {
        return id;
    }

    public String getAuthLevel() {
        return authLevel;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    @Override
    public String toString(){
        return nameFirst + " " + nameLast + " has " + authLevel + " access and has been assigned identifier: " + id + " address1 is " + address1;
    }
}
