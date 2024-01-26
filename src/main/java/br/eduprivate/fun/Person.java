package br.eduprivate.fun;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person() {
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        Period period = Period.between(LocalDate.now(), birthday);
        return period.getYears();
    }

    public void printPerson() {
        System.out.println(name);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person();

        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("cadu", LocalDate.of(1981, 2, 2), Sex.MALE, "edu@email");
        Person person2 = new Person("mika", LocalDate.of(1985, 2, 9), Sex.MALE, "mika@email");
        persons.add(person1);
        persons.add(person2);

        printPersonsOlderThan(persons, 30);
    }




}