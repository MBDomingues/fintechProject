package br.com.fintech.fintechproject.dao;

import br.com.fintech.fintechproject.exeption.DBExeption;
import br.com.fintech.fintechproject.model.Email;

import java.util.List;

public interface EmailDao {
    void inserirEmail(Email email) throws DBExeption;
    void alterarEmail(Email email) throws DBExeption;
    void excluirEmail(int id) throws DBExeption;
    Email buscarEmailPorId(int id) throws DBExeption;
    List<Email> listarEmails() throws DBExeption;
}
