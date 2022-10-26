package airlinetickethandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author Stelios Papakosmas, AM: 171085
 */
public class TicketListWindow extends JFrame{
    
    JFrame frame = new JFrame();
    private JLabel label;
    private JButton backBtn;
    private JButton newTicketBtn;
    private JButton refreshBtn;
    private ArrayList<User> usersList;

    
    private JTextArea area;

    public TicketListWindow(){
        super();//implicit call
        label = new JLabel("Ticket List");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        backBtn = new JButton("Back");
        newTicketBtn = new JButton("New Ticket");
        refreshBtn = new JButton("Refresh");
        
        usersList = new ArrayList();
        
        area = new JTextArea();
    }
    
    void prepareUI(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //create panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        bottomPanel.add(backBtn);
        bottomPanel.add(newTicketBtn);  
        bottomPanel.add(refreshBtn);                
        topPanel.add(label);
        
        this.add(area, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.PAGE_END);
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
        
        newTicketBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            NewTicketWindow myWindow = new NewTicketWindow();
            myWindow.prepareUI();
        }
        }); 
        
        refreshBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            area.getText();
            area.setText("");
            String fileName = "C:\\Users\\stpap\\Documents\\NetBeansProjects\\AirlineTicketHandler\\src\\airlinetickethandler\\AirplaneTickets.txt"; 
            loadFromFile(fileName);
        }
        });
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //setup the frame
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Ticket List Window");
        this.setVisible(true);
    }

    private void loadFromFile(String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            String line = "";
            //bazoume se array oti lambanoume apo to file
            String[] token;
            User user;
            
            while(reader.ready()){  //diabazei
                line = reader.readLine();
                //spame se kommatia thn grammh kai ta bazoume sto array kai ta pairnoume meta
                token = line.split("\t");
                
                if (token.length == 9){
                    //eftiaxa antikeimena users
                    user = new User(token[0], token[1], token[2], token[3], token[4], token[5], token[6], token[7], token[8]);
                    usersList.add(user);
                }
            }
            for (User user1: usersList){
                area.append(user1.toString());
                area.append("\n");
            }
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
        }
        }
    
    private void exitApp() {
    int i = JOptionPane.showConfirmDialog(TicketListWindow.this, "Do you want to exit the app?");
    if (i == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }
}

