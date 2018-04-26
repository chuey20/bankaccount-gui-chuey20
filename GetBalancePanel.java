import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetBalancePanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public GetBalancePanel(ArrayList<BankAccount> accts)
	{
		accounts = accts;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblNum = new JLabel("Account Number: ");
		add(lblNum, gbc);
		
		gbc.gridx = 1;
		JTextField txtNum = new JTextField();
		txtNum.setPreferredSize(new Dimension(150, 25));
		add(txtNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton getB  = new JButton("Get Balance");
		getB.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							boolean there = false;
							double bal = 0;
							for(int i = 0; i < accounts.size(); i++) 
							{
								if(accounts.get(i).getAccountNumber() == Double.parseDouble(txtNum.getText()))
								{
									bal = accounts.get(i).getBalance();
									there = true;
								}
							}
							if(!there) {JOptionPane.showMessageDialog(null, "Error. invalid input");}
							else {JOptionPane.showMessageDialog(null, "$"+bal);}
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							e.printStackTrace();
						}
						txtNum.setText("");
					}
			
				});
		add(getB, gbc);
	}
}
