package util;



import exception.InvalidDataException;

public class Validator {

    public static void validateName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty");
        }
    }

    public static void validateAge(int age) {

        if (age <= 0 || age > 120) {
            throw new InvalidDataException("Invalid age provided");
        }
    }
}
