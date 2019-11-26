package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe Monitores representa todas os monitores de uma Tabela no DB.
Tem como métodos select's e update.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Monitores
{
	/**
	 Método que confere se o monitor está cadastrado
	 * @param RA é o RA do monitor a ser procurado
	 * @return se está cadastrado ou não
	 * @throws Exception se ocorrer algum erro na procura
	 */
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
    
    /**
	 Método que altera as informações de um monitor já inserido
	 * @param monitor objeto da classe Monitor que será alterado
	 * @throws Exception se o objeto for inválido ou se ocorrer erros na conexão
	 */
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

    /**
	 Método que retorna um monitor.
	 * @param RA é o RA do monitor a ser retornado
	 * @return o objeto do monitor do respectivo RA
	 * @throws Exception se o monitor não estiver cadastrado, ou problemas no DB
	 */
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
    
    /**
	 Método que retorna todos os monitores.
	 * @return o dicionário contento todos os monitores
	 * @throws Exception se houver problemas no DB
	 */
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