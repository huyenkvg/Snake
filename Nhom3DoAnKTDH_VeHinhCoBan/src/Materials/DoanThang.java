/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import Materials.Diem;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.math.BigInteger;


/**
 *
 * @author Nhóm 3 - Nguyễn Đỗ Yến Chi - Châu Văn Hậu - Lê Thị Thu Hương - Nguyễn Thị Thanh Huyền - Nguyễn Thị Thảo Nguyên
 */
public class DoanThang {
    public Diem dau =new Diem();
    public Diem cuoi =new Diem();
    public int d;
    public Diem phapTuyen;
    public Diem muiten2;
    public Diem muiten1;
    public DoanThang() {
        dau = new Diem();
        cuoi = new Diem();
    }
    public DoanThang(Diem dau, Diem cuoi, Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        Diem p = new Diem(), pe = new Diem();
        int dx, dy, dx1, dy1, s1, s2;
        dx = cuoi.x - dau.x;
        dy = cuoi.y - dau.y;
        dx1 = abs(dx);
        dy1 = abs(dy);
        s1 = 2 * dy1 - dx1;
        s2 = 2 * dx1 - dy1;

        if (dy1 < dx1){
            if (dx >= 0){
                p.x= dau.x;
                p.y =dau.y;
                pe.x = cuoi.x;
            }
            else
            {
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.x = dau.x;
            }
            g2d.fillRect(p.x, p.y, 5, 5);

            for (int j = 0; p.x < pe.x; j++){
                p.x = p.x + 5;
                if (s1 < 0) s1 = s1 + 2 * dy1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.y = p.y + 5;
                    else p.y = p.y - 5;
                    s1 = s1 + 2 * (dy1 - dx1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        }
        else{
            if (dy >= 0){
                p.x = dau.x;
                p.y = dau.y;
                pe.y = cuoi.y;
            }
            else{
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.y = dau.y;
            }
            g2d.fillRect(p.x, p.y, 5, 5);
            for (int j = 0; p.y < pe.y; j++){
                p.y = p.y + 5;
                if (s2 <= 0) s2 = s2 + 2 * dx1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.x = p.x + 5;
                    else p.x = p.x - 5;
                    s2 = s2 + 2 * (dx1 - dy1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        }
    }
    public DoanThang(Diem dau, Diem cuoi, Graphics g, boolean dut){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        int dem=0;
        Diem p = new Diem(), pe = new Diem();
        int dx, dy, dx1, dy1, s1, s2;
        dx = cuoi.x - dau.x;
        dy = cuoi.y - dau.y;
        dx1 = abs(dx);
        dy1 = abs(dy);
        s1 = 2 * dy1 - dx1;
        s2 = 2 * dx1 - dy1;

        if (dy1 <= dx1){
            if (dx >= 0){
                p.x= dau.x;
                p.y =dau.y;
                pe.x = cuoi.x;
            }
            else
            {
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.x = dau.x;
            }
            if(dem%4==0||dem%4==1){
                g2d.fillRect(p.x, p.y, 5, 5);
            }
            dem++;

            for (int j = 0; p.x < pe.x; j++){
                p.x = p.x + 5;
                if (s1 < 0) s1 = s1 + 2 * dy1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.y = p.y + 5;
                    else p.y = p.y - 5;
                    s1 = s1 + 2 * (dy1 - dx1);
                }
                if(dem%4==0||dem%4==1){
                    g2d.fillRect(p.x, p.y, 5, 5);
                }
                dem++;
            }
        }
        else{
            if (dy >= 0){
                p.x = dau.x;
                p.y = dau.y;
                pe.y = cuoi.y;
            }
            else{
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.y = dau.y;
            }
            if(dem%4==0||dem%4==1){
                g2d.fillRect(p.x, p.y, 5, 5);
            }
            dem++;
            for (int j = 0; p.y < pe.y; j++){
                p.y = p.y + 5;
                if (s2 <= 0) s2 = s2 + 2 * dx1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.x = p.x + 5;
                    else p.x = p.x - 5;
                    s2 = s2 + 2 * (dx1 - dy1);
                }
                if(dem%4==0||dem%4==1){
                    g2d.fillRect(p.x, p.y, 5, 5);
                }
                dem++;
            }
        }
    }
    public DoanThang(Diem dau, Diem cuoi, int d){
        this.dau = dau;
        this.cuoi = cuoi;
        this.d = d;
        if (d == 4)
        {
            int a = dau.x - cuoi.x;
            int b = dau.y - cuoi.y;
            BigInteger b1 = BigInteger.valueOf(a);
            BigInteger b2 = BigInteger.valueOf(b);
            BigInteger gcd = b1.gcd(b2);
            a = a/gcd.intValue();
            b = b/gcd.intValue();
            phapTuyen=new Diem(b, -a);
        }
    }
    public void setMuiTen(int doLonMuiTen)
    {
        setPhapTuyen();
        Diem chiphuong = new Diem(-phapTuyen.y, phapTuyen.x);
       // doLonMuiTen = (int) min(abs(doLonMuiTen), abs(sqrt((dau.x-cuoi.x)*(dau.x-cuoi.x)+(dau.y-cuoi.y)*(dau.y-cuoi.y))));
        
        Diem see= new Diem();
          
        float scale = (float) ((doLonMuiTen/abs(sqrt(phapTuyen.x*phapTuyen.x+phapTuyen.y*phapTuyen.y))));
            see.x = (int) (cuoi.x+chiphuong.x*(scale));
            see.y = (int) (cuoi.y+chiphuong.y*(scale));
       
        
        
        muiten1 = new Diem((int) (see.x+ 1.0*phapTuyen.x*(scale)), (int) (see.y+1.0*phapTuyen.y*(scale)));
        muiten2 = new Diem((int) (see.x- 1.0*phapTuyen.x*(scale)), (int) (see.y-1.0*phapTuyen.y*(scale)));
       // muiten2 = new Diem(see.x-phapTuyen.x*((int)scale), see.y-phapTuyen.y*((int)scale));       
        
    }
    public void setPhapTuyen()
    {
            int a = dau.x - cuoi.x;
            int b = dau.y - cuoi.y;
            BigInteger b1 = BigInteger.valueOf(a);
            BigInteger b2 = BigInteger.valueOf(b);
            BigInteger gcd = b1.gcd(b2);
            a = a/gcd.intValue();
            b = b/gcd.intValue();
            
            phapTuyen=new Diem(b, -a);
            //return phapTuyen;
    }
    
    
    
}
