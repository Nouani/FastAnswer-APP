package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bd.daos.Materias;
import bd.daos.Monitores;
import bd.dbos.Aluno;
import bd.dbos.Materia;
import bd.dbos.Monitor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Menu extends JFrame {
	
	private JLabel lblNome = null;
	private JLabel lblEspecificacao = null;
	
	private Aluno aluno = null;
	private Monitor monitor = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null, null);
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
	public Menu(Aluno aluno, Monitor monitor) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1001, 534);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 51, 102));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
		);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(204, 0, 102));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 0, 102));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(153, 51, 102));
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(new Color(255, 255, 255));
		lblChat.setFont(new Font("Arial", Font.BOLD, 18));
		lblChat.setBackground(Color.WHITE);
		GridBagConstraints gbc_lblChat = new GridBagConstraints();
		gbc_lblChat.insets = new Insets(0, 0, 0, 5);
		gbc_lblChat.gridx = 2;
		gbc_lblChat.gridy = 0;
		panel_8.add(lblChat, gbc_lblChat);
		
		JPanel panel_9 = new JPanel();
		panel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_9.setBackground(new Color(204, 0, 102));
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("Z:\\2\u00B0Semestre\\6-Pratica Profissional\\Projeto 1\\Aplicativo\\imagens\\chat2.png"));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		panel_9.add(label_3, gbc_label_3);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
							.addGap(1)))
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(204)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 238, Short.MAX_VALUE)
					.addGap(81)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(194))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 51, 102));
		
		JPanel panel_4 = new JPanel();
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBackground(new Color(204, 0, 102));
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("Z:\\2\u00B0Semestre\\6-Pratica Profissional\\Projeto 1\\Aplicativo\\imagens\\list2.png"));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		panel_4.add(label_2, gbc_label_2);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 217, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
							.addGap(11))))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Listas de Exerc\u00EDcios");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);
		panel_6.setLayout(gl_panel_6);
		panel_3.setLayout(gl_panel_3);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Z:\\2\u00B0Semestre\\6-Pratica Profissional\\Projeto 1\\Website\\Website\\home\\imgs\\Letra.png"));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, BorderLayout.SOUTH);
		
		lblEspecificacao = new JLabel("Monitor de X");
		lblEspecificacao.setFont(new Font("Arial", Font.PLAIN, 13));
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Arial", Font.BOLD, 17));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(32))
						.addComponent(lblEspecificacao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(838))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEspecificacao)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
		
		try {
			setMonitor(monitor);
			setAluno(aluno);
		}
		catch (Exception erro) 
		{ } // sei que não vai dar erro
		
		
		// EVENTOS: 
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GerenciamentoListas gl = new GerenciamentoListas(aluno, monitor);
				gl.setVisible(true);
			}
		});
		
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{
					ChatUsers chat = new ChatUsers(aluno, monitor);
					chat.setVisible(true);
				} catch (Exception erro) 
				{ } // sei que não vai dar erro
			}
		});
	}
	
	// MÉTODOS:
	public void renderForm() throws Exception{
        Materia materia = new Materia(Materias.getMateria(this.monitor.getCodigo()));
        String especificacao = materia.getNome();
        try
        {
            lblNome.setText(this.aluno.getNome());
            lblEspecificacao.setText("Monitor(a) de " + especificacao);
        }
        catch(Exception erro)
        { } // sei que não vai dar erro
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
