package com.CadastroDeAlgo.CadastroDeAlgo.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToMany(mappedBy = "persons")
    private Set<JobModel> jobs = new HashSet<>();


}
