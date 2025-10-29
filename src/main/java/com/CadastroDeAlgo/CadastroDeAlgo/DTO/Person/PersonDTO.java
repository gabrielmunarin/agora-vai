package com.CadastroDeAlgo.CadastroDeAlgo.DTO.Person;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.JobModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private UUID id;
    private String name;
    private String email;
    private String imgUrl;
    private Set<JobModel> jobs = new HashSet<>();


}
