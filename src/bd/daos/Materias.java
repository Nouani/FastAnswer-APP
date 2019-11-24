package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Materias
{
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS " +
                  "WHERE CODMONITOR = ?";

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
            throw new Exception ("Erro ao procurar mat�ria");
        }

        return retorno;
    }

    public static void incluir (Materia materia) throws Exception
    {
        if (materia==null)
            throw new Exception ("Matéria nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO MATERIAS " +
                  "(CODMATERIA,CODMONITOR,NOME) " +
                  "VALUES " +
                  "(?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, materia.getCodigo ());
            BDSQLServer.COMANDO.setInt (2, materia.getCodMonitor ());
            BDSQLServer.COMANDO.setString  (3, materia.getNome ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao inserir mat�ria");
        }
    }

    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM MATERIAS " +
                  "WHERE CODMONITOR=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao excluir matéria");
        }
    }

    public static void alterar (Materia materia) throws Exception
    {
        if (materia==null)
            throw new Exception ("Matéria nao fornecida");

        if (!cadastrado (materia.getCodigo()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE MATERIA " +
                  "SET NOME=? " +
                  "WHERE CODMONITOR = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString  (1, materia.getNome ());
            BDSQLServer.COMANDO.setInt    (2, materia.getCodMonitor ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao atualizar dados da matéria");
        }
    }

    public static Materia getMateria (int codigo) throws Exception
    {
        Materia materia = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS " +
                  "WHERE CODMONITOR = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            System.out.println(codigo);
            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            materia = new Materia (resultado.getInt   ("CODMATERIA"),
                               resultado.getInt("CODMONITOR"),
                               resultado.getString ("NOME"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar matéria");
        }

        return materia;
    }

    public static MeuResultSet getMaterias () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MATERIAS";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar matérias");
        }

        return resultado;
    }
}