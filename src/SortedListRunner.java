
import javax.swing.JFrame;


public class SortedListRunner 
{
    public static void main(String[] args) 
    {
        SortedListFrame MySortedListFrame = new SortedListFrame();

        MySortedListFrame.SetSortedListFrameDisplay();

        MySortedListFrame.setSize(900, 500);

        MySortedListFrame.setResizable(false);

        MySortedListFrame.setLocationRelativeTo(null);
        
        MySortedListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MySortedListFrame.setVisible(true);        
    }
}
