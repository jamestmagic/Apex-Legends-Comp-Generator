import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Legend
{
	private int value;
	private String name;
	private String type;
	private BufferedImage legendImage;
  private BufferedImage typeImage;

	public Legend(int value, String name, String type)
	{
		this.value = value;
		this.name = name;
		this.type = type;

		if(type.equals("support"))
		{
			try
			{
				typeImage = ImageIO.read(new File("support.png"));
			}catch(IOException e) {}
		}
		if(type.equals("offensive"))
		{
			try
			{
				typeImage = ImageIO.read(new File("offensive.png"));
			}catch(IOException e) {}
		}
		if(type.equals("defensive"))
		{
			try
			{
				typeImage = ImageIO.read(new File("defensive.png"));
			}catch(IOException e) {}
		}
		if(type.equals("recon"))
		{
			try
			{
				typeImage = ImageIO.read(new File("recon.png"));
			}catch(IOException e) {}
		}
    //-------------------------------------------------------------------------

    if(name.equals("Bloodhound"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Bloodhound.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Gibraltar"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Gibraltar.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Lifeline"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Lifeline.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Pathfinder"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Pathfinder.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Wraith"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Wraith.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Bangalore"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Bangalore.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Caustic"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Caustic.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Mirage"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Mirage.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Octane"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Octane.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Wattson"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Wattson.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Crypto"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Crypto.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Revenant"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Revenant.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Loba"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Loba.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Rampart"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Rampart.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Horizon"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Horizon.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Fuse"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Fuse.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Valkyrie"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Valkyrie.png"));
			}catch(IOException e) {}
		}
    if(name.equals("Seer"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Seer.png"));
			}catch(IOException e) {}
		}
		if(name.equals("Ash"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Ash.png"));
			}catch(IOException e) {}
		}
		if(name.equals("Mad Maggie"))
		{
			try
			{
				legendImage = ImageIO.read(new File("Legends/Mad Maggie.png"));
			}catch(IOException e) {}
		}
	}

	public void drawMe(Graphics g, int x, int y)
	{
		//card
		/*g.setColor(Color.white);
		g.fillRect(x,y,652,729);
		g.setColor(Color.black);
		g.drawRect(x,y,120,150);
		*/
		//type
    g.drawImage(legendImage,x,y,null);
		g.drawImage(typeImage,x,y-75,null);

		//set up font and color
		Font font = new Font("Apex", Font.PLAIN, 50);
		g.setFont(font);
		g.setColor(Color.black);


		//draw name of card
		g.drawString(name,x+60,y-25);

	}

	public int getValue()
	{
		return value;
	}
}
