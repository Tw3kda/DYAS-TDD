package edu.unisabana.dyas.registry;

import org.junit.jupiter.api.Assertions;  // For test methods
import org.junit.jupiter.api.Test;  // Instead of using * to import all, import the specific class

/**
 * Pruebas unitarias para la clase Registry.
 * Verifica los diferentes casos de registro de votantes.
 */
public class RegistryTest {

    // Constantes definidas primero
    private static final int ELIGIBLE_AGE = 23;
    private static final int DECEASED_AGE = 35;
    private static final int MINOR_AGE = 16;
    private static final int ADULT_AGE = 21;
    private static final int NEGATIVE_AGE = -5;
    private static final int MAX_AGE = 150;
    private static final int PERSON_1_ID = 1;
    private static final int PERSON_2_ID = 2;
    private static final int PERSON_3_ID = 3;
    private static final int PERSON_4_ID = 4;
    private static final int PERSON_5_ID = 5;
    private static final int PERSON_6_ID = 6;

    private final Registry registry = new Registry();

    @Test
    public void shouldReturnValidForEligiblePerson() {
        Person person = new Person();
        person.setId(PERSON_1_ID);
        person.setName("Fubuki");
        person.setAge(ELIGIBLE_AGE);
        person.setAlive(true);

        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.VALID, result);  // Use Assertions.assertEquals
    }

    @Test
    public void shouldReturnDeadForDeceasedPerson() {
        Person person = new Person();
        person.setId(PERSON_2_ID);
        person.setName("Konan");
        person.setAge(DECEASED_AGE);
        person.setAlive(false);

        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.DEAD, result);  // Use Assertions.assertEquals
    }

    @Test
    public void shouldReturnUnderageForMinor() {
        Person person = new Person();
        person.setId(PERSON_3_ID);
        person.setName("Ana");
        person.setAge(MINOR_AGE);
        person.setAlive(true);

        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.UNDERAGE, result);  // Use Assertions.assertEquals
    }

    @Test
    public void shouldReturnDuplicatedForSamePersonTwice() {
        Person person = new Person();
        person.setId(PERSON_4_ID);
        person.setName("Zoro");
        person.setAge(ADULT_AGE);
        person.setAlive(true);

        // First registration should be valid
        RegisterResult first = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.VALID, first);  // Use Assertions.assertEquals

        // Second registration should be duplicated
        RegisterResult second = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.DUPLICATED, second);  // Use Assertions.assertEquals
    }

    @Test
    public void shouldReturnInvalidAgeForNegativeAge() {
        Person person = new Person();
        person.setId(PERSON_5_ID);
        person.setName("PEPE");
        person.setAge(NEGATIVE_AGE);
        person.setAlive(true);
        System.out.println("Edad en test: " + person.getAge());


        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.INVALID_AGE, result);  // Use Assertions.assertEquals
    }

    @Test
    public void shouldReturnInvalidAgeForTooHighAge() {
        Person person = new Person();
        person.setId(PERSON_6_ID);
        person.setName("Shinobu");
        person.setAge(MAX_AGE);
        person.setAlive(true);

        RegisterResult result = registry.registerVoter(person);
        Assertions.assertEquals(RegisterResult.INVALID_AGE, result);  // Use Assertions.assertEquals
    }
}
