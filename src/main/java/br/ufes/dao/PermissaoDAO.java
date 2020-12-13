package br.ufes.dao;

import br.ufes.model.Permissao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alcebiades
 */
public class PermissaoDAO {
    
    public void AddPermission(Permissao permission) throws Exception {
        Connection conn = ConexaoFactory.getConexao();
        
        PreparedStatement ps = null;

        if (permission == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
                      
            String SQL = "INSERT INTO permissao (idusuario, idimagem, excluir, visualizar, compartilhar)"
                    + " values (?, ?, ?, ?, ?);";

            ps = conn.prepareStatement(SQL);
            ps.setInt(1, permission.getUsuario().getId());
            ps.setInt(2, permission.getImagem().getId());
            ps.setBoolean(3, permission.isExcluir());
            ps.setBoolean(4, permission.isVizualizar());
            ps.setBoolean(5, permission.isCompartilhar());            
            ps.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConexaoFactory.fecharConexao(conn, ps);
        }
    }
    
}
