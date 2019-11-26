package bd.dbos;

/**
A classe Aluno representa um aluno de uma tabela Alunos.
Tem como métodos get's e set's de valores.
@author Nouani Gabriel Sanches & Pedro Go Ikeda
*/
public class Aluno implements Cloneable
{
    private String RA;
    private String nome;
    private String senha;
    private String atividade;
    
    /**
	Seta o RA do aluno.
	@param RA RA desejado para inclusão
	@throws Exception caso RA seja nulo ou vazio
	*/
    public void setRA(String RA) throws Exception
    {
        if (RA == null || RA.trim().equals("")) 
            throw new Exception ("RA invalido");

        this.RA = RA;
    }   
    
    /**
	Seta o nome do aluno.
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
	Seta a senha do aluno.
	@param senha senha desejada para inclusão
	@throws Exception caso senha seja nula ou vazia
	*/
    public void setSenha (String senha) throws Exception
    {
        if (senha == null || senha.trim().equals(""))
            throw new Exception ("Senha invalida");

        this.senha = senha;
    }
    
    /**
	Seta a atividade do aluno.
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
	Pega o RA do aluno
	@return RA do aluno
	*/
    public String getRA ()
    {
        return this.RA;
    }
    
    /**
	Pega o nome do aluno
	@return nome do aluno
	*/
    public String getNome ()
    {
        return this.nome;
    }
    
    /**
	Pega a senha do aluno
	@return senha do aluno
	*/
    public String getSenha ()
    {
        return this.senha;
    }
    
    /**
	Pega a senha do aluno
	@return senha do aluno
	*/
    public String getAtividade ()
    {
        return this.atividade;
    }
    
    /**
	Construtor da classe Aluno.
	Seta os atributos da classe.
	@param RA RA do aluno
	@param nome nome do aluno
	@param senha senha do aluno
	@param atividade atividade online ou offline
	@throws Exception caso o parâmetro seja nulo ou vazio
	*/
    public Aluno (String RA, String nome, String senha, String atividade) throws Exception
    {
        this.setRA (RA);
        this.setNome(nome);
        this.setSenha(senha);
        this.setAtividade(atividade);
    }
    
    /**
	Transforma e retorna a instância em formato de String
	@return string com os valores da instância
	*/
    public String toString ()
    {
        String ret="";

        ret+="RA: "+this.RA+"\n";
        ret+="Nome..: "+this.nome  +"\n";
        ret+="Senha.: "+this.senha + "\n";
        ret+="Atividade.: "+this.atividade;

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

        if (!(obj instanceof Aluno))
            return false;

        Aluno alu = (Aluno)obj;

        if (this.RA!=alu.RA)
            return false;

        if (this.nome.equals(alu.nome))
            return false;

        if (this.senha.equals(alu.senha))
            return false;
        
        if (this.atividade.equals(alu.atividade))
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

        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.nome.hashCode();
        ret = 7*ret + this.senha.hashCode();
        ret = 7*ret + this.atividade.hashCode();

        return ret;
    }

    /**
	Construtor de cópia da classe.
	Seta os atributos da instância com os do passado como parâmetro
	@param instância a ser copiada
	*/
    public Aluno (Aluno modelo) throws Exception
    {
        this.RA = modelo.RA; 
        this.nome   = modelo.nome;   
        this.senha  = modelo.senha; 
        this.atividade  = modelo.atividade; 
    }
    
    /**
	Clona a instância.
	@return a instância clonada
	*/
    public Object clone ()
    {
        Aluno ret=null;

        try
        {
            ret = new Aluno (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}