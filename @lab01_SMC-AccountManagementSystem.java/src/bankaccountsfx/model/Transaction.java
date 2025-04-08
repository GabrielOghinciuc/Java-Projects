package bankaccountsfx.model;


import java.text.*;
import java.util.Date;


public class Transaction {
    
    String accountNumber;
    Date date;
    String description;
    float amount;
    
    /**
     * Initializare obiect de tranzactie cu toate datele sale
     * @param accountNumber
     * @param date
     * @param description
     * @param amount 
     */
    public Transaction( 
        String accountNumber,
        Date date,
        String description,
        float amount
    ){
        
        this.accountNumber = accountNumber;
        this.date = date;
        this.description = description;
        this.amount = amount;
        
    }
    
    /**
     * Salvarea a noului cont nr in obiectul Transaction
     * @param newAccountNumber 
     */
    
    public void setAccountNumber( String newAccountNumber ){ this.accountNumber = newAccountNumber; }
    
    /**
     * Citeste nr contului din obiectul Transaction
     * @return String
     */
    
    public String getAccountNumber() { return this.accountNumber; }
    
    /**
     * Salvare datele de tranzactie in obiectul Transaction
     * @param newDate 
     */
    
    public void setDate( Date newDate ){ this.date = newDate; }
    
    /**
     * citeste datele tranzactiei în format (zz/LL/aaaa) din obiectul Transaction
     * @return String
     */
    
    public String getDate() { 
        
        DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
        return dateFormat.format( this.date ); 
        
    } 
    
    /**
     * Salvarea descrierii noii tranzactii in obiectul Transaction
     * @param newDescription 
     */
    
    public void setDescription( String newDescription ){ this.description = newDescription; }
    
    /**
     * Obtinerea descrierii tranzactiei din obiectul Transaction
     * @return String
     */
    
    public String getDescription() { return this.description; }
    
    /**
     * Salvarea noii sume a tranzactiei in obiectul Transaction
     * @param newAmount 
     */
    
    public void setAmount( Float newAmount ){ this.amount = newAmount; }
    
    /**
     * Obtinerea sumei tranzactiei din obiectul Transaction
     * @return Float
     */
    
    public Float getAmount() { return this.amount; }
    
    @Override
    public String toString(){ 
                    
       return this.accountNumber + 
               ";" + 
               getDate() + 
               ";" + 
               this.description + 
               ";" + 
               this.amount;
       
    }
    
}
