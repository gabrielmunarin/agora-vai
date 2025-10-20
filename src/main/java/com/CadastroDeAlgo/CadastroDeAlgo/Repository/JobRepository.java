package com.CadastroDeAlgo.CadastroDeAlgo.Repository;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobModel, UUID> {
}
