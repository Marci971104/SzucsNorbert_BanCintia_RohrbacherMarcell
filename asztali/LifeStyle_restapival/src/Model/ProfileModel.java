
package Model;

import java.util.Vector;


public class ProfileModel {

    public ProfileModel() {
    }
    

    
    public Vector<String> getProfileColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        
        columnNames.add( "Magass�g" );
        columnNames.add( "S�ly" );
        columnNames.add( "�letkor" );
        columnNames.add( "Neme" );
        columnNames.add( "�sszeskal�ria" );
        columnNames.add( "Megivott v�z(dl)" );
        
     
        
        return columnNames;
    }
    
    
}
