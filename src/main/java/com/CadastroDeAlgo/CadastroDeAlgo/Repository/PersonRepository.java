package com.CadastroDeAlgo.CadastroDeAlgo.Repository;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonModel, UUID> {
}
