package grafiquitos;
import javax.swing.*;

public class Practica1 extends JFrame {

	private JLabel jlLabel;
	public Practica1() {
		setLayout(null);
		jlLabel = new JLabel("HOLA MUNDO");
		
		jlLabel.setBounds(10,20,200,30);
		add(jlLabel);
	}
	public static void main(String[]args) {
		Practica1 vent = new Practica1();
		vent.setBounds(10,10,400,300);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vent.setVisible(true);
	}
}
