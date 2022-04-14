
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class SortedListFrame extends JFrame
{
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel displayPanel;
    private JPanel searchPanel;
    
    private JTextArea displayArea;
    private JScrollPane displayScrollPane;
    
    private JTextField inputTextField;
    private JButton addToListButton;
    
    private JTextField searchTextField;
    private JButton searchListButton;
    
    private ArrayList<String> sortedStringArray;
    
    public SortedListFrame()
    {
        setTitle("Sorted List Binary Search");
        
        sortedStringArray = new ArrayList<>();
        stringPosition = 0;
    }
    
    public void SetSortedListFrameDisplay()
    {
        mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
        createInputPanel();
        createDisplayPanel();
        createSearchPanel();
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(displayPanel, BorderLayout.CENTER);
        mainPanel.add(searchPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }

    private void createInputPanel() 
    {
        inputPanel = new JPanel();
        
        Font inputPanelFont  = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
                
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border blueTitledBorder = BorderFactory.createTitledBorder(blueLineBorder, "Input Panel", TitledBorder.LEADING, TitledBorder.TOP, inputPanelFont);
        
        inputPanel.setBorder(blueTitledBorder);
                   
        inputPanel.setFont(inputPanelFont);
        
        GridBagLayout productInputGridBagLayout = new GridBagLayout();

        inputPanel.setLayout(productInputGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();

        inputTextField = new JTextField(30);
        inputTextField.setFont(inputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        
        bagConstraints1.insets = new Insets(10, 30, 10, 10);
        bagConstraints1.anchor = GridBagConstraints.WEST;
        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 0;
        
        inputPanel.add(inputTextField, bagConstraints1);
        
        addToListButton = new JButton("Add String to List");
        addToListButton.setFont(inputPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 0;
    
        addToListButton.addActionListener(ae -> addToListButtonClicked());
                
        inputPanel.add(addToListButton, bagConstraints1);
    }

    private void createDisplayPanel() 
    {
        displayPanel = new JPanel();

        Font textAreaFont  = new Font(Font.MONOSPACED, Font.PLAIN, 22);
        
        displayArea = new JTextArea(11, 67);
        displayArea.setFont(textAreaFont);
        displayArea.setEditable(false);
        
        displayScrollPane = new JScrollPane(displayArea);
        displayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        displayScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        displayPanel.add(displayScrollPane);
    }
    
    private void createSearchPanel() 
    {
        searchPanel = new JPanel();
        
        Font searchPanelFont  = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
                
        Border blueLineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
        Border blueTitledBorder = BorderFactory.createTitledBorder(blueLineBorder, "Search List Panel", TitledBorder.LEADING, TitledBorder.TOP, searchPanelFont);
        
        searchPanel.setBorder(blueTitledBorder);
                   
        searchPanel.setFont(searchPanelFont);
        
        GridBagLayout productInputGridBagLayout = new GridBagLayout();

        searchPanel.setLayout(productInputGridBagLayout);
                
        GridBagConstraints bagConstraints1 = new GridBagConstraints();

        searchTextField = new JTextField(30);
        searchTextField.setFont(searchPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.NONE;
        
        bagConstraints1.insets = new Insets(10, 30, 10, 10);
        bagConstraints1.anchor = GridBagConstraints.WEST;
        bagConstraints1.gridx = 0;
        bagConstraints1.gridy = 0;
        
        searchPanel.add(searchTextField, bagConstraints1);
        
        searchListButton = new JButton("Enter Search String");
        searchListButton.setFont(searchPanelFont);
        
        bagConstraints1.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints1.gridx = 1;
        bagConstraints1.gridy = 0;
    
        searchListButton.addActionListener(ae -> searchButtonClicked());
                
        searchPanel.add(searchListButton, bagConstraints1);
    }
        
    private boolean stringFound;
    
    private int binarySearch(String newString, int low, int high) 
    {
        int mid = 0;
        stringFound = false;
        //if(low == 0 && high == 0) return 0;
        
        // Repeat until the pointers low and high meet each other
        while (low <= high) 
        {
          // get index of mid element
            mid = low + (high - low) / 2;

            //JOptionPane.showMessageDialog(null, "Before => low = " + low + " high = " + high + " mid = " + mid);
            
            // if element to be searched is the mid element
            if (sortedStringArray.get(mid).equals(newString))
            {
                stringFound = true;
                return mid;
            }

            // if element is less than mid element
            // search only the left side of mid
            if (sortedStringArray.get(mid).compareTo(newString) < 0)
            {
                low = mid + 1;
            }

            // if element is greater than mid element
            // search only the right side of mid
            else
            {
                high = mid - 1;
            }
            
            //JOptionPane.showMessageDialog(null, "After => low = " + low + " high = " + high + " mid = " + mid);
        }

        return low;
    }

    private int stringPosition;
    
    private void addToListButtonClicked() 
    {
        if(inputTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Input String for Addition");
            return;
        }
        
        sortedStringArray.add(inputTextField.getText());
        displayArea.append((stringPosition + 1) + ") " + inputTextField.getText() + "\n");
        stringPosition++;
        inputTextField.setText("");
    }
    
    private void DisplaySortedStringList()
    {
        displayArea.setText("");
        
        for(String sortedString : sortedStringArray)
        {
            displayArea.append(sortedString + "\n");
        }
    }

    private void searchButtonClicked() 
    {
        if(searchTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Input Search String");
            return;
        }
                
        int indexToSerach = binarySearch(searchTextField.getText(), 0, sortedStringArray.size() - 1);
        
        if(stringFound == true)
        {
            JOptionPane.showMessageDialog(null, String.format("The String is found at position %s in the List", (indexToSerach + 1)));
        }
        else
        {
            JOptionPane.showMessageDialog(null, String.format("The New String should be inserted at position %s in the List", (indexToSerach + 1)));
        }
    }
}
