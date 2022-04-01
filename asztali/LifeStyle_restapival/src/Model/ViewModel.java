
package Model;

import java.util.Vector;


public class ViewModel {

    public ViewModel() {
    }
    
    public Vector<String> getUserColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Azonosito" );
        columnNames.add( "Név" );
        columnNames.add( "Email" );
        columnNames.add( "Jelszó" );

        
        return columnNames;
    }
    
    public Vector<String> getMealColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        
        columnNames.add( "Kaja azonosító" );
        columnNames.add( "Étel neve" );
        columnNames.add( "Kalória érték" );
        columnNames.add( "Zsír" );
        columnNames.add( "Fehérje" );
        columnNames.add( "Szénhidrát" );
        columnNames.add( "Só" );
     
        
        return columnNames;
    }
    
    public Vector<String> getDataColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        columnNames.add( "Magasság" );
        columnNames.add( "Súly" );
        columnNames.add( "Életkor" );
        columnNames.add( "Neme" );
        columnNames.add( "Össze kalória" );
        columnNames.add( "Megivott víz (dl)" );
        
        
        return columnNames;
    }
}
