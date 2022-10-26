package airlinetickethandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 * @author Stelios Papakosmas, AM: 171085
 */
public class NewTicketWindow extends JFrame{
    
    JFrame frame = new JFrame();
    private JLabel label;
    private JButton backBtn;
    private JButton saveBtn;
    
    private JLabel ticketIdlb;
    private JLabel issueDatelb;
    private JLabel clientNamelb;
    private JLabel itinerarylb;
    private JLabel costlb;
    private JLabel luggagelb;
    private JLabel luggageNumlb;
    private JLabel ticketTypelb;
    private JLabel foodlb;
    private JLabel foodTypelb;
    private JLabel gatelb;
    private JLabel seatlb;
    private JLabel boardingTimelb;    
    
    private JTextField ticketIdTf;
    private JTextField issueDateTf;
    private JTextField clientNameTf;
    private JTextField itinerarydTf;
    private JTextField cosTf;
    private JTextField luggageNumTf;
    private JTextField gateTf;
    private JTextField seatTf;
    private JTextField boardingTimeTf;

    private ArrayList<User> usersList;

    
    public NewTicketWindow(){
        super();//implicit call
        label = new JLabel("New Ticket");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        backBtn = new JButton("Back");
        saveBtn = new JButton("Save");
        
        
        ticketIdlb = new JLabel("Ticket ID");
        issueDatelb = new JLabel(" Issue date");
        clientNamelb = new JLabel(" Name");
        itinerarylb = new JLabel(" Itinerary");
        costlb = new JLabel(" Cost");
        luggagelb = new JLabel(" Luggage");
        foodlb = new JLabel("Food");
        foodTypelb = new JLabel("Foot type");
        gatelb = new JLabel("  Gate");
        seatlb = new JLabel(" Seat");
        
        ticketIdTf = new JTextField(10);
        issueDateTf = new JTextField(10);
        clientNameTf = new JTextField(10);
        itinerarydTf = new JTextField(10);
        cosTf = new JTextField(10);
        gateTf = new JTextField(10);
        seatTf = new JTextField(10);
        
        usersList = new ArrayList();

        
    }
    
    void prepareUI(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //create panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        bottomPanel.add(backBtn);
        bottomPanel.add(saveBtn);
        topPanel.add(label);
        
        JRadioButton yesButton = new JRadioButton("Yes"); 	
        JRadioButton noButton = new JRadioButton("No"); 
        
                //ορισμός χαρακτηριστικών	
        luggagelb.setBounds(420, 110, 100, 25);
        yesButton.setBounds(380, 140, 100, 25);		
        noButton.setBounds(480, 140, 100, 25);	
        yesButton.setSelected(true);         
        
        JRadioButton noFoodButton = new JRadioButton("No food"); 	
        JRadioButton cheapMealButton = new JRadioButton("Pasta 5$");         
        JRadioButton mediumMealButton = new JRadioButton("Gyros 10$"); 	
        JRadioButton expensiveMealButton = new JRadioButton("Shrimp 20$"); 
        
                //Δημιουργώ την ομάδα (group) στην οποία θα ανήκουν τα παραπάνω κουμπιά.
        ButtonGroup group = new ButtonGroup();
        group.add(yesButton);		
        group.add(noButton);		
        
        add(luggagelb);
        add(yesButton);		
        add(noButton);	

        ButtonGroup group2 = new ButtonGroup();
        group2.add(noFoodButton);		
        group2.add(cheapMealButton);
        group2.add(mediumMealButton);		
        group2.add(expensiveMealButton);        
        //πρόσθεση αντικειμένων στο παράθυρο με τη μέθοδο add.	
        add(foodTypelb);
        add(noFoodButton);		
        add(cheapMealButton);	
        add(mediumMealButton);		
        add(expensiveMealButton);	
        
        //ορισμός χαρακτηριστικών	
        foodTypelb.setBounds(420, 210, 100, 25);
        noFoodButton.setBounds(250, 240, 100, 25);
        cheapMealButton.setBounds(350, 240, 100, 25);		
        mediumMealButton.setBounds(450, 240, 100, 25);	        
        expensiveMealButton.setBounds(550, 240, 100, 25);	
        expensiveMealButton.setSelected(true);

        
        centerPanel.add(ticketIdlb);
        centerPanel.add(ticketIdTf);
        centerPanel.add(issueDatelb);
        centerPanel.add(issueDateTf);
        centerPanel.add(clientNamelb);
        centerPanel.add(clientNameTf);
        centerPanel.add(itinerarylb);
        centerPanel.add(itinerarydTf);
        centerPanel.add(costlb);
        centerPanel.add(cosTf);
        centerPanel.add(gatelb);
        centerPanel.add(gateTf);
        centerPanel.add(seatlb);
        centerPanel.add(seatTf);         

        
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(topPanel, BorderLayout.PAGE_START);
        
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            exitApp();
        }
        });
        
        backBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainFrame frame = new MainFrame();
            frame.prepareUI();

        }
        });  
        
            saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String luggageVl = "NO";
                String foodVl = "Shrimp 20$";
                
                String ticketIdVl = ticketIdTf.getText();
                String issueDateVl = issueDateTf.getText();
                String clientNameVl = clientNameTf.getText();
                String itineraryVl = itinerarydTf.getText();
                String costVl = cosTf.getText();
                String gateVl = gateTf.getText();
                String seatVl = seatTf.getText();       
                
                if(yesButton.isSelected()){
                luggageVl = "YES";
                }
                if(noButton.isSelected()){
                luggageVl = "NO";
                }
                
                if(noFoodButton.isSelected()){
                foodVl = "NO food";
                }
                if(cheapMealButton.isSelected()){
                foodVl = "Pasta 5$";
                }
                if(mediumMealButton.isSelected()){
                foodVl = "Gyros 10$";
                }
                if(expensiveMealButton.isSelected()){
                foodVl = "Shrimp 20$";
                }

                User user = new User(ticketIdVl, issueDateVl, clientNameVl, itineraryVl, costVl, luggageVl, gateVl, seatVl, foodVl);
                usersList.add(user);
                
                if (usersList.isEmpty()) {
                    JOptionPane.showMessageDialog(NewTicketWindow.this, 
                            "Nothing to save",
                            "File access error",
                            JOptionPane.ERROR_MESSAGE);
                    return;                    
                }
                               
                String fileName = "C:\\Users\\stpap\\Documents\\NetBeansProjects\\AirlineTicketHandler\\src\\airlinetickethandler\\AirplaneTickets.txt"; 
                saveUsersList(fileName);
                
                dispose();
                MainFrame frame = new MainFrame();
                frame.prepareUI();
            }
        });
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //setup the frame
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("New Ticket Window");
        this.setVisible(true);
    }

    
    private void exitApp() {
    int i = JOptionPane.showConfirmDialog(NewTicketWindow.this, "Do you want to exit the app?");
    if (i == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }
    
    
        private void saveUsersList(String fileName) {       
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(fileName, true));
            
            for(User user : usersList) {
                file.write(user.toString());
                file.newLine();
            }
            
            file.close();
                        
        } catch (IOException ex) {
            
        }
        
        
    }
    
}
