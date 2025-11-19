package edu.ifpb.webII.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifpb.webII.model.Servidor;
import edu.ifpb.webII.repository.ServidorRepository;

@Service
public class ServidorService {

    @Autowired
    private ServidorRepository servidorRepository;

    public void salvar(Servidor servidor) {
        servidorRepository.save(servidor);
    }

    public List<Servidor> listarTodos() {
        return servidorRepository.findAll();
    }

    public Servidor buscarPorId(Long id) {
        return servidorRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        servidorRepository.deleteById(id);
    }
}
