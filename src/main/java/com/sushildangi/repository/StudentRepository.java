package com.sushildangi.repository;

import com.sushildangi.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

    Flux<Student> findByFirstnameIgnoreCase(String firstname);
}
