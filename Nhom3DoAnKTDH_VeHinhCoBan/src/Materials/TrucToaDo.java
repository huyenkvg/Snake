/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Nhóm 3 - Nguyễn Đỗ Yến Chi - Châu Văn Hậu - Lê Thị Thu Hương - Nguyễn Thị Thanh Huyền - Nguyễn Thị Thảo Nguyên
 */
public class TrucToaDo extends JPanel{
    public ArrayList<Diem> diem = new ArrayList<Diem>(); 
    public boolean intenDiemBai5 = false;
 private void TrucToaDo(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Diem s;
        g2d.setColor(Color.LIGHT_GRAY);
        int y=300, x=300;
        
        while(y<600){
            g2d.drawLine(0, y+5, 600, y+5);
            y+=5;
        }
        
        y=300;
        while(y>0){
            g2d.drawLine(0, y-5, 600, y-5);
            y-=5;
        }
        
        while(x<600){
            g2d.drawLine(x+5, 600, x+5, 0);
            x+=5;
        }
        x=300;
        while(x>0){
            g2d.drawLine(x-5, 600, x-5, 0);
            x-=5;
        }
        
        g2d.setPaint(Color.blue);
        //Ox 300, 301
        g2d.drawLine(0, 300 , 600, 300);
        //Oy 301, 302
        g2d.drawLine(300, 600, 300, 0);
    
        if(diem.size()>0) {
            for(int i=0 ; i<diem.size();i++){
                s=new Diem();
                s.x = diem.get(i).x;
                s.y = diem.get(i).y;
                s.Chuyen_mt_sang_truc();
                g2d.fillRect(diem.get(i).x, diem.get(i).y, 5, 5);
                g2d.drawString("("+s.x+", "+s.y+")", diem.get(i).x +12, diem.get(i).y+4);
                if(i==(diem.size()-1)){
                    g2d.setPaint(Color.RED);
                    g2d.fillRect(diem.get(i).x, diem.get(i).y, 5, 5);
                    g2d.drawString("("+s.x+", "+s.y+")", diem.get(i).x +12, diem.get(i).y+4);
                }
                if (intenDiemBai5 == true)
                {
                    if (i == 0)
                    {
                        g2d.drawString("Q", diem.get(i).x +4, diem.get(i).y+4);
                    }if (i == 1)
                    {
                        g2d.drawString("A", diem.get(i).x +4, diem.get(i).y+4);
                    }if (i == 2)
                    {
                        g2d.drawString("P", diem.get(i).x +4, diem.get(i).y+4);
                    }
                        
                }
            }
        }   
    }
public void addDiem(int a, int b){
        Diem s = new Diem();
        s.x = a;
        s.y = b;
        diem.add(s);
        
}
 @Override
    public void paintComponent(Graphics g) {
 
        //super.paintComponent(g);
        TrucToaDo(g);
    }
}

