package com.sushildangi.service;

import com.sushildangi.model.Student;
import com.sushildangi.payload.StudentPayload;
import com.sushildangi.repository.StudentRepository;
import com.sushildangi.response.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Flux<Student> findAllStudent() {
        return studentRepository.findAll().delayElements(Duration.ofMillis(10));
    }

    @Override
    public Mono<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Mono<APIResponse> createStudent(StudentPayload payload) {
        Mono<Student> save = studentRepository.save(
                Student
                        .builder()
                        .age(payload.getAge())
                        .firstname(payload.getFirstname())
                        .lastname(payload.getLastname())
                        .build()
        );
        return Mono.justOrEmpty(APIResponse.builder()
                .id(0L)
                .message("Student Created successfully!")
                .statusCode(HttpStatus.CREATED.value())
                .statusName(HttpStatus.CREATED.name())
                .success(true)
                .build());
    }

    @Override
    public Flux<Student> findByFirstname(String firstname) {
        return studentRepository.findByFirstnameIgnoreCase(firstname);
    }

    @Override
    public Mono<APIResponse> deleteById(Long id) {
        studentRepository.deleteById(id);
        return Mono.justOrEmpty(APIResponse.builder()
                .id(id)
                .message("Student Deleted successfully!")
                .statusCode(HttpStatus.OK.value())
                .statusName(HttpStatus.OK.name())
                .success(true)
                .build());
    }
}
