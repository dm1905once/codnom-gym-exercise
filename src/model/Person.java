package model;

import utils.MiscTools;

public class Person {
    protected String id;
    protected String authLevel;
    protected String name1;
    protected String addressStreet1;
    protected String addressCity;


    public Person(String authLevel, String name1, String addressStreet1, String addressCity) {
        this.id = "X" + this.setId();
        this.authLevel="NONE";
        this.name1 = name1;
        this.addressStreet1 = addressStreet1;
        this.addressCity = addressCity;
    }

    public String setId() {
        return MiscTools.getRandomString(7);
    }

    @Override
    public String toString(){
        return("Type: Person\nIdentifier: " + id + "\nName: " + name1);
    }
}
