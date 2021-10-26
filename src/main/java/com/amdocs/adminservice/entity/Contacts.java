package com.amdocs.adminservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String message;

}
