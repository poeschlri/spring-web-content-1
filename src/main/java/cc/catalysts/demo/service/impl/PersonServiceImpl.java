package cc.catalysts.demo.service.impl;

import cc.catalysts.demo.model.Person;
import cc.catalysts.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Klaus Lehner
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Klaus", "Lehner"));
        personList.add(new Person("John", "Doe"));
        return personList;
    }
}
