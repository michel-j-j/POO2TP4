package ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import portsin.Registro;
import portsin.RegistroException;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	 private JTextField nombre;
	 private JTextField telefono;
	 private JTextField region;
	 private Registro registro;

	public VentanaPrincipal(Registro registro) {
		this.registro = Objects.requireNonNull(registro);
		setupUIComponents();
	}
		 private void setupUIComponents() {
		 setTitle("Add Participant");
		 setSize(400, 400);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.nombre = new JTextField(10);
		 this.telefono = new JTextField(10);
		 this.region = new JTextField(10);
		 this.nombre.setText("");
		 
		 this.telefono.setText("");
		 this.region.setText("China");
		 JPanel contentPane = new JPanel();
		 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 contentPane.setLayout(new FlowLayout());
		 contentPane.add(new JLabel("Nombre: "));
		 contentPane.add(nombre);
		 contentPane.add(new JLabel("Telefono: "));
		 contentPane.add(telefono);
		 contentPane.add(new JLabel("Region: "));
		 contentPane.add(region);
		 JButton botonCargar = new JButton("Cargar");
		 botonCargar.addActionListener((ActionListener) new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		  onBotonCargar();
		  }
		 });
		 contentPane.add(botonCargar);
		 setContentPane(contentPane);
		 contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 pack();
		 setVisible(true);
		  


          }
		  private void onBotonCargar(){
			  String nombreTxt = nombre.getText();
			  String telefonoTxt = telefono.getText();
			  String regionTxt = region.getText();
			  
			  try
			  {
			  registro.cargarParticipante(nombreTxt, regionTxt,telefonoTxt);
			  JOptionPane.showMessageDialog(this, "Participante cargado con exito!");
			  }
			  catch(RegistroException e)
			  {
				  JOptionPane.showMessageDialog(this, e.obtenerMsj());
			  }
	}
}
