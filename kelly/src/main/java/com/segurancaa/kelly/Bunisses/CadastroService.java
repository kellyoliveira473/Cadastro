package com.segurancaa.kelly.Bunisses;

import com.segurancaa.kelly.Infrascture.Entites.Cadastro;
import com.segurancaa.kelly.Infrascture.Repository.CadastroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {
    private final CadastroRepository repository;

    public CadastroService(CadastroRepository repository) {
        this.repository = repository;
    }
    public Cadastro salvar(Cadastro cadastro) {
        return repository.save(cadastro);
    }
public List<Cadastro> listar() {
        return repository.findAll();
}


}
