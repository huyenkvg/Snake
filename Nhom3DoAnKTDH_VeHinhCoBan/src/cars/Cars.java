
package cars;

import Materials.Tree;
import javax.swing.JFrame;

public class Cars extends JFrame {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //work w = new work();
        //frame.add(w);
        Tree t = new Tree();
        frame.add(t);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setResizable(false);
        frame.setSize(1110,650);
        frame.setTitle("Chào mừng huyền đến với đường đua!!!");
        frame.setVisible(true);
    }
}
