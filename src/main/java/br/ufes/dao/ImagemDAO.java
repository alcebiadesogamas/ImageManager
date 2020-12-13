package br.ufes.dao;

import br.ufes.model.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alcebiades
 */
public class ImagemDAO {
    private Connection conn;

    public ImagemDAO() throws Exception {
        try {
            this.conn = ConexaoSQLITE.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }
    
    public void createUser(Imagem image) throws Exception {
        PreparedStatement ps = null;

        if (image == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
                      
            String SQL = "INSERT INTO imagem (descricao,caminho) values (?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, user.getNome());
            ps.setString(2, password);
            
            if(user.isAdmin())
                ps.setBoolean(3, true);
            else
                ps.setBoolean(3, false);
            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoSQLITE.fecharConexao(conn, ps);
        }
    }
}
