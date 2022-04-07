
package Model;

import java.util.Vector;


public class ViewModel {

    public ViewModel() {
    }
    
    public Vector<String> getUserColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Azonosito" );
        columnNames.add( "N�v" );
        columnNames.add( "Email" );
        columnNames.add( "Jelsz�" );

        
        return columnNames;
    }
    
    public Vector<String> getMealColumnNames() {
        
        Vector<String> columnNames = new Vector<>();
        
        
        columnNames.add( "Kaja azonos�t�" );
        columnNames.add( "�tel neve" );
        columnNames.add( "Kal�ria �rt�k" );
        columnNames.add( "Zs�r" );
        columnNames.add( "Feh�rje" );
        columnNames.add( "Sz�nhidr�t" );
        columnNames.add( "S�" );
     
        
        return columnNames;
    }
    
    
}
