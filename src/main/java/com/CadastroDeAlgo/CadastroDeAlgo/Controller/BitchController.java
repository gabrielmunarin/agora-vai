package com.CadastroDeAlgo.CadastroDeAlgo.Controller;


import com.CadastroDeAlgo.CadastroDeAlgo.Model.BitchModel;
import com.CadastroDeAlgo.CadastroDeAlgo.Service.BitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/bitch")
public class BitchController {

    private final BitchService _bitchService;

    public BitchController(BitchService bitchService) {
        _bitchService = bitchService;
    }

    @GetMapping
    public ResponseEntity<List<BitchModel>> listAll(
            @RequestParam(name = "hairColor", required = false) String hairColor ){
        if (!(hairColor == null)){
            return ResponseEntity.ok(_bitchService.findByHairColor(hairColor));
        }
        return ResponseEntity.ok(_bitchService.listAll());

    }

    @GetMapping("{uuid}")
    public ResponseEntity<BitchModel> findById(@PathVariable UUID uuid){
        return ResponseEntity.ok(_bitchService.findById(uuid));
    }

    @PostMapping
    public ResponseEntity<BitchModel> register(@RequestBody BitchModel bitch){
        return ResponseEntity.ok(_bitchService.register(bitch));
    }

    @DeleteMapping("{uuid}")
    public void delete(@PathVariable UUID uuid){
        _bitchService.delete(uuid);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<BitchModel> update(@PathVariable UUID uuid, @RequestBody BitchModel bitch){
        return ResponseEntity.ok(_bitchService.update(uuid, bitch));
    }


}
