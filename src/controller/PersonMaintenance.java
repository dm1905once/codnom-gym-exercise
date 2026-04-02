package controller;

import model.Person;
import model.PersonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonMaintenance {

    static String personSourceFilePath = "src/data/initial-person-load.csv";
    ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        try {
            initialPersonLoad(personSourceFilePath);
        } catch (IOException e) {
            System.out.println("Issues loading source file or invalid record");
        }

    }

    public static void initialPersonLoad(String sourceFilePath) throws IOException{
        try (BufferedReader bfr = new BufferedReader(new FileReader(sourceFilePath))) {
            // Ignore first line because it contains headers
            String record = bfr.readLine();

            while ((record = bfr.readLine()) != null) {
                List<String> fields = Arrays.stream(record.split(",", -1))
                        .map(String::trim)
                        .toList();

                String authLevel = fields.get(0);
                String nameFirst = fields.get(1);
                String nameLast = fields.get(2);
                String DOB = fields.get(3);

                if (!authLevel.isEmpty()  && !authLevel.substring(0,1).startsWith("#")){

                    if (nameFirst.isEmpty() || nameLast.isEmpty() || DOB.isEmpty()) {
                        throw (new IOException());
                    }

                    System.out.println("Creating person ...");
                    PersonBuilder builder;
                    builder = new PersonBuilder(authLevel, nameFirst, nameLast, DOB);

                    // Optional parameters:
                    String address1 = fields.get(4);
                    String address2 = fields.get(5);
                    String addressCity = fields.get(6);
                    String dateJoined = fields.get(7);

                    //Optional.ofNullable(fields.get(4)).ifPresent(builder::setAddress1);
                    if (!address1.isEmpty()) {
                        builder.setAddress1(address1);
                    }
                    if (!address2.isEmpty()) {
                        builder.setAddress2(address2);}

                    if (!addressCity.isEmpty()) {
                        builder.setAddressCity(addressCity);
                    }
                    if (!dateJoined.isEmpty()) {
                        builder.setDateJoined(dateJoined);}

                    Person alguien = builder.build();
                    System.out.println(alguien.toString());
                }



            }
        }
    }
}
