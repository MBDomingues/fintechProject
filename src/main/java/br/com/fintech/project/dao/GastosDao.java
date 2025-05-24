package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Gastos;

import java.util.List;

public interface GastosDao {
    void inserirGastos(Gastos gastos) throws DBExeption;
    void alterarGastos(Gastos gastos) throws DBExeption;
    void excluirGastos(int id) throws DBExeption;
    Gastos buscarGastoPorId(int id) throws DBExeption;
    List<Gastos> listarGastos(int codigo)  throws DBExeption;
}
