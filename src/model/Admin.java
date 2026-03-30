package model;

import utils.MiscTools;

public class Admin extends Person {
    static final String IDPREFIX = "A";

    public Admin(String name1, String addressStreet1, String addressCity) {
        super("ADMIN", name1, addressStreet1, addressCity);
        this.id = IDPREFIX + super.setId();
    }

    @Override
    public String toString(){
        return("\nType: Admin\nIdentifier: " + id + "\nName: " + name1);
    }
}
