package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class MensagensAlunos
{
    public static boolean cadastrado (String ra) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MENSAGENSALUNOS " +
                  "WHERE RA = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, ra);

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
            throw new Exception ("Erro ao procurar a mensagem enviada do aluno");
        }

        return retorno;
    }

    public static void incluir (MensagemAluno mensagemAluno) throws Exception
    {
        if (mensagemAluno==null)
            throw new Exception ("Mensagem a ser enviada nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO MensagensAlunos " +
                  "(CodMensagemAluno,RA,MensagemAluno,CodMonitor,DataEnvio,Recebimento) " +
                  "VALUES " +
                  "(?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, mensagemAluno.getCodMensagemAluno());
            BDSQLServer.COMANDO.setString(2, mensagemAluno.getRAEnvio());
            BDSQLServer.COMANDO.setString(3, mensagemAluno.getMensagemAluno());
            BDSQLServer.COMANDO.setInt(4, mensagemAluno.getCodMonitor());
            BDSQLServer.COMANDO.setString(5, mensagemAluno.getEnvioAluno());
            BDSQLServer.COMANDO.setString(6, mensagemAluno.getRecebimentoAluno());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao cadastrar a mensagem do aluno");
        }
    }

    public static void excluir (String ra) throws Exception
    {
        if (!cadastrado (ra))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM MensagensAlunos " +
                  "WHERE RA=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, ra);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao excluir mensagem do aluno");
        }
    }

    public static void alterar (MensagemAluno mensagemAluno) throws Exception
    {
        if (mensagemAluno==null)
            throw new Exception ("Mensagem do aluno não fornecida");

        if (!cadastrado (mensagemAluno.getRAEnvio()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE MensagensAlunos " +
            	  "SET RA=? " +
                  "SET MensagemAluno=? " +
                  "SET CodMonitor=? " +
                  "SET EnvioAluno=? " +
                  "SET Recebimento=? " +
                  "WHERE CodMensagemAluno = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, mensagemAluno.getMensagemAluno());
            BDSQLServer.COMANDO.setString (2, mensagemAluno.getRAEnvio());
            BDSQLServer.COMANDO.setInt  (3, mensagemAluno.getCodMonitor());
            BDSQLServer.COMANDO.setString (4, mensagemAluno.getEnvioAluno());
            BDSQLServer.COMANDO.setString (5, mensagemAluno.getRecebimentoAluno());
            BDSQLServer.COMANDO.setInt    (6, mensagemAluno.getCodMensagemAluno());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar mensagem do aluno");
        }
    }

    /*public static MensagemAluno getMensagemAluno (int codMensagemAluno) throws Exception
    {
    	MensagemAluno mensagemAluno = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensAlunos " +
                  "WHERE CodMensagemAluno = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codMensagemAluno);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            mensagemAluno = new MensagemAluno (resultado.getInt("CodMensagemAluno"),
                               				resultado.getString("MensagemAluno"),
                               				resultado.getInt("CodMonitor"),
                               				resultado.getString("Recebimento"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar mensagem do aluno");
        }

        return mensagemAluno;
    }*/

    public static MeuResultSet getMensagensAlunosOrdenadas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensAlunos "+
            	  "order by EnvioAluno";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos alunos");
        }

        return resultado;
    }
    
    public static MeuResultSet getMensagensPeloRA (String ra, int codMonitor) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensAlunos "+
                  "WHERE RA = ? AND "+
                  "CodMonitor = ? "+
                  "order by EnvioAluno";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString (1, ra);
            BDSQLServer.COMANDO.setInt (2, codMonitor);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos alunos com tal recebimento");
        }

        return resultado;
    }
}