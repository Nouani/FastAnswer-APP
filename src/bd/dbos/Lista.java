package bd.dbos;

public class Lista implements Cloneable
{
    private int    codLista;
    private int    codMateria;
    private String arquivo;
    private String nomeLista;
 
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo < 0)
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
    
    public void setNomeLista (String nomeLista) throws Exception
    {
        if (nomeLista==null || nomeLista.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nomeLista = nomeLista;
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
    
    public String getNomeLista ()
    {
        return this.nomeLista;
    }

    public Lista (int codLista, int codMateria, String arquivo, String nomeLista) throws Exception
    {
    	System.out.println("dasdas");
        this.setCodigo (codLista);
        System.out.println("dasdas");
        this.setCodMateria (codMateria);
        System.out.println("dasdas");
        this.setArquivo (arquivo);
        System.out.println("dasdas");
        this.setNomeLista(nomeLista);
        System.out.println("dasdas");
    }

    public String toString ()
    {
        String ret="";

        ret+="Codigo da Lista: "+this.codLista+"\n";
        ret+="Codigo da Matéria..: "+this.codMateria  +"\n";
        ret+="Arquivo..: "+this.arquivo  +"\n";
        ret+="Nome da Lista..: "+this.nomeLista;

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

        if (this.arquivo.equals(list.arquivo))
            return false;
        
        if (this.nomeLista.equals(list.nomeLista))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codLista).hashCode();
        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + this.arquivo.hashCode();
        ret = 7*ret + this.nomeLista.hashCode();

        return ret;
    }


    public Lista (Lista modelo) throws Exception
    {
        this.codLista = modelo.codLista;
        this.codMateria = modelo.codMateria;   
        this.arquivo = modelo.arquivo;  
        this.nomeLista = modelo.arquivo;  
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