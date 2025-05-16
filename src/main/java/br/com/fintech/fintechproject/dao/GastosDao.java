package br.com.fintech.fintechproject.dao;

import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.model.Gastos;

import java.util.List;

public interface GastosDao {
    void inserirGastos(Gastos g) throws DBExeption;
    void alterarGastos(Gastos g) throws DBExeption;
    void excluirGastos(int id) throws DBExeption;
    Gastos buscarGastoPorId(int id) throws DBExeption;
    List<Gastos> listarGastos()  throws DBExeption;
}
