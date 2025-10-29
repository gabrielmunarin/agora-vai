package com.CadastroDeAlgo.CadastroDeAlgo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Set<JobModel> jobs = new HashSet<>();

    @Column(name = "img_url")
    private String imgUrl;


}
