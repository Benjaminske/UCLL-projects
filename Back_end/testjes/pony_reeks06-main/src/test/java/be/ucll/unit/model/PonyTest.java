package be.ucll.unit.model;

import be.ucll.model.Pony;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PonyTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void setup () {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void teardown() {
        validatorFactory.close();
    }

    @Test
    public void givenNegativeAge_whenCreatingPony_thenAgeViolationIsThrown () {
        Pony pony = new Pony("Unicorn", -5);
        Set<ConstraintViolation<Pony>> violations = validator.validate(pony);

        assertEquals(1, violations.size());
        assertEquals("Age must be positive", violations.iterator().next().getMessage());

    }

}
