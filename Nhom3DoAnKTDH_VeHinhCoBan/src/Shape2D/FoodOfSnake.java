/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

import Materials.Diem;
import Materials.DoanThang;
import Materials.HinhTron;
import java.awt.Color;

/**
 *
 * @author HUYENKUTE
 */
public class FoodOfSnake {
    public int x, y;
    public int BanKinh;
    public int count = 0;
    public static final int FOOD = 0;
    public static final int BOOM = 1;
    public static final int HODEN = 2;
    
    public HinhTron food;
    public HinhTron inerFood;
    public Color foodColor = Color.GREEN;
    public Color foodColor2 = Color.RED;
    public Color boomColor = Color.BLACK;
    public Color boomColor2 = Color.WHITE;
    public int type;
    public DoanThang ngoiBoom;

    public FoodOfSnake(int x, int y, int type, int bankink) {
        this.x = x;
        this.y = y;
        this.type = type;
        BanKinh = bankink;
        food = new HinhTron(new Diem(x, y), BanKinh);
        inerFood = new HinhTron(new Diem(x, y), BanKinh-2);
        ngoiBoom = new DoanThang(new Diem(x, y), new Diem(x+6, y-4), 0);
    }
    public void NhapNho(double Dy) // Thu Phóng theo thông số Dy
    {
        if(count++%2 == 1)
        {
            food.radius *= Dy;
            inerFood.radius *= Dy;
        }
        else
        { 
            food.radius /= Dy;
            inerFood.radius /= Dy;
        }
        if(type == FOOD) // Nếu là thức ăn thì tịnh tiến lên xuống, trái phãi 1 đơn vị vẽ nữa.
            if(count %40 < 20)
            {
                if(count %80 < 40)
                    if(count%40 < 10)
                            y--;
                    else
                        y++;
                else
                    if(count%40 < 10)
                            y++;
                    else
                        y--;
            }
            else{
                if(count %80 < 40)
                    if(count%40 < 30)
                            x--;
                    else
                        x++;
                else
                    if(count%40 < 30)
                            x++;
                    else
                        x--;
            }
        else if(type == BOOM)
        {
            if(count%2  == 1)
                ngoiBoom.cuoi.y++;
            else
                ngoiBoom.cuoi.y--;
        }
    }
    
}
