package br.com.mayara.HogwartsSortingHat.exception;

public class SchoolNotFoundException extends RuntimeException{
    public SchoolNotFoundException() {
        super("School not found");
    }
}
