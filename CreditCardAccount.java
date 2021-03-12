/**@author Frankie Nyaga
  *@since Sep 28, 2020
  *Class represents the typical credit card account
  */
public class CreditCardAccount {
  /**Stores max amount that may be borrowed*/
  private int creditLimit;
  /**Stores interest rate for account*/
  private double interestRate;
  /**Stores min amount that must be payed to avoid payment penalty*/
  private int minMonthlyPayment;
  /**Stores charge for late payment*/
  private int latePaymentPen;
  /**Stores account balance*/
  private double bal;
  /**Stores amount user must pay for current month*/
  private double monthlyPayment;
  /**Stores total amount paid so far for the month*/
  private double madeMonthlyPay;
  /**Stores interest charged so far*/
  private double interestFeeBal;
  /**Stores whether or not balance has been paid in full*/
  private boolean paidInFullFlag;
  
  public CreditCardAccount() {
  }
  
  public CreditCardAccount(int creditLimit, double interestRate, int minMonthlyPayment, int latePaymentPen) {
    this.creditLimit = creditLimit;
    this.interestRate = interestRate;
    this.minMonthlyPayment = minMonthlyPayment;
    this.latePaymentPen = latePaymentPen;
  }
  
  /**@return credit limit*/
  public int getCreditLimit() {
    return creditLimit;
  }
  
  /**Updates credit limit value
    *@param newLimit  Updated credit limit
    */
  public void setCreditLimit(int newLimit) {
    creditLimit = newLimit;
  }
  
  /**@return interest rate*/
  public double getInterestRate() {
    return interestRate;
  }
  
  /**Updates value of interest rate
    *@param newRate  Updated interest rate value
    */
  public void setInterestRate(double newRate) {
    interestRate = newRate;
  }
  
  /**@return min monthly payment*/
  public int getMinMonthlyPayment() {
    return minMonthlyPayment;
  }
  
  /**Updates value of min monthly payment
    *@param newPayment  Updated min monthly payment value
    */
  public void setMinMonthlyPayment(int newPayment) {
    minMonthlyPayment = newPayment;
  }
  
  /**@return late payment penalty*/
  public int getLatePaymentPenalty() {
    return latePaymentPen;
  }
  
  /**Updates value of late payment penalty
    *@param newPen  Updated late payment penalty value
    */
  public void setLatePaymentPenalty(int newPen) {
    latePaymentPen = newPen;
  }
  
  /**@return account balance*/
  public double getBalance() {
    return bal;
  }
  
  /**@return payment needed to pay off credit card in full*/
  public double getMonthlyPayment() {
    return monthlyPayment;
  }
  
  /**Applys a charge on credit card
    *@return
    *@param amount  amount user is trying to charge their card
    */
  public boolean charge(double amount) {
    if ((bal + amount) <= creditLimit) {
      bal += amount;
      return true;
    }
    else {
      return false;
    }
  }
  
  /**Makes a payment on credit card
    *@param amount  amount being payed on card
    */
  public void payment(double amount) {
    bal -= amount;
    madeMonthlyPay += amount;
  }
  
  /**@Override
    *Computes payments made that day and updates interest fee balance*/
  public void incrementDay() {
    if (!paidInFullFlag) {
      double sum = bal + interestFeeBal;
      interestFeeBal += ((sum * interestRate) / 365.0);
    }
  }
  
  /**@Override
    *Computes payments made that month and resets proper monthly balances
    */
  public void incrementMonth() {
    bal += interestFeeBal;
    interestFeeBal = 0.0;
    if (madeMonthlyPay >= monthlyPayment)
      paidInFullFlag = true;
    else
      paidInFullFlag = false;
    if ((minMonthlyPayment < monthlyPayment) && (madeMonthlyPay < minMonthlyPayment))
      bal += latePaymentPen;
    madeMonthlyPay = 0.0;
    monthlyPayment = 0.0;
  }
}