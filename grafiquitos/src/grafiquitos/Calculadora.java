package grafiquitos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculadora extends JFrame implements ActionListener{

	private JTextField text1,text2;
	private JButton sumar,restar,multiplicar,dividir;
	
	public Calculadora() {
		setLayout(null);
		text1 = new JTextField();
		text1.setBounds(10,200,100,30);
		add(text1);
		text2 = new JTextField();
		text2.setBounds(10,150,100,30);
		add(text2);
		//sumar
		sumar = new JButton("+");
		sumar.setBounds(150,10,50,50);
		add(sumar);
			// restar
		sumar.addActionListener(this);
		restar = new JButton("-");
		restar.setBounds(200,10,50,50);
		add(restar);
		restar.addActionListener(this);
		//multiplicar
		multiplicar = new JButton("*");
		multiplicar.setBounds(250,10,50,50);
		add(multiplicar);
		multiplicar.addActionListener(this);
		//dividir
		dividir = new JButton("/");
		dividir.setBounds(300,10,50,50);
		add(dividir);
		dividir.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sumar) {
			String cad1 = text1.getText();
			String cad2 = text2.getText();
			int n1 = Integer.parseInt(cad1);
			int n2 = Integer.parseInt(cad2);
			int suma = n1+n2;
			String text = String.valueOf(suma);
			setTitle(text);
		}
		if(e.getSource()==restar) {
			String cad1 = text1.getText();
			String cad2 = text2.getText();
			int n1 = Integer.parseInt(cad1);
			int n2 = Integer.parseInt(cad2);
			int resta = n1-n2;
			String text = String.valueOf(resta);
			setTitle(text);
		}
		if(e.getSource()==multiplicar) {
			String cad1 = text1.getText();
			String cad2 = text2.getText();
			int n1 = Integer.parseInt(cad1);
			int n2 = Integer.parseInt(cad2);
			int mul = n1*n2;
			String text = String.valueOf(mul);
			setTitle(text);
			
			
		}
		if(e.getSource()==dividir) {
			setTitle("dividir");
			String cad1 = text1.getText();
			String cad2 = text2.getText();
			int n1 = Integer.parseInt(cad1);
			int n2 = Integer.parseInt(cad2);
			try {
			int div = n2/n1;
			String text = String.valueOf(div);
			setTitle(text);
			}catch(Exception e1) 
			{
				System.out.print("EROOR"+e1.getMessage());
			}
		}
		
	}
	public static void main(String []args) 
	{
		Calculadora b1 = new Calculadora();
		b1.setBounds(0,0,450,350);
		b1.setVisible(true);
		b1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
