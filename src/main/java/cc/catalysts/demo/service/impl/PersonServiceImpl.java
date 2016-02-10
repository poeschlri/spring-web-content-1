package cc.catalysts.demo.service.impl;

import cc.catalysts.demo.model.Person;
import cc.catalysts.demo.repository.PersonRepository;
import cc.catalysts.demo.service.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Klaus Lehner
 */
@Service
public class PersonServiceImpl implements PersonService, InitializingBean {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (personRepository.count() == 0) {     // SELECT count(1) from Person;
            personRepository.save(new Person("Klaus", "Lehner"));    // INSERT INTO PERSON VALUES ('Klaus', 'Lehner');
            personRepository.save(new Person("John", "Doe"));
        }
    }
}
