/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.PI;

/**
 *
 * @author HUYENKUTE
 */
public class Point5Pixel {
    public int x,y;
    public int x1,y1;
    
    public Color color3;
    public Color color = new Color(204,204,255);
    public boolean trangThaiX5picel = false;

    public Point5Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Point5Pixel() {
    }
    public Point5Pixel(Point5Pixel x) {
        this.color = x.color;
        this.color3= x.color3;
        this.x = x.x;
        this.y = x.y;
        this.trangThaiX5picel = x.trangThaiX5picel;
    }
    public Point5Pixel(int x, int y) {
        this.x = x;
        this.y = y;
        color = new Color(204,204,255);
        //color = new Color(255,105,180);
        color3 = new Color(112,128,144);//đường đua
        
        
    }
    public void SwitchToX5Picel()
    {
        if(trangThaiX5picel == false)
        {
            x = x*5;
            y = y*5;
            trangThaiX5picel = true;
        }
    }
    public void SwitchToX1Picel()
    {
        if(trangThaiX5picel == true)
        {
            x = x/5;
            y = y/5;
            trangThaiX5picel = false;
        }
    }
    public void SwitchToMTPoint() // Đã là đơn vị 5 pixel nha
    {
        if(x <= 0)
            {
                x = 110 + x;
            }
        else
            {
                x += 110;
            }
        
                y= 65-y;
    }
    public void SwitchToAxisPoint() // Đã là đơn vị 5 pixel nha
    {
            if(x >= 110)
            {
                x -= 110;
            }
            else
            {
                x = - (110-x);
            }
            if(y >= 65)
            {
                y= -( y- 65);
            }
            else
            {
                y = (65-y);
            }
    }
    
    public static void main(String[] args) {
        Point5Pixel A = new Point5Pixel(10, 0);
        Point5Pixel Q = new Point5Pixel(15, 0);
        Point5Pixel P = BienDoi.biendoi2D(BienDoi.XuayQuanh1Diem(PI/2.0, A.x, A.y), Q);
        System.out.println("---->: P(" +P.x+" : "+P.y+")");
        
    }
    
    
}
