package bd.dbos;

public class Lista implements Cloneable
{
    private int    codLista;
    private int    codMateria;
    private String arquivo;
 
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo da lista é invalidp");

        this.codLista = codigo;
    }
    
    public void setCodMateria (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo da matéria é invalido");

        this.codMateria = codigo;
    }   

    public void setArquivo (String arquivo) throws Exception
    {
        if (arquivo==null || arquivo.equals(""))
            throw new Exception ("Diretório nao fornecido");

        this.arquivo = arquivo;
    }

    public int getCodigo ()
    {
        return this.codLista;
    }
    
    public int getCodMateria ()
    {
        return this.codMateria;
    }

    public String getArquivo ()
    {
        return this.arquivo;
    }

    public Lista (int codLista, int codMateria, String arquivo) throws Exception
    {
        this.setCodigo (codLista);
        this.setCodMateria (codMateria);
        this.setArquivo (arquivo);
    }

    public String toString ()
    {
        String ret="";

        ret+="Codigo da Lista: "+this.codLista+"\n";
        ret+="Codigo da Matéria..: "+this.codMateria  +"\n";
        ret+="Arquivo..: "+this.arquivo  +"\n";

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Lista))
            return false;

        Lista list = (Lista)obj;

        if (this.codLista!=list.codLista)
            return false;

        if (this.codMateria!=list.codMateria)
            return false;

        if (this.arquivo!=list.arquivo)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codLista).hashCode();
        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + this.arquivo.hashCode();

        return ret;
    }


    public Lista (Lista modelo) throws Exception
    {
        this.codLista = modelo.codLista; // nao clono, pq nao eh objeto
        this.codMateria = modelo.codMateria;   // nao clono, pq nao eh clonavel
        this.arquivo = modelo.arquivo;  // nao clono, pq nao eh objeto
    }

    public Object clone ()
    {
        Lista ret=null;

        try
        {
            ret = new Lista (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}