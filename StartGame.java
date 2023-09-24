import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGame implements ActionListener {
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    
    private JLabel cbLabel;
    private JCheckBox option1;
    private JCheckBox option2;
    
    private JLabel rbLabel;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private ButtonGroup rbGroup;
    
    private JLabel txtLabel;
    private JTextField txt;
    private JButton submit;

    
    private JLabel ddLabel;
    private JButton ddButton;
    private JComboBox<String> ddBox;
    
    
    
    // constructor method
    public StartGame() {
        
    } // end of StartGame constructor method
    
    // class methods
    public void outputGUI() {
        JFrame frame = new JFrame("GUI Example"); // create frame window
        JPanel content = new JPanel(); // create content pane
        frame.add(content); // add content frame to window
        
        // clears the layout of the JPanel so that components can be placed using .setBounds(x,y,w,h);
        // content.setLayout(null);
        
        // define JButtons
        buttonA = new JButton("Hello");    
        buttonB = new JButton("World");
        buttonC = new JButton("Quit");
        
        buttonA.setBounds(0,0,100,100);
        
        // attach buttons to ActionListener 
        buttonA.addActionListener(this); // 'this' refers to the current button
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        
        // add buttons to the JPanel
        content.add(buttonA);
        content.add(buttonB);
        content.add(buttonC);
        
        // define JLabel and JCheckBox compoenents
        cbLabel = new JLabel("Select an option: ");
        option1 = new JCheckBox("Option 1");
        option2 = new JCheckBox("Option 2");
        
        // attach check boxes to ActionListner
        option1.addActionListener(this);
        option2.addActionListener(this);
        
        // add check boxes to the JPanel
        content.add(cbLabel);
        content.add(option1);
        content.add(option2);       
        
        // define radio buttons
        rbLabel = new JLabel("Select an answer: ");
        rb1 = new JRadioButton("Answer 1");
        rb2 = new JRadioButton("Answer 2");
        
        // add radio buttons to the group
        rbGroup = new ButtonGroup();
        rbGroup.add(rb1);
        rbGroup.add(rb2);
        
        // attach radio buttons to ActionListener
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        
        // add radio buttons to JPanel
        content.add(rbLabel);
        content.add(rb1);
        content.add(rb2);
        
        // define text field with buttons
        txtLabel = new JLabel("Enter message, click SUBMIT");
        txt = new JTextField(20); // 20 character text field
        submit = new JButton("SUBMIT");
        
        // attach button to ActionListener
        submit.addActionListener(this);

        // add components to JPanel
        content.add(txtLabel);
        content.add(txt);
        content.add(submit);
        
        // define drop-down menu with button
        ddLabel = new JLabel("Choose your favourite subject: ");
        ddButton = new JButton("Select");
        String[] subjects = {"Math", "English", "Science", "Art", "Comp Sci"};
        ddBox = new JComboBox<String>(subjects);
        
        // add components to JPanel
        content.add(ddLabel);
        content.add(ddBox);
        content.add(ddButton);
        
        // add button to ActionListener
        ddButton.addActionListener(this);
        
        // set the layout of the JPanel to a 0x3 grid (any number rows and 3 cols)
        content.setLayout(new GridLayout(0,3));
        
        // set window properties
        frame.setSize(600,400); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack(); // fits all components into the window
        
    } // end of outputGUI method
    
    @Override
    public void actionPerformed(ActionEvent e) { // overwrites method from ActionListener class
        
        // action code for JButtons
        if (e.getSource() == buttonA) {
            System.out.println("You pressed button 'A'");
            //StartGame myWindow = new StartGame();
        }
        else if (e.getSource() == buttonB) {
            System.out.println("You pressed button 'B'");
        }
        else if (e.getSource() == buttonC) {
            System.out.println("Exiting...");
            System.exit(0);
        }
        
        // action code for JCheckBox Option 1
        if (option1.isSelected()) {
            System.out.println("Option 1 selected");
        }
        else {
            System.out.println("Option 1 NOT selected");
        }
        
        // action code for JCheckBox Option 2
        if (option2.isSelected()) {
            System.out.println("Option 2 selected");
        }
        else {
            System.out.println("Option 2 NOT selected");
        }
        
        // action code for JRadioButtons
        if(rb1.isSelected()) {
            System.out.println("Sorry, incorrect.");
            rbLabel.setText("Sorry, incorrect.");
        }
        else if (rb2.isSelected()) {
            System.out.println("Correct!");
            rbLabel.setText("Correct!");
        }
        
        // action code for text field
        if (e.getSource() == submit) {
            System.out.println("Message: " + txt.getText());
        }
        // action code for drop-down box
        if (e.getSource() == ddButton) {
            String response = "Your choice: " + ddBox.getSelectedItem().toString();
            ddLabel.setText(response); // update the label text
        }
        
    } // end of actionPerformed method

}

/* 
public class StartGame {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello!");
    private JButton buttonA = new JButton("A");

    StartGame() {
        label.setBounds(0,0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        buttonA.setBounds(0, 0, 200, 200);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

*/