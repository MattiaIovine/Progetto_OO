package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class AssunzioneImpiegato extends JFrame {

	private JPanel contentPane;
	Controller theController;
	private JTextField Campo_CF;
	private JTextField Campo_Nome;
	private JTextField Campo_Cognome;
	private JTextField Campo_Mail;
	private JTextField Campo_Telefono;
	private JTextField Campo_Salario;
	JFrame frame;

	
	public AssunzioneImpiegato(Controller c) {
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				theController.Torna_Finestra_Principale();
			}
		});
		Bottone_Indietro.setBounds(10, 327, 89, 44);
		contentPane.add(Bottone_Indietro);
		
		Campo_CF = new JTextField();
		Campo_CF.setBounds(127, 50, 184, 30);
		contentPane.add(Campo_CF);
		Campo_CF.setColumns(10);
		
		Campo_Nome = new JTextField();
		Campo_Nome.setBounds(127, 91, 184, 30);
		contentPane.add(Campo_Nome);
		Campo_Nome.setColumns(10);
		
		Campo_Cognome = new JTextField();
		Campo_Cognome.setBounds(127, 132, 184, 30);
		contentPane.add(Campo_Cognome);
		Campo_Cognome.setColumns(10);
		
		Campo_Mail = new JTextField();
		Campo_Mail.setBounds(127, 173, 184, 30);
		contentPane.add(Campo_Mail);
		Campo_Mail.setColumns(10);
		
		Campo_Telefono = new JTextField();
		Campo_Telefono.setBounds(127, 214, 184, 30);
		contentPane.add(Campo_Telefono);
		Campo_Telefono.setColumns(10);
		
		Campo_Salario = new JTextField();
		Campo_Salario.setBounds(127, 255, 184, 30);
		contentPane.add(Campo_Salario);
		Campo_Salario.setColumns(10);
		
		JLabel Etichetta_CF = new JLabel("Codice Fiscale");
		Etichetta_CF.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_CF.setBounds(27, 58, 90, 14);
		contentPane.add(Etichetta_CF);
		
		JLabel Etichetta_Nome = new JLabel("Nome");
		Etichetta_Nome.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_Nome.setBounds(27, 99, 72, 14);
		contentPane.add(Etichetta_Nome);
		
		JLabel Etichetta_Cognome = new JLabel("Cognome");
		Etichetta_Cognome.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_Cognome.setBounds(27, 140, 72, 14);
		contentPane.add(Etichetta_Cognome);
		
		JLabel Etichetta_Mail = new JLabel("Mail");
		Etichetta_Mail.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_Mail.setBounds(27, 181, 72, 14);
		contentPane.add(Etichetta_Mail);
		
		JLabel Etichetta_Telefono = new JLabel("Telefono");
		Etichetta_Telefono.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_Telefono.setBounds(27, 222, 72, 14);
		contentPane.add(Etichetta_Telefono);
		
		JLabel Etichetta_Salario = new JLabel("Salario");
		Etichetta_Salario.setHorizontalAlignment(SwingConstants.LEFT);
		Etichetta_Salario.setBounds(27, 263, 72, 14);
		contentPane.add(Etichetta_Salario);
		
		
		
		JButton Bottone_Conferma_Assunzione = new JButton("Conferma Assunzione");
		Bottone_Conferma_Assunzione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Campo_CF.getText().length()==16) {
					if(!Campo_Nome.getText().isEmpty() && !Campo_Cognome.getText().isEmpty() && !Campo_Mail.getText().isEmpty() && Campo_Telefono.getText().length()>9) {
						try {
							if(Float.parseFloat(Campo_Salario.getText())>0.0) {
								JOptionPane.showMessageDialog(frame, "Assunzione effettuata");
								theController.Assumi_Impiegato(Campo_CF.getText() , Campo_Nome.getText(), Campo_Cognome.getText(), Campo_Mail.getText(), Campo_Telefono.getText(), Float.parseFloat(Campo_Salario.getText()));
						}
							else JOptionPane.showMessageDialog(frame, "Il campo Salario deve essere positivo!", "Attenzione", JOptionPane.WARNING_MESSAGE);
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(frame, "Il salario deve essere un valore numerico non nullo!", "Errore", JOptionPane.ERROR_MESSAGE);
						}
					}
					else JOptionPane.showMessageDialog(frame, "Tutti i campi devono essere pieni!", "Attenzione", JOptionPane.WARNING_MESSAGE);
				}
				else JOptionPane.showMessageDialog(frame, "Il codice fiscale deve essere di 16 caratteri!", "Attenzione", JOptionPane.WARNING_MESSAGE);
			}
		});
		Bottone_Conferma_Assunzione.setBounds(380, 327, 137, 44);
		contentPane.add(Bottone_Conferma_Assunzione);
	}
}
