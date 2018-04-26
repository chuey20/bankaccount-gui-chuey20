import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TransferPanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public TransferPanel(ArrayList<BankAccount> accts)
	{
		accounts = accts;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblAccount1 = new JLabel("Transfer from (account number): ");
		add(lblAccount1, gbc);
		
		gbc.gridx++;
		JTextField txtNum1 = new JTextField();
		txtNum1.setPreferredSize(new Dimension(150, 25));
		add(txtNum1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblAccount2 = new JLabel("Transfer to (account number): ");
		add(lblAccount2, gbc);
		
		gbc.gridx++;
		JTextField txtNum2 = new JTextField();
		txtNum2.setPreferredSize(new Dimension(150, 25));
		add(txtNum2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblAmount = new JLabel("Amount: ");
		add(lblAmount, gbc);
		
		gbc.gridx++;
		JTextField txtAmount = new JTextField();
		txtAmount.setPreferredSize(new Dimension(150, 25));
		add(txtAmount, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton transfer = new JButton("submit");
		transfer.addActionListener(new ActionListener()
				{
	
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							if(txtNum1.getText().equals(null) || txtNum2.getText().equals(null) || txtAmount.getText().equals(null))
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							else
							{	
								int index1 = -1;
								int index2 = -1;
								for(int i = 0; i < accounts.size(); i++)
								{
									if(Double.parseDouble(txtNum1.getText()) == accounts.get(i).getAccountNumber())
									{
										index1= i;
									}
									else if(Double.parseDouble(txtNum2.getText()) == accounts.get(i).getAccountNumber())
									{
										index2 = i;
									}
								}
								accounts.get(index1).transfer(accounts.get(index2), Double.parseDouble(txtAmount.getText()));
								JOptionPane.showMessageDialog(null, "Transaction complete");
							}
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							ex.printStackTrace();
						}
						
						txtNum1.setText("");
						txtNum2.setText("");
						txtAmount.setText("");
					}
			
				});
		add(transfer, gbc);
	}
}
