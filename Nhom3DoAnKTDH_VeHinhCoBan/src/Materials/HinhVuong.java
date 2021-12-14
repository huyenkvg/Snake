/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.awt.Color;

/**
 *
 * @author HUYENKUTE
 */
public class HinhVuong {
    public int a,x,y;
    boolean isFilled;
    Color color;

    public HinhVuong(int a, Color color) {
        this.a = a;
        this.isFilled = true;
        this.color = color;
    }

    public HinhVuong() {
        this.isFilled = true;
    }
    
    public HinhVuong(int a, int x, int y) {
        this.a = a;
        this.isFilled = true;
        this.x = x;
        this.y = y;
        
    }
    
    
    
}
