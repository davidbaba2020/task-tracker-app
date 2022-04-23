package com.decadave.tasktrackerapp.repository;

import com.decadave.tasktrackerapp.models.UserOfApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
class UserOfAppRepositoryTest {
    @Autowired
    private UserOfAppRepository userOfAppRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void testCreateUserOfApp() {
        UserOfApp user = UserOfApp.builder()
                .firstName("David")
                .lastName("Baba")
                .email("david@gmail.com")
                .password("12345")
                .build();

        UserOfApp savedUser = userOfAppRepository.save(user);

        UserOfApp existingUser = testEntityManager.find(UserOfApp.class, savedUser.getId());

        assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());
    }

}