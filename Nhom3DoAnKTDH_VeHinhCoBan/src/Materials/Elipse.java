/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

/**
 *
 * @author HUYENKUTE
 */
public class Elipse {
    public Diem tam;
    public int a,b;

    public Elipse(Diem tam, int a, int b) {
        this.tam = tam;
        this.a = a;
        this.b = b;
    }
    public Elipse() {
        tam = new Diem(0,0);
        a = 0;
        b = 0;
    }

    public Diem getTam() {
        return tam;
    }

    public void setTam(Diem tam) {
        this.tam = tam;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
}
