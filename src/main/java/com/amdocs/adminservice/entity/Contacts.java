package com.amdocs.adminservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String message;

    @OneToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(contactId, contacts.contactId) && Objects.equals(fullName, contacts.fullName) && Objects.equals(email, contacts.email) && Objects.equals(phoneNumber, contacts.phoneNumber) && Objects.equals(message, contacts.message) && Objects.equals(user, contacts.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, fullName, email, phoneNumber, message, user);
    }
}
