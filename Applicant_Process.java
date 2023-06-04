import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;



public class Applicant_Process {

	public JFrame ApplicantProcess;
	public JPanel panel1;
	public JPanel panel2;
	public JPanel panel3;
	public JLayeredPane layeredPane;
	private JTable App_table;
    private DefaultTableModel model;
    private JTextField searchField;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Applicant_Process window = new Applicant_Process();
					window.ApplicantProcess.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//METHODS ====================================================================================

	//Loads Data from txt file
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
    
	//Panel Switch
	public void switchPanels(JPanel panel) {
		
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
				
	} 	

	/**
	 * Create the application.
	 */
	public Applicant_Process() {
		initialize();
        loadDataFromFile();
	}
    public JTable getTable() {
        return App_table;
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ApplicantProcess = new JFrame();
		ApplicantProcess.setBounds(100, 100, 1026, 645);
		ApplicantProcess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ApplicantProcess.setLocationRelativeTo(null);
		ApplicantProcess.getContentPane().setLayout(null);
		
		//PANELS ====================================================================================

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(222, 123, 798, 494);
		ApplicantProcess.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
        model = new DefaultTableModel();
		
		//PANEL 1 ====================================================================================

		//VIEW AVAILABLE POSITINS
		panel1 = new JPanel();
		layeredPane.add(panel1, "name_55815229348416");
		panel1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(45, 70, 726, 404);
		panel1.add(scrollPane);
		
		//Available Positions table
		App_table = new JTable();
		App_table.setModel(model);
		App_table.setEnabled(false);
		App_table.setFocusable(false);
		App_table.setRowSelectionAllowed(false);
		App_table.getTableHeader().setReorderingAllowed(false);
		App_table.getTableHeader().setResizingAllowed(false);
	        Object[] column = { "Position Code", "Job Title", "Responsibilities", "Salary" };
	        model.setColumnIdentifiers(column);
	        final Object[] row = new Object[4];
	        model.setColumnIdentifiers(column);
		scrollPane.setViewportView(App_table);
		
		//PANEL 2 ====================================================================================

		//APPLY TO DESIRED POSITION
		panel2 = new JPanel();
		layeredPane.add(panel2, "name_55815229348417");
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Panel2");
		lblNewLabel_1.setBounds(378, 5, 41, 16);
		panel2.add(lblNewLabel_1);
		
		//Search Box
		searchField = new JTextField();
		searchField.setBounds(33, 65, 335, 46);
		panel2.add(searchField);
		searchField.setColumns(10);
		
		//Search Button
		JButton btn_Search = new JButton("Search");
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
			}
		});
		btn_Search.setBounds(396, 75, 117, 29);
		panel2.add(btn_Search);
		
		
		//Search Table
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(33, 123, 335, 180);
		panel2.add(scrollPane_1);
		        
        //Apply Button
        JButton btn_Apply = new JButton("Apply");
        btn_Apply.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		

             
        	}
        });
        btn_Apply.setBounds(138, 327, 117, 29);
        panel2.add(btn_Apply);
	  
		//PANEL 3 ====================================================================================

		//VIEW APLIED POSITION
		panel3 = new JPanel();
		layeredPane.add(panel3, "name_55815229348418");
		panel3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Panel3");
		lblNewLabel_2.setBounds(391, 5, 41, 16);
		panel3.add(lblNewLabel_2);
		
		//LOGOUT BUTTON
		JButton LOGOUTBUTTON = new JButton("");
		LOGOUTBUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Applicant_Log ApplicantLog = new Applicant_Log(null, null);
				ApplicantLog.ApplicantLog.setVisible(true);
				ApplicantProcess.dispose();
				
			}
		});
		LOGOUTBUTTON.setIcon(new ImageIcon("/Users/luiz/Downloads/LOGOUT (1).png"));
		LOGOUTBUTTON.setBounds(880, 71, 116, 40);
		ApplicantProcess.getContentPane().add(LOGOUTBUTTON);
		

		//BUTTONS ====================================================================================
		
		//VIEW AVAILABLE POSITINS
		JButton btnViewPositions = new JButton("");
		btnViewPositions.setIcon(new ImageIcon("/Users/luiz/Downloads/VAP.png"));
		btnViewPositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panel1);
				
			}
		});
		btnViewPositions.setBounds(21, 226, 189, 53);
		ApplicantProcess.getContentPane().add(btnViewPositions);
		
		
		//APPLY TO DESIRED POSITION
		JButton btnApply = new JButton("");
		btnApply.setIcon(new ImageIcon("/Users/luiz/Downloads/ADP.png"));
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panel2);
				
			}
		});
		btnApply.setBounds(21, 328, 189, 53);
		ApplicantProcess.getContentPane().add(btnApply);
		
		
		//VIEW APLIED POSITION
		JButton btnViewApplied = new JButton("");
		btnViewApplied.setIcon(new ImageIcon("/Users/luiz/Downloads/VAJP.png"));
		btnViewApplied.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panel3);
				
			}
		});
		btnViewApplied.setBounds(21, 427, 189, 53);
		ApplicantProcess.getContentPane().add(btnViewApplied);
		
		
		//BACKGROUND ====================================================================================

		JLabel ApplicantProcess_BG = new JLabel("");
		ApplicantProcess_BG.setIcon(new ImageIcon("/Users/luiz/Downloads/APPLICANT PROCESS (1).png"));
		ApplicantProcess_BG.setBounds(0, 0, 1026, 617);
		ApplicantProcess.getContentPane().add(ApplicantProcess_BG);	
		
	}
}
