package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class GerenciamentoListas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoListas frame = new GerenciamentoListas();
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
	public GerenciamentoListas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 896, 506);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 153, 204));
		
		JLabel label = new JLabel("Gerenciamento de Listas");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		
		JLabel label_1 = new JLabel("Selecione uma das op\u00E7\u00F5es abaixo:");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		
		JRadioButton radioButton = new JRadioButton("Adicionar");
		radioButton.setFont(new Font("Arial", Font.PLAIN, 13));
		radioButton.setBackground(Color.WHITE);
		panel_3.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Remover");
		radioButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		radioButton_1.setBackground(Color.WHITE);
		panel_3.add(radioButton_1);
		
		JPanel pnlContainer = new JPanel();
		pnlContainer.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
				.addComponent(pnlContainer, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlContainer, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button = new JButton("Arquivo");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		
		JLabel label_2 = new JLabel("Selecione o arquivo que deseja remover");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Arial", Font.BOLD, 17));
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 872, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(211)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
					.addGap(214))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 163, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("Digite o Nome da Lista:");
		
		JButton button_1 = new JButton("Realizar");
		GroupLayout gl_pnlContainer = new GroupLayout(pnlContainer);
		gl_pnlContainer.setHorizontalGroup(
			gl_pnlContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContainer.createSequentialGroup()
					.addGap(249)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(281))
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_pnlContainer.createSequentialGroup()
					.addGap(336)
					.addGroup(gl_pnlContainer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContainer.createSequentialGroup()
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addGap(123))
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addGroup(gl_pnlContainer.createSequentialGroup()
							.addGap(67)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(95)))
					.addGap(311))
		);
		gl_pnlContainer.setVerticalGroup(
			gl_pnlContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlContainer.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlContainer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlContainer.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_3)
					.addGap(6)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pnlContainer.setLayout(gl_pnlContainer);
		panel.setLayout(gl_panel);
	}
}
