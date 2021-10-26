package com.amdocs.adminservice.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    private String c_name;

    private String c_desp;

    private String c_pees;

    private String c_resource;
}
