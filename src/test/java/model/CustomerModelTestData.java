package model;

public record CustomerModelTestData(String firstName,
        String lastName,
        String email,
        String password,
        String street,
        String city,
        String state,
        String zip,
        String passengersCount,
        String expectedPrice) {

}
