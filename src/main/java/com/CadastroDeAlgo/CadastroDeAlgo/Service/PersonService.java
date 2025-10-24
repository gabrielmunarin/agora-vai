package com.CadastroDeAlgo.CadastroDeAlgo.Service;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService{

    private final PersonRepository _personRepository;

    public PersonService (PersonRepository _personRepository){
        this._personRepository = _personRepository;
    }

    //getall
    public List<PersonModel> listAll(){
        return _personRepository.findAll();
    }

    //get by id
    public PersonModel findById(UUID uuid){
        Optional<PersonModel> person = _personRepository.findById(uuid);
        return person.orElse(null);
    }

    //create
    public PersonModel register(PersonModel person){
        return _personRepository.save(person);
    }
}
