/**@author Frankie Nyaga
  *@since Sep 28, 2020
  *Class represents the typical Bank Account
  */
public class BankAccount {
  /**Stores current balance*/
  private double currentBal;
  /**Stores interest rate*/
  private double interestRate;
  /**Stores minimum balance value (threshold)*/
  private int minBal;
  /**Stores amount charged when withdrawATM() is called (the ATM Fee)*/
  private double atmFee;
  /**Stores ammount charged if account balance is less than account's minimum 
   *balance at the end of the day Over Draft Fee*/
  private double odFee;
  /**Stores bounced check fee charged if withDraft() removes more than accBal*/
  private double bouncedCheckFee;
  /**Stores withdraw fee charged per withdrawal when user exceeds max number
    *of monthly withdraws allowed on account**/
  private double withdrawFee;
  /**Stores withdra limit 0 when max account otherwise limit is max number of 
    *free withdrawals allowed per month*/
  private int withdrawLimit;
  /**Stores number of withdraws for the month*/
  private int monthlyWithdraws;
  /**Stores monthly interest earned by account*/
  private double monthlyInterestEarned;
  /**Stores whether or not overdraft fee has been charged yet this month*/
  private boolean overdraftFlag;
    
  public BankAccount() {
  }
  
  public BankAccount (double interestRate, int minBal, double odFee, double atmFee, double bouncedCheckFee) {
    this.interestRate = interestRate;
    this.minBal = minBal;
    this.odFee = odFee;
    this.atmFee = atmFee;
    this.bouncedCheckFee = bouncedCheckFee;
  }
  
  /**@return current balance*/
  public double getBalance() {
    return currentBal;
  }
  
  /**@return interest rate*/
  public double getInterestRate() {
    return interestRate;
  }
  
  /**Updates interest rate
   *@Param newRate  Updated interest rate
   */
  public void setInterestRate(double newRate) {
    interestRate = newRate;
  }
  
  /**@return minimum balance threshold*/
  public int getMinimumBalance() {
    return minBal;
  }
  
  /**Updates minimum balance threshold
    *@param newMinBal  Updated minimum balance threshold
    */
  public void setMinimumBalance(int newMinBal) {
    minBal = newMinBal;
  }
  
  /**@return ATM Fee*/
  public double getATMFee() {
    return atmFee;
  }
  
  /**Updates ATM Fee charge
    *@param newATMFee  Updated ATM Fee charge
    */
  public void setATMFee(double newATMFee) {
    atmFee = newATMFee;
  }
  
  /**@return Over Draft Fee*/
  public double getOverDraftFee() {
    return odFee;
  }
  
  /***Updates Over Draft Fee 
    *@param newODFee  Updated Over Draft Fee
    */
  public void setOverDraftFee(double newODFee) {
    odFee = newODFee;
  }
  
  /**@return bouncedCheckFee**/
  public double getBouncedCheckFee() {
    return bouncedCheckFee;
  }
  
  /**Updates bouncedCheckFee
   *@param newBCFee  Updated bounced check fee
   */
  public void setBouncedCheckFee(double newBCFee) {
    bouncedCheckFee = newBCFee;
  }
  
  /**@return withdraw fee*/
  public double getWithdrawFee() {
    return withdrawFee;
  }
  
  /**Update withdraw fee
    *@param newWFee  Updated withdraw fee
    */
  public void setWithdrawFee(double newWFee) {
    withdrawFee = newWFee;
  }
  
  /**@returns withdraw limit*/
  public int getWithdrawLimit() {
    return withdrawLimit;
  }
  
  /**Updates withdraw limit
    *@param newWLimit  Updated withdraw limit
    */
  public void setWithdrawLimit(int newWLimit) {
    withdrawLimit = newWLimit;
  }
  
  /**Adds funds to current balance
    *@param depositAmount  Amount being added to current balance
    */
  public void deposit(double depositAmount) {
    currentBal += depositAmount;
  }
  
  /**Takes funds from current balance
    *@return true if current balance is greater or equal to withdrawAmount, false otherwise
    *@param withdrawAmount  Amount being taken from current balance
    */
  public boolean withdraw(double withdrawAmount) {
    if ((currentBal >= withdrawAmount) && (withdrawLimit >= monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      monthlyWithdraws += 1;
      return true;
    }
    else if ((currentBal >= withdrawAmount) && (withdrawLimit < monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      monthlyWithdraws += 1;
      currentBal -= withdrawFee;
      return true;
    }
    else {
      return false;
    }
  }
  
  /**Takes funds from current balance and applys bounced check fee if balance is less than amount
    *@return true if currentbalance is greater or equal to withdrawAmount, false otherwise
    *@param withdrawAmount  Amount being taken from balance
    */
  public boolean withdrawDraft(double withdrawAmount) {
    if ((currentBal >= withdrawAmount) && (withdrawLimit >= monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      monthlyWithdraws += 1;
      return true;
    }
    else if ((currentBal >= withdrawAmount) && (withdrawLimit < monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      monthlyWithdraws += 1;
      currentBal -= withdrawFee;
      return true;
    }
    else {
      currentBal -= bouncedCheckFee;
      return false;
    }
  }
  
  /**Takes funds from current balance and applys ATMFees
    *@return True if current balance is greater or equal to withdrawAmount and the ATM fee, false otherwise
    *@param withdrawAmount  Amount being taken from balance
    */
  public boolean withdrawATM (double withdrawAmount) {
    if ((currentBal >= (withdrawAmount + atmFee)) && (withdrawLimit >= monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      currentBal -= atmFee;
      monthlyWithdraws += 1;
      return true;
    }
    else if ((currentBal >= (withdrawAmount + atmFee)) && (withdrawLimit < monthlyWithdraws)) {
      currentBal -= withdrawAmount;
      currentBal -= atmFee;
      monthlyWithdraws += 1;
      currentBal -= withdrawFee;
      return true;
    }
    else {
      return false;
    }
  }
  
  /**@Override
    *Computes interest earned that day*/
  public void incrementDay() {
    if ((currentBal < minBal) && !overdraftFlag) {
      currentBal -= odFee;
      overdraftFlag = true;
      monthlyInterestEarned = 0.0;
    }
    else if ((currentBal < minBal) && overdraftFlag) {
      monthlyInterestEarned = 0.0;
    }
    else {
      double sum = monthlyInterestEarned + currentBal;
      monthlyInterestEarned = monthlyInterestEarned + ((sum * interestRate) / 365.0);
    }
  }
  
  /**@Override
    *Applys monthly interest earned to balance and resets the value and the overdraft flag*/
  public void incrementMonth() {
    currentBal += monthlyInterestEarned;
    monthlyInterestEarned = 0.0;
    overdraftFlag = false;
  }
}
