package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Conta;

import java.util.List;

public interface ContaDao {
    void inserirConta(Conta conta)  throws DBExeption;
    void alterarConta(Conta conta)  throws DBExeption;
    void excluirConta(Conta conta)  throws DBExeption;
    Conta buscarContaPorId(int id)  throws DBExeption;
    List<Conta> listarContas()  throws DBExeption;
}
