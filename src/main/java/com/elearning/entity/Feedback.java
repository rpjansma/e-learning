package com.elearning.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "feedbacks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedback_id;
    private String name;
    private String email;
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Override
    public String toString() {
        return "Feedback{" +
                "feedback_id=" + feedback_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", feedback='" + feedback + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback1 = (Feedback) o;
        return Objects.equals(feedback_id, feedback1.feedback_id) && Objects.equals(name, feedback1.name) && Objects.equals(email, feedback1.email) && Objects.equals(feedback, feedback1.feedback) && Objects.equals(user, feedback1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback_id, name, email, feedback, user);
    }
}
