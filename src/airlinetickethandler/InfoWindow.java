package airlinetickethandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Stelios Papakosmas, AM: 171085
 */
public class InfoWindow extends JFrame{
    
    JFrame frame = new JFrame();
    private JLabel label;
    private JLabel infolb;
    private JLabel imagelb;
    private JButton backBtn;
    
    public InfoWindow(){
        super();//implicit call
        label = new JLabel("Info");
        infolb = new JLabel("<HTML>Project Name: AirlineTicketHandler<br> Full Name: Papakosmas Stylianos<br> AM: 171085<br> Release date: 9/6/2021<br></HTML> ");
        infolb.setFont(new Font("Serif", Font.PLAIN, 18));
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        imagelb = new JLabel();
        imagelb.setIcon(new ImageIcon("C:\\Users\\stpap\\Documents\\NetBeansProjects\\AirlineTicketHandler\\src\\airlinetickethandler\\DesktopPhoto.jpg"));
        backBtn = new JButton("Back");
    }
    
    void prepareUI(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //create panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel centerPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));        
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        bottomPanel.add(backBtn);
        centerPanel.add(infolb);
        centerPanel.add(imagelb);
        
        validate();
        topPanel.add(label);
        
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
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //setup the frame
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Info Window");
        this.setVisible(true);
    }

    
    private void exitApp() {
    int i = JOptionPane.showConfirmDialog(InfoWindow.this, "Do you want to exit the app?");
    if (i == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }
}
