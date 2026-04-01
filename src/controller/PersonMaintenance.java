package controller;

import model.Person;
import model.PersonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PersonMaintenance {

    static String personSourceFilePath = "src/data/initial-person-load.csv";
    ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        try {
            initialPersonLoad(personSourceFilePath);
        } catch (IOException e) {
            System.out.println("Issues loading source file");
        }

    }

    public static void initialPersonLoad(String sourceFilePath) throws IOException{
        try (BufferedReader bfr = new BufferedReader(new FileReader(sourceFilePath))) {
            String record = bfr.readLine(); // Ignore first line

            while ((record = bfr.readLine()) != null) {
                String[] fields = record.split(",");

                if (fields[0].isEmpty() || fields[1].isEmpty() || fields[2].isEmpty() || fields[3].isEmpty()) {
                    throw (new IOException("At least one mandatory field is missing"));
                }
                System.out.println("Creating person ...");
                PersonBuilder builder;
                builder = new PersonBuilder(fields[0], fields[1], fields[2], LocalDate.of(Integer.parseInt(fields[3].substring(0, 3)), Integer.parseInt(fields[3].substring(4, 6)), Integer.parseInt(fields[3].substring(6, 8))));
                // Optional parameters:
                //Optional.ofNullable(fields[4]).ifPresent(builder::setAddress1);


                Person alguien = builder.build();
                System.out.println(alguien.toString());

            }
        }
    }
}
