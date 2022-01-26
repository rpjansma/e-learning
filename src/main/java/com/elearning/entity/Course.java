package com.elearning.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    private String c_name;

    private String c_desp;

    private String c_pees;

    private String c_resource;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinColumn(name = "feedback_id")
    private Set<Feedback> feedbacks = new HashSet<>();


    @ManyToOne
    private Admin admin;

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", c_name='" + c_name + '\'' +
                ", c_desp='" + c_desp + '\'' +
                ", c_pees='" + c_pees + '\'' +
                ", c_resource='" + c_resource + '\'' +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return course_id != null ? course_id.equals(course.course_id) : course.course_id == null;
    }

    @Override
    public int hashCode() {
        return course_id != null ? course_id.hashCode() : 0;
    }
}
