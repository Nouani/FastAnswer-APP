package bd.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe Listas representa todas as listas de uma Tabela no DB.
Tem como método insert.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Listas
{
	/**
	 Método que inclui uma nova lista
	 * @param lista objeto da classe Lista que será incluido
	 * @throws Exception se o objeto lista for inválido ou problemas no DB
	 */
    public static void incluir (Lista lista) throws Exception
    {
        if (lista==null)
            throw new Exception ("Lista nao fornecida");

        try
        {
            String sql;
            System.out.println("C3");
            sql = "INSERT INTO LISTAS " +
                  "(CODMATERIA, ARQUIVO, NOMELISTA) " +
                  "VALUES " +
                  "(?,?,?)";
            System.out.println("C4");
            BDSQLServer.COMANDO.prepareStatement (sql);
            
            String diretorio = lista.getArquivo();
            File f = new File(diretorio);
            InputStream is = new FileInputStream(f);
            
            //converte o objeto file em array de bytes
            byte[] bytes = new byte[(int)f.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                offset += numRead;
            }
            System.out.println("C5");
            BDSQLServer.COMANDO.setInt(1, lista.getCodMateria ());
            BDSQLServer.COMANDO.setBytes(2, bytes);
            BDSQLServer.COMANDO.setString(3, lista.getNomeLista());
            
            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
            System.out.println("C6");
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao inserir lista");
        }
    }
}