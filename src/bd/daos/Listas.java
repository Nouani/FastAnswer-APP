package bd.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Listas
{
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LISTAS " +
                  "WHERE CODLISTA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

            /* // ou, se preferirmos,

            String sql;

            sql = "SELECT COUNT(*) AS QUANTOS " +
                  "FROM LIVROS " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            resultado.first();

            retorno = resultado.getInt("QUANTOS") != 0;

            */
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar lista");
        }

        return retorno;
    }

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
    
    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM LISTAS " +
                  "WHERE CODLISTA=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao excluir lista");
        }
    }

    public static void alterar (Lista lista) throws Exception
    {
        if (lista==null)
            throw new Exception ("Lista nao fornecida");

        if (!cadastrado (lista.getCodigo()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE LISTAS " +
                  "SET CODMATERIA=?, " +
                  "ARQUIVO=?, " +
                  "NOMELISTA=? " +
                  "WHERE CODLISTA = ?";

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

            BDSQLServer.COMANDO.setInt(1, lista.getCodMateria());
            BDSQLServer.COMANDO.setBytes(2, bytes);
            BDSQLServer.COMANDO.setString(3, lista.getNomeLista());
            BDSQLServer.COMANDO.setInt(4, lista.getCodigo ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar dados da lista");
        }
    }

    /*public static Lista getLista(int codigo) throws Exception
    {
        Lista lista = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LISTAS " +
                  "WHERE CODLISTA = ?";

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

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            lista = new Lista(resultado.getInt   ("CODLISTA"),
                               resultado.getInt("CODMATERIA"),
                               resultado.getString ("ARQUIVO"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar lista");
        }

        return lista;
    }*/

    public static MeuResultSet getListas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM LISTAS";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar as listas");
        }

        return resultado;
    }
}