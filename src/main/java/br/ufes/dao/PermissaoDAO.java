package br.ufes.dao;

import java.sql.Connection;

/**
 *
 * @author Alcebiades
 */
public class PermissaoDAO {
    private Connection conn;

    public PermissaoDAO() throws Exception {
        try {
            this.conn = ConexaoSQLITE.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }
}
