package cc.catalysts.demo.service;

import cc.catalysts.demo.dto.CreatePersonDto;
import cc.catalysts.demo.model.Person;

import java.util.List;

/**
 * @author Klaus Lehner
 */
public interface PersonService {

    List<Person> findAll();

    void create(CreatePersonDto person);
}
