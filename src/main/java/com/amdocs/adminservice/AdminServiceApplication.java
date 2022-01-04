package com.amdocs.adminservice;

import com.amdocs.adminservice.entity.Contacts;
import com.amdocs.adminservice.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"com.amdocs.adminservice.controller"})
@ComponentScan({"com.amdocs.adminservice.service"})
@ComponentScan({"com.amdocs.adminservice.repository"})
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);

        Contacts contatinho = Contacts.builder()
                .fullName("Raul Jansma Paes")
                .email("rpjansma@gmail.com")
                .message("Uh lá lá")
                .build();

        User usuário = User.builder()
                .username("teste")
                .contacts(contatinho)
                .build();

        System.out.println(usuário.toString());
    }

}
