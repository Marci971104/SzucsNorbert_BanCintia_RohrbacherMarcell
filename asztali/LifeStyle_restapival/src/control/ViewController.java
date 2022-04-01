package control;


import Model.ViewModel;

import view.LifeForm;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewController {

    private LifeForm lifeFrm;
    

    private ViewModel viewMdl;
    private Vector<Vector<Object>> tableData;
    private RapiController rapiCtr;


	private String id;
    
    public ViewController(RapiController rapiCtr) {
        
        this.rapiCtr = rapiCtr;
        viewMdl = new ViewModel();
        initFrames();
        ActionListeners();
        
    }
    private void ActionListeners() {
    	lifeFrm.getSearchBtn().addActionListener( event -> { search(); } );
    	lifeFrm.getExitBtn().addActionListener( event -> { exit(); });
    	lifeFrm.getTableTb().addChangeListener(event -> {initTables(); });
    	lifeFrm.getDeleteBtn().addActionListener(event -> {delete(); });
        


    }
    private void initFrames() {
    	lifeFrm = new LifeForm();
    	lifeFrm.setVisible(true);
       initTables();
    }

   
    private void initTables() {
    
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
        	
        	
        	
        	
  

        
       
    
   /*
	private void initMeals() {
    	Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
    	if(lifeFrm.getTableTb().getSelectedIndex() == 0) {
            columnNames = viewMdl.getMealColumnNames();
            tableData = rapiCtr.getMeal();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getMealTbl().setModel(tableMdl);
    }else {
            columnNames = viewMdl.getMealColumnNames();
            tableData = rapiCtr.getMeal();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getMealTbl().setModel(tableMdl);
    }     
    }
    
    private void initDatas() {
    	
    	Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
    
    	if(lifeFrm.getTableTb().getSelectedIndex() == 0) {
            columnNames = viewMdl.getDataColumnNames();
            tableData = rapiCtr.getData();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getDataTbl().setModel(tableMdl);
    }else {
            columnNames = viewMdl.getDataColumnNames();
            tableData = rapiCtr.getData();
            TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
            lifeFrm.getDataTbl().setModel(tableMdl);
    }
    }
    
*/


    private void search() {
        int openTab = lifeFrm.getTableTb().getSelectedIndex();
        String search_text = lifeFrm.getSearchBtn().getText();
        if(openTab == 0) {
        	rapiCtr.setSearchData(search_text);
        	initTables();
        }else {
        	rapiCtr.setSearchData(search_text);
        	initTables();
        }
        
        
    }
    
    private void delete() {
        
        
        int openTab = lifeFrm.getTableTb().getSelectedIndex();
        if(openTab == 0) {
            DeleteUser();
        }else {
            DeleteMeal();
        }
       
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
    
   
}

