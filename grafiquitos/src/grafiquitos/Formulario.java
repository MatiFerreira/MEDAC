package grafiquitos;
import javax.swing.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener {
	private JLabel label1, label2;
	private JTextField texto1,texto2;
	private JButton boton;
	public Formulario()
	{
		
		setLayout(null);
		
		label1= new JLabel("Nombre:");
		label1.setBounds(10,10,100,30);
		add(label1);
		

		label2= new JLabel("Clave:");
		label2.setBounds(10,50,100,30);
		add(label2);
		
		texto1=new JTextField();
		texto1.setBounds(130,10,100,30);
		add(texto1);
		
		texto2=new JTextField();
		texto2.setBounds(130,50,100,30);
		add(texto2);
		
		
	    boton=new JButton("Confirmar");
	    boton.setBounds(10,100,100,30);
	    add(boton);
	    boton.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource()==boton)
		{	
			String cad1=texto1.getText();
			String cad2=texto2.getText();		
			if(cad1.equals("amigo")==true && cad2.equals("miclave")==true)
			{

				setTitle("correcto");
			}
			else
			{
				
				setTitle("incorrecto");
			}
			
		}
			
	}
	
	public static void main(String args [])
	{
		Formulario f=new Formulario();
		f.setBounds(0,0,500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}