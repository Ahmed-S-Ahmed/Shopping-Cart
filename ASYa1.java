import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ASYa1 extends JFrame implements ActionListener{
	private JButton ba,bb;
	private JLabel lge,lam;
	private JTextField tam;
	private JComboBox<String> jcb;
	private JRadioButton rgm,rsm,rnm;
	private JPanel prb;
	private ButtonGroup bgm;
	private JTable basket;
	private int b1a,b2a,b3a,b4a,b5a;
	private double Total;
	String g1[]= {"science[10p]","history[15p]","drama[5p]","romance[7p]","action[13p]"};
	int prices[]= {10,15,5,7,13};
	
	public ASYa1() {
		setLayout(null);
		b1a=0;
		b2a=0;
		b3a=0;
		b4a=0;
		b5a=0;
		Total=0;
		
		lge= new JLabel("Genre");
		lge.setSize(40,20);
		lge.setLocation(20,30);
		
		lam= new JLabel("Amount");
		lam.setSize(60,20);
		lam.setLocation(300,30);
		
		tam= new JTextField();
		tam.setSize(100,25);
		tam.setLocation(300,55);
		
		
		ba= new JButton("Add");
		ba.setSize(90,25);
		ba.setLocation(450,55);
		ba.addActionListener(this);
		
		bb= new JButton("Buy");
		bb.setSize(90,25);
		bb.setLocation(450,110);
		bb.addActionListener(this);
		
		jcb= new JComboBox<String>(g1);
		jcb.setSize(125,25);
		jcb.setLocation(20,55);
		
		rgm= new JRadioButton("Golden Member");
		rgm.setHorizontalAlignment(SwingConstants.CENTER);
		rsm= new JRadioButton("Silver Member");
		rsm.setHorizontalAlignment(SwingConstants.CENTER);
		rnm= new JRadioButton("Non-Member");
		rnm.setHorizontalAlignment(SwingConstants.CENTER);
		rnm.setSelected(true);
		
		bgm=new ButtonGroup();
		bgm.add(rgm);
		bgm.add(rsm);
		bgm.add(rnm);
		
		prb=new JPanel();
		prb.setLayout(new BoxLayout(prb, BoxLayout.X_AXIS));
		prb.setSize(500,200);
		prb.setLocation(20,100);
		prb.add(rgm);
		prb.add(rsm);
		prb.add(rnm);
		
		add(lge);
		add(lam);
		add(tam);
		add(ba);
		add(bb);
		add(jcb);
		add(prb);
		
		
		setSize(600,275);
		setTitle("Jarir Bookstore-Not just a bookstore!");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ASYa1();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ba) {
			try {
			if(g1[0].equals(jcb.getSelectedItem()))
				b1a += Integer.parseInt(tam.getText());
			else if(g1[1].equals(jcb.getSelectedItem()))
				b2a += Integer.parseInt(tam.getText());
			else if(g1[2].equals(jcb.getSelectedItem()))
				b3a += Integer.parseInt(tam.getText());
			else if(g1[3].equals(jcb.getSelectedItem()))
				b4a += Integer.parseInt(tam.getText());
			else if(g1[4].equals(jcb.getSelectedItem()))
				b5a += Integer.parseInt(tam.getText());}
			catch(NumberFormatException w) {
				JOptionPane.showMessageDialog(this,"Please enter an integer amount","Warning",JOptionPane.WARNING_MESSAGE);
			}
			tam.setText("");
		}
		
		if(e.getSource()==bb) {
			Total=(b1a*prices[0])+(b2a*prices[1])+(b3a*prices[2])+(b4a*prices[3])+(b5a*prices[4]);
			if(rgm.isSelected())
				Total= Total*0.85;
			else if(rsm.isSelected())
				Total= Total*0.9;
				
			Object[][] rows= {{"science",b1a,prices[0]},{"history",b2a,prices[1]},
					{"drama",b3a,prices[2]},{"romance",b4a,prices[3]},
					{"action",b5a,prices[4]},{"Total Price","",Total}};
			
			Object[] cols= {"Book","Amount","Price"};
			
			basket= new JTable(rows,cols);
			JOptionPane.showMessageDialog(null, new JScrollPane(basket));
			
			b1a=0;
			b2a=0;
			b3a=0;
			b4a=0;
			b5a=0;
			Total=0;
			rnm.setSelected(true);
			tam.setText("");
		}
	}
}
