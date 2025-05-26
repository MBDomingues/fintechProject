package br.com.fintech.project.dao;

import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Metas;

import java.util.List;

public interface MetasDao {
    void cadastrarMeta (Metas metas)  throws DBExeption;
    void alterarMeta (Metas metas)  throws DBExeption;
    void excluirMeta (int id)  throws DBExeption;
    List<Metas> listarMetas(int codigo)  throws DBExeption;
    Metas buscarMetasPorCodigo(int codigo)  throws DBExeption;
}
