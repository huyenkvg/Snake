/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

/**
 *
 * @author CVanHau
 */
public class Diem3D {
    int x,y,z;
    public Diem3D(){
        this.x=0;
        this.y=0;
        this.z=0;
    }
    public Diem3D(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public Diem Chuyen_Sang_2D(){
        float a =  x - z*((float)(Math.sqrt(2))/2);
        float b =  y - z*((float)(Math.sqrt(2))/2); 
        Diem diem = new Diem(Math.round(a),Math.round(b));
        return diem;
    }
    public String HienThi(){
        return "("+x+", "+y+", "+z+")";
    }

}

