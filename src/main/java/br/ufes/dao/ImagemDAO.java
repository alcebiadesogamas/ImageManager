package br.ufes.dao;

import java.sql.Connection;

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
}
