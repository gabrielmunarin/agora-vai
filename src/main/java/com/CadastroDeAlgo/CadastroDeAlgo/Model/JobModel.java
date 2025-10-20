package com.CadastroDeAlgo.CadastroDeAlgo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_job")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "job_person",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<PersonModel> persons;


}
