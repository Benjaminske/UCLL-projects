package be.ucll.unit.model;

import be.ucll.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
        User user = new User("John Doe", 56);

        assertEquals("John Doe", user.getName());
        assertEquals(56, user.getAge());
    }
    
}
