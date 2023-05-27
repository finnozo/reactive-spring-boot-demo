package com.sushildangi.service;

import com.sushildangi.model.Student;
import com.sushildangi.payload.StudentPayload;
import com.sushildangi.response.APIResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> findAllStudent();

    Mono<Student> findById(Long id);

    Mono<APIResponse> createStudent(StudentPayload payload);

    Flux<Student> findByFirstname(String firstname);

    Mono<APIResponse> deleteById(Long id);
}
