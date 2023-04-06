package br.com.mayara.HogwartsSortingHat.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException() {
        super("Student not found");
    }
}
