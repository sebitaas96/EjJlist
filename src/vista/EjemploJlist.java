package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploJlist extends JFrame {

	private JPanel contentPane;
	private JTextField txtAniadir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public EjemploJlist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);
		
		String [] VarrayLista = {"Critsina" , "Sebas" , "EEE" , "SS" , "SARA"};
		
		JList list = new JList(VarrayLista);
		//Para ir añadiendo elementos en tiempo real ejemplio en panel centro
		panelOeste.add(list);
		
		
		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);
		
		List<String> arrayLista = Arrays.asList(VarrayLista);
		
		JList list_1 = new JList (arrayLista.toArray());
		panelEste.add(list_1);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		txtAniadir = new JTextField();
		panelBotones.add(txtAniadir);
		txtAniadir.setColumns(10);
		

		

		
		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		
		//Con esto creamos un modelo que podemos ir añadiendo cosas en tiempo real 
		DefaultListModel modelo = new DefaultListModel();
		modelo.addAll(arrayLista);
		modelo.addElement("Ana");
		JList listaConModelo = new JList(modelo);
		listaConModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(listaConModelo);
		//panelCentral.add(listaConModelo);
		panelCentral.add(scroll);
		
		JButton btnNewButton = new JButton("aniadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement(txtAniadir.getText());
				txtAniadir.setText("");
			}
		});
		panelBotones.add(btnNewButton);
	
		JButton btnNewButton_1 = new JButton("ELIMINAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.remove(listaConModelo.getSelectedIndex()); // Le damos lo que hemos seleccionado de la lista
			}
		});
		panelBotones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EliminarTodos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeAllElements();
			}
		});
		panelBotones.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Seleccionartodo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, listaConModelo.getSelectedValue());
			}
		});
		panelBotones.add(btnNewButton_3);
		
		//SELECCIONES MULTIMPLES 
		JButton btnNewButton_4 = new JButton("cambiar tipo seleccion");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaConModelo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			}
		});
		panelBotones.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("VerSeleccionados");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, listaConModelo.getSelectedValuesList()); // Me devuelve los seleccionados como una lista.
				
				for(Object s : listaConModelo.getSelectedValuesList()) {
					System.out.println((String) s);
				}
			}
		});
		panelBotones.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("VerSeleccionados");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, listaConModelo.getSelectedIndices()); // Me devuelve los seleccionados como una lista.
				int cont =0;
				for(Integer i : listaConModelo.getSelectedIndices()) {
					System.out.println( i);
					modelo.remove(i-cont++);
				}
			}
		});
		panelBotones.add(btnNewButton_6);
}}
