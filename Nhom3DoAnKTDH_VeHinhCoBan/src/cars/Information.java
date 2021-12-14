
package cars;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class Information extends JDialog {
	private JPanel contentPane;
       
	public Information(String infotext,int x, int y) {
		this.setTitle("Thông báo");
		this.setBounds(x, y, 300, 150);
		this.setVisible(true);
                this.setResizable(false);
                this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
                this.setAlwaysOnTop(true);
                

	}

}
