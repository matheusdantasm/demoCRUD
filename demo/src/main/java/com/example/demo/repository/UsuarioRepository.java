package com.example.demo.repository;

import com.example.demo.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Criar tabela ao iniciar aplicação
    @PostConstruct
    public void criarTabela() {
        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(255) NOT NULL,
                    email VARCHAR(255) NOT NULL
                )
                """;
        jdbcTemplate.execute(sql);
    }

    // Salvar
    public int salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, usuario.getNome(), usuario.getEmail());
    }

    // Listar todos
    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM usuarios";
        return jdbcTemplate.query(sql, this::mapRowToUsuario);
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToUsuario, id);
    }

    // Atualizar
    public int atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getId());
    }

    // Remover
    public int remover(Long id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Mapper
    private Usuario mapRowToUsuario(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.atualizarNome(rs.getString("nome"));
        usuario.atualizarEmail(rs.getString("email"));
        return usuario;
    }
}
