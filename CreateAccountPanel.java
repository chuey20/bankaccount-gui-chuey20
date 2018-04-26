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

public class CreateAccountPanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public CreateAccountPanel(ArrayList<BankAccount> accts)
	{
		accounts = accts;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		
		gbc.gridx++;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(150, 25));
		add(txtName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblDeposit = new JLabel("Initial Deposit: ");
		add(lblDeposit, gbc);
		
		gbc.gridx++;
		JTextField txtDeposit = new JTextField();
		txtDeposit.setPreferredSize(new Dimension(150, 25));
		add(txtDeposit, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel type = new JLabel("Account Type: ");
		add(type, gbc);
		
		gbc.gridx++;
		String[] acct = {"Checking", "Savings"};
		JList<String> acctList = new JList<String>(acct);
		JScrollPane choice = new JScrollPane(acctList);
		choice.setPreferredSize(new Dimension(150, 40));
		add(choice, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton addAccount = new JButton("submit");
		addAccount.addActionListener(new ActionListener()
				{
	
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							if(acctList.getSelectedIndex() == -1  || txtName.getText().equals("") || txtName.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							}
							else if(acctList.getSelectedIndex() == 0)
							{
								BankAccount add = new CheckingAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), 1, 1, 1);
								accounts.add(add);
								JOptionPane.showMessageDialog(null, "Account created");
								
							}
							else if(acctList.getSelectedIndex() == 1)
							{
								BankAccount add = new SavingsAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), 1, 1, 1);
								accounts.add(add);
								JOptionPane.showMessageDialog(null, "Account created");
							}
							
							
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid input.");
							ex.printStackTrace();
						}
						txtName.setText("");
						txtDeposit.setText("");
						acctList.clearSelection();
					}
			
				});
		add(addAccount, gbc);
	}
}