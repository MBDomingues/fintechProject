package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Banco;

import java.util.List;

public interface BancoDao {
    void cadastrarBanco(Banco banco)  throws DBExeption;
    void alterarBanco(Banco banco)  throws DBExeption;
    void excluirBanco(String nome)  throws DBExeption;
    Banco buscarBancoPorNome(String nome)  throws DBExeption;
    List<Banco> listarBancos() throws DBExeption;
}
