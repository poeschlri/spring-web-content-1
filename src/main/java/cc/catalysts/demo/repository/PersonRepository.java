package cc.catalysts.demo.repository;

import cc.catalysts.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Klaus Lehner
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
