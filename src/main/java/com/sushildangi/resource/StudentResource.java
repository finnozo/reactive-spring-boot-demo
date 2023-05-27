package com.sushildangi.resource;

import com.sushildangi.model.Student;
import com.sushildangi.payload.StudentPayload;
import com.sushildangi.response.APIResponse;
import com.sushildangi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentResource {
    private final StudentService studentService;

    //@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @GetMapping()
    public Flux<Student> findAll() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<APIResponse> create(@RequestBody StudentPayload payload) {
        return studentService.createStudent(payload);
    }

    @GetMapping("/filter")
    public Flux<Student> findByAuthor(@RequestParam String name) {
        return studentService.findByFirstname(name);
    }

    @DeleteMapping("/{id}")
    public Mono<APIResponse> deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }
}
