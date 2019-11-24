package bd.dbos;

public class Livro implements Cloneable
{
    private int    codigo;
    private String nome;
    private float  preco;
 
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo invalido");

        this.codigo = codigo;
    }   

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public void setPreco (float preco) throws Exception
    {
        if (preco <= 0)
            throw new Exception ("Preco invalido");

        this.preco = preco;
    }

    public int getCodigo ()
    {
        return this.codigo;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public float getPreco ()
    {
        return this.preco;
    }

    public Livro (int codigo, String nome, float preco) throws Exception
    {
        this.setCodigo (codigo);
        this.setNome   (nome);
        this.setPreco  (preco);
    }

    public String toString ()
    {
        String ret="";

        ret+="Codigo: "+this.codigo+"\n";
        ret+="Nome..: "+this.nome  +"\n";
        ret+="Preco.: "+this.preco;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Livro))
            return false;

        Livro liv = (Livro)obj;

        if (this.codigo!=liv.codigo)
            return false;

        if (this.nome.equals(liv.nome))
            return false;

        if (this.preco!=liv.preco)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codigo).hashCode();
        ret = 7*ret + this.nome.hashCode();
        ret = 7*ret + new Float(this.preco).hashCode();

        return ret;
    }


    public Livro (Livro modelo) throws Exception
    {
        this.codigo = modelo.codigo; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
        this.preco  = modelo.preco;  // nao clono, pq nao eh objeto
    }

    public Object clone ()
    {
        Livro ret=null;

        try
        {
            ret = new Livro (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}