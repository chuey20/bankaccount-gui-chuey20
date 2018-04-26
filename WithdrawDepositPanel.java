import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WithdrawDepositPanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public WithdrawDepositPanel(ArrayList<BankAccount> accts)
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
		JLabel lblAmount = new JLabel("Amount: ");
		add(lblAmount, gbc);
		
		gbc.gridx = 1;
		JTextField txtAmount = new JTextField();
		txtAmount.setPreferredSize(new Dimension(150, 25));
		add(txtAmount, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JCheckBox chkWithdraw = new JCheckBox("Withdraw");
		add(chkWithdraw, gbc);
		
		gbc.gridx = 1;
		JCheckBox chkDeposit = new JCheckBox("Deposit");
		add(chkDeposit, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton submit = new JButton("submit");
		submit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						try
						{
							int index = -1;
							
							for(int i = 0; i < accounts.size(); i++)
							{
								if(Double.parseDouble(txtNum.getText()) == accounts.get(i).getAccountNumber())
								{
									index = i;
								}
							}
							if(chkWithdraw.isSelected() ^ chkDeposit.isSelected())
							{
								if(chkWithdraw.isSelected())
								{
									accounts.get(index).withdraw(Double.parseDouble(txtAmount.getText()));
								}
								else
								{
									accounts.get(index).deposit(Double.parseDouble(txtAmount.getText()));
								}
								JOptionPane.showMessageDialog(null, "Transaction complete");
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							
						
						}
	
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
						}
						
						txtNum.setText("");
						txtAmount.setText("");
						chkWithdraw.setSelected(false);
						chkDeposit.setSelected(false);
					}
			
				});
				
		add(submit, gbc);
		
	}
}
