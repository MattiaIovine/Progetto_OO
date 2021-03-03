package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.*;
import javax.swing.JList;
import Controller.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class SelezioneImpiegato extends JFrame {

	Controller theController;
	private JPanel contentPane;

	public SelezioneImpiegato(Controller c, ArrayList<Impiegato> Risultati) {
		theController=c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Impiegato n1 = new Impiegato("123123","Marco","Rossi","Mail","Telefono", 15);
		Impiegato n2 = new Impiegato("123123","Marco678","Ros123si","Mail","Telefono", 1589);
		Impiegato n3 = new Impiegato("123123","Marco123","R434ossi","Mail","Telefono", 1556);
		Risultati.add(n1);
		Risultati.add(n2);
		Risultati.add(n3);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setToolTipText("");
		list.setBounds(53, 45, 283, 169);
		contentPane.add(list);
		DefaultListModel<String> newListModel = new DefaultListModel<String>();
		for(Impiegato impiegato:Risultati) {
			newListModel.addElement(impiegato.toString());
		}
		list.setModel(newListModel);
		list.setVisible(true);
		getContentPane().add(list,BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Risultati.get(list.getSelectedIndex()));
			}
		});
		btnNewButton.setBounds(419, 140, 89, 23);
		contentPane.add(btnNewButton);
	}
}
