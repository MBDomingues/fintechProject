package br.com.fintech.fintechproject.dao;

import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.model.Banco;

import java.util.List;

public interface BancoDao {
    void cadastrarBanco(Banco banco)  throws DBExeption;
    void alterarBanco(Banco banco)  throws DBExeption;
    void excluirBanco(Banco banco)  throws DBExeption;
    Banco buscarBancoPorId(int id)  throws DBExeption;
    List<Banco> listarBancos() throws DBExeption;
}
