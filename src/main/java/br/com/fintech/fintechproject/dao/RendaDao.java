package br.com.fintech.fintechproject.dao;

import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.model.Renda;

import java.util.List;

public interface RendaDao {
    void inserirRenda(Renda renda) throws DBExeption;
    void alterarRenda(Renda renda) throws DBExeption;
    void excluirRenda(int id) throws DBExeption;
    Renda buscarRendaPorId(int id) throws DBExeption;
    List<Renda> listarRendas() throws DBExeption;
}
