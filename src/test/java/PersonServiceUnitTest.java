import com.covid.info.domain.Person;
import com.covid.info.repository.PersonRepository;
import com.covid.info.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class PersonServiceUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @MockBean
    private PersonRepository personRepository;

    // write test cases here

    @Test
    public void whenFindByName_thenReturnPerson() {
        // given
        Person alex = new Person("alex", "abc");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Person found = personRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());

    }
}
