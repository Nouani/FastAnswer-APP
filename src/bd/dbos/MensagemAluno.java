package bd.dbos;

/**
A classe MensagemAluno representa uma mensagem de um Aluno.
Tem como métodos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class MensagemAluno implements Cloneable
{
    private int codMensagemAluno;
    private String RA;
    private String mensagemAluno;
    private int codMonitor;
    private int ordemMensagem;
    private String recebimento;
    
    /**
	Seta o código da mensagem.
	@param codMensagemAluno codigo desejado para inclusão
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodMensagemAluno(int codMensagemAluno) throws Exception
    {
        if (codMensagemAluno < 0)
            throw new Exception ("Código inválido");

        this.codMensagemAluno = codMensagemAluno;
    }
    
    /**
	Seta o RA do aluno.
	@param RA RA desejado para inclusão
	@throws Exception caso RA seja nulo ou vazio
	*/
    public void setRAEnvio (String RA) throws Exception
    {
    	RA.trim();
    	if (RA==null || RA.trim().equals(""))
            throw new Exception ("Código do monitor é  invalido");

        this.RA = RA;
    }
    
    /**
	Seta a mensagem.
	@param mensagemAluno mensagem desejada para inclusão
	@throws Exception caso mensagem seja nula ou vazia
	*/
    public void setMensagemAluno (String mensagemAluno) throws Exception
    {
        if (mensagemAluno==null || mensagemAluno.trim().equals(""))
            throw new Exception ("Mensagem não fornecida");

        this.mensagemAluno = mensagemAluno;
    }
    
    /**
	Seta código do monitor.
	@param codMonitor código desejada para inclusão
	@throws Exception caso código seja menor que zero
	*/
    public void setCodMonitor (int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Código do monitor é  invalido");

        this.codMonitor = codMonitor;
    }
    
    /**
	Seta ordem da mensagem.
	@param ordemMensagem ordem desejada para inclusão
	@throws Exception caso ordem seja menor que zero
	*/
    public void setOrdemMensagem (int ordemMensagem) throws Exception
    {
        if (ordemMensagem<0)
            throw new Exception ("ordem inválida");

        this.ordemMensagem = ordemMensagem;
    }
    
    /**
	Seta recebimento da mensagem.
	@param recebimento recebimento desejado para inclusão
	@throws Exception caso recebimento seja nulo ou vazio
	*/
    public void setRecebimentoAluno (String recebimento) throws Exception
    {
        if (recebimento==null || recebimento.trim().equals(""))
            throw new Exception ("Recebimento não fornecido");

        this.recebimento = recebimento;
    }
    
    /**
	Pega o código da mensagem
	@return codigo da mensagem
	*/
    public int getCodMensagemAluno ()
    {
        return this.codMensagemAluno;
    }
    
    /**
	Pega o RA do aluno
	@return RA do aluno
	*/
    public String getRAEnvio ()
    {
        return this.RA;
    }
    
    /**
	Pega a mensagem do aluno
	@return mensagem do aluno
	*/
    public String getMensagemAluno ()
    {
        return this.mensagemAluno;
    }
    
    /**
	Pega o código do monitor
	@return código do monitor
	*/
    public int getCodMonitor ()
    {
        return this.codMonitor;
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
    public String getRecebimentoAluno ()
    {
        return this.recebimento;
    }
    
    /**
	Construtor da classe MensagemAluno.
	Seta os atributos da classe.
	@param codMensagemAluno código da mensagem
	@param RA RA do aluno
	@param mensagemAluno mensagem enviada
	@param codMonitor código do monitor
	@param ordemMensagem ordem da mensagem
	@param recebimento foi recebido ou não
	@throws Exception caso o parâmetro seja nulo, vazio ou menor que zero
	*/
    public MensagemAluno (int codMensagemAluno, String RA, String mensagemAluno, int codMonitor, int ordemMensagem, String recebimento) throws Exception
    {
        this.setCodMensagemAluno (codMensagemAluno);
        this.setRAEnvio (RA);
        this.setMensagemAluno(mensagemAluno);
        this.setCodMonitor(codMonitor);
        this.setOrdemMensagem(ordemMensagem);
        this.setRecebimentoAluno(recebimento);
    }

    /**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
    public String toString ()
    {
        String ret="";

        ret+="Código da Mensagem do Aluno: "+this.codMensagemAluno+"\n";
        ret+="RA do Aluno que enviou: "+this.RA+"\n";
        ret+="Mensagem do Aluno..: "+this.mensagemAluno  +"\n";
        ret+="Código do Monitor a receber.: "+this.codMonitor+"\n";
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

        if (!(obj instanceof MensagemAluno))
            return false;

        MensagemAluno alu = (MensagemAluno)obj;

        if (this.codMensagemAluno!=alu.codMensagemAluno)
            return false;
        
        if (!this.RA.equals(alu.RA))
            return false;

        if (!this.mensagemAluno.equals(alu.mensagemAluno))
            return false;

        if (this.codMonitor!=alu.codMonitor)
            return false;
        
        if (this.ordemMensagem!=alu.ordemMensagem)
            return false;
        
        if (!this.recebimento.equals(alu.recebimento))
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

        ret = 7*ret + new Integer (this.codMensagemAluno).hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.mensagemAluno.hashCode();
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + new Integer (this.ordemMensagem).hashCode();
        ret = 7*ret + this.recebimento.hashCode();

        return ret;
    }

    /**
	Construtor de cópia da classe.
	Seta os atributos da instância com os do passado como parâmetro
	@param modelo instância a ser copiada
	*/
    public MensagemAluno (MensagemAluno modelo)
    {
        this.codMensagemAluno = modelo.codMensagemAluno; 
        this.RA = modelo.RA; 
        this.mensagemAluno   = modelo.mensagemAluno;   
        this.codMonitor  = modelo.codMonitor;  
        this.ordemMensagem  = modelo.ordemMensagem;  
        this.recebimento  = modelo.recebimento;  
    }
    
    /**
	Clona a instância.
	@return a instância clonada
	*/
    public Object clone ()
    {
        MensagemAluno ret=null;

        try
        {
            ret = new MensagemAluno (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}