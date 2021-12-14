/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import Materials.Diem;

/**
 *
 * @author Thao Nguyen
 */
public class PointDouble {
    public double x,y;

    public PointDouble() {
    }

    public PointDouble(Diem P) {
        this.x = P.x;
        this.y = P.y;
    }
    public PointDouble(double a, double b) {
        this.x = a;
        this.y = b;
    }

   public PointDouble Chuyen_truc3D_sang_mt(){
        
        if(this.x>=0){
            if(this.y<=0){
                this.x = this.x*5+500;
                this.y = (-this.y)*5+400;
                
            }
            else{
                this.x = this.x*5+500;
                this.y = 400 - this.y*5;
                
            }
        }
        else{
            if(this.y<=0){
                this.x = 500+this.x*5;
                this.y = (-this.y)*5+400;
            }
            else{
                this.x = 500+this.x*5;
                this.y = 400-this.y*5;
            }   
        }
        this.x=this.x -2;
        this.y=this.y-2;
       return this;
    }
   public Diem Chuyen_Sang_int(){
       Diem b = new Diem();
       b.x =  (int) x ;
       b.y = (int) y;
       return b;
   }
}
