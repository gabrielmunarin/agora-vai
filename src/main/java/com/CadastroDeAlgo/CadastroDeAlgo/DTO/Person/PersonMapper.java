package com.CadastroDeAlgo.CadastroDeAlgo.DTO.Person;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper{

    public PersonModel map(PersonDTO personDTO){

        PersonModel personModel = new PersonModel();

        personModel.setId(personDTO.getId());
        personModel.setName(personDTO.getName());
        personModel.setEmail(personDTO.getEmail());
        personModel.setImgUrl(personDTO.getImgUrl());
        personModel.setJobs(personDTO.getJobs());

        return personModel;
    }

    public PersonDTO map(PersonModel personModel){
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(personModel.getId());
        personDTO.setName(personModel.getName());
        personDTO.setEmail(personModel.getEmail());
        personDTO.setImgUrl(personModel.getImgUrl());
        personDTO.setJobs(personModel.getJobs());

        return personDTO;
    }



    public List<PersonDTO> map(List<PersonModel> personModel){
       List<PersonDTO> personDTO = personModel.stream()
                .map(p ->
                        new PersonDTO(
                                p.getId(),
                                p.getName(),
                                p.getEmail(),
                                p.getImgUrl(),
                                p.getJobs()))
               .toList();

        return personDTO;
    }

}
