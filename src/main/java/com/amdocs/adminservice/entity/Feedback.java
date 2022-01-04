package com.amdocs.adminservice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feedbacks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedback_id;
    private String name;
    private String email;
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;
}
