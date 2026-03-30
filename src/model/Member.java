package model;

public class Member extends Person {
    private String dateJoined;
    static final String IDPREFIX = "M";

    public Member(String name1, String addressStreet1, String addressCity, String dateOfBirth) {
        super("MEMBER", name1, addressStreet1, addressCity);
        this.id = IDPREFIX + super.setId();
        this.dateJoined = dateOfBirth;
    }

    @Override
    public String toString(){
        return("\nType: Member\nIdentifier: " + id + "\nName: " + name1 + "\nMember since: " + dateJoined);
    }
}