package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GestioneMeeting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneMeeting frame = new GestioneMeeting();
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
	public GestioneMeeting() {
		setTitle("Gestione Meeting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Bottone_Indietro = new JButton("Indietro");
		Bottone_Indietro.setBounds(427, 316, 89, 44);
		contentPane.add(Bottone_Indietro);
		
		JButton Bottone_VediMeeting = new JButton("Calendario Meeting");
		Bottone_VediMeeting.setBounds(48, 80, 169, 44);
		contentPane.add(Bottone_VediMeeting);
		
		JButton Bottone_CreaMeeting = new JButton("Fissare Nuovo Meeting");
		Bottone_CreaMeeting.setBounds(48, 202, 169, 44);
		contentPane.add(Bottone_CreaMeeting);
	}

}
