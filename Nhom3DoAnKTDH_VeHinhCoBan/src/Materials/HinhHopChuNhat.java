/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author CVanHau
 */
public class HinhHopChuNhat extends JPanel {
    public boolean truc;
    public Diem3D a,b,c,d,e,f,g,h;
    public int dai, rong, cao;
    private void HinhHopChuNhat (Graphics g){
        Diem a2,b2,c2,d2,e2,f2,g2,h2;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        a2 =  a.Chuyen_Sang_2D();
        a2.Chuyen_truc_sang_mt();
        g2d.drawString("A", a2.x-7, a2.y-5-2);
        b2 =  b.Chuyen_Sang_2D();
        b2.Chuyen_truc_sang_mt();
        g2d.drawString("B", b2.x-7, b2.y-5-2);
        c2 =  c.Chuyen_Sang_2D();
        c2.Chuyen_truc_sang_mt();
        g2d.drawString("C", c2.x-7, c2.y-5-2);
        d2 =  d.Chuyen_Sang_2D();
        d2.Chuyen_truc_sang_mt();
        g2d.drawString("D", d2.x-7, d2.y-5-2);
        e2 =  e.Chuyen_Sang_2D();
        e2.Chuyen_truc_sang_mt();
        g2d.drawString("E", e2.x-5, e2.y-5);
        f2 =  f.Chuyen_Sang_2D();
        f2.Chuyen_truc_sang_mt();
        g2d.drawString("F", f2.x-5, f2.y-5);
        g2 =  this.g.Chuyen_Sang_2D();
        g2.Chuyen_truc_sang_mt();
        g2d.drawString("G", g2.x-5, g2.y-5);
        h2 =  h.Chuyen_Sang_2D();
        h2.Chuyen_truc_sang_mt();
        g2d.drawString("H", h2.x-5, h2.y-5);
        
        dai = dai*5;
        rong = rong*5;
        cao = cao*5;
        DoanThang canh = new DoanThang(a2, b2, g,true);
        canh = new DoanThang(a2, d2, g, true);
        canh = new DoanThang(a2, e2, g, true);
        canh = new DoanThang(b2, c2, g);
        canh = new DoanThang(b2, f2, g);
        canh = new DoanThang(c2, d2, g);
        canh = new DoanThang(c2, g2, g);
        canh = new DoanThang(d2, h2, g);
        canh = new DoanThang(e2, f2, g);
        canh = new DoanThang(f2, g2, g);
        canh = new DoanThang(g2, h2, g);
        canh = new DoanThang(h2, e2, g);
        
    }
    @Override
    public void paintComponent(Graphics g) {
        if(truc == true){
            Truc3D truc = new Truc3D();
            truc.Truc3D(g);
            HinhHopChuNhat(g);
        }
        HinhHopChuNhat(g);
    }
}

