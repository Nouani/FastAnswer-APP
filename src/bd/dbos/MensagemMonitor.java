package bd.dbos;

public class MensagemMonitor implements Cloneable
{
    private int codMensagemMonitor;
    private int codMonitor;
    private String mensagemMonitor;
    private String RA;
    private String envioMonitor;
    private String recebimento;
 
    public void setCodMensagemMonitor(int codMensagemMonitor) throws Exception
    {
        if (codMensagemMonitor < 0)
            throw new Exception ("Código inválido");

        this.codMensagemMonitor = codMensagemMonitor;
    } 
    
    public void setCodMonitorEnviou(int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Código do monitor inválido");

        this.codMonitor = codMonitor;
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
    
    public void setEnvioMonitor (String envioMonitor) throws Exception
    {
        if (envioMonitor==null || envioMonitor.equals(""))
            throw new Exception ("data não fornecida");

        this.envioMonitor = envioMonitor;
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
    
    public int getCodMonitorEnviou ()
    {
        return this.codMonitor;
    }

    public String getMensagemMonitor ()
    {
        return this.mensagemMonitor;
    }

    public String getRA ()
    {
        return this.RA;
    }
    
    public String getEnvioMonitor ()
    {
        return this.envioMonitor;
    }
    
    public String getRecebimentoMonitor ()
    {
        return this.recebimento;
    }

    public MensagemMonitor (int codMensagemMonitor, int codMonitor, String mensagemMonitor, String RA, String envioMonitor, String recebimento) throws Exception
    {
        this.setCodMensagemMonitor (codMensagemMonitor);
        this.setCodMonitorEnviou (codMonitor);
        this.setMensagemMonitor(mensagemMonitor);
        this.setRA(RA);
        this.setEnvioMonitor(envioMonitor);
        this.setRecebimentoMonitor(recebimento);
    }

    public String toString ()
    {
        String ret="";

        ret+="Código da Mensagem do Monitor: "+this.codMensagemMonitor+"\n";
        ret+="Código do Monitor que enviou: "+this.codMensagemMonitor+"\n";
        ret+="Mensagem do Monitor..: "+this.mensagemMonitor  +"\n";
        ret+="RA do aluno a receber.: "+this.RA+"\n";
        ret+="Data e Horário do envio.: "+this.envioMonitor+"\n";
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
        
        if (this.codMonitor!=monit.codMonitor)
            return false;

        if (!this.mensagemMonitor.equals(monit.mensagemMonitor))
            return false;

        if (!this.RA.equals(monit.RA))
            return false;
        
        if (!this.envioMonitor.equals(monit.envioMonitor))
            return false;
        
        if (!this.recebimento.equals(monit.recebimento))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer (this.codMensagemMonitor).hashCode();
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + this.mensagemMonitor.hashCode();
        ret = 7*ret + this.RA.hashCode();
        ret = 7*ret + this.envioMonitor.hashCode();
        ret = 7*ret + this.recebimento.hashCode();
        
        if (ret < 0)
        	ret = -ret;

        return ret;
    }


    public MensagemMonitor (MensagemMonitor modelo) throws Exception
    {
        this.codMensagemMonitor = modelo.codMensagemMonitor; 
        this.codMonitor = modelo.codMonitor; 
        this.mensagemMonitor   = modelo.mensagemMonitor;   
        this.RA  = modelo.RA;  
        this.envioMonitor = modelo.envioMonitor;  
        this.recebimento = modelo.recebimento;  
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