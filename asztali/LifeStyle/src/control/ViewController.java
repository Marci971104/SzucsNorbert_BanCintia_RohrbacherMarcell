
package control;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Model.DataModel;
import Model.UserModel;
import Model.MealModel;
import Model.ViewModel;
import view.LifeForm;


public class ViewController {
    
    private LifeForm lifeFrm;
    private ViewModel viewMdl;
    private MealModel bikeMdl;
    private Vector<Vector<Object>> tableData;
    //private DatabaseController dbCtr;

    /*public ViewController( DatabaseController dbCtr ) {
        
        this.dbCtr = dbCtr;
        bikeFrm = new BikeForm();
        viewMdl = new ViewModel();
        initComponents();
        initListeners();
        start();
    }*/
    
    /*private void initComponents() {
        
        if( dbCtr.setDatabase() ){
            bikeFrm.setStatusLbl( "Kapcsolat OK" );
        }
    }*/
    
    private void initListeners() {
        
        lifeFrm.getExitBtn().addActionListener( event -> { exit(); });
        lifeFrm.getDeleteBtn().addActionListener( event -> { delete(); });
        lifeFrm.getEditBtn().addActionListener( event -> { edit(); });
        lifeFrm.getSaveBtn().addActionListener( event -> { save(); });
        lifeFrm.getSearchBtn().addActionListener( event -> { search(); });
        lifeFrm.getTableTb().addChangeListener( event -> { initTables(); });
    }
    
    private void start() {
        
        initTables();
        lifeFrm.setVisible( true );
    }
    
    private void initTables() {
        
        Vector<String> columnNames = new Vector<>();
        
        
        if( lifeFrm.getTableTb().getSelectedIndex() == 0 ) {
            
            columnNames = viewMdl.getUserColumnNames();
            tableData = dbCtr.getUsers();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            lifeFrm.getUserTbl().setModel( tablMdl );
            
        }else if( lifeFrm.getTableTb().getSelectedIndex() == 1 ) {
            
            columnNames = viewMdl.getMealColumnNames();
            tableData = dbCtr.getBikes();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            lifeFrm.getMealTbl().setModel( tablMdl );
            
        }else {
            
            columnNames = viewMdl.getDataColumnNames();
            tableData = dbCtr.getRents();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            lifeFrm.getDataTbl().setModel( tablMdl );
        }
    }
    
    private void search() {

    }
    
    private void save(){
        
        
        if(lifeFrm.getTableTb().getSelectedIndex() == 0){
            UserModel UserModel = new UserModel();
            int row = lifeFrm.getUserTbl().getSelectedRow();          
            UserModel.setName(lifeFrm.getUserTbl().getValueAt(row,0).toString());
            UserModel.setEmail(lifeFrm.getUserTbl().getValueAt(row,1).toString());
            UserModel.setPassword(lifeFrm.getUserTbl().getValueAt(row,2).toString());

            
            boolean success= dbCtr.setMemberData(memModel);
            
            
            if(success){
                lifeFrm.setStatusLbl( "Kiírás OK" );
                initTables();
            }else{
                lifeFrm.setStatusLbl( "Kiírás sikertelen" );
        }

        }else if(lifeFrm.getTableTb().getSelectedIndex() == 1){
            MealModel model = new MealModel();
            int row = lifeFrm.getMealTbl().getSelectedRow();          
            model.setMealname(lifeFrm.getMealTbl().getValueAt(row,0).toString());
            model.setCalorievalue(lifeFrm.getMealTbl().getValueAt(row,1).toString());
            model.setFat(lifeFrm.getMealTbl().getValueAt(row,2).toString());
            model.setProtein(lifeFrm.getMealTbl().getValueAt(row,3).toString());
            model.setCarbohydrate(lifeFrm.getMealTbl().getValueAt(row,4).toString());
            model.setSalt(lifeFrm.getMealTbl().getValueAt(row,5).toString());
         
            
            boolean success= dbCtr.setBikeData( model);
            if (success) {
				lifeFrm.setStatusLbl("Sikeres felírás");
			}else {
				lifeFrm.setStatusLbl("Irás sikeres!!!");
			}
        }
        
        
       
        
    }

    private void edit() {
         System.out.println("Szerkesztés sikerült");
    }
    
    private void delete() {
         System.out.println("törlés sikerült");
    }
    
    private void exit() {
        
        System.exit( 0 );
    }
}
