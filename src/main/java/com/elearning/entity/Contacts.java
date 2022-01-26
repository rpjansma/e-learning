package com.elearning.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "contacts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contacts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String message;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(contact_id, contacts.contact_id) && Objects.equals(fullName, contacts.fullName) && Objects.equals(email, contacts.email) && Objects.equals(phoneNumber, contacts.phoneNumber) && Objects.equals(message, contacts.message) && Objects.equals(user, contacts.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact_id, fullName, email, phoneNumber, message, user);
    }
}
