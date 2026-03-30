package controller;

import model.Person;
import model.PersonBuilder;

import java.time.LocalDate;

public class PersonMaintenance {

    public static void main(String[] args) {
        System.out.println("Creating person ...");
        PersonBuilder builder = new PersonBuilder("ADMIN", "Alex", "A", LocalDate.of(2020, 12, 25));
        // Optional parameters:
        builder.setAddress1("999 Evergreen St");

        Person alguien = builder.build();
        System.out.println(alguien.toString());;

    }
}
