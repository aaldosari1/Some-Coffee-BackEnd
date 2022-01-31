package com.example.Some_Coffee_BackEnd.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Test Get All users
    @Test
    void itShouldFindAllUser() {
        User user1 = new User("hamad@gmail.com", "123");
        User user2 = new User("jack@gmail.com", "321");
        userRepository.save(user1);
        userRepository.save(user2);

        List<User> result = userRepository.findAll();
        assertNotNull(result);
        assertEquals("hamad@gmail.com", result.get(0).getEmail());
        assertEquals("jack@gmail.com", result.get(1).getEmail());
        assertEquals("123", result.get(0).getPassword());
        assertEquals("321", result.get(1).getPassword());
    }

    //Test getting a user by 'Id'
    @Test
    void itShouldFindUser() {
        User user = new User("hamad@gmail.com", "123");
        User savedUser = userRepository.save(user);
        User result = userRepository.findById(savedUser.getUserId()).orElse(null);
        assertNotNull(result);
        assertEquals("123", result.getPassword());
    }


    //Test adding a user
    @Test
    void itShouldAddUser() {
        User user = new User("a@a.com", "123");
        User result = userRepository.save(user);
        assertTrue(result.getUserId() != null);
    }

    //Test getting user by 'email'
    @Test
    void itShouldFindUserByEmail() {
        String email = "a@a.com";
        User user = new User(email, "123");
        userRepository.save(user);
        User result = userRepository.findByEmail(email);
        assertEquals(email, result.getEmail());
        assertNotEquals("b@b.com", result.getEmail());

    }

    //Test deleting a user
    @Test
    void itShouldDeleteUser() {

        User user = new User("a@a.com", "123");
        User savedUser = userRepository.save(user);
        userRepository.deleteById(savedUser.getUserId());
        User notExist = userRepository.findById(savedUser.getUserId()).orElse(null);
        assertTrue(notExist == null);


    }

    //Test updating a user data
    @Test
    void itShouldUpdateUser() {
        User user = new User("a@a.com", "123");
        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            savedUser.setEmail("a@bbb.com");
            savedUser.setPassword("12345");
        }

        assertEquals("a@bbb.com", savedUser.getEmail());
        assertEquals("12345", savedUser.getPassword());

    }


}