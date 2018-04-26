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

public class RemoveAccountPanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public RemoveAccountPanel(ArrayList<BankAccount> accts)
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
		gbc.gridy = 0;
		JTextField txtNum = new JTextField();
		txtNum.setPreferredSize(new Dimension(150, 25));
		add(txtNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton remove = new JButton("remove");		
		remove.addActionListener( new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							boolean there = false;
							for(int i = 0; i < accounts.size(); i++) 
							{
								if(accounts.get(i).getAccountNumber() == Double.parseDouble(txtNum.getText()))
								{
									accounts.remove(i);
									there = true;
								}
							}
							if(!there) {JOptionPane.showMessageDialog(null, "Error. invalid input");}
							else{JOptionPane.showMessageDialog(null, "Account removed");}
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							e.printStackTrace();
						}
						
						txtNum.setText("");
	
					}
			
				});
		add(remove, gbc);
	}
}
