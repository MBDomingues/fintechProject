package br.com.fintech.project.dao.impl;
//Imports
import br.com.fintech.project.dao.BancoDao;
import br.com.fintech.project.connection.ConnectionManager;
import br.com.fintech.project.exeption.DBExeption;
import br.com.fintech.project.model.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Classe DAO da tabela Banco
public class OracleBancoDao implements BancoDao {
    private Connection conexao;

//Metodo Caastrar
    @Override
    public void cadastrarBanco(Banco banco) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            String sql = "insert into t_banco (cd_banco, nm_banco) values(SEQ_CD_BANCO.NEXTVAL,?)";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, banco.getNm_banco());
            stmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao cadastrar Banco");
            } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


//Metodo Alterar
    @Override
    public void alterarBanco(Banco banco) throws DBExeption {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();

            String sql = "update t_banco set  nm_banco = ? where nm_banco = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, banco.getNm_banco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao alterar Banco");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


//Metodo remover banco
    @Override
    public void excluirBanco(String nome) throws DBExeption {

        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "delete from t_banco where nm_banco = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao deletar Banco");
        }  finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

//Metodo buscar
    @Override
    public Banco buscarBancoPorNome(String nome) throws DBExeption {

        Banco banco = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "select * from t_banco where nm_banco = ?";

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("cd_banco");
                nome = rs.getString("nm_banco");

                banco = new Banco(codigo, nome);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao buscar Banco");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return banco;
    }

//  Listar bancos
    @Override
    public List<Banco> listarBancos() throws DBExeption {

        List<Banco> bancos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getConnectionManager();
            String sql = "select * from t_banco order by cd_banco";

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

//            percorre todos os registros
            while (rs.next()) {
                int codigo = rs.getInt("cd_banco");
                String nome = rs.getString("nm_banco");
                Banco banco = new Banco(codigo, nome);
                bancos.add(banco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBExeption("Erro ao listar Bancos");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bancos;
    }
}
