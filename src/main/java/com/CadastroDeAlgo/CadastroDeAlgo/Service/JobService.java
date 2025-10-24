package com.CadastroDeAlgo.CadastroDeAlgo.Service;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.JobModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Repository.JobRepository;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    //@Autowired tbm da pra inicializar a injecao de dependencia
    private final JobRepository _jobRepository;

    public JobService(JobRepository jobRepository){
        this._jobRepository = jobRepository;
    }

    //listar todos
    public List<JobModel> listAll(){
       var jobs = _jobRepository.findAll();
       return jobs;
    }

    //buscar por id
    public JobModel findById(UUID uuid){
        Optional<JobModel> job = _jobRepository.findById(uuid);
        return job.orElse(null);
    }

    //criar
    public JobModel register(JobModel job){
        System.out.println(job);
        return _jobRepository.save(job);
    }


}
