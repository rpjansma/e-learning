package com.elearning.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Override
    public String toString() {
        return "Feedback{" +
                "feedback_id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", feedback='" + text + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback1 = (Feedback) o;
        return Objects.equals(id, feedback1.id) && Objects.equals(name, feedback1.name) && Objects.equals(email, feedback1.email) && Objects.equals(text, feedback1.text) && Objects.equals(user, feedback1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, text, user);
    }

    public boolean isValid() {
        if(getName() != null && getEmail() != null && getText() != null) {
            return true;
        }
        else return false;
    }

}
