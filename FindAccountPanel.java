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

public class FindAccountPanel extends JPanel
{
	ArrayList<BankAccount> accounts;
	public FindAccountPanel(ArrayList<BankAccount> acct)
	{
		accounts = acct;
		setSize(400, 500);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = gbc.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Account Name: ");
		add(lblName, gbc);
		
		gbc.gridx = 1;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(150, 25));
		add(txtName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton find = new JButton("Find Accounts");
		find.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						if(txtName.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Error. Invalid Input.");
							
						}
						else
						{
							String show = "Accounts: ";
							for(int i = 0; i < accounts.size(); i++)
							{
								if(accounts.get(i).getName().equals(txtName.getText()))
								{
									show+="\n"+accounts.get(i).getName() + " " + accounts.get(i).getAccountNumber();
								}
							}
							if(!show.equals("Accounts: "))
							{JOptionPane.showMessageDialog(null, show);}
							else
							{
								JOptionPane.showMessageDialog(null, "No accounts in that name");
							}
						}
						txtName.setText("");
					}
			
				});
		add(find, gbc);
	}
}
