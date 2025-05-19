package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Renda;

import java.util.List;

public interface RendaDao {
    void inserirRenda(Renda renda) throws DBExeption;
    void alterarRenda(Renda renda) throws DBExeption;
    void excluirRenda(int id) throws DBExeption;
    Renda buscarRendaPorId(int id) throws DBExeption;
    List<Renda> listarRendas() throws DBExeption;
}
