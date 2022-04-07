
package Model;

import java.util.Vector;


public class ProfileModel {

    public ProfileModel() {
    }
    

    
    public Vector<String> getProfileColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        
        columnNames.add( "Magasság" );
        columnNames.add( "Súly" );
        columnNames.add( "Életkor" );
        columnNames.add( "Neme" );
        columnNames.add( "Összeskalória" );
        columnNames.add( "Megivott víz(dl)" );
        
     
        
        return columnNames;
    }
    
    
}
