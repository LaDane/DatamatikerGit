package balls;


import javax.swing.JPanel;
import java.awt.*;

/**
 * Start code for Thread Exercise
 */
class Ball extends Thread{



  private final int SLEEP_TIME = 30;
  Color color;
  boolean stop = false;
  private JPanel canvas;
  private static final int XSIZE = 15;
  private static final int YSIZE = 15;
  private int x = 0;
  private int y = 0;
  private int dx = 5;
  private int dy = 5;

  public Ball(JPanel c, Color col) {
    canvas = c;
    color = col;
  }

  public void stopBall() {
    Graphics g = canvas.getGraphics();
    g.setColor(canvas.getBackground());
    g.fillOval(x, y, XSIZE, YSIZE);
    stop = true;
  }

  public void move() {
    Graphics g = canvas.getGraphics();
    g.setColor(canvas.getBackground());
    g.fillOval(x, y, XSIZE, YSIZE);
    x += dx;
    y += dy;
    Dimension d = canvas.getSize();
    if (x < 0) {
      x = 0;
      dx = -dx;
    }
    if (x + XSIZE >= d.width) {
      x = d.width - XSIZE;
      dx = -dx;
    }
    if (y < 0) {
      y = 0;
      dy = -dy;
    }
    if (y + YSIZE >= d.height) {
      y = d.height - YSIZE;
      dy = -dy;
    }
    g.setColor(color);
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
  }


  @Override
  public void run() {
    stop = false;
    while (!stop) {
      move();
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }

}
