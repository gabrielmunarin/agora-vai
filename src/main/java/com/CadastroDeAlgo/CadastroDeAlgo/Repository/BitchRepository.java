package com.CadastroDeAlgo.CadastroDeAlgo.Repository;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.BitchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BitchRepository extends JpaRepository<BitchModel, UUID> {

    List<BitchModel> findByHairColorContaining(String hairColor);

}
