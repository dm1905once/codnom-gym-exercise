package controller;

import model.Admin;
import model.Member;
import model.Person;

public class PersonMaintenance {

    public static void main(String[] args) {
        Member alguien = new Member("Alberto", "calle 1", "Sn Jose", "010101");
        System.out.println(alguien.toString());

        Admin otro = new Admin("Madie", "calle 2", "Gigi");
        System.out.println(otro.toString());
    }
}
