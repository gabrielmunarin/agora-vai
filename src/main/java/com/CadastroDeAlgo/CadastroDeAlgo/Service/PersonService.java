package com.CadastroDeAlgo.CadastroDeAlgo.Service;

import com.CadastroDeAlgo.CadastroDeAlgo.DTO.Person.PersonDTO;
import com.CadastroDeAlgo.CadastroDeAlgo.DTO.Person.PersonMapper;
import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService{

    private final PersonRepository _personRepository;
    private final PersonMapper _personMapper;

    public PersonService(PersonRepository _personRepository, PersonMapper _personMapper) {
        this._personRepository = _personRepository;
        this._personMapper = _personMapper;
    }

    //getall
    public List<PersonDTO> listAll(){
        List<PersonModel> persons = _personRepository.findAll();
        return _personMapper.map(persons);
    }

    //get by id
    public PersonModel findById(UUID uuid){
        Optional<PersonModel> person = _personRepository.findById(uuid);
        return person.orElse(null);
    }

    //create
    public PersonDTO register(PersonDTO personDTO){
        PersonModel person = _personMapper.map(personDTO);
        _personRepository.save(person);
        return _personMapper.map(person);

    }

    //delete
    public void delete(UUID uuid){
        _personRepository.deleteById(uuid);
    }

    //update
    public PersonModel update(UUID uuid, PersonModel person){
      if(_personRepository.existsById(uuid)){
          //seta o id antes de salvar
          //o person vem sem o ID
          //seto o ID entao o obj de person vai ser salvo com o id ja existente
          /*
          {
            "id": "c8263eea-412c-4bb7-b081-80829fdc5b71",
            "name": "gabriel",
            "email": "gabriel@mail.com"
          }
           */
          person.setId(uuid);
          return _personRepository.save(person);
      }
      return null;

    }
}
