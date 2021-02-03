package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class FinestraPrincipale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraPrincipale frame = new FinestraPrincipale();
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
	public FinestraPrincipale() {
		setTitle("Finestra Principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Chiudi = new JButton("Chiudi");
		Bottone_Chiudi.setBounds(426, 328, 89, 44);
		contentPane.add(Bottone_Chiudi);
		
		JButton Bottone_Progetti = new JButton("Gestione Progetti");
		Bottone_Progetti.setBounds(62, 60, 140, 44);
		contentPane.add(Bottone_Progetti);
		
		JButton Bottone_Meeting = new JButton("Gestione Meeting");
		Bottone_Meeting.setBounds(62, 160, 140, 44);
		contentPane.add(Bottone_Meeting);
		
		JButton Bottone_Assunzioni = new JButton("Assunzione Impiegato");
		Bottone_Assunzioni.setBounds(62, 260, 140, 44);
		contentPane.add(Bottone_Assunzioni);
	}
}
