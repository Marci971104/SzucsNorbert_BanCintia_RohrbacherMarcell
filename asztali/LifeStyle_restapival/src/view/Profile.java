package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Profile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable dataTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton exitBtn = new JButton("Kilépés");
	    exitBtn = new javax.swing.JButton();
	    exitBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
		panel.add(exitBtn);
		
		JPanel profilePnl = new JPanel();
		contentPane.add(profilePnl, BorderLayout.CENTER);
		
		JTabbedPane dataTb_1 = new JTabbedPane(JTabbedPane.TOP);
		profilePnl.add(dataTb_1);
		
		JScrollPane datapnl = new JScrollPane();
		dataTb_1.addTab("Adatok", null, datapnl, null);
		
		dataTbl = new JTable();
		datapnl.setViewportView(dataTbl);
		
		JPanel userTb = new JPanel();
		dataTb_1.addTab("New tab", null, userTb, null);
		userTb.setLayout(new GridLayout(1, 1));
		
		JScrollPane jScrollPane1 = new JScrollPane();
		userTb.add(jScrollPane1);
		
		JPanel jPanel10 = new JPanel();
		dataTb_1.addTab("New tab", null, jPanel10, null);
		jPanel10.setLayout(new GridLayout(1, 1));
		
		JTabbedPane tableTb = new JTabbedPane();
		tableTb.setMaximumSize(new Dimension(500, 500));
		tableTb.setForeground(Color.WHITE);
		tableTb.setBackground(Color.WHITE);
		jPanel10.add(tableTb);
	}
	  public javax.swing.JButton exitBtn;
	public JButton getExitBtn(){ return exitBtn ; }





	public JTable getDataTbl() {
		return dataTbl;
	}

	public void setDataTbl(JTable dataTbl) {
		this.dataTbl = dataTbl;
	}

	public JTabbedPane getTableTb() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 




}
