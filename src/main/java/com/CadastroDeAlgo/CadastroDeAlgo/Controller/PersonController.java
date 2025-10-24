package com.CadastroDeAlgo.CadastroDeAlgo.Controller;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    public final PersonService _personService;

    public PersonController(PersonService _personService){
        this._personService = _personService;
    }


    @GetMapping
    public ResponseEntity<List<PersonModel>> listAll(){
        return ResponseEntity.ok(_personService.listAll());
    }

    @PostMapping
    public ResponseEntity<PersonModel> register(@RequestBody PersonModel person){
        return ResponseEntity.ok(_personService.register(person));
    }
}
