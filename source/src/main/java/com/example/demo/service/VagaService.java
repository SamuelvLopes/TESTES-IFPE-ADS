package com.example.demo.service;

import com.example.demo.entity.Vaga;
import com.example.demo.repository.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga salvar (Vaga vaga){
        return vagaRepository.save(vaga);
    }

public List<Vaga> listarvagas(){
        return vagaRepository.findAll();
}



public Optional<Vaga> buscarPorId(Long id){
        return vagaRepository.findById(id);
}

public void removerPorId(Long id){
    vagaRepository.deleteById(id);
}

}
