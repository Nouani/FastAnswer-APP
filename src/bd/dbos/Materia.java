package bd.dbos;

public class Materia implements Cloneable
{
    private int    codMateria;
    private int    codMonitor;
    private String nome;
 
    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo da matéria é inválido");

        this.codMateria = codigo;
    }
    
    public void setCodMonitor(int codigo) throws Exception
    {
    	if (codigo <= 0)
    		throw new Exception("Codigo do monitor é inválido");
    	
    	this.codMonitor = codigo;
    }

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public int getCodigo ()
    {
        return this.codMateria;
    }
    
    public int getCodMonitor ()
    {
        return this.codMonitor;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public Materia (int codMateria, int codMonitor,  String nome) throws Exception
    {
        this.setCodigo (codMateria);
        this.setCodMonitor(codMonitor);
        this.setNome   (nome);
    }

    public String toString ()
    {
        String ret="";

        ret+="Codigo Matéria: "+this.codMateria+"\n";
        ret+="Codigo Monitor: "+this.codMonitor+"\n";
        ret+="Nome..: "+this.nome  +"\n";

        return ret;
    }

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

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codMateria).hashCode();
        ret = 7*ret + new Integer(this.codMonitor).hashCode();
        ret = 7*ret + this.nome.hashCode();

        return ret;
    }


    public Materia (Materia modelo) throws Exception
    {
        this.codMonitor = modelo.codMonitor; // nao clono, pq nao eh objeto
        this.codMateria = modelo.codMateria; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
    }

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