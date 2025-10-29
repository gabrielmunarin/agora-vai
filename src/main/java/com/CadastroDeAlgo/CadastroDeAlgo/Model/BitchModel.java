package com.CadastroDeAlgo.CadastroDeAlgo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_bitch")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BitchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID uuid;
    private String name;
    private Short age;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hair_calor")
    private String hairColor;

    private Double height;

    @ManyToMany(mappedBy = "bitches")
    @JsonIgnore
    private List<JobModel> jobs;

}
