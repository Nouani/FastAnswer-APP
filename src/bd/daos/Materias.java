package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe Materias representa todos as matérias de uma Tabela no DB.
Tem como métodos select's.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Materias
{
	 /**
	 Método que retorna uma matéria.
	 * @param codigo é o código do monitor representante daquela matéria
	 * @return o objeto da classe Matéria do respectivo código
	 * @throws Exception se a matéria não estiver cadastrado, ou problemas no DB
	 */
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

    /**
	 Método que retorna todas as matérias
	 * @return o dicionário contento todas as matérias
	 * @throws Exception se houver problemas no DB
	 */
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