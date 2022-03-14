import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import java.awt.Font;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.awt.event.*;
import javax.swing.*;

public class Generator extends JPanel implements ActionListener, KeyListener
{
	private ArrayList<Legend> roster;
	private ArrayList<Legend> playerLegends;
	private ArrayList<Legend> dealerLegends;
	//private Win[] confetti;
	private int userIndex;
	private JButton generateButton;
	private JComboBox<String> typeSelection1;
	private JComboBox<String> typeSelection2;
	private JComboBox<String> typeSelection3;

	private Color white;
	Font apexFont;

	private int x;
	private int x2;
	private int y;
	private int y2;

	public Generator()
	{
		this.setLayout(null);
		roster = new ArrayList<Legend>();
		roster.add(new Legend(0, "Bloodhound", "Recon"));
		roster.add(new Legend(1, "Gibraltar", "Defensive"));
		roster.add(new Legend(2, "Lifeline", "Support"));
		roster.add(new Legend(3, "Pathfinder", "Recon"));
		roster.add(new Legend(4, "Wraith", "Offensive"));
		roster.add(new Legend(5, "Bangalore", "Offensive"));
		roster.add(new Legend(6, "Caustic", "Defensive"));
		roster.add(new Legend(7, "Mirage", "Offensive"));
		roster.add(new Legend(8, "Octane", "Offensive"));
		roster.add(new Legend(9, "Wattson", "Defensive"));
		roster.add(new Legend(10, "Crypto", "Recon"));
		roster.add(new Legend(11, "Revenant", "Offensive"));
		roster.add(new Legend(12, "Loba", "Support"));
		roster.add(new Legend(13, "Rampart", "Defensive"));
		roster.add(new Legend(14, "Horizon", "Offensive"));
		roster.add(new Legend(15, "Fuse", "Offensive"));
		roster.add(new Legend(16, "Valkyrie", "Recon"));
		roster.add(new Legend(17, "Seer", "Recon"));
		roster.add(new Legend(18, "Ash", "Offensive"));
		roster.add(new Legend(19, "Mad Maggie", "Offensive"));







		apexFont = new Font("Apex", Font.PLAIN, 50);


		generateButton = new JButton("GENERATE NEW COMP");
		generateButton.setFont(apexFont);
		generateButton.setForeground(Color.lightGray);
		generateButton.setBackground(Color.darkGray);
		generateButton.setBounds(500,650,500,100);
		generateButton.addActionListener(this);
		generateButton.addMouseListener(new MouseAdapter() {
         Color fcolor = generateButton.getForeground();
				 Color bcolor = generateButton.getBackground();
         public void mouseEntered(MouseEvent me) {
            fcolor = generateButton.getForeground();
            generateButton.setBackground(new Color(123,10,33)); // change the color to red when mouse over a button
         }
         public void mouseExited(MouseEvent me) {
            generateButton.setBackground(bcolor);
         }
		});
		generateButton.setLayout(null);
		this.add(generateButton);


		String types[] = {"Any", "Recon", "Offensive", "Defensive", "Support"};

		typeSelection1 = new JComboBox<>(types);
		typeSelection1.setBounds(225, 50, 100, 25);
		typeSelection1.addActionListener(this);
		this.add(typeSelection1);
		typeSelection1.setVisible(true);

		typeSelection2 = new JComboBox<>(types);
		typeSelection2.setBounds(725, 50, 100, 25);
		typeSelection2.addActionListener(this);
		this.add(typeSelection2);
		typeSelection2.setVisible(true);

		typeSelection3 = new JComboBox<>(types);
		typeSelection3.setBounds(1225, 50, 100, 25);
		typeSelection3.addActionListener(this);
		this.add(typeSelection3);
		typeSelection3.setVisible(true);

		shuffle();

		this.setFocusable(true);
		addKeyListener(this);

	}

	public Dimension getPreferredSize()
    {
        //Sets the size of the panel
        return new Dimension(1920,1080);
    }

	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        g.setColor(Color.gray);
        g.fillRect(0,0,1920,1080);

				x = 150;
				y = 200;
				x2 = 20;
				y2 = 350;

				for(int i = 0;i<playerLegends.size();i++)
				{
					playerLegends.get(i).drawMe(g,x,y);
					x += 500;
				}

				g.drawString("Press and release SPACE for more randomized comp", 0, 0);
	}

	public void shuffle()
    {
			for(int i = 0;i<roster.size();i++)
			{
				int j = (int)(Math.random()*roster.size());
				Legend temp = roster.get(i);
				roster.set(i,roster.get(j));
				roster.set(j,temp);
			}

			playerLegends = new ArrayList<Legend>();
			//First Legend
			for(int i = 0;i<roster.size();i++)
			{
				if(typeSelection1.getItemAt(typeSelection1.getSelectedIndex()).equals("Any")){
					playerLegends.add(roster.get(i));
					break;
				}
				if(roster.get(i).getType().equals(typeSelection1.getItemAt(typeSelection1.getSelectedIndex()))){
					playerLegends.add(roster.get(i));
					break;
				}
			}
			//Second Legend

			for(int i = 0;i<roster.size();i++)
			{
				if(typeSelection2.getItemAt(typeSelection2.getSelectedIndex()).equals("Any") &&
				playerLegends.get(0).getName() != roster.get(i).getName()){
					playerLegends.add(roster.get(i));
					break;
				}
				if(roster.get(i).getType().equals(typeSelection2.getItemAt(typeSelection2.getSelectedIndex())) &&
				playerLegends.get(0).getName() != roster.get(i).getName()){
					playerLegends.add(roster.get(i));
					break;
				}
			}
			//Third Legend
			for(int i = 0;i<roster.size();i++)
			{
				if(typeSelection3.getItemAt(typeSelection3.getSelectedIndex()).equals("Any") &&
				playerLegends.get(1).getName() != roster.get(i).getName() &&
				playerLegends.get(0).getName() != roster.get(i).getName()){
					playerLegends.add(roster.get(i));
					break;
				}
				if(roster.get(i).getType().equals(typeSelection3.getItemAt(typeSelection3.getSelectedIndex())) &&
				playerLegends.get(1).getName() != roster.get(i).getName() &&
				playerLegends.get(0).getName() != roster.get(i).getName()){
					playerLegends.add(roster.get(i));
					break;
				}
			}
    }




	public void actionPerformed(ActionEvent e){
		if(e.getSource() == generateButton)
		{
			shuffle();
		}
		repaint();
	}

	public void keyPressed(KeyEvent e){
		if( e.getKeyCode() == 32 ) //spacebar
		{
		 	shuffle();
		}
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

}
