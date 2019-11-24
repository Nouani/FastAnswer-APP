package bd.dbos;

public class MensagemMonitor implements Cloneable
{
    private int codMensagemMonitor;
    private String mensagemMonitor;
    private String RA;
    private String recebimento;
 
    public void setCodMensagemMonitor(int codMensagemMonitor) throws Exception
    {
        if (codMensagemMonitor < 0)
            throw new Exception ("Código inválido");

        this.codMensagemMonitor = codMensagemMonitor;
    }   

    public void setMensagemMonitor (String mensagemMonitor) throws Exception
    {
        if (mensagemMonitor==null || mensagemMonitor.equals(""))
            throw new Exception ("Mensagem não fornecida");

        this.mensagemMonitor = mensagemMonitor;
    }

    public void setRA (String RA) throws Exception
    {
    	RA.trim();
    	if (RA==null || RA.equals(""))
            throw new Exception ("Código do monitor é  invalido");

        this.RA = RA;
    }
    
    public void setRecebimentoMonitor (String recebimento) throws Exception
    {
        if (recebimento==null || recebimento.equals(""))
            throw new Exception ("Recebimento não fornecido");

        this.recebimento = recebimento;
    }


    public int getCodMensagemMonitor ()
    {
        return this.codMensagemMonitor;
    }

    public String getMensagemMonitor ()
    {
        return this.mensagemMonitor;
    }

    public String getRA ()
    {
        return this.RA;
    }
    
    public String getRecebimentoMonitor ()
    {
        return this.recebimento;
    }

    public MensagemMonitor (int codMensagemMonitor, String mensagemMonitor, String RA, String recebimento) throws Exception
    {
        this.setCodMensagemMonitor (codMensagemMonitor);
        this.setMensagemMonitor(mensagemMonitor);
        this.setRA(RA);
        this.setRecebimentoMonitor(recebimento);
    }

    public String toString ()
    {
        String ret="";

        ret+="Código da Mensagem do Monitor: "+this.codMensagemMonitor+"\n";
        ret+="Mensagem do Monitor..: "+this.mensagemMonitor  +"\n";
        ret+="Código do Monitor a receber.: "+this.RA+"\n";
        ret+="Mensagem foi recebida?: "+this.recebimento;

        return ret;
    }

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

        if (!this.mensagemMonitor.equals(monit.mensagemMonitor))
            return false;

        if (!this.RA.equals(monit.RA))
            return false;
        
        if (!this.recebimento.equals(monit.recebimento))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer (this.codMensagemMonitor).hashCode();
        ret = 7*ret + this.mensagemMonitor.hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.recebimento.hashCode();

        return ret;
    }


    public MensagemMonitor (MensagemMonitor modelo) throws Exception
    {
        this.codMensagemMonitor = modelo.codMensagemMonitor; 
        this.mensagemMonitor   = modelo.mensagemMonitor;   
        this.RA  = modelo.RA;  
        this.recebimento  = modelo.recebimento;  
    }

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