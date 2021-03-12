/**@author Frank Nyaga
  *@since Sep 28, 2020
  *Class represents standard calander date
  */
public class Date {
  /**Stores day of the month, between 1 and 31*/
  private int day = 1;
  /**Stores month of the year, between 1 and 12*/
  private int month = 1;
  
  public Date(int month, int day) {
    this.day = day;
    this.month = month;
  }
  
  /**@return Month of date*/
  public int getMonth() {
    return month;
  }
  
  /**@return Day of Date*/
  public int getDay() {
    return day;
  }
  
  /**Moves date to next calender day*/
  public void incrementDay() {
    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12) && day < 31) 
      day++;
    else if ((month == 4) || (month == 6) || (month == 9) || (month == 11) && day < 30)
      day++;
    else if (month == 2 && day < 28)
      day++;
    else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12) && day == 31) {
      if (month == 12) {
        month = 1;
        day = 1;
        return;
      }
      month++;
      day = 1;
    }
    else if ((month == 4) || (month == 6) || (month == 9) || (month == 11) && day == 30) {
      month++;
      day = 1;
    }
    else if (month == 2 && day == 28) {
      month++;
      day = 1;
    }
  }
  
  /**@Override
    *@return True if dates are the same, otherwise false
    *@param date  Date being compared to this. date
    */
  public boolean equals(Date date) {
    if (day == date.day && month == date.month)
      return true;
    else {
      return false;
    }
  }
  
  /**@Override
    *@return The date as a string of characters and numbers
    */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (month == 1)
      builder.append("Jan ");
    else if (month == 2)
      builder.append("Feb ");
    else if (month == 3)
      builder.append("Mar ");
    else if (month == 4)
      builder.append("Apr ");
    else if (month == 5)
      builder.append("May ");
    else if (month == 6)
      builder.append("Jun ");
    else if (month == 7)
      builder.append("Jul ");
    else if (month == 8)
      builder.append("Aug ");
    else if (month == 9)
      builder.append("Aug ");
    else if (month == 10)
      builder.append("Oct ");
    else if (month == 11)
      builder.append("Nov ");
    else if (month == 12)
      builder.append("Dec ");
    builder.append(day);
    return builder.toString();
  }
}