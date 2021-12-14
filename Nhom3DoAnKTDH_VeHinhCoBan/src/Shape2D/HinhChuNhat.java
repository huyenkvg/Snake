
package Shape2D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class HinhChuNhat {
    //dau: đầu cạnh
    //cuoi: cuối cạnh
    private void HinhChuNhat(Graphics g,Point dau, Point cuoi){
        Graphics2D g2d = (Graphics2D) g;
        int y = 0, x = 0;
        x = dau.x;
        y = dau.y;
        if( dau.x < cuoi.x && dau.y < cuoi.y){
            while(x <= cuoi.x){
                while(y <= cuoi.y){
                    g2d.fillRect(x, y, 5, 5);
                    y += 5;
                }
                y = dau.y;
                x+=5;
            }
        }else if(dau.x > cuoi.x && dau.y > cuoi.y){
            while(x >= cuoi.x){
                while(y >= cuoi.y){
                    g2d.fillRect(x, y, 5, 5);
                    y -= 5;
                }
                y = dau.y;
                x -= 5;
            }
         }else if(dau.x > cuoi.x && dau.y < cuoi.y){
            while(x >= cuoi.x){
                while(y <= cuoi.y){
                    g2d.fillRect(x, y, 5, 5);
                    y += 5;
                }
                y = dau.y;
                x -= 5;
            }
        }else if(dau.x < cuoi.x && dau.y > cuoi.y){
            while(x <= cuoi.x){
                while(y >= cuoi.y){
                    g2d.fillRect(x, y, 5, 5);
                    y -= 5;
                }
                y = dau.y;
                x += 5;
            }
        }
    }
    
}
