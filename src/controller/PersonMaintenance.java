package controller;

import model.Person;
import model.PersonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
            String record = bfr.readLine(); // Ignore first line

            while ((record = bfr.readLine()) != null) {
                String[] fields = record.split(",", -1);

                if (fields[0].isEmpty() || fields[1].isEmpty() || fields[2].isEmpty() || fields[3].isEmpty()) {
                    throw (new IOException());
                }

                System.out.println("Creating person ...");
                PersonBuilder builder;
                builder = new PersonBuilder(fields[0], fields[1], fields[2], fields[3]);

                // Optional parameters:
                //Optional.ofNullable(fields[4]).ifPresent(builder::setAddress1);
                if (!fields[4].isEmpty()) {
                    builder.setAddress1(fields[4]);
                }
                if (!fields[5].isEmpty()) {
                    builder.setAddress2(fields[5]);
                }
                if (!fields[6].isEmpty()) {
                    builder.setAddressCity(fields[6]);
                }
                if (!fields[7].isEmpty()) {
                    builder.setDateJoined(fields[7]);
                }

                Person alguien = builder.build();
                System.out.println(alguien.toString());

            }
        }
    }
}
