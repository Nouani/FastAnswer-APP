package bd.dbos;

/**
A classe MensagemMonitor representa uma mensagem de um Monitor.
Tem como métodos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class MensagemMonitor implements Cloneable
{
    private int codMensagemMonitor;
    private int codMonitor;
    private String mensagemMonitor;
    private String RA;
    private int ordemMensagem;
    private String recebimento;
    
    /**
	Seta o código da mensagem.
	@param codMensagemMonitor codigo desejado para inclusão
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodMensagemMonitor(int codMensagemMonitor) throws Exception
    {
        if (codMensagemMonitor < 0)
            throw new Exception ("Código inválido");

        this.codMensagemMonitor = codMensagemMonitor;
    } 
    
    /**
	Seta o código do monitor.
	@param codMonitor código desejado para inclusão
	@throws Exception caso código seja menor que zero
	*/
    public void setCodMonitorEnviou(int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Código do monitor inválido");

        this.codMonitor = codMonitor;
    }
    
    /**
	Seta a mensagem.
	@param mensagemMonitor mensagem desejada para inclusão
	@throws Exception caso mensagem seja nula ou vazia
	*/
    public void setMensagemMonitor (String mensagemMonitor) throws Exception
    {
        if (mensagemMonitor==null || mensagemMonitor.trim().equals(""))
            throw new Exception ("Mensagem não fornecida");

        this.mensagemMonitor = mensagemMonitor;
    }
    
    /**
	Seta RA do aluno.
	@param RA RA desejado para inclusão
	@throws Exception caso RA seja nulo ou vazio
	*/
    public void setRA (String RA) throws Exception
    {
    	RA.trim();
    	if (RA==null || RA.trim().equals(""))
            throw new Exception ("Código do monitor é  invalido");

        this.RA = RA;
    }
    
    /**
	Seta ordem da mensagem.
	@param ordemMensagem ordem desejada para inclusão
	@throws Exception caso ordem seja menor que zero
	*/
    public void setOrdemMensagem (int ordemMensagem) throws Exception
    {
        if (ordemMensagem < 0)
            throw new Exception ("ordem inválida");

        this.ordemMensagem = ordemMensagem;
    }
    
    /**
   	Seta recebimento da mensagem.
   	@param recebimento recebimento desejado para inclusão
   	@throws Exception caso recebimento seja nulo ou vazio
   	*/
    public void setRecebimentoMonitor (String recebimento) throws Exception
    {
        if (recebimento==null || recebimento.trim().equals(""))
            throw new Exception ("Recebimento não fornecido");

        this.recebimento = recebimento;
    }

    /**
	Pega o código da mensagem
	@return codigo da mensagem
	*/
    public int getCodMensagemMonitor ()
    {
        return this.codMensagemMonitor;
    }
    
    /**
	Pega o código do monitor
	@return código do monitor
	*/
    public int getCodMonitorEnviou ()
    {
        return this.codMonitor;
    }
    
    /**
	Pega a mensagem do monitor
	@return mensagem do monitor
	*/
    public String getMensagemMonitor ()
    {
        return this.mensagemMonitor;
    }
    
    /**
	Pega o RA do aluno
	@return RA do aluno
	*/
    public String getRA ()
    {
        return this.RA;
    }
    
    /**
	Pega a ordem da mensagem
	@return ordem da mensagem
	*/
    public int getOrdemMensagem ()
    {
        return this.ordemMensagem;
    }
    
    /**
	Pega o recebimento da mensagem
	@return recebimento da mensagem
	*/
    public String getRecebimentoMonitor ()
    {
        return this.recebimento;
    }
    
    /**
	Construtor da classe MensagemMonitor.
	Seta os atributos da classe.
	@param codMensagemMonitor código da mensagem
	@param codMonitor código do monitor
	@param mensagemMonitor mensagem enviada
	@param RA RA do aluno
	@param ordemMensagem ordem da mensagem
	@param recebimento foi recebido ou não
	@throws Exception caso o parâmetro seja nulo, vazio ou menor que zero
	*/
    public MensagemMonitor (int codMensagemMonitor, int codMonitor, String mensagemMonitor, String RA, int ordemMensagem, String recebimento) throws Exception
    {
        this.setCodMensagemMonitor (codMensagemMonitor);
        this.setCodMonitorEnviou (codMonitor);
        this.setMensagemMonitor(mensagemMonitor);
        this.setRA(RA);
        this.setOrdemMensagem(ordemMensagem);
        this.setRecebimentoMonitor(recebimento);
    }
    
    /**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
    public String toString ()
    {
        String ret="";

        ret+="Código da Mensagem do Monitor: "+this.codMensagemMonitor+"\n";
        ret+="Código do Monitor que enviou: "+this.codMensagemMonitor+"\n";
        ret+="Mensagem do Monitor..: "+this.mensagemMonitor  +"\n";
        ret+="RA do aluno a receber.: "+this.RA+"\n";
        ret+="Data e Horário do envio.: "+this.ordemMensagem+"\n";
        ret+="Mensagem foi recebida?: "+this.recebimento;

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

        if (!(obj instanceof MensagemMonitor))
            return false;

        MensagemMonitor monit = (MensagemMonitor)obj;

        if (this.codMensagemMonitor!=monit.codMensagemMonitor)
            return false;
        
        if (this.codMonitor!=monit.codMonitor)
            return false;

        if (!this.mensagemMonitor.equals(monit.mensagemMonitor))
            return false;

        if (!this.RA.equals(monit.RA))
            return false;
        
        if (this.ordemMensagem!=monit.ordemMensagem)
            return false;
        
        if (!this.recebimento.equals(monit.recebimento))
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

        ret = 7*ret + new Integer (this.codMensagemMonitor).hashCode();
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + this.mensagemMonitor.hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + new Integer (this.ordemMensagem).hashCode();
        ret = 7*ret + this.recebimento.hashCode();
        
        if (ret < 0)
        	ret = -ret;

        return ret;
    }

    /**
	Construtor de cópia da classe.
	Seta os atributos da instância com os do passado como parâmetro
	@param instância a ser copiada
	*/
    public MensagemMonitor (MensagemMonitor modelo) throws Exception
    {
        this.codMensagemMonitor = modelo.codMensagemMonitor; 
        this.codMonitor = modelo.codMonitor; 
        this.mensagemMonitor   = modelo.mensagemMonitor;   
        this.RA  = modelo.RA;  
        this.ordemMensagem = modelo.ordemMensagem;  
        this.recebimento = modelo.recebimento;  
    }
    
    /**
	Clona a instância.
	@return a instância clonada
	*/
    public Object clone ()
    {
        MensagemMonitor ret=null;

        try
        {
            ret = new MensagemMonitor (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}