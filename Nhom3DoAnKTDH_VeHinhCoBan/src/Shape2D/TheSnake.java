/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

import Materials.Diem;
import Materials.HinhTron;
import Materials.HinhVuong;
import static Shape2D.BienDoi.XuayQuanh1Diem;
import java.awt.Color;
import static java.lang.Math.PI;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HUYENKUTE
 */
public class TheSnake {
    public boolean moiVuaAnNo = false;
    public Point5Pixel mat1;
    public Point5Pixel mat2;
    public ArrayList<Point5Pixel> thanran;
    public ArrayList<Point5Pixel> duoiran;
    public ArrayList<HinhTron> them;
    public ArrayList<Point5Pixel> luoi = new ArrayList<>();
    
    public Color mauthan1 = Color.ORANGE;
    public Color mauthan2 = Color.BLACK;
    ;
    public static int BienDo = 20;
    public int length;
    public int x, y; // dieam bat dau = doi mat cua ran
    int xduoi = 0, yduoi = 0;
    

    public int huongDiChuyen = 0; // 0-1-2-3-  Phai-Xuong-Trai-Len
    public int huongDiChuyenCu = 0; // 0-1-2-3-  Phai-Xuong-Trai-Len
    public int huongDuoi = 3; // 0-1-2-3-  Phai-Xuong-Trai-Len
    public final static int LEN = 3;
    public final static int XUONG = 1;
    public final static int TRAI = 2;
    public final static int PHAI = 0;

    public TheSnake() {
        mat1 = new Point5Pixel();
        mat2 = new Point5Pixel();
        thanran = new ArrayList<>();
        duoiran = new ArrayList<>();
        them = new ArrayList<>();
    }

    public TheSnake(int length, int x, int y) {
        this.length = length;
        this.x = x;
        this.y = y;
        mat1 = new Point5Pixel(x, y - 1);
        mat2 = new Point5Pixel(x, y + 2);
        thanran = new ArrayList<>();
        duoiran = new ArrayList<>();
        them = new ArrayList<>();

        for (int i = x - length; i < x; i++) {
            int Y = (int) (1.5 * Math.sin((0.5 * i)) + y);
            if (i >= 0 && Y >= 0 && i < 220 && Y < 130) {
                if ((i - x) % 5 == 0) {
                    thanran.add(new Point5Pixel(i, Y, mauthan1));
                    thanran.add(new Point5Pixel(i, Y + 1, mauthan1));
                    thanran.add(new Point5Pixel(i, (Y - 1), mauthan1));
//                    thanran.add(new Point5Pixel(i, Y + 3, mauthan1));

                } else {
                    thanran.add(new Point5Pixel(i, Y, mauthan2));
                    thanran.add(new Point5Pixel(i, Y + 1, mauthan2));
                    thanran.add(new Point5Pixel(i, Y - 1, mauthan2));
//                    thanran.add(new Point5Pixel(i, Y + 3, mauthan2));

                }
            }

        }
        xduoi = x - length - 1;
        yduoi = (int) (1.5 * Math.sin((xduoi * 0.5)) + y + 1);
        if (xduoi >= 0 & yduoi >= 0 && xduoi < 220 && yduoi < 130) {
            duoiran.add(new Point5Pixel(xduoi, yduoi, mauthan1));
            duoiran.add(new Point5Pixel(xduoi, yduoi + 1, mauthan1));
        }
        if (xduoi >= 1 && yduoi >= 0 && xduoi < 220 && yduoi < 130) {
            duoiran.add(new Point5Pixel(xduoi - 1, yduoi + 1, mauthan1));
        }
        
    }

    public void TiepTuc() {
        ArrayList<Point5Pixel> thanranMoi = new ArrayList<>();

        //=========== Bỏ đốt cuối đi =============;
        int diembatdau = 3;
        if(moiVuaAnNo)
        {
            moiVuaAnNo = false;
            diembatdau = 0;
            
        }
        for (int i = diembatdau; i < thanran.size(); i++) {
            thanranMoi.add(thanran.get(i));
        }
        //=========== Đốt mới của bé rắn=========     
        if (huongDiChuyen == XUONG ||huongDiChuyen == LEN )
        {
                int X = (int) (1.5 * Math.sin((0.5 * y)) + x);
                thanranMoi.add(new Point5Pixel(X, y, mauthan1));
                thanranMoi.add(new Point5Pixel(X+1, y, mauthan1));
                thanranMoi.add(new Point5Pixel(X-1, y, mauthan1));
//                thanranMoi.add(new Point5Pixel(X+2, y, mauthan1));
//                thanranMoi.add(new Point5Pixel(X-2, y, mauthan1));
//                thanranMoi.add(new Point5Pixel(X-3, y, mauthan1));
            
        }
        else if (huongDiChuyen == TRAI ||huongDiChuyen == PHAI)
        {
            
            int Y = (int) (1.5 * Math.sin((0.5 * x)) + y);            
            thanranMoi.add(new Point5Pixel(x, Y, mauthan1));
            thanranMoi.add(new Point5Pixel(x, Y+1, mauthan1));
            thanranMoi.add(new Point5Pixel(x, Y-1, mauthan1));
//            thanranMoi.add(new Point5Pixel(x, Y+2, mauthan1));
//            thanranMoi.add(new Point5Pixel(x, Y-2, mauthan1));
        }
        
        for (int i = 0, j = 0; i < thanran.size(); i+= 3, j++) {
            if(j%5 == 0)
            {
                thanranMoi.get(i).color = mauthan1;
                thanranMoi.get(i+1).color = mauthan1;
                thanranMoi.get(i+2).color = mauthan1;
//                thanranMoi.get(i+3).color = mauthan1;                
            }
            else
            {
                thanranMoi.get(i).color = mauthan2;
                thanranMoi.get(i+1).color = mauthan2;
                thanranMoi.get(i+2).color = mauthan2;
//                thanranMoi.get(i+3).color = mauthan2;                   
            }
        }

        //=========== Đầu mới của bé rắn ============
        
        luoi.clear();
        if(huongDiChuyen == PHAI || huongDiChuyen == TRAI)
        {
//            System.out.println(mat1.x + ":"  +mat1.y + "-->mat1");
//            System.out.println(mat2.x + ":"  +mat2.y + "-->mat2");
            if (huongDiChuyen == TRAI)
            {
                x--;
                luoi.add( new Point5Pixel(x, y));
                luoi.add( new Point5Pixel(x-1, y));
                luoi.add( new Point5Pixel(x-2, y));
                luoi.add( new Point5Pixel(x-3, y-1));
                luoi.add( new Point5Pixel(x-3, y+1));
            }
            else{
                x++;
                luoi.add( new Point5Pixel(x, y));
                luoi.add( new Point5Pixel(x+1, y));
                luoi.add( new Point5Pixel(x+2, y)); 
                luoi.add( new Point5Pixel(x+3, y-1));
                luoi.add( new Point5Pixel(x+3, y+1));         
            
            }
            mat1 = new Point5Pixel(x, y - 2);
            mat2 = new Point5Pixel(x, y + 2);
            
            
        }
        if(huongDiChuyen == LEN || huongDiChuyen == XUONG)
        {
//            System.out.println(mat1.x + ":"  +mat1.y + "-->mat1");
//            System.out.println(mat2.x + ":"  +mat2.y + "-->mat2");
            if (huongDiChuyen == LEN)
            {
                y--;
                
                luoi.add( new Point5Pixel(x, y));
                luoi.add( new Point5Pixel(x, y-1));
                luoi.add( new Point5Pixel(x, y-2));
                luoi.add( new Point5Pixel(x-1, y-3));
                luoi.add( new Point5Pixel(x+1, y-3));
            
            }
            else{
                y++;
                luoi.add( new Point5Pixel(x, y));
                luoi.add( new Point5Pixel(x, y+1));
                luoi.add( new Point5Pixel(x, y+2));
                luoi.add( new Point5Pixel(x-1, y+3));
                luoi.add( new Point5Pixel(x+1, y+3));
            
            }
            mat1 = new Point5Pixel(x+2, y );
            mat2 = new Point5Pixel(x-2, y );
           
        }
        //=================LƯỠI============================
        //=========== Vẽ Lại đuôi rắn ===============
        
        xduoi = thanran.get(0).x;
        yduoi = thanran.get(0).y;
        
        //==================Loại bỏ vòng quẹo ==================
        if(them.size() > 0)
        {
            if(abs(xduoi - them.get(0).tam.x) <=2 && abs(yduoi - them.get(0).tam.y) <=2)
                them.remove(0);
        }
        
        duoiran.clear();
        if (xduoi >= 1 & yduoi >= 1 && xduoi < 219 && yduoi < 130) {
            duoiran.add(new Point5Pixel(xduoi, yduoi, mauthan2));
            
            duoiran.add(new Point5Pixel(xduoi, yduoi + 1, mauthan2));
            duoiran.add(new Point5Pixel(xduoi+1, yduoi , mauthan2));
            duoiran.add(new Point5Pixel(xduoi-1, yduoi , mauthan2));
            duoiran.add(new Point5Pixel(xduoi, yduoi-1 , mauthan2));
        }
        if (xduoi >= 1 && yduoi >= 0 && xduoi < 220 && yduoi < 130) {
//            duoiran.add(new Point5Pixel(xduoi - 1, yduoi + 1, mauthan2));
        }
        thanran = thanranMoi;

    }

    public void QueoLen() {
        huongDiChuyenCu = huongDiChuyen;
        huongDiChuyen = LEN;
        if(huongDiChuyenCu == TRAI)
            them.add(new HinhTron(new Diem(x+1, y), 2));
        if(huongDiChuyenCu == PHAI)
            them.add(new HinhTron(new Diem(x-1, y), 2));
    }

    public void QueoXuong() {
        huongDiChuyenCu = huongDiChuyen;
        huongDiChuyen = XUONG;
        if(huongDiChuyenCu == TRAI)
            them.add(new HinhTron(new Diem(x+1, y), 2));
        if(huongDiChuyenCu == PHAI)
            them.add(new HinhTron(new Diem(x-1, y), 2));
        
    }

    public void QueoTrai() {
        huongDiChuyenCu = huongDiChuyen;
        huongDiChuyen = TRAI;
        if(huongDiChuyenCu == LEN)
            them.add(new HinhTron(new Diem(x, y+1), 2));
        if(huongDiChuyenCu == XUONG)
            them.add(new HinhTron(new Diem(x, y-1), 2));
    }

    public void QueoPhai() {
        huongDiChuyenCu = huongDiChuyen;
        huongDiChuyen = PHAI;
        if(huongDiChuyenCu == LEN)
            them.add(new HinhTron(new Diem(x, y+1), 2));
        if(huongDiChuyenCu == XUONG)
            them.add(new HinhTron(new Diem(x, y-1), 2));
        
    }

}
