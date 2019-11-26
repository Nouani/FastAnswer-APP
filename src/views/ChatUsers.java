package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.core.MeuResultSet;
import bd.daos.Alunos;
import bd.daos.MensagensAlunos;
import bd.daos.MensagensMonitores;
import bd.daos.Monitores;
import bd.dbos.Aluno;
import bd.dbos.MensagemAluno;
import bd.dbos.MensagemMonitor;
import bd.dbos.Monitor;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ChatUsers extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnviar;
	private JList listaUsuarios;
	private JScrollPane scrollUsuarios;
	private JTextArea txtAreaMensagens;
	
	private Aluno aluno;
	private Monitor monitor;
	
	private ArrayList<Aluno> listaAlunos;
	private ArrayList<MensagemMonitor> mensagensMonitor;
	private ArrayList<MensagemAluno> mensagensAluno;
	
	private String[] todasMensagens;
	
	private int indiceSelecionado;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatUsers frame = new ChatUsers(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	Construtor da classe Monitor.
	Seta os atributos da classe.
	@param aluno objeto da classe Aluno 
	@param monitor objeto da classe Monitor
	*/
	public ChatUsers(Aluno aluno, Monitor monitor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollUsuarios = new JScrollPane();
		
		txtEnviar = new JTextField();
		txtEnviar.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		
		JLabel label = new JLabel("Usu\u00E1rios");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblInfo = new JLabel("Clique duas vezes no nome de algu\u00E9m para enviar uma mensagem");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSala = new JLabel("Voc\u00EA n\u00E3o est\u00E1 conectado!");
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		setListAlunos();
		listaUsuarios = new JList(getNomesDaLista());
		scrollUsuarios.setViewportView(listaUsuarios);
		
		txtAreaMensagens = new JTextArea();
		txtAreaMensagens.setEditable(false);
		scrollPane.setViewportView(txtAreaMensagens);
		
		JButton btnAtualizar = new JButton("Atualizar Mensagens");
		btnAtualizar.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSala, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnConectar, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
							.addGap(146)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(56))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtEnviar, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
									.addGap(6)
									.addComponent(btnEnviar, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAtualizar, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(scrollUsuarios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollUsuarios, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
		
		try {
			setMonitor(monitor);
			setAluno(aluno);
		}
		catch (Exception erro) 
		{ } // sei que não vai dar erro
		
		// EVENTOS:
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				String opcao = btnConectar.getText();
				if (opcao == "Desconectar") {
					try {
						monitor.setAtividade("offline");
						Monitores.alterar(monitor);
					}
					catch (Exception erro) 
					{ } // sei que não vai dar erro
				}
			}
		});
		
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String opcao = btnConectar.getText();
				if (opcao.equals("Conectar")) {
					try {
						btnConectar.setText("Desconectar");
						btnEnviar.setEnabled(true);
						
						btnAtualizar.setEnabled(true);
						
						lblSala.setText("Você está conectado!");
						
						monitor.setAtividade("online");
						Monitores.alterar(monitor);
					}
					catch (Exception erro) 
					{ } // sei que não vai dar erro
				} 
				else {
					try {
						btnConectar.setText("Conectar");
						btnEnviar.setEnabled(false);
						
						btnAtualizar.setEnabled(false);
						
						lblSala.setText("Você não está conectado!");
						
						monitor.setAtividade("offline");
						Monitores.alterar(monitor);
					}
					catch (Exception erro) 
					{ } // sei que não vai dar erro
				}
			}
		});
		
		listaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (btnEnviar.isEnabled()) { // se está conectado
						indiceSelecionado = listaUsuarios.locationToIndex(e.getPoint());
						String nome = (String)listaUsuarios.getSelectedValue();
						if (nome != null) {
							Aluno alunoSelecionado = listaAlunos.get(indiceSelecionado);
							carregarMensagens(alunoSelecionado);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Você precisa estar conectado!");
					}
					
		            
					/*listaUsuarios.setSelectedIndex(index);
		            String usuarioAReceber = (String)listaUsuarios.getSelectedValue();
		            System.out.println(index);
		            JOptionPane.showMessageDialog(null, index);*/
				}
			}
		});
		
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				carregarMensagens(getAlunoSelecionado());
			}
		});
		
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aluno alunoSelecionado = getAlunoSelecionado();
				if ((txtEnviar.getText().trim()).equals(""))
					JOptionPane.showMessageDialog(null, "Digite o que deseja mandar para o " + alunoSelecionado.getNome());
				else {
					enviarMensagem(alunoSelecionado, txtEnviar.getText());
					carregarMensagens(alunoSelecionado);
					txtEnviar.setText("");
				}
			}
		});
	}
	
	public void enviarMensagem(Aluno alunoSelecionado, String mensagem) {
		try {
			int ultimaPosicao = this.todasMensagens.length;
			MensagemMonitor msgMonitor = new MensagemMonitor(0, this.monitor.getCodigo(), mensagem, alunoSelecionado.getRA(), ultimaPosicao+1, "N");
			MensagensMonitores.incluir(msgMonitor);
		} catch (Exception e) 
		{ } // sei que não vai dar erro
	}
	
	public void carregarMensagens(Aluno alunoSelecionado) {
		MeuResultSet msgsAluno = null;
		MeuResultSet msgsMonitor = null;
		try {
			msgsAluno = MensagensAlunos.getMensagensPeloRA(alunoSelecionado.getRA(), monitor.getCodigo());
			msgsMonitor = MensagensMonitores.getMensagensPeloCodMonitor(monitor.getCodigo(), alunoSelecionado.getRA());
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
		
		mensagensMonitor = new ArrayList<MensagemMonitor>();
		mensagensAluno = new ArrayList<MensagemAluno>();
		
		try {
			while (msgsAluno.next()) {
				mensagensAluno.add(new MensagemAluno(msgsAluno.getInt("CodMensagemAluno"),
													 msgsAluno.getString("RA"),
													 msgsAluno.getString("MensagemAluno"),
													 msgsAluno.getInt("CodMonitor"),
													 msgsAluno.getInt("OrdemMensagem"),
													 msgsAluno.getString("Recebimento")));
			}
			
			while (msgsMonitor.next()) {
				mensagensMonitor.add(new MensagemMonitor(msgsMonitor.getInt("CodMensagemMonitor"),
													 msgsMonitor.getInt("CodMonitor"),
													 msgsMonitor.getString("MensagemMonitor"),
													 msgsMonitor.getString("RA"),
													 msgsMonitor.getInt("OrdemMensagem"),
													 msgsMonitor.getString("Recebimento")));
			}
		}
		catch(Exception erro) {
			erro.printStackTrace();
		}
		
		todasMensagens = new String[0];
		
		boolean naoRecebidas = false;
		
		int contMsgAluno = 0;
		int contMsgMonitor = 0;
		int contador = 0;
		
		String nomeMonitor = null;
		String nomeAluno = null;
		
		try {
			nomeMonitor = (Alunos.getAluno(monitor.getRA())).getNome();
			nomeAluno = alunoSelecionado.getNome();
		}
		catch (Exception erro) 
		{ } // sei que não vai dar erro
		
		while (contMsgAluno != mensagensAluno.size() && contMsgMonitor != mensagensMonitor.size()) {
			int posicaoEnvioAluno = (mensagensAluno.get(contMsgAluno)).getOrdemMensagem();
			int posicaoEnvioMonitor = (mensagensMonitor.get(contMsgMonitor)).getOrdemMensagem();
			

			if (contador == todasMensagens.length) {
				todasMensagens = redimensionar(1, todasMensagens);
			}
			
			if (posicaoEnvioAluno < posicaoEnvioMonitor) { // aluno é o mais antigo
				mensagensAluno.get(contMsgAluno);
				todasMensagens[contador] = nomeAluno + ": " + mensagensAluno.get(contMsgAluno).getMensagemAluno();
				contador++;
				contMsgAluno++;
			}
			if (posicaoEnvioMonitor < posicaoEnvioAluno) { // monitor é o mais antigo
				todasMensagens[contador] = nomeMonitor + ": " + mensagensMonitor.get(contMsgMonitor).getMensagemMonitor();
				contador++;
				contMsgMonitor++;
			}
			else { // é igual
				
			}
		}
		
		while (contMsgAluno != mensagensAluno.size()) {
			if (contador == todasMensagens.length) {
				todasMensagens = redimensionar(1, todasMensagens);
			}
			
			String recebimento = mensagensAluno.get(contMsgAluno).getRecebimentoAluno();
			if (recebimento.equals("N")) {
				if (!naoRecebidas) {
					marcarRecebidas(mensagensAluno.get(contMsgAluno));
					todasMensagens[contador] = "\nNovas mensagens: ";
					naoRecebidas = true;
					contador++;
				}
				else
					marcarRecebidas(mensagensAluno.get(contMsgAluno));
			}
			
			if (contador == todasMensagens.length) {
				todasMensagens = redimensionar(1, todasMensagens);
			}
			
			todasMensagens[contador] =  nomeAluno + ": " + mensagensAluno.get(contMsgAluno).getMensagemAluno();
			contador++;
			contMsgAluno++;
		}
		while (contMsgMonitor != mensagensMonitor.size()) {
			if (contador == todasMensagens.length) {
				todasMensagens = redimensionar(1, todasMensagens);
			}
			
			todasMensagens[contador] = nomeMonitor + ": " + mensagensMonitor.get(contMsgMonitor).getMensagemMonitor();
			contador++;
			contMsgMonitor++;
		}
		
		txtAreaMensagens.setText("");
		for (int i = 0; i < todasMensagens.length; i++) {
			txtAreaMensagens.append(todasMensagens[i] + "\n");
		}
		
		
		
		    /*LocalDateTime date1 = LocalDateTime.now();
			System.out.println(date1);*/
	}
	
	public void marcarRecebidas(MensagemAluno msgAluno) {
		try {
			msgAluno.setRecebimentoAluno("S");
			MensagensAlunos.alterar(msgAluno);
		} 
		catch (Exception e) 
		{ } // sei que não vai dar erro
	}
	
	/*public LocalDateTime formatarData(String data) {
		String dataFormatada = "";
		dataFormatada += data.substring(0, 10);
		dataFormatada += "T";
		dataFormatada += data.substring(11);
		
		LocalDateTime dataConvertida = LocalDateTime.parse(dataFormatada);
		return dataConvertida;
	}*/
	
	public void setListAlunos(){
		try {
			this.listaAlunos = new ArrayList<Aluno>();
			MeuResultSet resultado = Alunos.getAlunosAtividade("online");
			
			while (resultado.next()) {
				this.listaAlunos.add(new Aluno (resultado.getString("RA"),
                        		resultado.getString("NOME"),
                        		resultado.getString("SENHA"),
                        		resultado.getString("ATIVIDADE")));
			}
		}
		catch(Exception erro) 
		{ } // sei que não vai dar erro
	}
	
	public String[] getNomesDaLista() {
		String[] nomes = new String[1];
		int cont = 0;
		for (Aluno aluno : this.listaAlunos) {
			if (cont == nomes.length) {
				nomes = redimensionar(1, nomes);
			}
			nomes[cont] = aluno.getNome();
			cont++;
		}
		return nomes;
	}
	
	public Aluno getAlunoSelecionado() {
		Aluno alunoSelecionado = listaAlunos.get(indiceSelecionado);
		return alunoSelecionado;
	}
	
	public void setMonitor(Monitor monitor) throws Exception {
		if (monitor == null)
			throw new Exception("Monitor inválido");
		this.monitor = monitor;
	}
	
	public void setAluno(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("Aluno inválido");
		this.aluno = aluno;
	}
	
	public String[] redimensionar(int val, String[] vetAtual) {
		String[] vetNovo = new String[vetAtual.length + val];
		for (int i = 0; i < vetAtual.length; i++) {
			vetNovo[i] = vetAtual[i];
		}
		vetAtual = vetNovo;
		return vetAtual;
	}
}
