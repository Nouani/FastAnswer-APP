package views;

//import lista.desordenada.*;
//import lista.ordenada.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;

public class Chat {

	private JFrame frmChat;
	private JTextField txtEnviar;
	private JTextArea txtAreaMensagens;
	private JList listaUsuarios;
	private boolean conectado=false;
	private DefaultListModel<String> model;
	private JLabel lblConectado;
	private JButton btnConectar;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChat = new JFrame();
		frmChat.setResizable(false);
		frmChat.setTitle("Chat");
		frmChat.setBounds(50, 50, 857, 599);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 639, 389);
		frmChat.getContentPane().add(scrollPane);
		
		txtAreaMensagens = new JTextArea();
		txtAreaMensagens.setEditable(false);
		scrollPane.setViewportView(txtAreaMensagens);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(659, 96, 161, 425);
		frmChat.getContentPane().add(scrollPane_1);
		
		// Lista de usuarios
		model = new DefaultListModel<String>();
		listaUsuarios = new JList(model);
		scrollPane_1.setViewportView(listaUsuarios);
		
		// Area para escrever a mensagem que vai ser enviada
		txtEnviar = new JTextField();
		txtEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//btnEnviar.doClick();
			}
		});
		txtEnviar.setBounds(10, 496, 528, 25);
		frmChat.getContentPane().add(txtEnviar);
		txtEnviar.setColumns(10);
		
		// Botao para enviar mensagem
		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				/*if (txtEnviar.getText().trim().equals(""))
					return;
				
				txtEnviar.setText("");*/
			}
		});
		
		btnEnviar.setBounds(544, 496, 105, 25);
		frmChat.getContentPane().add(btnEnviar);
		
		
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(659, 73, 105, 25);
		frmChat.getContentPane().add(lblNewLabel);
		
		JLabel lblMensagens = new JLabel("Mensagens");
		lblMensagens.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensagens.setBounds(10, 73, 105, 25);
		frmChat.getContentPane().add(lblMensagens);
		
		lblConectado = new JLabel("Voc\u00EA n\u00E3o est\u00E1 conectado a nenhuma sala!");
		lblConectado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConectado.setBounds(10, 21, 639, 35);
		frmChat.getContentPane().add(lblConectado);
		
		
		// Botao para conectar a um servidor
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// atualizar 'atividade' no DB
			}
		});
		btnConectar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConectar.setBounds(659, 21, 161, 32);
		frmChat.getContentPane().add(btnConectar);
		
		JLabel lblNewLabel_1 = new JLabel("Clique duas vezes no nome de algu\u00E9m para enviar uma mensagem particular");
		lblNewLabel_1.setBounds(356, 532, 464, 18);
		frmChat.getContentPane().add(lblNewLabel_1);
		
		
		// USUARIO FECHOU O PROGRAMA - FECHAR CONEXAO
		frmChat.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
            	try
            	{
            		// atualizar 'atividade' no DB
					return;
            	}
            	catch (Exception erro) {}
            }
        });
		
		btnConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		// Evento double click da lista de usuarios
		listaUsuarios.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt)
		    {
		    	// carregar mensagens no text area
		    	/*if (!conectado)
		    		return;
		    	
				JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2)
		        {
		            // Double-click detectado
		            int index = list.locationToIndex(evt.getPoint());
		            
		            list.setSelectedIndex(index);
		            String usuarioAReceber = (String)list.getSelectedValue();
		            
		            String mensagemAEnviar = JOptionPane.showInputDialog("Digite a mensagem particular a ser enviada para " + usuarioAReceber);
		            //enviarMensagem(mensagemAEnviar, usuarioAReceber);
		        }*/
		    }
		});
		
		
	}
}
