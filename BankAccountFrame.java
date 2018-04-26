import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BankAccountFrame extends JFrame
{

	public BankAccountFrame() 
	{
		setTitle("Huey Banking");
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		ArrayList<BankAccount> accounts = new ArrayList<>();
		
		JMenuBar menu = new JMenuBar();
		JMenuItem home = new JMenuItem("Home");
		JMenu acct = new JMenu("Account");
		JMenu trans = new JMenu("Transaction");
		
		JMenuItem add = new JMenuItem("Add Account");
		JMenuItem remove = new JMenuItem("Remove Account");
		JMenuItem find = new JMenuItem("Find Account");
		JMenuItem wd = new JMenuItem("Withdraw/Deposit");
		JMenuItem transfer = new JMenuItem("Transfer");
		JMenuItem getBalance = new JMenuItem("Get Balance");
		acct.add(add);
		acct.add(remove);
		acct.add(find);
		trans.add(wd);
		trans.add(transfer);
		trans.add(getBalance);
		
		menu.add(acct);
		menu.add(trans);
		menu.add(home);
		setJMenuBar(menu);
		
		CreateAccountPanel createPanel = new CreateAccountPanel(accounts);
		FindAccountPanel findPanel = new FindAccountPanel(accounts);
		GetBalancePanel getPanel = new GetBalancePanel(accounts);
		HomePanel homePanel = new HomePanel();
		RemoveAccountPanel removePanel = new RemoveAccountPanel(accounts);
		TransferPanel transferPanel = new TransferPanel(accounts);
		WithdrawDepositPanel wdPanel = new WithdrawDepositPanel(accounts);
		
		overall.add(createPanel, "Add Account");
		overall.add(findPanel, "Find Account");
		overall.add(getPanel, "Get Account Balance");
		overall.add(homePanel, "Home");
		overall.add(transferPanel, "Transfer");
		overall.add(wdPanel, "Withdraw/Deposit");
		overall.add(removePanel, "Remove Account");
		cl.show(overall, "Home");
		add(overall);
		setBounds(400, 300, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Add Account");
			}
			
		});
		remove.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Remove Account");
			}
			
		});
		find.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Find Account");
			}
			
		});
		wd.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Withdraw/Deposit");
			}
			
		});
		transfer.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Transfer");
			}
			
		});
		getBalance.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Get Account Balance");
			}
			
		});
		home.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "Home");
			}
			
		});
	}
	
	public static void main(String[] args)
	{
		new BankAccountFrame();
	}
}
