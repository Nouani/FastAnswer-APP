package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.core.MeuResultSet;
import bd.daos.Alunos;
import bd.daos.Monitores;
import bd.dbos.Aluno;
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
import java.util.ArrayList;
import java.util.Calendar;

public class ChatUsers extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnviar;
	private JList listaUsuarios;
	private JScrollPane scrollUsuarios;
	
	private Aluno aluno;
	private Monitor monitor;
	
	private boolean conectado;
	private ArrayList<Aluno> listaAlunos;

	/**
	 * Launch the application.
	 */
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
	 * Create the frame.
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
		
		JLabel lblSala = new JLabel("Voc\u00EA n\u00E3o est\u00E1 conectado a nenhuma sala!");
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		setListAlunos();
		listaUsuarios = new JList(getNomesDaLista());
		scrollUsuarios.setViewportView(listaUsuarios);
		
		JTextArea txtAreaMensagens = new JTextArea();
		txtAreaMensagens.setEditable(false);
		scrollPane.setViewportView(txtAreaMensagens);
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
							.addComponent(scrollUsuarios, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollUsuarios, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
					.addGap(11))
		);
		contentPane.setLayout(gl_contentPane);
		
		try {
			setMonitor(monitor);
			setAluno(aluno);
		}
		catch (Exception erro) 
		{ } // sei que n�o vai dar erro
		
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
					{ } // sei que n�o vai dar erro
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
						
						monitor.setAtividade("online");
						Monitores.alterar(monitor);
						
						conectado = true;
					}
					catch (Exception erro) 
					{ } // sei que n�o vai dar erro
				} 
				else {
					try {
						btnConectar.setText("Conectar");
						btnEnviar.setEnabled(false);
						
						monitor.setAtividade("offline");
						Monitores.alterar(monitor);
						
						conectado = false;
					}
					catch (Exception erro) 
					{ } // sei que n�o vai dar erro
				}
			}
		});
		
		listaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (btnEnviar.isEnabled()) { // se est� conectado
						int index = listaUsuarios.locationToIndex(e.getPoint());
						String nome = (String)listaUsuarios.getSelectedValue();
						if (nome != null) {
							Aluno alunoSelecionado = listaAlunos.get(index);
							carregarMensagens(null);
						}
					}
					
		            
					/*listaUsuarios.setSelectedIndex(index);
		            String usuarioAReceber = (String)listaUsuarios.getSelectedValue();
		            System.out.println(index);
		            JOptionPane.showMessageDialog(null, index);*/
				}
			}
		});
	}
	public void carregarMensagens(Aluno alunoSelecionado) {
		    LocalDateTime date1 = LocalDateTime.now();
			System.out.println(date1);
	}
	
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
		{ } // sei que n�o vai dar erro
	}
	
	public String[] getNomesDaLista() {
		String[] nomes = new String[10];
		int cont = 0;
		for (Aluno aluno : this.listaAlunos) {
			nomes[cont] = aluno.getNome();
			cont++;
		}
		return nomes;
	}
	
	public void setMonitor(Monitor monitor) throws Exception {
		if (monitor == null)
			throw new Exception("Monitor inv�lido");
		this.monitor = monitor;
	}
	
	public void setAluno(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("Aluno inv�lido");
		this.aluno = aluno;
	}
}
