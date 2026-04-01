package model;

import utils.MiscTools;

import java.time.LocalDate;

public class PersonBuilder {

    protected String id;
    protected String authLevel;
    protected String nameFirst;
    protected String nameLast;
    protected LocalDate dateBirth;

    // Optional parameters
    protected String address1;
    protected String address2;
    protected String addressCity;
    protected LocalDate dateJoined;

    public PersonBuilder(String authLevel, String nameFirst, String nameLast, LocalDate dateBirth) {
        this.authLevel = authLevel;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.dateBirth = dateBirth;
        this.id = switch (authLevel){
            case "ADMIN"    -> "A" + MiscTools.getRandomString(7);
            case "MEMBER"   -> "M" + MiscTools.getRandomString(11);
            case "TRAINER"  -> "T" + MiscTools.getRandomString(7);
            default -> "X" + MiscTools.getRandomString(7);
        };
    }

    public PersonBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setAuthLevel(String authLevel) {
        this.authLevel = authLevel;
        return this;
    }

    public PersonBuilder setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
        return this;
    }

    public PersonBuilder setNameLast(String nameLast) {
        this.nameLast = nameLast;
        return this;
    }

    public PersonBuilder setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public PersonBuilder setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public PersonBuilder setAddressCity(String addressCity) {
        this.addressCity = addressCity;
        return this;
    }

    public PersonBuilder setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
        return this;
    }

    public PersonBuilder setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
        return this;
    }

    public Person build() {
        return new Person(this);
    }
}