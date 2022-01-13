package com.elearning.adminservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    private String a_name;
    private String a_email;
    private String a_password;


    @OneToMany
    @JoinColumn(name = "course_id")
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", a_name='" + a_name + '\'' +
                ", a_email='" + a_email + '\'' +
                ", courses=" + courses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        return admin_id != null ? admin_id.equals(admin.admin_id) : admin.admin_id == null;
    }

    @Override
    public int hashCode() {
        return admin_id != null ? admin_id.hashCode() : 0;
    }
}
