package utilities.random;

import com.github.javafaker.Faker;

public class RandomData {

    public static String randomNumbersBetween0To9(int charsAmount){
        Faker faker = new Faker();
        return faker.regexify("[0-9]{"+charsAmount+"}");
    }
    public static String randomHebrewChars(int charsAmount){
        Faker faker = new Faker();
        return faker.regexify("[א-ת]{"+charsAmount+"}");
    }
    public static String randomEnglishLowerCaseChars(int charsAmount){
        Faker faker = new Faker();
        return faker.regexify("[a-z]{"+charsAmount+"}");
    }
    public static String randomEnglishUpperCaseChars(int charsAmount){
        Faker faker = new Faker();
        return faker.regexify("[A-Z]{"+charsAmount+"}");
    }
    public static String randomSpecialChars(int charsAmount){
        Faker faker = new Faker();
        return faker.regexify("[!@#$%^&*()_-+={}]{|/?.><,']"+charsAmount+"}");

    }

}
