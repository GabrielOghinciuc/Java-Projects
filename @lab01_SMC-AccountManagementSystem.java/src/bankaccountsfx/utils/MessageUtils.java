package bankaccountsfx.utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;

public class MessageUtils {
    
    /**
     * Afiseaza un mesaj de eroare cu params
     * @param header
     * @param message 
     */
    public static void showError(String header, String message){
        
        Alert alert = new Alert( AlertType.ERROR );
        alert.setTitle( "Eroare" );
        alert.setHeaderText( header );
        alert.setContentText( message );

        alert.showAndWait();
        
    }
    
    /**
     * Afiseaza mesaj informativ cu parametru params
     * @param header
     * @param message 
     */
    public static void showMessage(String header, String message){
        
        Alert alert = new Alert( AlertType.INFORMATION );
        alert.setTitle( "Dialog informativ" );
        alert.setHeaderText( header );
        alert.setContentText( message );

        alert.showAndWait();
        
    }
    
    /**
     * fiseaza mesaj de confirmare cu parametru params
     * @param header
     * @param message 
     * @return  
     */
    public static boolean showConfirmMessage(String header, String message ){
        
        Alert alert = new Alert( AlertType.INFORMATION );
        alert.setTitle( "Dialog de confirmare" );
        alert.setHeaderText( header );
        alert.setContentText( message );
        alert.getButtonTypes().setAll( ButtonType.OK, ButtonType.CANCEL );
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            
            return true;
            
        } else {
            
            alert.close();
            return false;
            
        }
        
    }
    
}
