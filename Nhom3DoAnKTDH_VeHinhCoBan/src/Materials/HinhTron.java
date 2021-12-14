/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import Materials.Diem;
import static java.lang.Math.abs;

/**
 *
 * @author HUYENKUTE
 */
public class HinhTron {
    public Diem tam;
    public int radius;

    public Diem getTam() {
        return tam;
    }

    public void setTam(Diem tam) {
        this.tam = tam;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public HinhTron(Diem tam, int radius) {
        this.tam = tam;
        this.radius = abs(radius);
    }
    public HinhTron() {
        tam = new Diem(0,0);
        radius = 0;
    }    
}
