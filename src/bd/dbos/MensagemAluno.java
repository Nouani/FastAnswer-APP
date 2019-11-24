package bd.dbos;

public class MensagemAluno implements Cloneable
{
    private int codMensagemAluno;
    private String mensagemAluno;
    private int codMonitor;
    private String recebimento;
 
    public void setCodMensagemAluno(int codMensagemAluno) throws Exception
    {
        if (codMensagemAluno < 0)
            throw new Exception ("Código inválido");

        this.codMensagemAluno = codMensagemAluno;
    }   

    public void setMensagemAluno (String mensagemAluno) throws Exception
    {
        if (mensagemAluno==null || mensagemAluno.equals(""))
            throw new Exception ("Mensagem não fornecida");

        this.mensagemAluno = mensagemAluno;
    }

    public void setCodMonitor (int codMonitor) throws Exception
    {
        if (codMonitor < 0)
            throw new Exception ("Código do monitor é  invalido");

        this.codMonitor = codMonitor;
    }
    
    public void setRecebimentoAluno (String recebimento) throws Exception
    {
        if (recebimento==null || recebimento.equals(""))
            throw new Exception ("Recebimento não fornecido");

        this.recebimento = recebimento;
    }


    public int getCodMensagemAluno ()
    {
        return this.codMensagemAluno;
    }

    public String getMensagemAluno ()
    {
        return this.mensagemAluno;
    }

    public int getCodMonitor ()
    {
        return this.codMonitor;
    }
    
    public String getRecebimentoAluno ()
    {
        return this.recebimento;
    }

    public MensagemAluno (int codMensagemAluno, String mensagemAluno, int codMonitor, String recebimento) throws Exception
    {
        this.setCodMensagemAluno (codMensagemAluno);
        this.setMensagemAluno(mensagemAluno);
        this.setCodMonitor(codMonitor);
        this.setRecebimentoAluno(recebimento);
    }

    public String toString ()
    {
        String ret="";

        ret+="Código da Mensagem do Aluno: "+this.codMensagemAluno+"\n";
        ret+="Mensagem do Aluno..: "+this.mensagemAluno  +"\n";
        ret+="Código do Monitor a receber.: "+this.codMonitor+"\n";
        ret+="Mensagem foi recebida?: "+this.recebimento;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof MensagemAluno))
            return false;

        MensagemAluno alu = (MensagemAluno)obj;

        if (this.codMensagemAluno!=alu.codMensagemAluno)
            return false;

        if (!this.mensagemAluno.equals(alu.mensagemAluno))
            return false;

        if (this.codMonitor!=alu.codMonitor)
            return false;
        
        if (!this.recebimento.equals(alu.recebimento))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer (this.codMensagemAluno).hashCode();
        ret = 7*ret + this.mensagemAluno.hashCode();
        ret = 7*ret + new Integer (this.codMonitor).hashCode();
        ret = 7*ret + this.recebimento.hashCode();

        return ret;
    }


    public MensagemAluno (MensagemAluno modelo) throws Exception
    {
        this.codMensagemAluno = modelo.codMensagemAluno; 
        this.mensagemAluno   = modelo.mensagemAluno;   
        this.codMonitor  = modelo.codMonitor;  
        this.recebimento  = modelo.recebimento;  
    }

    public Object clone ()
    {
        MensagemAluno ret=null;

        try
        {
            ret = new MensagemAluno (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca é null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}