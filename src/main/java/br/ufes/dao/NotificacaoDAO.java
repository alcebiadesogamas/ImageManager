package br.ufes.dao;

import br.ufes.model.Notificacao;
import br.ufes.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alcebiades
 */
public class NotificacaoDAO {

    public void saveById(Notificacao notificacao) throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        PreparedStatement ps = null;

        if (notificacao == null) {
            throw new Exception("Atributo não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO notificacao (idusuario, descricao)"
                    + " values (?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setInt(1, notificacao.getUsuario().getId());
            ps.setString(2, notificacao.getDescricao());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }

    public ArrayList<Notificacao> getNotificationById(int id) throws Exception {
        Connection conn = ConexaoFactory.getConexao();

        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select idnotificacao, descricao FROM Notificacao inner join UsuarioLogin "
                    + "on (notificacao.idusuarioLogin = notificacao.idusuarioLogin) where notificacao.idusuarioLogin = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            ArrayList<Notificacao> list = new ArrayList<>();

            while (rs.next()) {
                int idNotificacao = rs.getInt(1);
                int idUsuario = rs.getInt(2);
                String descricao = rs.getString(3);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.findbyId(idUsuario);

                list.add(new Notificacao(idNotificacao, usuario, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps, rs);
        }

    }

    public void delete(Notificacao notificacao) throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        PreparedStatement ps = null;

        if (notificacao == null) {
            throw new Exception("Notificacao não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete * from notificacao where idnotificacao= ?;");
            ps.setInt(1, notificacao.getIdNotificacao());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }

    }
}
