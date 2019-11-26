package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import bd.daos.Alunos;
import bd.daos.Monitores;
import bd.dbos.Aluno;
import bd.dbos.Monitor;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Date: Nov 25-2019
 * Aplicativo desenvolvido para os Monitores do PADEMT (Cotuca)
 * @author Nouani Gabriel Sanches & Pedro Go Ikeda
 * @version 1.0
 */
public class Login {

	private JFrame  frame     = new JFrame  ("Fast Answer");
	private JLabel  visor      = new JLabel  ("Bem Vindo", JLabel.RIGHT);
	
	private JTextField txtRA;
	private JTextField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 22));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(111)
					.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addGap(110))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEntrar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblBemvindo = new JLabel("Bem-Vindo");
		lblBemvindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemvindo.setFont(new Font("Arial", Font.BOLD, 46));
		panel_4.add(lblBemvindo);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		
		txtRA = new JTextField();
		txtRA.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("RA:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_5.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
								.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
									.addComponent(txtRA, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
								.addGap(88)))))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtRA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		panel_5.setLayout(gl_panel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Z:\\2\u00B0Semestre\\6-Pratica Profissional\\Projeto 1\\Website\\Website\\home\\imgs\\Logo Icon.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(72))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(73)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(105))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// EVENTOS:
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
		            if (txtRA.getText().equals(""))
		                JOptionPane.showMessageDialog(null, "Digite seu RA");
		            else
		            {
		                if (txtSenha.getText().equals(""))
		                    JOptionPane.showMessageDialog(null, "Digite sua senha");
		                else
		                {
		                    if (Alunos.cadastrado(txtRA.getText())) {
		                        if (Monitores.cadastrado(txtRA.getText())) {
		                            fazerLogin(txtRA.getText(), txtSenha.getText());
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Você não possuí este nível de permissão");
		                        }
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Você não está cadastrado");
		                    }
		                }
		            }
		        } 
		        catch (Exception erro) {
		            JOptionPane.showMessageDialog(null, erro.getMessage());
		        }
			}
		});
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MÉTODOS:
	
	private void fazerLogin(String ra, String senha) throws Exception {
        try {
            Aluno aluno = new Aluno(Alunos.getAluno(ra)); 
            Monitor monitor = new Monitor(Monitores.getMonitor(ra));
            
            if (aluno.getSenha().equals(senha)) {
            	txtRA.setText("");
            	txtSenha.setText("");
                JOptionPane.showMessageDialog(null, "Bem-Vindo de volta " + aluno.getNome());
                Menu menu = new Menu(aluno, monitor);
                menu.renderForm();
                menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Senha Incorreta!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
}
