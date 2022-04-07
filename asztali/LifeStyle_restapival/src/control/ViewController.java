package control;


import Model.ProfileModel;
import Model.ViewModel;

import view.LifeForm;
import view.Profile;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewController {

    private LifeForm lifeFrm;
    private Profile proFrm;
    

    private ViewModel viewMdl;
    private ProfileModel proMdl;
    private Vector<Vector<Object>> tableData;
    private RapiController rapiCtr;
	private String id;

  public ViewController(RapiController rapiCtr) {
        
        this.rapiCtr = rapiCtr;
        viewMdl = new ViewModel();
        proMdl=new ProfileModel();
        initFrames();
        ActionListeners();
        
    }
   private void ActionListeners() {
	   
    	lifeFrm.getExitBtn().addActionListener( event -> { exit(); });
    	lifeFrm.getTableTb().addChangeListener(event -> {initTables(); });
    	lifeFrm.getDeleteBtn().addActionListener(event -> {delete(); });

    	lifeFrm.getProfilBtn().addActionListener(event -> {initProfile();});
    	proFrm.getExitBtn().addActionListener( event -> { test(); });
    }
    private void initFrames() {
    	initProfileFrame();
        proFrm = new Profile();
    	initLifeFrame();
        proFrm = new Profile();
        initTables();
    }
    
    private void initLifeFrame() {
        lifeFrm = new LifeForm();
        lifeFrm.setTitle("LifeStyle");
        lifeFrm.setLocationRelativeTo(null);
        lifeFrm.setVisible(true);
      
    }
    
    private void initProfileFrame() {
        proFrm = new Profile();
        proFrm.setTitle("Profil");
        proFrm.setLocationRelativeTo(null);
        proFrm.setVisible(true);
    }
    
 
 private void initTables() {
    	  proFrm.dispose();
    
        Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
        if(lifeFrm.getTableTb().getSelectedIndex() == 0) {
            columnNames = viewMdl.getUserColumnNames();
            tableData = rapiCtr.getUsers();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getUserTbl().setModel(tableMdl);
    }else {
            columnNames = viewMdl.getMealColumnNames();
            tableData = rapiCtr.getMeal();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getMealTbl().setModel(tableMdl);
    }   
}
	private void initProfile() {
    	Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
    	if(proFrm.getTableTb().getSelectedIndex() == 0) {
            columnNames = proMdl.getProfileColumnNames();
            tableData = rapiCtr.getData();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            proFrm.getDataTbl().setModel(tableMdl);
    }else {
    	columnNames = proMdl.getProfileColumnNames();
        tableData = rapiCtr.getData();
        TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
        proFrm.getDataTbl().setModel(tableMdl);
    }     	
  }
	
	
    private void delete() {
        
        
        int openTab = lifeFrm.getTableTb().getSelectedIndex();
        if(openTab == 0) {
            DeleteUser();
        }else {
            DeleteMeal();
           
        }
        
        proFrm.dispose();
    }
    
    private void DeleteMeal() {
        int row = lifeFrm.getMealTbl().getSelectedRow();
        String value = lifeFrm.getMealTbl().getModel().getValueAt(row, 0).toString();
        rapiCtr.setId(value);
        
        rapiCtr.DeleteMeal();
        lifeFrm.setStatusLbl(rapiCtr.getDeleteMealMsg(), id);
        
        initTables();
    }
    
    private void DeleteUser() {
        int row = lifeFrm.getUserTbl().getSelectedRow();
        String value = lifeFrm.getUserTbl().getModel().getValueAt(row, 0).toString();
        rapiCtr.setId(value);
        
        rapiCtr.DeleteUser();
        lifeFrm.setStatusLbl(rapiCtr.getDeleteUserMsg(), id);
        
        initTables();
    }

    
  private void exit() {
        rapiCtr.Logout();
        System.exit(0);
    }
  
  private void test() {
      proFrm.dispose();
  }
}

