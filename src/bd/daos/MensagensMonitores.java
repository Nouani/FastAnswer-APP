package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
A classe MensagensMonitores representa todas as mensagens enviadas pelos monitores de uma Tabela no DB.
Tem como métodos insert, select's.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class MensagensMonitores
{
	/**
	 Método que inclui uma nova mensagem de um monitor
	 * @param mensagemMonitor objeto da classe MensagemMonitor que será incluido
	 * @throws Exception se o objeto dado for inválidos
	 */
    public static void incluir (MensagemMonitor mensagemMonitor) throws Exception
    {
        if (mensagemMonitor==null)
            throw new Exception ("Mensagem a ser enviada nao fornecida");

        try
        {
            String sql;

            /*sql = "INSERT INTO MensagensMonitores " +
                  "(CodMonitor,MensagemMonitor,RA,DataEnvio,OrdemMensagem) " +
                  "VALUES " +
                  "(?,?,?,?,?)";*/
            sql = "insert into MensagensMonitores values(?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1, mensagemMonitor.getCodMonitorEnviou());
            BDSQLServer.COMANDO.setString(2, mensagemMonitor.getMensagemMonitor());
            BDSQLServer.COMANDO.setString(3, mensagemMonitor.getRA());
            BDSQLServer.COMANDO.setInt(4, mensagemMonitor.getOrdemMensagem());
            BDSQLServer.COMANDO.setString(5, mensagemMonitor.getRecebimentoMonitor());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
          //BDSQLServer.COMANDO.rollback ();
            throw new Exception ("Erro ao cadastrar a mensagem do monitor");
        }
    }
    
    /**
	 Método que retorna todas as mensagens ordenados pelo campo OrdemMensagem.
	 * @return o dicionário contendo todas as mensagens ordenadas
	 * @throws Exception se ocorrer algum problema no DB
	 */
    public static MeuResultSet getMensagensMonitoresOrdenadas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM MensagensMonitores "+
            	  "order by OrdemMensagem";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos monitores");
        }

        return resultado;
    }
    
    /**
	 Método que retorna todas as mensagens por um determinado código de monitor e RA
	 ordenados pelo campo OrdemMensagem.
	 * @param codMonitor é o código do monitor com mensagens enviadas a serem procuradas
	 * @param RA é o RA do aluno com mensagens recebidas a serem procuradas
	 * @return o dicionário contendo todas as mensagens de acordo com o código do minitor e RA ordenadas
	 * @throws Exception se ocorrer algum problema no DB
	 */
    public static MeuResultSet getMensagensPeloCodMonitor (int codMonitor, String RA) throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;
            
            sql = "SELECT * " +
                   "FROM MensagensMonitores "+
                   "WHERE CodMonitor = ? AND "+
                   "RA = ? "+
                   "order by OrdemMensagem";

            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setInt (1, codMonitor);
            BDSQLServer.COMANDO.setString (2, RA);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar todas as mensagens dos monitores com tal recebimento");
        }

        return resultado;
    }
}