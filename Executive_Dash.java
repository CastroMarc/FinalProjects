import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Executive_Dash {

	public JFrame ExecutiveDash;
	private JTable dash_table;
    private DefaultTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executive_Dash window = new Executive_Dash();
					window.ExecutiveDash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//METHODS ====================================================================================

	//Loads data from the txt file to Dashboard table
    private void loadDataFromFile() {
        try {
            File file = new File("/Users/luiz/Library/Mobile Documents/com~apple~TextEdit/Documents/Job Posting.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   // ====================================================================================
    
	/**
	 * Create the application.
	 */
	public Executive_Dash() {
		initialize();
        loadDataFromFile();
	}
	
    public JTable getTable() {
        return dash_table;
    }
 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ExecutiveDash = new JFrame();
		ExecutiveDash.setBounds(100, 100, 1026, 645);
		ExecutiveDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExecutiveDash.setLocationRelativeTo(null);
		ExecutiveDash.getContentPane().setLayout(null);
		
        model = new DefaultTableModel();
		
        //Added Positions
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 197, 439, 386);
		ExecutiveDash.getContentPane().add(scrollPane);
	
		dash_table = new JTable();
		 scrollPane.setViewportView(dash_table);
		 dash_table.setModel(model);
		 dash_table.setEnabled(false);
		 dash_table.setFocusable(false);
		 dash_table.setRowSelectionAllowed(false);
		 dash_table.getTableHeader().setReorderingAllowed(false);
		 dash_table.getTableHeader().setResizingAllowed(false);
	        Object[] column = { "Position Code", "Job Title", "Responsibilities", "Salary" };
	        model.setColumnIdentifiers(column);
	        final Object[] row = new Object[4];
	        model.setColumnIdentifiers(column);
		scrollPane.setViewportView(dash_table);
		
		
		//BUTTONS ====================================================================================

		//Job Posting Button
		JButton btn_JobPosting = new JButton("");
		btn_JobPosting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Job_Posting JobPosting = new Job_Posting(dash_table,getTable());
				JobPosting.JobPosting.setVisible(true);
				ExecutiveDash.dispose();
				
			}
		});
		btn_JobPosting.setIcon(new ImageIcon("/Users/luiz/Downloads/JOB POSTING .png"));
		btn_JobPosting.setBackground(new Color(11, 20, 10));
		btn_JobPosting.setBounds(754, 67, 116, 40);
		ExecutiveDash.getContentPane().add(btn_JobPosting);
		
		//Log Out Button
		JButton btn_LogOut = new JButton("");
		btn_LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_Log AdminLog = new Admin_Log();
				AdminLog.setVisible(true);
				ExecutiveDash.dispose();
				
			}
		});
		btn_LogOut.setIcon(new ImageIcon("/Users/luiz/Downloads/LOGOUT (1).png"));
		btn_LogOut.setBounds(882, 67, 116, 40);
		ExecutiveDash.getContentPane().add(btn_LogOut);
			
		//BACKGROUND====================================================================================

		JLabel ExecutiveDash_BG = new JLabel("");
		ExecutiveDash_BG.setIcon(new ImageIcon("/Users/luiz/Downloads/EXECUTIVE DASH (1).png"));
		ExecutiveDash_BG.setBounds(0, 0, 1026, 617);
		ExecutiveDash.getContentPane().add(ExecutiveDash_BG);
		
	}
}
