package br.ufes.dao;

import br.ufes.model.Imagem;
import br.ufes.proxy.IProxyImagem;
import br.ufes.proxy.ImagemProxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class ImagemDAO {

    public void AddImage(ImagemProxy image) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;
        ResultSet rs = null;
        if (image == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            
            ps = conn.prepareStatement("SELECT * FROM imagem where caminho = ?;");
            ps.setString(1, image.getCaminho());
            rs = ps.executeQuery();
            if(!rs.next()){
                String SQL = "INSERT INTO imagem (caminho) values (?);";

                ps = conn.prepareStatement(SQL);
                ps.setString(1, image.getCaminho());
            
                ps.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public boolean FindAnyImage() throws Exception {
        Connection conn = ConexaoFactory.getConexao();

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

    public ArrayList<ImagemProxy> findAll() throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        ArrayList<ImagemProxy> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from imagem");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String caminho = rs.getString(2);
                list.add(new ImagemProxy(id, caminho));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);

        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }
        return list;
    }

    public void delete(ImagemProxy image) throws Exception {
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


 public ImagemProxy findImagem(String path) throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from imagem where caminho = ?;");
            ps.setString(1, path);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                return new ImagemProxy(id, path);
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);

        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }
       return null;
    }
}