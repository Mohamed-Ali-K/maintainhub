package com.maintainhub.cmms.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link User} class.
 * Tests the creation, role assignment, and equality of user objects.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
class UserTest {

    /**
     * Tests the creation of a user with basic properties.
     * Verifies that all user fields are correctly set and accessible.
     */
    @Test
    void testUserCreation() {
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setFullName("Test User");

        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("Test User", user.getFullName());
    }

    /**
     * Tests the assignment of roles to a user.
     * Verifies that roles are correctly added and accessible.
     */
    @Test
    void testUserWithRoles() {
        User user = new User();
        user.setUsername("testuser");
        
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        
        user.getRoles().add(adminRole);
        user.getRoles().add(userRole);

        assertEquals(2, user.getRoles().size());
        assertTrue(user.getRoles().contains(adminRole));
        assertTrue(user.getRoles().contains(userRole));
    }

    /**
     * Tests the equality and hashCode methods of User.
     * Verifies that two User objects with the same data are considered equal
     * and have the same hashCode.
     */
    @Test
    void testUserEquality() {
        User user1 = new User();
        user1.setUsername("testuser");
        user1.setEmail("test@example.com");
        
        User user2 = new User();
        user2.setUsername("testuser");
        user2.setEmail("test@example.com");
        
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }
} 