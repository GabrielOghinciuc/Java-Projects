package bankaccountsfx.model;

import bankaccountsfx.utils.FileUtils;
import static bankaccountsfx.utils.MessageUtils.showError;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Account {
    
    String accountNumber;
    String owner;

    /**
     * Initializare un obiect de cont cu toate datele sale
     * @param accountNumber
     * @param owner 
     */
    public Account( 
        String accountNumber,
        String owner 
    ){
        
        this.accountNumber = accountNumber;
        this.owner = owner;
        
    }
    
    /**
     * Salvare un nou numar de cont în obiectul Cont
     * @param newAccountNumber 
     */
    public void setAccountNumber( String newAccountNumber ){ this.accountNumber = newAccountNumber; }
    
    /**
     * Obtineti numarul de cont din obiectul Cont
     * @return String
     */
    
    public String getAccountNumber() { return this.accountNumber; } 
    
    /**
     * Salvati un nou proprietar în obiectul Cont
     * @param newOwner 
     */
    
    public void setOwner( String newOwner ){ this.owner = newOwner; }
    
    /**
     * Obtineti proprietarul din obiectul Cont
     * @return String
     */
    
    public String getOwner() { return this.owner; }
    
    @Override
    public String toString(){ 
                    
       return this.accountNumber + 
               ";" + 
               this.owner;
       
    }
    
}
