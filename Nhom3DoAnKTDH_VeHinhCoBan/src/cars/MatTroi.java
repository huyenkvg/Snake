/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import Materials.Diem;
import Materials.DoanThang;
import Materials.HinhTron;
import Shape2D.Point5Pixel;
import static cars.PhepBienDoi2D.PI;
import static cars.PhepBienDoi2D.XuayQuanh1Diem;

/**
 *
 * @author HUYENKUTE
 */
public class MatTroi {
    public HinhTron mattroi;
    public DoanThang[] tia = new DoanThang[11];
    public int x, y;
    int gocXoay = 20;
    public MatTroi( int x, int y) {
        this.mattroi = new HinhTron(new Diem(x,y), 10);
        tia[0] = new DoanThang(new Diem(x, y), new Diem(x+10, y+10), 0);
        for(int i = 1; i <= 10; i++)
        {
            tia[i] = new DoanThang(new Diem(x, y), new Diem(x+14, y+14), 0);
            Point5Pixel tam = PhepBienDoi2D.biendoi2D( XuayQuanh1Diem(PI/10*i, x+14, y+14), new Point5Pixel(x, y));
            tia[i].cuoi = new Diem(tam.x, tam.y);
        }
        this.x = x;
        this.y = y;
    }
    
   
    public void Xoay()
    {
        gocXoay+=10;
        if(gocXoay > 2000)
                gocXoay = 20;
        for(int i = 0; i <= 10; i++)
        {
            Point5Pixel Ttam = PhepBienDoi2D.biendoi2D( XuayQuanh1Diem(gocXoay*i,  x+14 , y+14), new Point5Pixel(x, y));
            tia[i].cuoi = new Diem(Ttam.x, Ttam.y);
            
        }
    }
}
