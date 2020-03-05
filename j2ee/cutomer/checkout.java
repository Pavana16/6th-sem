package customer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class checkout extends JFrame implements ActionListener{
	String username="abc123",password="xyz";
	JButton go,check,pay;
	JFrame cart;
	JTextField phno,itemid,quant;
	Integer[] discount= {0,10,20,50};
	double price;
	JTextArea name,cphno,iname,totprice;
	HashMap<Long, String> customers=new HashMap<Long, String>();
	ArrayList<item> itemlist=new ArrayList<item>();
	checkout() {
		super("checkout");
		while(true){
			String u=JOptionPane.showInputDialog(this,"Enter username:","Log in",JOptionPane.INFORMATION_MESSAGE);
			if(u.equals(username)) {
				String p=JOptionPane.showInputDialog(this,"Enter Password:","Log in",JOptionPane.INFORMATION_MESSAGE);
				if(p.equals(password))
					break;
				JOptionPane.showMessageDialog(this, "Invalid password"
						,"Error",JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(this, "Invalid username",
						"Error",JOptionPane.ERROR_MESSAGE);
		}
		JLabel lphno=new JLabel("Enter customer phone number:");
		add(lphno);
		phno=new JTextField(10);
		add(phno);
		go=new JButton("Go");
		go.addActionListener(this);
		add(go);
		cart=new JFrame("Choose Items");
		itemlist.add(new item("i01","Poster",299));
		itemlist.add(new item("i02","Wallclock",499));
		itemlist.add(new item("i03","Pop Figure",999));
		JLabel lname=new JLabel("Customer id:");
		JLabel lcphno=new JLabel("Ph. no.:");
		JLabel litemid=new JLabel("Enter Item id:");
		JLabel lquant=new JLabel("Enter quantity:");
		JLabel liname=new JLabel("Item name:");
		JLabel ltotprice=new JLabel("Total price:");
		name=new JTextArea(20, 5);
		cphno=new JTextArea(20, 5);
		itemid=new JTextField(20);
		quant=new JTextField(20);
		iname=new JTextArea(20, 5);
		totprice=new JTextArea(20, 5);
		check=new JButton("Check");
		pay=new JButton("Pay");
		check.addActionListener(this);
		pay.addActionListener(this);
		cart.add(lname);cart.add(name);
		cart.add(lcphno);cart.add(cphno);
		cart.add(litemid);cart.add(itemid);
		cart.add(lquant);cart.add(quant);
		cart.add(liname);cart.add(iname);
		cart.add(ltotprice);cart.add(totprice);
		cart.add(check);cart.add(pay);
		name.setEnabled(false);
		cphno.setEnabled(false);
		iname.setEnabled(false);
		totprice.setEnabled(false);
		pay.setEnabled(false);
		cart.setSize(1000,800);
		cart.setLayout(new GridLayout(4,2));
	}
	public static void main(String args[]){
		checkout app=new checkout();
		app.setVisible(true);
		app.setSize(600, 200);
		app.setLayout(new GridLayout(1,2));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==go) {
			long num=Long.parseLong(phno.getText());
			String cid;
			if(!customers.containsKey(num)) {
				cid=JOptionPane.showInputDialog(this,"Enter cutomer id:",
							"New customer",JOptionPane.QUESTION_MESSAGE);
				customers.put(num,cid);
			}
			else
				cid=customers.get(num);
			this.setVisible(false);
			name.setText(cid);
			cphno.setText(num+"");
			cart.setVisible(true);
		}
		if(e.getSource()==check) {
			String iid=itemid.getText();
			int q=Integer.parseInt(quant.getText());
			item i=null;
			boolean flag=false;
			for(item x:itemlist)
				if(x.id.equals(iid)) {
					i=x;
					flag=true;
					break;
				}
			if(flag) {
				iname.setText(i.name);
				price=(q*i.cost);
				totprice.setText("Rs. "+price);
				pay.setEnabled(true);
			}
			else {
				iname.setText("Invalid item");
				totprice.setText("Invalid");
				pay.setEnabled(false);
			}
		}
		if(e.getSource()==pay) {
			int d1=JOptionPane.showOptionDialog(cart, "Choose discount(%):", "Offer", 0,
					JOptionPane.INFORMATION_MESSAGE, null, discount, discount[0]);
			JOptionPane.showMessageDialog(cart, "Amount to be paid: Rs. "+(price-(price*discount[d1]/100)), 
					"Bill", JOptionPane.INFORMATION_MESSAGE);
			cart.setVisible(false);
			this.setVisible(true);
		}
	}
}


