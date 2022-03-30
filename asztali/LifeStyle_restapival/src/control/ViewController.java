package control;


import Model.ViewModel;

import view.LifeForm;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewController {

    private LifeForm lifeFrm;
    

    private ViewModel viewMdl;
    private Vector<Vector<Object>> tableData;
    private RapiController rapiCtr;
    
    public ViewController(RapiController rapiCtr) {
        
        this.rapiCtr = rapiCtr;
        viewMdl = new ViewModel();
        initFrames();
        ActionListeners();
        
    }
    private void ActionListeners() {
    	//lifeFrm.getSearchBtn().addActionListener( event -> { search(); } );
    	lifeFrm.getExitBtn().addActionListener( event -> { exit(); });
    	lifeFrm.getTableTb().addChangeListener(event -> {initUsers(); });
    	lifeFrm.getTableTb().addChangeListener(event -> {initMeals(); });
    	lifeFrm.getTableTb().addChangeListener(event -> {initDatas(); });
        


    }
    private void initFrames() {
    	lifeFrm = new LifeForm();
    	lifeFrm.setVisible(true);
        initUsers();
        initDatas();
        initMeals();
    }

   
    private void initUsers() {
    
        Vector<String> columnNames = new Vector<>();
        tableData = new Vector<>();
        
        if(lifeFrm.getTableTb().getSelectedIndex() == 0) {
                columnNames = viewMdl.getUserColumnNames();
                tableData = rapiCtr.getUsers();
                TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
                lifeFrm.getUserTbl().setModel(tableMdl);
        }else {
                columnNames = viewMdl.getUserColumnNames();
                tableData = rapiCtr.getUsers();
                TableModel tableMdl = new DefaultTableModel(tableData, columnNames);
                lifeFrm.getUserTbl().setModel(tableMdl);
        }

           
        
    }
        

        
       
    
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
    



    private void search() {
     
    }
    private void exit() {
        rapiCtr.Logout();
        System.exit(0);
    }
}

