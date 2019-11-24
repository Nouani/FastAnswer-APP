package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Monitores
{
    public static boolean cadastrado (String RA) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MONITORES " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, RA);

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
            throw new Exception ("Erro ao procurar monitor");
        }

        return retorno;
    }

    public static void incluir (Monitor monitor) throws Exception
    {
        if (monitor==null)
            throw new Exception ("Monitor nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO MONITORES " +
                  "(CODMONITOR,RA,ATIVIDADE) " +
                  "VALUES " +
                  "(?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setInt (1, monitor.getCodigo ());
            BDSQLServer.COMANDO.setString (2, monitor.getRA ());
            BDSQLServer.COMANDO.setString (3, monitor.getAtividade());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao cadastrar monitor");
        }
    }

    public static void excluir (String RA) throws Exception
    {
        if (!cadastrado (RA))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM MONITORES " +
                  "WHERE RA=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, RA);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao excluir monitor");
        }
    }

    public static void alterar (Monitor monitor) throws Exception
    {
        if (monitor==null)
            throw new Exception ("Monitor nao fornecido");

        if (!cadastrado (monitor.getRA()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE MONITORES " +
                  "SET ATIVIDADE= ? " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, monitor.getAtividade());
            BDSQLServer.COMANDO.setString (2, monitor.getRA());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar dados do monitor");
        }
    }

    public static Monitor getMonitor (String RA) throws Exception
    {
        Monitor monitor = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MONITORES " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, RA);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            /*monitor = new Monitor ( resultado.getInt("CODMONITOR");
                                    resultado.getString("RA"));*/
            monitor = new Monitor(resultado.getInt("CODMONITOR"),
                                  resultado.getString("RA"),
                                  resultado.getString("ATIVIDADE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar monitor");
        }

        return monitor;
    }

    public static MeuResultSet getMonitores() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MONITORES";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar monitores");
        }

        return resultado;
    }
}