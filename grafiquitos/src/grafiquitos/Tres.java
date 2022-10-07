package grafiquitos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tres extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton1,boton2,boton3;
	public Tres() {
		setLayout(null);
		boton1 = new JButton("Finalizar");
		boton1.setBounds(10,200,100,30);
		add(boton1);
		boton1.addActionListener(this);
		//boton2
		setLayout(null);
		boton2 = new JButton("Finalizar 2");
		boton2.setBounds(110,200,100,30);
		add(boton2);
		boton2.addActionListener(this);
		//voton3
		setLayout(null);
		boton3 = new JButton("Finalizar 3");
		boton3.setBounds(200,200,100,30);
		add(boton3);
		boton3.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1) {
			setTitle("Boton-1");
			System.exit(0);
		}
		if(e.getSource()==boton2) {
			setTitle("Boton-2");
			System.exit(0);
		}
		if(e.getSource()==boton3) {
			setTitle("Boton-3");
			System.exit(0);
		}
	}
	public static void main(String []args) 
	{
		Tres b1 = new Tres();
		b1.setBounds(0,0,450,350);
		b1.setVisible(true);
		b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
