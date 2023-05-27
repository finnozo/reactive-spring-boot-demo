package com.sushildangi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@Table("student")
@AllArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
}
