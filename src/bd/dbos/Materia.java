package bd.dbos;

/**
A classe Materia representa uma matéria de uma tabela de Matérias.
Tem como métodos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Materia implements Cloneable
{
    private int    codMateria;
    private int    codMonitor;
    private String nome;
    
    /**
	Seta o código da materia.
	@param codMateria codigo desejado para inclusão
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodigo (int codMateria) throws Exception
    {
        if (codMateria < 0)
            throw new Exception ("Codigo da matéria é inválido");

        this.codMateria = codMateria;
    }
    
    /**
	Seta o código do monitor.
	@param codMonitor codigo desejado para inclusão
	@throws Exception caso codigo seja menor que zero
	*/
    public void setCodMonitor(int codMonitor) throws Exception
    {
    	if (codMonitor < 0)
    		throw new Exception("Codigo do monitor é inválido");
    	
    	this.codMonitor = codMonitor;
    }
    
    /**
	Seta o nome da matéria.
	@param nome nome desejado para inclusão
	@throws Exception caso nome seja nulo ou vazio
	*/
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.trim().equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }
    
    /**
	Pega o código da matéria
	@return codigo da matéria
	*/
    public int getCodigo ()
    {
        return this.codMateria;
    }
    
    /**
	Pega o código do monitor
	@return codigo do monitor
	*/
    public int getCodMonitor ()
    {
        return this.codMonitor;
    }
    
    /**
	Pega o nome da matéri
	@return nome da matéria
	*/
    public String getNome ()
    {
        return this.nome;
    }
    
    /**
	Construtor da classe Materia.
	Seta os atributos da classe.
	@param codMateria código da matéria
	@param codMonitor código do monitor
	@param nome nome da matéria
	@throws Exception caso o parâmetro seja nulo, vazio ou menor que zero
	*/
    public Materia (int codMateria, int codMonitor,  String nome) throws Exception
    {
        this.setCodigo (codMateria);
        this.setCodMonitor(codMonitor);
        this.setNome   (nome);
    }
    
    /**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
    public String toString ()
    {
        String ret="";

        ret+="Codigo Matéria: "+this.codMateria+"\n";
        ret+="Codigo Monitor: "+this.codMonitor+"\n";
        ret+="Nome..: "+this.nome  +"\n";

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

        if (!(obj instanceof Materia))
            return false;

        Materia mat = (Materia)obj;

        if (this.codMateria!=mat.codMateria)
            return false;
        
        if (this.codMonitor!=mat.codMonitor)
            return false;

        if (this.nome.equals(mat.nome))
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

        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + new Integer(this.codMonitor).hashCode();
        ret = 7*ret + this.nome.hashCode();

        return ret;
    }

    /**
	Construtor de cópia da classe.
	Seta os atributos da instância com os do passado como parâmetro
	@param modelo instância a ser copiada
	*/
    public Materia (Materia modelo)
    {
        this.codMonitor = modelo.codMonitor; // nao clono, pq nao eh objeto
        this.codMateria = modelo.codMateria; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
    }
    
    /**
	Clona a instância.
	@return a instância clonada
	*/
    public Object clone ()
    {
        Materia ret=null;

        try
        {
            ret = new Materia (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}