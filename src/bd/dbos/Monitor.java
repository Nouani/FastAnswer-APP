package bd.dbos;

/**
A classe Aluno representa um aluno de uma tabela Alunos.
Tem como métodos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Monitor implements Cloneable
{
    private int codMonitor;
    private String RA;
    private String atividade;
    
    /**
	Seta o código do monitor.
	@param codMonitor código desejado para inclusão
	@throws Exception caso código seja menor que zero
	*/
    public void setCodigo(int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Codigo nao fornecido");

        this.codMonitor = codMonitor;
    }
    
    /**
	Seta o RA do monitor.
	@param RA RA desejado para inclusão
	@throws Exception caso RA seja nulo ou vazio
	*/
    public void setRA (String RA) throws Exception
    {
    	RA.trim();
        if (RA==null || RA.equals(""))
            throw new Exception ("RA nao fornecido");

        this.RA = RA;
    }
    
    /**
	Seta a atividade do monitor.
	@param atividade atividade desejada para inclusão
	@throws Exception caso atividade seja nula ou vazia
	*/
    public void setAtividade (String atividade) throws Exception
    {
        if (atividade==null || atividade.trim().equals(""))
            throw new Exception ("Atividade nao fornecida");

        this.atividade = atividade;
    }
    
    /**
	Pega o código do monitor
	@return código do aluno
	*/
    public int getCodigo()
    {
        return this.codMonitor;
    }
    
    /**
	Pega o RA do monitor
	@return RA do monitor
	*/
    public String getRA ()
    {
        return this.RA;
    }
    
    /**
	Pega a atividade do monitor
	@return atividade do monitor
	*/
    public String getAtividade ()
    {
        return this.atividade;
    }
    
    /**
	Construtor da classe Monitor.
	Seta os atributos da classe.
	@param codMonitor código do monitor
	@param RA RA do monitor
	@param atividade atividade online ou offline
	@throws Exception caso o parâmetro seja nulo ou vazio
	*/
    public Monitor (int codMonitor, String RA, String atividade) throws Exception
    {
        this.setCodigo(codMonitor);
        this.setRA(RA);
        this.setAtividade(atividade);
    }
    
    /**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
    public String toString ()
    {
        String ret="";
        
        ret+="Codigo..: "+this.codMonitor  +"\n";
        ret+="RA..: "+this.RA  +"\n";
        ret+="Atividade..: "+this.atividade  +"\n";

        return ret;
    }

    /**
	Verifica se a instância é igual a outra.
	@param obj objeto a ser comparado com a instância
	@return true se os atributos forem iguais, false se não forem
	*/
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Monitor))
            return false;

        Monitor monit = (Monitor)obj;

        if (this.codMonitor != monit.codMonitor)
            return false;
        
        if (this.RA.equals(monit.RA))
            return false;
        
        if (this.atividade.equals(monit.atividade))
            return false;

        return true;
    }

    /**
	Calcula e devolve o código hash da instância.
	@return o código hash.
	*/
    public int hashCode ()
    {
        int ret=666;
        
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.atividade.hashCode();

        return ret;
    }

    /**
   	Construtor de cópia da classe.
   	Seta os atributos da instância com os do passado como parâmetro
   	@param modelo instância a ser copiada
   	*/
    public Monitor (Monitor modelo)
    {
        this.codMonitor   = modelo.codMonitor;   // nao clono, pq nao eh clonavel
        this.RA   = modelo.RA;   // nao clono, pq nao eh clonavel
        this.atividade = modelo.atividade;
    }

    /**
	Clona a instância.
	@return a instância clonada
	*/
    public Object clone ()
    {
        Monitor ret=null;

        try
        {
            ret = new Monitor (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca ï¿½ null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}