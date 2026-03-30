package model;

public class Trainer extends Person {
    private int yearsOfExperience;
    static final String IDPREFIX = "T";

    public Trainer(String name1, String addressStreet1, String addressCity, int yearsOfExperience) {
        super("TRAINER", name1, addressStreet1, addressCity);
        this.id = IDPREFIX + super.setId();
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString(){
        return("\nType: Trainer\nIdentifier: " + id + "\nName: " + name1 + "Years of experience: " + String.valueOf(yearsOfExperience));
    }
}