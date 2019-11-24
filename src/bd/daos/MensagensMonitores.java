package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class MensagensMonitores
{
    public static boolean cadastrado (int codMensagemMonitor) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MENSAGENSALUNOS " +
                  "WHERE CodMensagemMonitor = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, codMensagemMonitor);

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
            throw new Exception ("Erro ao procurar a mensagem enviada do monitor");
        }

        return retorno;
    }

    public static void incluir (MensagemMonitor MensagemMonitor) throws Exception
    {
        if (MensagemMonitor==null)
            throw new Exception ("Mensagem a ser enviada nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO MensagensAlunos " +
                  "(CodMensagemMonitor,MensagemMonitor,RA,Recebimento) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, MensagemMonitor.getCodMensagemMonitor());
            BDSQLServer.COMANDO.setString(2, MensagemMonitor.getMensagemMonitor());
            BDSQLServer.COMANDO.setString(3, MensagemMonitor.getRA());
            BDSQLServer.COMANDO.setString(4, MensagemMonitor.getRecebimentoMonitor());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao cadastrar a mensagem do monitor");
        }
    }

    public static void excluir (int codMensagemMonitor) throws Exception
    {
        if (!cadastrado (codMensagemMonitor))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM MensagensAlunos " +
                  "WHERE CodMensagemMonitor=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codMensagemMonitor);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao excluir mensagem do monitor");
        }
    }

    public static void alterar (MensagemMonitor mensagemMonitor) throws Exception
    {
        if (mensagemMonitor==null)
            throw new Exception ("Mensagem do monitore não fornecida");

        if (!cadastrado (mensagemMonitor.getCodMensagemMonitor()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE MensagensAlunos " +
                  "SET MensagemMonitor=? " +
                  "SET RA=? " +
                  "SET Recebimento=? " +
                  "WHERE CodMensagemMonitor = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, mensagemMonitor.getMensagemMonitor());
            BDSQLServer.COMANDO.setString  (2, mensagemMonitor.getRA());
            BDSQLServer.COMANDO.setString (3, mensagemMonitor.getRecebimentoMonitor());
            BDSQLServer.COMANDO.setInt    (4, mensagemMonitor.getCodMensagemMonitor());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar mensagem do monitor");
        }
    }

    public static MensagemMonitor getMensagemMonitor (int codMensagemMonitor) throws Exception
    {
    	MensagemMonitor mensagemMonitor = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensMonitores " +
                  "WHERE CodMensagemMonitor = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codMensagemMonitor);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            mensagemMonitor = new MensagemMonitor (resultado.getInt("CodMensagemMonitor"),
                               				resultado.getString("MensagemMonitor"),
                               				resultado.getString("RA"),
                               				resultado.getString("Recebimento"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar mensagem do monitor");
        }

        return mensagemMonitor;
    }

    public static MeuResultSet getTodasMensagensAlunos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensMonitores";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos monitores");
        }

        return resultado;
    }
    
    public static MeuResultSet getMensagensPeloRecebimento (String recebimento) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensMonitores "+
                  "WHERE Recebimento = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, recebimento);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos monitores com tal recebimento");
        }

        return resultado;
    }
}