package com.CadastroDeAlgo.CadastroDeAlgo.Controller;

import com.CadastroDeAlgo.CadastroDeAlgo.DTO.Person.PersonDTO;
import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    public final PersonService _personService;

    public PersonController(PersonService _personService){
        this._personService = _personService;
    }


    @GetMapping
    public ResponseEntity<List<PersonDTO>> listAll(){

        return ResponseEntity.ok(_personService.listAll());
    }

    @GetMapping("{uuid}")
    public ResponseEntity<PersonModel> findById(@PathVariable UUID uuid){
        var person = _personService.findById(uuid);
        return ResponseEntity.ok(person);

    }

    @PostMapping
    public ResponseEntity<PersonDTO> register(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(_personService.register(personDTO));
    }

    @PutMapping("{uuid}")
    public PersonModel update(@PathVariable UUID uuid, @RequestBody PersonModel person){
        return _personService.update(uuid, person);
    }
}
