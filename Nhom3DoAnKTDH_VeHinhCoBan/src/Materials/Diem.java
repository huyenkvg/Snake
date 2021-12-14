/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

/**
 *
 * @author Nhóm 3 - Nguyễn Đỗ Yến Chi - Châu Văn Hậu - Lê Thị Thu Hương - Nguyễn Thị Thanh Huyền - Nguyễn Thị Thảo Nguyên
 */
public class Diem {
    public int x,y;
    public Diem() {
        this.x = 0;
        this.y = 0;
    }
    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void Chuyen_truc_sang_mt(){
        
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
       
    }
    public void Chuyen_mt_sang_truc(){
        Diem s = new Diem();
        
        if(this.x>=300){
            if(this.y<=300){
                this.x = (this.x-300)/5 + (((this.x-300) % 5 < 3) ? 0 : 1);
                this.y = (60 - (this.y/5 + ((this.y % 5 < 3) ? 0 : 1)));
                
            }
            else{
                this.x = (this.x-300)/5 + (((this.x-300) % 5 < 3) ? 0 : 1);
                this.y = (300 -this.y)/5 + (((300 -this.y) % 5 < 3) ? 0 : 1);
               
            }
        }
        else{
            if(this.y<=300){
                this.x = (this.x-300)/5 + (((this.x-300) % 5 >= 3) ? 1 : 0);
                this.y =(60 - (this.y/5 + ((this.y % 5 < 3) ? 0: 1)));      
               
            }
            else{
                this.x = (this.x-300)/5 + (((this.x-300) % 5 >= 3) ? 1 : 0);
                this.y = (300 - this.y)/5 + (((300 - this.y) % 5 < 3) ? 0 : 1); 
                
            }   
        }
        
    }
}
