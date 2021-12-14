/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

//import static MainFolder.Main.diemChoiRan;
import MainFolder.Main;
import static Shape2D.FoodOfSnake.BOOM;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nhóm 3 - Nguyễn Đỗ Yến Chi - Châu Văn Hậu - Lê Thị Thu Hương - Nguyễn
 * Thị Thanh Huyền - Nguyễn Thị Thảo Nguyên
 */
public class MangLuoi2D_VeConRanVersion1 extends JPanel implements ActionListener, KeyListener {

    public int huongdiChuyen = TheSnake.PHAI;
    public boolean AxisVisible = Main.AxisVisible;
    public boolean SnakeVisible = false;
    public boolean foodVisible = true;
    public boolean boomVisible = true;
    public boolean setThua = false;
    public int trangthai = 0;
    public static int diemAn = 0;
    int timeToNewBoom = 90;
    public static int getDiemAn() {
        return diemAn;
    }

    FoodOfSnake food = new FoodOfSnake(60, 70, FoodOfSnake.FOOD, 5);
    FoodOfSnake boom = new FoodOfSnake(135, 40, FoodOfSnake.BOOM, 5);
    FoodOfSnake boom1 = new FoodOfSnake(200, 70, FoodOfSnake.BOOM, 5);
    FoodOfSnake boom2 = new FoodOfSnake(50, 110, FoodOfSnake.BOOM, 6);

    int trangthaiLeLuoi = 0;
    Point5Pixel mangLuoiPixel[][] = new Point5Pixel[150][240];
    Timer timer;
    public TheSnake snake = new TheSnake(70, 80, 25);
    
    public static Point5Pixel toadoDauRan = new Point5Pixel(0, 0);
    public static Point5Pixel toadoThucAn = new Point5Pixel(0, 0);
    public static Point5Pixel toadoBoom1= new Point5Pixel(0, 0);
    public static Point5Pixel toadoBoom2 = new Point5Pixel(0, 0);
    public static Point5Pixel toadoBoom3 = new Point5Pixel(0, 0);

    public MangLuoi2D_VeConRanVersion1() {
        timer = new Timer(50, this);
        addKeyListener(this);
        setFocusable(true);
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 220; j++) {
                mangLuoiPixel[i][j] = new Point5Pixel(i, j);
            }
        }

        timer.start();
        repaint();
    }

    public void ResetAll() {
        huongdiChuyen = TheSnake.PHAI;
        AxisVisible = true;
        SnakeVisible = false;
        foodVisible = true;
        boomVisible = true;
        setThua = false;
        trangthai = 0;

        food = new FoodOfSnake(60, 70, FoodOfSnake.BOOM, 5);
        
        trangthaiLeLuoi = 0;
        mangLuoiPixel = new Point5Pixel[130][220];
        timer.stop();
        timer.removeActionListener(this);
        snake = new TheSnake(70, 70, 25);
    }

    private void VeConRan(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (AxisVisible) {
            g2d.setColor(Color.LIGHT_GRAY);
            int y = 5, x = 5;

            while (y < 650) {
                g2d.drawLine(0, y, 1100, y);
                y += 5;
            }

            while (x < 1100) {
                g2d.drawLine(x, 650, x, 0);
                x += 5;
            }

            g2d.setPaint(Color.blue);
            //Ox 300, 301
            g2d.drawLine(0, 325, 1100, 325);
            //Oy 301, 302
            g2d.drawLine(550, 0, 550, 650);

        }

    }
    void BanDaThua()
    {
        
        setThua = true;
        timer.stop();
        if(setThua == true)
        {
            JOptionPane.showMessageDialog(null, "BẠN ĐÃ THUA !!!", "Thông báo", JOptionPane.YES_NO_OPTION);
            //g2d.fillRect(0, 0, 1100, 652);  
        }
        ToMauVe.VeConRanDaChet(mangLuoiPixel, snake); 
    }
    public void paint(Graphics g) {
         //=============================== CẬP NHẬT TỌA ĐỘ HIỂN THỊ ===========================================
         if(snake.luoi.size() >= 3)
         {
            toadoDauRan = new Point5Pixel(snake.luoi.get(2).x,snake.luoi.get(2).y) ;
            
         }
         else
         {
             toadoDauRan = new Point5Pixel(snake.mat1.x,snake.mat1.y);
         }
        toadoThucAn = new Point5Pixel(food.x, food.y);
        toadoBoom1 = new Point5Pixel(boom1.x, boom1.y);
        toadoBoom2= new Point5Pixel(boom2.x, boom2.y);
        toadoBoom3 = new Point5Pixel(boom.x, boom.y);        
        toadoDauRan.SwitchToAxisPoint();
        toadoThucAn.SwitchToAxisPoint();
        toadoBoom1.SwitchToAxisPoint();
        toadoBoom2.SwitchToAxisPoint();
        toadoBoom3.SwitchToAxisPoint();
        Color check = Color.RED;
        Graphics2D g2d = (Graphics2D) g;
        if (snake.luoi.size() > 0) {
            check = mangLuoiPixel[snake.luoi.get(2).y][snake.luoi.get(2).x].color;
        }

        //=======================Tô Nền nè ================
        //============================ KHỞI TẠỌ PHẦN TỬ TRONG CÁI LƯỚI ============================
        ToMauVe.ToMauNenChoLuoiPixel(mangLuoiPixel);

        //================================== VẼ VÒNG QUẸO  ================================================
        ToMauVe.VeVongQueo(mangLuoiPixel, snake);
        // ================================= VẼ RẮN BẰNG CÁCH TÔ MÀU ======================================
        trangthaiLeLuoi++;
        if (trangthaiLeLuoi % 3 == 0) {
            food.NhapNho(1.5);
            boom.NhapNho(1.5);
            boom1.NhapNho(1.5);
            boom2.NhapNho(1.5);
        }

        ToMauVe.VeConRanRa(mangLuoiPixel, snake, trangthaiLeLuoi);
        Color c1 = new Color(0,52,0);
        Color c2 = new Color(102,0,102);
        if (check == Color.BLACK || check == Color.WHITE || check == c1|| check == c2) {
           
            BanDaThua();
        }
        //==================================== VẼ NGÒI BOM ===============================================
        if (boomVisible == true) {
            ToMauVe.VeNgoiBoom(mangLuoiPixel, boom.ngoiBoom.dau, boom.ngoiBoom.cuoi, boom.boomColor);
            ToMauVe.VeNgoiBoom(mangLuoiPixel, boom1.ngoiBoom.dau, boom1.ngoiBoom.cuoi, boom1.boomColor);
            if(boom2.type==BOOM)
                ToMauVe.VeNgoiBoom(mangLuoiPixel, boom2.ngoiBoom.dau, boom2.ngoiBoom.cuoi, boom2.boomColor);
        }
        
        
        // ================================== VẼ LẠI CÁI LƯỚI ======================================
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 220; j++) {
                // ================================= VẼ ĐỒ ĂN =======================================
                //=========================================================================================
                double kcf = abs(sqrt(1.0 * ((j - food.x) * (j - food.x) + (i - food.y) * (i - food.y))));
                if ((kcf * 10) % 10 < 5) {
                    kcf = (int) kcf - 0.5;
                } else {
                    kcf = (int) kcf + 0.5;
                }
                if(foodVisible)
                {
                    if(ToMauVe.VeThucAn(mangLuoiPixel[i][j], i, j, food, kcf))
                    {
//                        foodVisible = false;
                          snake.moiVuaAnNo = true;
                          food = new FoodOfSnake(new Random().nextInt(195)+15, new Random().nextInt(95)+15, FoodOfSnake.FOOD, 5);
        
                    }
                }
                double kc = abs(sqrt(1.0 * ((j - boom.x) * (j - boom.x) + (i - boom.y) * (i - boom.y))));
                if ((kc * 10) % 10 < 5) {
                    kc = (int) kc - 0.5;
                } else {
                    kc = (int) kc + 0.5;
                }
                if(boomVisible)
                {
                    if(ToMauVe.VeThucAn(mangLuoiPixel[i][j], i, j, boom, kc))
                    { 
                         mangLuoiPixel[snake.luoi.get(2).y][snake.luoi.get(2).x].color = Color.WHITE;
                    }
                    
                }
                //================================BOOM 1=================================
                kc = abs(sqrt(1.0 * ((j - boom1.x) * (j - boom1.x) + (i - boom1.y) * (i - boom1.y))));
                if ((kc * 10) % 10 < 5) {
                    kc = (int) kc - 0.5;
                } else {
                    kc = (int) kc + 0.5;
                }
                if(boomVisible)
                {
                    if(ToMauVe.VeThucAn(mangLuoiPixel[i][j], i, j, boom1, kc))
                    { 
                         mangLuoiPixel[snake.luoi.get(2).y][snake.luoi.get(2).x].color = Color.WHITE;
                    }
                    
                }
                //=====================================BOOM 2============================
                kc = abs(sqrt(1.0 * ((j - boom2.x) * (j - boom2.x) + (i - boom2.y) * (i - boom2.y))));
                if ((kc * 10) % 10 < 5) {
                    kc = (int) kc - 0.5;
                } else {
                    kc = (int) kc + 0.5;
                }
                if(boomVisible || foodVisible)
                {
                    if(ToMauVe.VeThucAn(mangLuoiPixel[i][j], i, j, boom2, kc))
                    {   if(boom2.type == BOOM)
                            mangLuoiPixel[snake.luoi.get(2).y][snake.luoi.get(2).x].color = Color.WHITE;
                         
                    }
                    
                }
                //=================================================================
                g2d.setColor(mangLuoiPixel[i][j].color);
                g2d.fillRect(j * 5, i * 5, 5, 5);

            }
        }

        
                //=================================== VẼ TRỤC TỌA ĐỘ ĐÈ LÊN =======================================
        if (AxisVisible) {
            g2d.setColor(new Color(100, 100, 100));
//            g2d.setColor(new Color(90, 140, 222));

            int y = 2, x = 2;

            while (y < 650) {
                g2d.drawLine(0, y, 1100, y);
                y += 5;
            }

            while (x < 1100) {
                g2d.drawLine(x, 650, x, 0);
                x += 5;
            }

            g2d.setColor(new Color(51, 51, 51));
            //Ox 300, 301
            g2d.drawLine(0, 328, 1100, 328);
            //Oy 301, 302
            g2d.drawLine(553, 0, 553, 650);

        }
                //====================================================================
        
        
        if(setThua)
            ResetAll();
        //=====================================================================
        
        
    }

    public void VeTrucToaDo() {
//        AxisVisible = (true);
        SnakeVisible = (false);
        repaint();
    }

    public int StopRun() {
        trangthai++;
        if (trangthai % 2 == 1) {
            timer.stop();
        } else {
            timer.start();
        }
        return trangthai;
    }

    public void actionPerformed(ActionEvent e) {
        snake.TiepTuc();
        if(setThua)
            timer.stop();

        if((timeToNewBoom--) == 0)
        {
            timeToNewBoom = 90;
            boom = new FoodOfSnake(new Random().nextInt(190)+15, new Random().nextInt(95)+15, FoodOfSnake.BOOM, 5);
            boom.boomColor = Color.GRAY;
            boom.boomColor2= Color.LIGHT_GRAY;
            boom1 = new FoodOfSnake(new Random().nextInt(190)+15, new Random().nextInt(95)+15, FoodOfSnake.BOOM, 6);
            boom1.boomColor = Color.GRAY;
            boom1.boomColor2= Color.LIGHT_GRAY;
            
                boom2 = new FoodOfSnake(new Random().nextInt(190)+15, new Random().nextInt(95)+15, FoodOfSnake.BOOM, 5);
                boom2.boomColor = Color.GRAY;
                boom2.boomColor2= Color.LIGHT_GRAY;
        }
        if (timeToNewBoom == 75)
        {
            boom.boomColor = Color.BLACK;
            boom.boomColor2= Color.WHITE;
            boom1.boomColor = Color.BLACK;
            boom1.boomColor2= Color.WHITE;
                boom2.boomColor = Color.BLACK;
                boom2.boomColor2= Color.WHITE;
        }
        
        repaint();
        //diemChoiRan.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("---------------");
        switch(key) {
            case KeyEvent.VK_UP: 
                snake.QueoLen();
                break;
            case KeyEvent.VK_DOWN:
                snake.QueoXuong();
                break;
            case KeyEvent.VK_LEFT:
                snake.QueoTrai();
                break;
            case KeyEvent.VK_RIGHT:
                snake.QueoPhai();
                break;
            default:
                break;
        }
        
//        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

   
}
