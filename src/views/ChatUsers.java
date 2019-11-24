package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.ListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatUsers extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnviar;
	
	private Aluno aluno;
	private Monitor monitor;

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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		txtEnviar = new JTextField();
		txtEnviar.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		
		JLabel label = new JLabel("Usu\u00E1rios");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCliqueDuasVezes = new JLabel("Clique duas vezes no nome de algu\u00E9m para enviar uma mensagem particular");
		lblCliqueDuasVezes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("Voc\u00EA n\u00E3o est\u00E1 conectado a nenhuma sala!");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		String[] elementos={"a","s","s","d","g"};
		JList listaUsuarios = new JList(elementos);
		scrollPane_1.setViewportView(listaUsuarios);
		
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
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnConectar, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCliqueDuasVezes, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
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
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCliqueDuasVezes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
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
				System.out.println("dsad");
			}
		});
		
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String opcao = btnConectar.getText();
				if (opcao.equals("Conectar")) {
					btnConectar.setText("Desconectar");
				} else {
					btnConectar.setText("Conectar");
				}
			}
		});
		
		listaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("dsad");
					int index = listaUsuarios.locationToIndex(e.getPoint());
		            
					listaUsuarios.setSelectedIndex(index);
		            String usuarioAReceber = (String)listaUsuarios.getSelectedValue();
		            System.out.println(usuarioAReceber);
				}
			}
		});
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
}
