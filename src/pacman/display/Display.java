package pacman.display;

import javax.swing.JFrame;
import java.awt.*;
public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int w,h;
    public Display(String title,int w,int h){
        this.title=title;
        this.w=w;
        this.h=h;
        createDisplay();
        
    }
    
    private void createDisplay(){
        frame=new JFrame(title);
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas=new Canvas();
        canvas.setFocusable(false);
        
        canvas.setPreferredSize(new Dimension(w,h));
        canvas.setMaximumSize(new Dimension(w,h));
        canvas.setMinimumSize(new Dimension(w,h));   
        frame.add(canvas);
        frame.pack();
    }
    public Canvas getCanvas(){
        return canvas;
        
    }
    public JFrame getFrame() {
    	return frame;
    }
}

