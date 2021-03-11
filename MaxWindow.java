//Frankie Nyaga
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MaxWindow extends JFrame {
  private boolean heightMaximized = false;
  private int originalHeight = 0;
  private boolean widthMaximized = false;
  private int originalWidth = 0;
  // Moves window to top and keeps horizontal
  public void snapToTop(){
    this.setLocation(getX(),0);
  }
  // Moves window to the left keeps vertical
  public void snapToLeft(){
    this.setLocation(0,getY());
  }
  //stretches window height to the max
  public void maximizeHeight(boolean x){
    if ((x == true) && (heightMaximized == false)) {
      originalHeight = this.getHeight();
      this.snapToTop();
      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension d = kit.getScreenSize();
      int y = (int)d.getHeight();
      this.setSize(getX(),y);
      heightMaximized = true;
    }
    else if ((x == false) && (heightMaximized == true)){
      this.setSize(getX(),originalHeight);
      heightMaximized = false;
    }
  }
  //stretches window width to the max
  public void maximizeWidth(boolean y){
    if ((y == true) && (widthMaximized == false)) {
      originalWidth = this.getWidth();
      this.snapToLeft();
      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension d = kit.getScreenSize();
      int x = (int)d.getWidth();
      this.setSize(x, getY());
      widthMaximized = false;
    }
    else if ((y == false) && (widthMaximized == true)){
      this.setSize(originalWidth, getY());
      widthMaximized = false;
    }
  }
}