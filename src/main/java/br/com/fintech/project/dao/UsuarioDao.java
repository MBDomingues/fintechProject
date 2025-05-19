package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void cadastrarUsuario(Usuario usuario) throws DBExeption;
    List<Usuario> listarUsuarios() throws DBExeption;
    void alterarUsuario(Usuario usuario)  throws DBExeption;
    void excluirUsuario(String nome)  throws DBExeption;
    Usuario buscarUsuarioPorNome(String nome)   throws DBExeption;
}
