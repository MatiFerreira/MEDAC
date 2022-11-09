package grafiquitos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Boton extends JFrame implements ActionListener {
	JButton jbBoton;
	public Boton() {
		setLayout(null);
		jbBoton = new JButton("Finalizar");
		jbBoton.setBounds(300,200,100,30);
		add(jbBoton);
		jbBoton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbBoton) {
			System.exit(0);
		}
	}
	public static void main(String []args) 
	{
		Boton b1 = new Boton();
		b1.setBounds(0,0,450,350);
		b1.setVisible(true);
		b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
