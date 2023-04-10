package br.com.mayara.HogwartsSortingHat.exception;

public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException() {
        super("House not found");
    }
}
