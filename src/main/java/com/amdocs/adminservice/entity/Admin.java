package com.amdocs.adminservice.entity;

import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;

@Entity
@Table(name="admins")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    private String name;
    private String email;
    private String password;
}
