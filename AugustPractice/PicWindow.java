/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AugustPractice;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author ahmad
 */
public class PicWindow implements WindowListener{
    
    public JFrame window;
    
    public boolean isOpen = false;
    
    public PicWindow(int width, int height, String name){
        
    }
    
    public PicWindow(String name){
       window = new JFrame();
       window.setTitle(name);
       window.addWindowListener(this);
       window.setSize(100,100);
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       isOpen = true;
    }
    
    public JFrame getFrame(){
        return window;
    }
    

    @Override
    public void windowOpened(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        System.out.println("Task Done");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
