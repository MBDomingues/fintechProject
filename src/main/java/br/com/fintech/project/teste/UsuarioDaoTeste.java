package br.com.fintech.project.teste;

import br.com.fintech.project.dao.UsuarioDao;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.factory.DaoFactory;
import br.com.fintech.project.model.Usuario;

import java.util.List;

public class UsuarioDaoTeste {
    public static void main(String[] args) {
        UsuarioDao dao = DaoFactory.getUsuarioDao();

////        Cadastrar usuario
//        Usuario usuario = new Usuario (
//                0,
//                "Tacamon",
//                "teste",
//                0,
//                "tacamon@123",
//                "pessoal"
//        );
//        try {
//            dao.cadastrarUsuario(usuario);
//            System.out.println("Usuario inserido com sucesso");
//        } catch (DBExeption e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            dao.excluirUsuario("Tacamon");
//            System.out.println("Usuario excluido com sucesso");
//        } catch (DBExeption e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            List<Usuario> usuarios = dao.listarUsuarios();
//            for (Usuario usuario : usuarios) {
//                System.out.println( usuario.getCd_user() + "-" + usuario.getName() + "-" + usuario.getPassword());
//                System.out.println("_____________");
//
//            }
//        }catch ( DBExeption e){
//            System.out.println(e.getMessage());
        String email = "teste3@com";
        try {
            Usuario usuario = dao.buscarUsuarioPoremail(email);
            System.out.println(usuario.getNom_email() + " " + usuario.getPassword());
        } catch (DBExeption e) {
            System.out.println(e.getMessage());
        }
        }

}

