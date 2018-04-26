import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel
{
	public HomePanel()
	{
		setSize(400, 500);
		ImageIcon image = new ImageIcon("pic1.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		add(label);
		
	}
}
