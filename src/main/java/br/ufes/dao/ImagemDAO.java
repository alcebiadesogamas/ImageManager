package br.ufes.dao;

import br.ufes.model.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alcebiades
 */
public class ImagemDAO {

    public void AddImage(Imagem image) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (image == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {

            String SQL = "INSERT INTO imagem (descricao, caminho) values (?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, image.getDescricao());
            ps.setString(2, image.getCaminho());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public boolean FindAnyImage() throws Exception {
        Connection conn  = ConexaoFactory.getConexao();
        
        PreparedStatement ps = null;
        boolean found = false;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from imagem");
            rs = ps.executeQuery();

            found = rs.next(); //returns true or false if exists.

        } catch (SQLException sqle) {
            throw new Exception(sqle);

        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }
        return found;
    }

    public void delete(Imagem image) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        if (image == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            //delete all notifications and permissions
            ps = conn.prepareStatement("delete from imagem where caminho = ?");
            ps.setString(1, image.getCaminho());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }
}
