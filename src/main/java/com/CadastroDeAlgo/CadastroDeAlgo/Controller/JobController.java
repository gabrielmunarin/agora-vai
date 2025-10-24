package com.CadastroDeAlgo.CadastroDeAlgo.Controller;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.JobModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/job")
public class JobController {

    private final JobService _jobService;

    public JobController(JobService jobService) {
        _jobService = jobService;
    }


    @GetMapping
    public List<JobModel> listAll(){
        var jobs = _jobService.listAll();
        return jobs;
    }

    @GetMapping("/{uuid}")
    public JobModel findById(@PathVariable UUID uuid){
        var job = _jobService.findById(uuid);
        return job;
    }

    @PostMapping
    public void register(@RequestBody JobModel job){
        _jobService.register(job);
    }

    @DeleteMapping("{uuid}")
    public void delete(@PathVariable UUID uuid){
        _jobService.delete(uuid);
    }
}
