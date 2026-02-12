package com.example.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Criar
    public Usuario criar(Usuario usuario) {
        usuarioRepository.salvar(usuario);
        return usuario;
    }

    // Listar
    public List<Usuario> listar() {
        return usuarioRepository.listarTodos();
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);

        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado com id: " + id);
        }

        return usuario;
    }

    // Atualizar
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {

        Usuario usuarioExistente = buscarPorId(id);

        // Aplicando POO (atualiza via métodos da entidade)
        usuarioExistente.atualizarNome(usuarioAtualizado.getNome());
        usuarioExistente.atualizarEmail(
                usuarioAtualizado.getEmail().getValor()
        );

        usuarioRepository.atualizar(usuarioExistente);

        return usuarioExistente;
    }

    // Remover
    public void remover(Long id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.remover(usuario.getId());
    }
}