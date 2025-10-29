package com.CadastroDeAlgo.CadastroDeAlgo.Service;

import com.CadastroDeAlgo.CadastroDeAlgo.Model.BitchModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Repository.BitchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BitchService {
    private final BitchRepository _bitchRepository;

    public BitchService(BitchRepository _bitchRepository){
        this._bitchRepository = _bitchRepository;
    }

    //list all
    public List<BitchModel> listAll(){

        return _bitchRepository.findAll();
    }

    //listByHairColor
    public List<BitchModel> findByHairColor(String hairColor){
       return _bitchRepository.findByHairColorContaining(hairColor);
    }

    //find by id
    public BitchModel findById(UUID uuid){
        Optional<BitchModel> bitch = _bitchRepository.findById(uuid);
        return bitch.orElse(null);
    }

    //register
    public BitchModel register(BitchModel bitch){
        return _bitchRepository.save(bitch);
    }

    //delete
    public void delete(UUID uuid){
        _bitchRepository.deleteById(uuid);
    }

    //update
    public BitchModel update(UUID uuid, BitchModel bitch){
        if(_bitchRepository.existsById(uuid)){
            bitch.setUuid(uuid);
            return _bitchRepository.save(bitch);
        }
        return null;
    }
}
