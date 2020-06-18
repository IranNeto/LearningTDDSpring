package com.example.tdddemo.services;

import com.example.tdddemo.entities.User;
import com.example.tdddemo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Retorna todos os usuários armazenados
     *
     * @return List<Usuario>
     */
    public List<User> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Registra um usuário
     *
     * @return Usuario
     */
    public User registerUser(User user) {
        User u = usuarioRepository.save(user);
        return u;
    }
}
