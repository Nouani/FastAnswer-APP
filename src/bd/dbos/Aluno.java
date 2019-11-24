package bd.dbos;

public class Aluno implements Cloneable
{
    private String RA;
    private String nome;
    private String senha;
    private String atividade;
 
    public void setRA(String RA) throws Exception
    {
        if (RA == null)
            throw new Exception ("RA invalido");

        this.RA = RA;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public void setSenha (String senha) throws Exception
    {
        if (senha == null)
            throw new Exception ("Senha invalida");

        this.senha = senha;
    }
    
    public void setAtividade (String atividade) throws Exception
    {
    	atividade.trim();
        if (atividade==null || atividade.equals(""))
            throw new Exception ("Atividade nao fornecida");

        this.atividade = atividade;
    }

    public String getRA ()
    {
        return this.RA;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public String getSenha ()
    {
        return this.senha;
    }
    
    public String getAtividade ()
    {
        return this.atividade;
    }

    public Aluno (String RA, String nome, String senha, String atividade) throws Exception
    {
        this.setRA (RA);
        this.setNome(nome);
        this.setSenha(senha);
        this.setAtividade(atividade);
    }

    public String toString ()
    {
        String ret="";

        ret+="RA: "+this.RA+"\n";
        ret+="Nome..: "+this.nome  +"\n";
        ret+="Senha.: "+this.senha + "\n";
        ret+="Atividade.: "+this.atividade;

        return ret;
    }

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

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.nome.hashCode();
        ret = 7*ret + this.senha.hashCode();
        ret = 7*ret + this.atividade.hashCode();

        return ret;
    }


    public Aluno (Aluno modelo) throws Exception
    {
        this.RA = modelo.RA; 
        this.nome   = modelo.nome;   
        this.senha  = modelo.senha; 
        this.atividade  = modelo.atividade; 
    }

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