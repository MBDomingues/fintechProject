package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Gastos;

import java.util.List;

public interface GastosDao {
    void inserirGastos(Gastos g) throws DBExeption;
    void alterarGastos(Gastos g) throws DBExeption;
    void excluirGastos(int id) throws DBExeption;
    Gastos buscarGastoPorId(int id) throws DBExeption;
    List<Gastos> listarGastos()  throws DBExeption;
}
