package airlinetickethandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author stpap
 */
public class MainFrame extends JFrame {
    
    private JButton newTicketBtn;
    private JButton ticketListBtn;
    private JButton infoBtn;
    private JButton exitBtn;
    
        public MainFrame() {
        super();//implicit call

        newTicketBtn = new JButton("New Ticket");
        ticketListBtn = new JButton("Ticket List");
        infoBtn = new JButton("Info");
        exitBtn = new JButton("Exit");
    }

    void prepareUI() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //create panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        topPanel.add(newTicketBtn);
        topPanel.add(ticketListBtn);
        topPanel.add(infoBtn);
        topPanel.add(exitBtn);
        
        this.add(topPanel, BorderLayout.PAGE_START);      
        
        newTicketBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            NewTicketWindow myWindow = new NewTicketWindow();
            myWindow.prepareUI();

        }
        });          
        
        ticketListBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            TicketListWindow myWindow = new TicketListWindow();
            myWindow.prepareUI();

        }
        });         

        infoBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            InfoWindow myWindow = new InfoWindow();
            myWindow.prepareUI();

        }
        });      
        
        exitBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exitApp();
        }
        });        

        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            exitApp();
        }
        });

        //setup the frame
        this.setSize(780, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Airline ticket starting page");
        this.setVisible(true);
    }
    
        private void exitApp() {
        int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the app?");
        if (i == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
