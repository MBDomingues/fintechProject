package br.com.fintech.fintechproject.dao;

import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void inserirUsuario(Usuario usuario) throws DBExeption;
    List<Usuario> listarUsuarios() throws DBExeption;
    void alterarUsuario(Usuario usuario)  throws DBExeption;
    void excluirUsuario(Usuario usuario)  throws DBExeption;
    Usuario buscarUsuarioPorId(int id)   throws DBExeption;
}
