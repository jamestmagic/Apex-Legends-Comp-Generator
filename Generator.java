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
import javax.sound.sampled.Clip;
import java.net.URL;

public class Generator extends JPanel implements ActionListener
{
	private ArrayList<Legend> roster;
	private ArrayList<Legend> playerLegends;
	private ArrayList<Legend> dealerLegends;
	//private Win[] confetti;
	private int userIndex;
	private JButton generateButton;
	private JButton standButton;
	private JButton newgameButton;
	private int totalPlayerValue;
	private int totalDealerValue;
	private int points;
	private boolean finish;
	private int winnings;
	private int playerScore;
	private int dealerScore;
	private Color white;
	private int x;
	private int y;
	private int x2;
	private int y2;
	private boolean seeDealer;
	private boolean over21;
	private boolean equal21;
	private boolean win;
	private boolean lose;
	private boolean tie;
	private boolean dealerBust;
	private boolean playerBust;

	public Generator()
	{
		roster = new ArrayList<Legend>();
		roster.add(new Legend(0, "Bloodhound", "recon"));
		roster.add(new Legend(1, "Gibraltar", "defensive"));
		roster.add(new Legend(2, "Lifeline", "support"));
		roster.add(new Legend(3, "Pathfinder", "recon"));
		roster.add(new Legend(4, "Wraith", "offensive"));
		roster.add(new Legend(5, "Bangalore", "offensive"));
		roster.add(new Legend(6, "Caustic", "defensive"));
		roster.add(new Legend(7, "Mirage", "offensive"));
		roster.add(new Legend(8, "Octane", "offensive"));
		roster.add(new Legend(9, "Wattson", "defensive"));
		roster.add(new Legend(10, "Crypto", "recon"));
		roster.add(new Legend(11, "Revenant", "offensive"));
		roster.add(new Legend(12, "Loba", "support"));
		roster.add(new Legend(13, "Rampart", "defensive"));
		roster.add(new Legend(14, "Horizon", "offensive"));
		roster.add(new Legend(15, "Fuse", "offensive"));
		roster.add(new Legend(16, "Valkyrie", "recon"));
		roster.add(new Legend(17, "Seer", "recon"));
		roster.add(new Legend(18, "Ash", "offensive"));
		roster.add(new Legend(19, "Mad Maggie", "offensive"));

		shuffle();

		x = 20;
		y = 150;
		x2 = 20;
		y2 = 400;



		seeDealer = false;
		over21 = false;
		equal21 = false;
		win = false;
		lose = false;
		tie = false;
		dealerBust = false;
		playerBust = false;

		playerLegends = new ArrayList<Legend>();
		playerLegends.add(roster.get(0));
		playerLegends.add(roster.get(1));
		playerLegends.add(roster.get(2));
		//roster.remove(0);
		//roster.remove(0);
		dealerLegends = new ArrayList<Legend>();
		dealerLegends.add(roster.get(0));
		dealerLegends.add(roster.get(1));
		roster.remove(0);
		roster.remove(0);

		generateButton = new JButton("GENERATE NEW COMP");
		generateButton.setBounds(100,100,100,100);
		generateButton.addActionListener(this);
		this.add(generateButton);

		/*standButton = new JButton("Stand");
		standButton.setBounds(230,50,200,30);
		standButton.addActionListener(this);
		this.add(standButton);

		newgameButton = new JButton("New Game");
		newgameButton.setBounds(250,300,200,30);
		newgameButton.addActionListener(this);
		*/

		this.setFocusable(true);

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
		totalPlayerValue = findPlayerValue();
		for(int i = 0;i<playerLegends.size();i++)
		{
			playerLegends.get(i).drawMe(g,x,y);
			x += 500;
		}

/*
		if(seeDealer == false)
		{
			g.setColor(Color.white);
			g.fillRect(100,y2,120,150);
			g.setColor(Color.black);
			g.drawRect(100,y2,120,150);
			g.drawString("Dealer Value: " + dealerLegends.get(0).getValue() , 50,550);
		}

		g.setColor(Color.black);
		g.drawString("Player Value: " + totalPlayerValue , 50,50);
		if(seeDealer == true)
		{
			g.drawString("Dealer Value: " + findDealerValue() , 50,550);
		}

		g.drawString("Player Score: " + playerScore , 600,50);
		g.drawString("Dealer Score: " + dealerScore , 600,550);


		if(tie == true)
		{
			g.drawString("It's a tie!", 700,300);
		}
		if(lose == true)
		{
			g.drawString("You lost!", 700,300);
		}
		if(win == true)
		{
			g.drawString("You won!", 700,300);
		}
		if(dealerBust == true)
		{
			g.drawString("Dealer Bust!",700,300);
		}
		if(playerBust == true)
		{
			g.drawString("Player Bust!",700,300);
		}
		*/
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
			playerLegends.add(roster.get(0));
			playerLegends.add(roster.get(1));
			playerLegends.add(roster.get(2));
    }

	public int findPlayerValue()
    {
    	int total = 0;
    	for(int i = 0; i<playerLegends.size();i++)
    	{
    		total = total + playerLegends.get(i).getValue();
    	}
    	return total;
    }

   	public int findDealerValue()
    {
    	int total = 0;
    	for(int i = 0; i<dealerLegends.size();i++)
    	{
    		total = total + dealerLegends.get(i).getValue();
    	}
    	return total;
    }

	public void choice()
	{
		totalPlayerValue = findPlayerValue();
		if(roster.get(0).getValue() + totalPlayerValue > 21 && totalPlayerValue <= 21 && equal21 == false)
		{
			standsound();
		}

		if(roster.get(0).getValue() + totalPlayerValue <= 21 && totalPlayerValue <= 21)
		{
			hitsound();
		}
	}

	public void actionPerformed(ActionEvent e)
    {

		if(e.getSource() == generateButton)
		{
			shuffle();
		}

		if(e.getSource() == standButton || equal21 == true)
		{
			seeDealer = true;
			totalDealerValue = findDealerValue();
			for(totalDealerValue = findDealerValue();totalDealerValue < 17;totalDealerValue=findDealerValue())
			{
				if(totalDealerValue < 17)
				{
					dealerLegends.add(roster.get(0));
					roster.remove(0);

				}
			}
			totalDealerValue = findDealerValue();
			totalPlayerValue = findPlayerValue();
			if(totalDealerValue >= 17 && totalDealerValue <=21 && totalPlayerValue >= 17 && totalPlayerValue <=21 && totalDealerValue > totalPlayerValue)
			{
				dealerScore++;
				lose = true;
				losesound();
			}
			if(totalDealerValue >= 17 && totalDealerValue <=21 && totalPlayerValue >= 17 && totalPlayerValue <=21 && totalDealerValue < totalPlayerValue)
			{
				playerScore++;
				win = true;
				winsound();
			}
			if(totalDealerValue >= 17 && totalDealerValue <=21 && totalPlayerValue > 21)
			{
				dealerScore++;
				//lose = true;
				playerBust = true;
				losesound();
			}
			if(totalPlayerValue >= 17 && totalPlayerValue <=21 && totalDealerValue > 21)
			{
				playerScore++;
				dealerBust = true;
				winsound();
			}
			if(totalDealerValue >= 17 && totalDealerValue <=21 && totalPlayerValue < 17)
			{
				dealerScore++;
				lose = true;
				losesound();
			}
			if(totalDealerValue == totalPlayerValue)
			{
				tie = true;
			}


			removeAll();
			this.add(newgameButton);

		}
		if(over21 == true)
		{
			dealerScore++;
			removeAll();
			this.add(newgameButton);
			over21 = false;
			//lose = true;
			playerBust = true;
			losesound();
		}
		if(e.getSource() == newgameButton)
		{
			for(int i = 0; i<playerLegends.size(); i++)
			{
				roster.add(playerLegends.get(i));
			}
			for(int i = 0; i<dealerLegends.size(); i++)
			{
				roster.add(dealerLegends.get(i));
			}

			playerLegends.clear();
			dealerLegends.clear();
			shuffle();
			removeAll();

			this.add(standButton);
			this.add(generateButton);
			seeDealer = false;
			over21 = false;
			equal21 = false;
			playerLegends.add(roster.get(0));
			playerLegends.add(roster.get(1));
			roster.remove(0);
			roster.remove(0);
			dealerLegends.add(roster.get(0));
			dealerLegends.add(roster.get(1));
			roster.remove(0);
			roster.remove(0);
			x = 20;
			y = 150;
			x2 = 20;
			y2 = 400;
			totalDealerValue = findDealerValue();
			totalPlayerValue = findPlayerValue();

			win = false;
			lose = false;
			tie = false;
			dealerBust = false;
			playerBust = false;

			choice();
		}



		repaint();
	}


	public void winsound()
	{
		  try

        {

            URL url = this.getClass().getClassLoader().getResource("sounds/win.wav");


            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(url));

            clip.start();

        }

        catch (Exception exc)

        {

            exc.printStackTrace(System.out);

        }
	}

	public void losesound()
	{

		  try

        {

            URL url = this.getClass().getClassLoader().getResource("sounds/lose.wav");


            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(url));

            clip.start();

        }

        catch (Exception exc)

        {

            exc.printStackTrace(System.out);

        }
	}
	public void hitsound()
	{
		  try

        {

            URL url = this.getClass().getClassLoader().getResource("sounds/hit.wav");


            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(url));

            clip.start();

        }

        catch (Exception exc)

        {

            exc.printStackTrace(System.out);

        }
	}
	public void standsound()
	{
		  try

        {

            URL url = this.getClass().getClassLoader().getResource("sounds/stand.wav");


            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(url));

            clip.start();

        }

        catch (Exception exc)

        {

            exc.printStackTrace(System.out);

        }
	}
}
