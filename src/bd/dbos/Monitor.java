package bd.dbos;

public class Monitor implements Cloneable
{
    private int CodMonitor;
    private String RA;
    private String atividade;
    
    public void setCodigo(int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo nao fornecido");

        this.CodMonitor = codigo;
    }

    public void setRA (String RA) throws Exception
    {
    	RA.trim();
        if (RA==null || RA.equals(""))
            throw new Exception ("RA nao fornecido");

        this.RA = RA;
    }
    
    public void setAtividade (String atividade) throws Exception
    {
    	atividade.trim();
        if (atividade==null || atividade.equals(""))
            throw new Exception ("Atividade nao fornecida");

        this.atividade = atividade;
    }
    
    public int getCodigo()
    {
        return this.CodMonitor;
    }

    public String getRA ()
    {
        return this.RA;
    }
    
    public String getAtividade ()
    {
        return this.atividade;
    }

    public Monitor (int CodMonitor, String RA, String atividade) throws Exception
    {
        this.setCodigo(CodMonitor);
        this.setRA(RA);
        this.setAtividade(atividade);
    }

    public String toString ()
    {
        String ret="";
        
        ret+="Codigo..: "+this.CodMonitor  +"\n";
        ret+="RA..: "+this.RA  +"\n";
        ret+="Atividade..: "+this.atividade  +"\n";

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Monitor))
            return false;

        Monitor monit = (Monitor)obj;

        if (this.CodMonitor != monit.CodMonitor)
            return false;
        
        if (this.RA.equals(monit.RA))
            return false;
        
        if (this.atividade.equals(monit.atividade))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;
        
        ret = 7*ret + new Integer (this.CodMonitor).hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.atividade.hashCode();

        return ret;
    }


    public Monitor (Monitor modelo) throws Exception
    {
        this.CodMonitor   = modelo.CodMonitor;   // nao clono, pq nao eh clonavel
        this.RA   = modelo.RA;   // nao clono, pq nao eh clonavel
        this.atividade = modelo.atividade;
    }

    public Object clone ()
    {
        Monitor ret=null;

        try
        {
            ret = new Monitor (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca � null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}