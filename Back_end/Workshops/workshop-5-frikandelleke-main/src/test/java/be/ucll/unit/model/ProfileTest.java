package be.ucll.unit.model;

import be.ucll.model.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    @Test
    public void givenValidProfile_whenCreatingProfile_thenProfileIsCreated() {
        Profile profile = new Profile("Developer", "Leuven", "Coding, Gaming");

        assertEquals("Developer", profile.getRole());
        assertEquals("Leuven", profile.getLocation());
        assertEquals("Coding, Gaming", profile.getInterests());
    }

    @Test
    public void givenBlankRole_whenCreatingProfile_thenExceptionIsThrown() {
        Exception ex = assertThrows(RuntimeException.class,
                () -> new Profile("", "Leuven", "Coding"));

        assertEquals("Role is required", ex.getMessage());
    }

    @Test
    public void givenBlankLocation_whenCreatingProfile_thenExceptionIsThrown() {
        Exception ex = assertThrows(RuntimeException.class,
                () -> new Profile("Developer", "", "Coding"));

        assertEquals("Location is required", ex.getMessage());
    }

    @Test
    public void givenBlankInterests_whenCreatingProfile_thenExceptionIsThrown() {
        Exception ex = assertThrows(RuntimeException.class,
                () -> new Profile("Developer", "Leuven", ""));

        assertEquals("Interests are required", ex.getMessage());
    }
}
