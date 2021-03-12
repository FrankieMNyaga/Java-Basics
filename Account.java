/**@author Frank Nyaga
  *@since Sep 28, 2020
  *Class represents a profile for a user's bank account
  */
public class Account {
  /**Stores user's first name*/
  private String firstName;
  /**Stores user's last name*/
  private String lastName;
  /**Stores user's street address*/
  private String streetAddress;
  /**Stores user's zip code*/
  private String zipCode;
  /**Stores user's bank account*/
  private BankAccount savingsAccount;
  /**Stores user's checking account*/
  private BankAccount checkingAccount;
  /**Stores user's money market account*/
  private BankAccount moneyMarketAccount;
  /**Stores user's credit card account*/
  private CreditCardAccount creditCardAcc;
  /**Stores date*/
  private Date date;
  
  public Account(String firstName, String lastName, String streetAddress, String zipCode, Date date) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.zipCode = zipCode;
    this.date = date;
  }
  
  /**@return First name of user*/
  public String getFirstName() {
    return firstName;
  }
  
  /**Updates user's first name
    *@param newName  Updated first name
    */
  public void setFirstName(String newName) {
    firstName = newName;
  }
  
  /**@return Last name of user*/
  public String getLastName() {
    return lastName;
  }
  
  /**Updates user's last name
    *@param newName  Updated lastName
    */
  public void setLastName(String newName) {
    lastName = newName;
  }
  
  /**@return User's street address*/
  public String getStreetAddress() {
    return streetAddress;
  }
  
  /**Update's user's street address
    *@param newAddy  Updated street address
    */
  public void setStreetAddress(String newAddy) {
    streetAddress = newAddy;
  }
  
  /**@return user's zip code*/
  public String getZipCode() {
    return zipCode;
  }
  
  /**Updates user's zip code
    *@param newZip  Updated zip code
    */
  public void setZipCode(String newZip) {
    zipCode = newZip;
  }
  
  /**@return Address in memory of user's savings account*/
  public BankAccount getSavingsAccount() {
    return savingsAccount;
  }
  
  /**Updates user's savings account
    *@param newAcc  Updated savings account
    */
  public void setSavingsAccount(BankAccount newAcc) {
    savingsAccount = newAcc;
  }
  
  /**@return Address in memory of checking account*/
  public BankAccount getCheckingAccount() {
    return checkingAccount;
  }
  
  /**Updates user's checking account
    *@param newAcc  Updated checking account
    */
  public void setCheckingAccount (BankAccount newAcc) {
    checkingAccount = newAcc;
  }
  
  /**@return Address in memory of money market account*/
  public BankAccount getMoneyMarketAccount() {
    return moneyMarketAccount;
  }
  
  /**Updates user's money market account
    *@param newAcc  Updated money market account
    */
  public void setMoneyMarketAccount(BankAccount newAcc) {
    moneyMarketAccount = newAcc;
  }
  
  /**@return User's credit card account*/
  public CreditCardAccount getCreditCardAccount() {
    return creditCardAcc;
  }
  
  /**Updates user's credit card account
    *@param newAcc  Updated credit card account
    */
  public void setCreditCardAccount(CreditCardAccount newAcc) {
    creditCardAcc = newAcc;
  }
  
  /**@return The date associated with account*/
  public Date getDate() {
    return date;
  }
  
  /**Updates the date associated with account
    *@param newDate  Updated date
    */
  public void setDate(Date newDate) {
    date = newDate;
  }
  
  /**@Override
    *Increments day of all accounts and month if it has changed
    */
  public void incrementDay(){
    int currMonth = date.getMonth();
    date.incrementDay();
    if (currMonth == date.getMonth()) {
      if (savingsAccount != null)
        savingsAccount.incrementDay();
      if (checkingAccount != null) 
        checkingAccount.incrementDay();
      if(moneyMarketAccount != null)
        moneyMarketAccount.incrementDay();
      if (creditCardAcc != null)
        creditCardAcc.incrementDay();
    }
    else {
      if (savingsAccount != null) {
        savingsAccount.incrementDay();
        savingsAccount.incrementMonth();
      }
      if (checkingAccount != null) {
        checkingAccount.incrementDay();
        checkingAccount.incrementMonth();
      }
      if(moneyMarketAccount != null) {
        moneyMarketAccount.incrementDay();
        moneyMarketAccount.incrementMonth();
      }
      if (creditCardAcc != null) {
        creditCardAcc.incrementDay();
        creditCardAcc.incrementMonth();
      }
    }
  }
  
  /**@Override
    *@return true if both accounts have the same first and last name, address, and zipcode, otherwise false
    *@param otherAcc  Account being compared to this account
    */
  public boolean equals(Account otherAcc) {
    if ((firstName == otherAcc.getFirstName()) && (lastName == otherAcc.getLastName()) && (streetAddress == otherAcc.getStreetAddress())
          && (zipCode == otherAcc.getZipCode())) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**@Override
    *@return account information in the form of a String
    */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(firstName+" "+lastName+" "+streetAddress+" "+zipCode);
    if (getSavingsAccount() != null)
      builder.append(" Savings: "+savingsAccount.getBalance());
    if (getCheckingAccount() != null)
      builder.append(" Checking: "+checkingAccount.getBalance());
    if (getMoneyMarketAccount() != null)
      builder.append(" Money Market: "+moneyMarketAccount.getBalance());
    if (getCreditCardAccount() != null)
      builder.append(" Credit Card: "+creditCardAcc.getBalance());
    return builder.toString();
  }
}