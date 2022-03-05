import javax.swing.JFrame;
public class Runner
{
    public static void main(String args[])
    {
        Generator game = new Generator();
        JFrame frame = new JFrame("Random Legend Generator");

        frame.add(game);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);

        //game.animate();
    }
}
