/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;

public class HinhTru extends JPanel {

    public boolean truc;
    public Diem3D a, b, c, d, e, f;
    public int r, cao, r2, r3, cao2;

    private void HinhTru(Graphics g) {
        Diem a2, b2, c2, d2, e2, f2;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        a2 = a.Chuyen_Sang_2D();
        a2.Chuyen_truc_sang_mt();
        g2d.drawString("A", a2.x - 10, a2.y - 5);
        b2 = b.Chuyen_Sang_2D();
        b2.Chuyen_truc_sang_mt();
        g2d.drawString("B", b2.x + 10, b2.y - 5);
        c2 = c.Chuyen_Sang_2D();
        c2.Chuyen_truc_sang_mt();
        g2d.drawString("C", c2.x + 10, c2.y - 5);
        d2 = d.Chuyen_Sang_2D();
        d2.Chuyen_truc_sang_mt();
        g2d.drawString("D", d2.x - 10, d2.y - 5);
        e2 = e.Chuyen_Sang_2D();
        e2.Chuyen_truc_sang_mt();
        g2d.drawString("E", e2.x - 10, e2.y - 5);
        f2 = f.Chuyen_Sang_2D();
        f2.Chuyen_truc_sang_mt();
        g2d.drawString("F", f2.x - 10, f2.y - 5);

        cao2 = cao * 5;
        r2 = r * 5;
//        r3 = Math.round( r / 3)*5;
        r3 = round((float)(r*sqrt(2)/2))*5;
        veElip e = new veElip();
        e.ElipTren(g, f2, r2, (int) r3);
        e.ElipDuoi(g, e2, r2, (int) r3);

        DoanThang canh = new DoanThang(a2, d2, g);
        canh = new DoanThang(b2, c2, g);
        canh = new DoanThang(b2, e2, g, true);
        canh = new DoanThang(c2, f2, g);
        canh = new DoanThang(e2, f2, g, true);

    }

    public void paintComponent(Graphics g) {
        if (truc == true) {
            Truc3D truc = new Truc3D();
            truc.Truc3D(g);
            HinhTru(g);
        }
        HinhTru(g);
    }
}
