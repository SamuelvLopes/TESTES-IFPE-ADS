package com.example.demo.controller;

import com.example.demo.entity.Vaga;
import com.example.demo.service.VagaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga salvar( @RequestBody Vaga vaga){
        return vagaService.salvar(vaga);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> listaVagas() {
        return vagaService.listarvagas();
    }

@GetMapping("/buscar/{id}")
@ResponseStatus(HttpStatus.OK)
    public Vaga buscarVagaPorId(@PathVariable("id") Long id){
        return vagaService.buscarPorId(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "VAGA NAO ENCONTRADA"));
    }

    @GetMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void removerVaga(@PathVariable("id") Long id){
vagaService.buscarPorId(id).map(vaga ->{
    vagaService.removerPorId(vaga.getId());
 return Void.TYPE;}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "VAGA NAO ENCONTRADA"));
}
//ver problema no put
@PutMapping("editar/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void editarVaga (@PathVariable("id") Long id, @RequestBody Vaga vaga){
    vagaService.buscarPorId(id).map(vagaBase -> {modelMapper.map(vaga,vagaBase);
     return Void.TYPE;
    }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "VAGA NAO ENCONTRADA"));
}
}
