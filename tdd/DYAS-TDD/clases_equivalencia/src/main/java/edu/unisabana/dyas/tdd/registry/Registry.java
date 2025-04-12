package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

/**
 * The {@code Registry} class manages the registration of voters. It contains a
 * method to register a voter and performs validations based on the voter's
 * status.
 *
 * <p>
 * This class ensures that only valid voters, with proper age and not already
 * registered, are successfully added to the voter registry.
 * </p>
 *
 * @see RegisterResult
 */
public class Registry {

    private static final int LEGAL_VOTING_AGE = 18;
    private static final int MAX_VALID_AGE = 130;
    private static final int MIN_VALID_AGE = 0;

    private final Set<String> registeredIds = new HashSet<>();

    /**
     * Default constructor for the Registry class.
     */
    public Registry() {
        // Default constructor
    }

    /**
     * Registers a voter if they meet the necessary requirements. A voter is
     * eligible if they are alive, of legal voting age (18 or older), and their
     * age is valid. A voter is not eligible if their age is out of the
     * realistic range (less than 0 or greater than 130). If the voter's ID is
     * already in the registry, registration is rejected.
     *
     * @param p the {@link Person} object representing the voter to be
     * registered
     * @return a {@link RegisterResult} indicating the result of the
     * registration process
     * @see RegisterResult
     */
    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        if (p.getAge() < MIN_VALID_AGE || p.getAge() > MAX_VALID_AGE) {
            return RegisterResult.INVALID_AGE;
        }

        if (p.getAge() < LEGAL_VOTING_AGE) {
            return RegisterResult.UNDERAGE;
        }

        String id = String.valueOf(p.getId());

        if (registeredIds.contains(id)) {
            return RegisterResult.DUPLICATED;
        }

        registeredIds.add(id);
        return RegisterResult.VALID;
    }
}
