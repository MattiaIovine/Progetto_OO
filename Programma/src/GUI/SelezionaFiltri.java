package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codice.Impiegato;
import Codice.Skill;
import Controller.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class SelezionaFiltri extends JFrame {

	private JPanel contentPane;
	private JTextField Campo_Val_Min;
	private JTextField Campo_Val_Max;
	private JTextField Campo_Salario_Min;
	private JTextField Campo_Salario_Max;
	Controller theController;

	public SelezionaFiltri(ArrayList<Skill> listaskill, Controller c) {
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Campo_Val_Min = new JTextField();
		Campo_Val_Min.setBounds(130, 33, 86, 20);
		contentPane.add(Campo_Val_Min);
		Campo_Val_Min.setColumns(10);
		
		Campo_Val_Max = new JTextField();
		Campo_Val_Max.setBounds(250, 33, 86, 20);
		contentPane.add(Campo_Val_Max);
		Campo_Val_Max.setColumns(10);
		
		Campo_Salario_Min = new JTextField();
		Campo_Salario_Min.setBounds(130, 78, 86, 20);
		contentPane.add(Campo_Salario_Min);
		Campo_Salario_Min.setColumns(10);
		
		JLabel Etichetta_Valutazione = new JLabel("Valutazione");
		Etichetta_Valutazione.setBounds(35, 36, 68, 14);
		contentPane.add(Etichetta_Valutazione);
		
		JLabel Etichetta_Minimo = new JLabel("Minima");
		Etichetta_Minimo.setBounds(147, 8, 46, 14);
		contentPane.add(Etichetta_Minimo);
		
		JLabel Etichetta_Massimo = new JLabel("Massima");
		Etichetta_Massimo.setBounds(264, 8, 46, 14);
		contentPane.add(Etichetta_Massimo);
		
		Campo_Salario_Max = new JTextField();
		Campo_Salario_Max.setBounds(250, 78, 86, 20);
		contentPane.add(Campo_Salario_Max);
		Campo_Salario_Max.setColumns(10);
		
		JLabel Etichetta_Salario = new JLabel("Salario");
		Etichetta_Salario.setBounds(37, 81, 46, 14);
		contentPane.add(Etichetta_Salario);
		
		JLabel Etichetta_Ambito = new JLabel("Ambito");
		Etichetta_Ambito.setBounds(37, 123, 46, 14);
		contentPane.add(Etichetta_Ambito);
		
		JComboBox BoxAmbito = new JComboBox();
		BoxAmbito.setModel(new DefaultComboBoxModel(new String[] {"Qualsiasi", "Economia", "Medicina", "Informatica", "Ingegneria"}));
		BoxAmbito.setBounds(130, 119, 91, 22);
		contentPane.add(BoxAmbito);
		
		DefaultListModel<String> newListModel = new DefaultListModel<String>();
		for(Skill s:listaskill) {
			newListModel.addElement(s.getNome());
		}
		JList Lista_Skill = new JList();
		Lista_Skill.setBounds(130, 189, 287, 97);
		contentPane.add(Lista_Skill);
		Lista_Skill.setModel(newListModel);
		Lista_Skill.setVisible(true);
		getContentPane().add(Lista_Skill,BorderLayout.SOUTH);
		
		
		JLabel Etichetta_Skill = new JLabel("Skill Richieste");
		Etichetta_Skill.setBounds(37, 226, 83, 14);
		contentPane.add(Etichetta_Skill);
	}
}
