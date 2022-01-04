package com.elearning.adminservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    private String a_name;
    private String a_email;
    private String a_password;

    //@ManyToMany
    //@JoinTable(name = "admin_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "admin_id"))
    //private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "admins_course_id")
    private Course courses;

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
