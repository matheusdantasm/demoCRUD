package com.seuprojeto.demo.service;

import com.seuprojeto.demo.model.Usuario;
import com.seuprojeto.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    public void atualizar(Usuario usuario) {
        usuarioRepository.atualizar(usuario);
    }

    public void remover(Long id) {
        usuarioRepository.remover(id);
    }
}
