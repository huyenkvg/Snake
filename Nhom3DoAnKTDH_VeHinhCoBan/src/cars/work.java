package cars;

import Shape2D.Point5Pixel;
import Shape2D.ToMauVe;
import static cars.PhepBienDoi2D.TinhTien;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;

public class work extends JPanel implements ActionListener, KeyListener {
    public static boolean tieptucdichuyen = true;
    private int space = 300;
    private int width = 80, height = 70; // kích thước vật cản
    private int speed = 2;
    private int WIDTH = 1100, HEIGHT = 650;// kích thước panel
    private int move = 100;
    private int count = 0;
    private Rectangle car;
    private ArrayList<Rectangle> rcars;
    private ArrayList<Rectangle> line;
    private Random rand;
    //Chôm của huyền
    public boolean AxisVisible = true;
    Point5Pixel mangLuoiPixel[][] = new Point5Pixel[130][220];
    MatTroi mattroi = new MatTroi(10, 10);
    Point[] points = new Point[20];
    Point[] pointTree = new Point[10];
    Timer time;
    int TinhTienTree = 40;
    int delayTinhTien = 0;
    //======= THUA
    public boolean hetXang = false;
    
    public static Point5Pixel[] trees = new Point5Pixel[10];
    public static Point5Pixel XeSo = new Point5Pixel(0,0);
    
    public static int diemChayXe = 0;
    
    public work() {
        
        diemChayXe = 0;
        time = new Timer(10, this);
        rand = new Random();
        rcars = new ArrayList<Rectangle>();
        line = new ArrayList<Rectangle>();
        car = new Rectangle(WIDTH / 2 - 90, HEIGHT - 100, width, height);
        XeSo = new Point5Pixel(car.x/5, car.y/5);
        XeSo.SwitchToAxisPoint();
        addKeyListener(this);// bắt sự kiện bàn phím
        setFocusable(true);// bắt sự kiện bàn phím
        addrcars(true);
        addrcars(true);
        addrcars(true);
        addrcars(true);
        addline(true);
        addline(true);
        addline(true);
        addline(true);
        addline(true);
        addline(true);
        addline(true);
        time.start();
        for(int i = 0; i < 8; i++)
        {
            trees[i] = new Point5Pixel(0, 0);
        }
    }
    public void StopRun()
    {
        time.stop();
        tieptucdichuyen=false;
    }
    public void Continue(){
            time.start();
            tieptucdichuyen = true;
    
    }
    public void addline(boolean first) {
        int x = WIDTH / 2 - 2;
        int y = 700;
        int width = 5, height = 100;//kích thước vạch kẻ đường
        int sp = 130;
        if (first) {
            line.add(new Rectangle(x, y - (line.size() * sp), width, height));
        } else {
            line.add(new Rectangle(x, line.get(line.size() - 1).y - sp, width, height));
        }
    }

    public void addrcars(boolean first) {
        int positionx = rand.nextInt() % 2;
        int x = 0;
        int y = 0;
        int Width = width;
        int Height = height;
        if (positionx == 0) {
            x = WIDTH / 2 - 90;
        } else {
            x = WIDTH / 2 + 10;
        }
        if (first) {
            rcars.add(new Rectangle(x, y - 100 - (rcars.size() * space), Width, Height));
        } else {
            rcars.add(new Rectangle(x, rcars.get(rcars.size() - 1).y - 300, Width, Height));
        }
    }

    private void addTree(Graphics gG, int xdau, int ydau, int wT, int hT) {
        //xdau, ydau: điểm đầu đường chéo hình chữ nhật của thân cây
        //wT, hT: chiều rộng, chiều cao thân cây
        Graphics2D g = (Graphics2D) gG;
        pointTree[0] = new Point(xdau, ydau);
        pointTree[1] = new Point(xdau + wT, ydau + hT);
        g.setColor(new Color(139, 69, 19));
        HinhChuNhat(g, pointTree[0], pointTree[1]);
        pointTree[2] = new Point(xdau + wT/2, ydau - wT - 10);//tâm hình tròn
        for (int n = 0, m = 0; n <= hT/5 - 1; n++, m += 5) {
            g.setColor(new Color(0, 140, 10));
            HinhTron(g, pointTree[2], hT - m);
        }
    }

    // vẽ đường thẳng
    private void Line(Graphics g, Point dau, Point cuoi) {
        Graphics2D g2d = (Graphics2D) g;
        Point p = new Point(), pe = new Point();
        int dx, dy, dx1, dy1, s1, s2;
        dx = cuoi.x - dau.x;
        dy = cuoi.y - dau.y;
        dx1 = abs(dx);
        dy1 = abs(dy);
        s1 = 2 * dy1 - dx1;
        s2 = 2 * dx1 - dy1;
        if (dy1 <= dx1) {
            if (dx >= 0) {
                p.x = dau.x;
                p.y = dau.y;
                pe.x = cuoi.x;
            } else {
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.x = dau.x;
            }
            g2d.fillRect(p.x, p.y, 5, 5);
            for (int j = 0; p.x < pe.x; j++) {
                p.x = p.x + 5;
                if (s1 < 0) {
                    s1 = s1 + 2 * dy1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.y = p.y + 5;
                    } else {
                        p.y = p.y - 5;
                    }
                    s1 = s1 + 2 * (dy1 - dx1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        } else {
            if (dy >= 0) {
                p.x = dau.x;
                p.y = dau.y;
                pe.y = cuoi.y;
            } else {
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.y = dau.y;
            }
            g2d.fillRect(p.x, p.y, 5, 5);
            for (int j = 0; p.y < pe.y; j++) {
                p.y = p.y + 5;
                if (s2 <= 0) {
                    s2 = s2 + 2 * dx1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.x = p.x + 5;
                    } else {
                        p.x = p.x - 5;
                    }
                    s2 = s2 + 2 * (dx1 - dy1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        }
    }

    //vẽ hình tròn
    void ve8Diem(Point tam, int x, int y, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(x + tam.x, y + tam.y, 5, 5);
        g2d.fillRect(-x + tam.x, y + tam.y, 5, 5);
        g2d.fillRect(x + tam.x, -y + tam.y, 5, 5);
        g2d.fillRect(-x + tam.x, -y + tam.y, 5, 5);
        g2d.fillRect(y + tam.x, x + tam.y, 5, 5);
        g2d.fillRect(-y + tam.x, x + tam.y, 5, 5);
        g2d.fillRect(y + tam.x, -x + tam.y, 5, 5);
        g2d.fillRect(-y + tam.x, -x + tam.y, 5, 5);
    }

    private void HinhTron(Graphics g, Point tam, int r) {
        int count = 0;
        int x = 0, y = r;
        int f = 1 - r;
        if (count % 3 == 0 || count % 3 == 1) {
            ve8Diem(tam, x, y, g);
        }
        count++;
        //ve8Diem(x,y,g);
        while (x < y) {
            if (f < 0) {
                f += (x << 5) + 3;
            } else {
                y -= 5;
                f += ((x - y) << 5) + 5;
            }
            x += 5;
            if (count % 3 == 0 || count % 3 == 1) {
                ve8Diem(tam, x, y, g);
            }
            count++;
        }
    }

    private void HinhChuNhat(Graphics g, Point dauCheo, Point cuoiCheo) {
        Graphics2D g2d = (Graphics2D) g;
        int x = dauCheo.x;
        int y = dauCheo.y;
        if (dauCheo.x < cuoiCheo.x && dauCheo.y < cuoiCheo.y) {
            while (x <= cuoiCheo.x) {
                while (y <= cuoiCheo.y) {
                    g2d.fillRect(x, y, 5, 5);
                    y += 5;
                }
                y = dauCheo.y;
                x += 5;
            }
        } else if (dauCheo.x > cuoiCheo.x && dauCheo.y > cuoiCheo.y) {
            while (x >= cuoiCheo.x) {
                while (y >= cuoiCheo.y) {
                    g2d.fillRect(x, y, 5, 5);
                    y -= 5;
                }
                y = dauCheo.y;
                x -= 5;
            }
        } else if (dauCheo.x > cuoiCheo.x && dauCheo.y < cuoiCheo.y) {
            while (x >= cuoiCheo.x) {
                while (y <= cuoiCheo.y) {
                    g2d.fillRect(x, y, 5, 5);
                    y += 5;
                }
                y = dauCheo.y;
                x -= 5;
            }
        } else if (dauCheo.x < cuoiCheo.x && dauCheo.y > cuoiCheo.y) {
            while (x <= cuoiCheo.x) {
                while (y >= cuoiCheo.y) {
                    g2d.fillRect(x, y, 5, 5);
                    y -= 5;
                }
                y = dauCheo.y;
                x += 5;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        XeSo = new Point5Pixel(car.x/5, car.y/5);
        
        XeSo.SwitchToAxisPoint();
        
        if(XeSo.y <= -72)
        {
            hetXang = true;
            JOptionPane.showMessageDialog(null, "BẠN ĐÃ HẾT XĂNG!!!\n DẮT XE VỀ ĐI :D ", "Thông báo", JOptionPane.YES_NO_OPTION);
            time.stop();
        }
        //======================KHỞI TẠỌ PHẦN TỬ TRONG CÁI LƯỚI ===============
        mattroi.Xoay();
        double khoangcach = mattroi.mattroi.radius;
        
        for (int i = 0; i < HEIGHT / 5; i++) {
            for (int j = 0; j < WIDTH / 5; j++) {
                mangLuoiPixel[i][j] = new Point5Pixel(i, j);
                double kcf = abs(sqrt(1.0 * ((j - mattroi.x) * (j - mattroi.x) + (i - mattroi.y) * (i - mattroi.y))));
                if(kcf < khoangcach-1)
                {
                    
                    mangLuoiPixel[i][j].color = Color.RED;
                }
                else if( kcf < khoangcach){
                    
                    mangLuoiPixel[i][j].color = Color.ORANGE;
                }
            }
        }
        for(int i = 0; i<10; i++)
        {
            if(i%2 == 0)
            ToMauVe.VeDoanThang(mangLuoiPixel, mattroi.tia[i], Color.YELLOW);
            else
            ToMauVe.VeDoanThang(mangLuoiPixel, mattroi.tia[i], Color.RED);
                
        }
        // ===================== VẼ CÁI LƯỚI =================================
        
        for (int i = 0; i < HEIGHT / 5; i++) {
            for (int j = 0; j < WIDTH / 5; j++) {
                g2d.setColor(mangLuoiPixel[i][j].color);
                g2d.fillRect(j * 5, i * 5, 5, 5);
                
            }
        }
       

//vẽ đường dua + vật đua
        //g.setColor(new Color(245,255,250));
        g2d.setColor(new Color(255, 228, 225));
        g2d.fillRect(WIDTH / 2 - 350, 0, 700, HEIGHT);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                g2d.setColor(mangLuoiPixel[i][j].color3);
                g2d.fillRect(WIDTH / 2 - 100, 0, 200, HEIGHT);
            }
        }
        //g.setColor(Color.BLACK);
        g.setColor(new Color(0, 0, 205));

//viền đua 1
        //WIDTH = 1100;HEIGHT = 650;
        points[0] = new Point(WIDTH / 2 - 100, 0);
        points[1] = new Point(WIDTH / 2 - 100, HEIGHT);
        points[2] = new Point(WIDTH / 2 - 120, 0);
        points[3] = new Point(WIDTH / 2 - 120, HEIGHT);
        Line(g, points[0], points[1]);
        Line(g, points[2], points[3]);
        for (int i = 0, a = 0; i <= 16; i++, a += 40) {
            for (int n = 0, m = 0; n <= 3; n++, m += 5) {
                points[4] = new Point(WIDTH / 2 - 120, a + m);
                points[5] = new Point(WIDTH / 2 - 100, a + 20 + m);
                Line(g, points[4], points[5]);
            }
        }
        //g.setColor(Color.red);
        g.setColor(new Color(205, 133, 63));
        for (int i = 0, a = 20; i <= 15; i++, a += 40) {
            g2d.fillRect(WIDTH / 2 - 105, 0, 5, 5);
            g2d.fillRect(WIDTH / 2 - 105, 5, 5, 5);
            g2d.fillRect(WIDTH / 2 - 110, 0, 5, 5);
            for (int n = 0, m = 0; n < 3; n++, m += 5) {
                points[6] = new Point(WIDTH / 2 - 115, a + 5 + m);// + 5 để xóa chấm đỏ ở viền
                points[7] = new Point(WIDTH / 2 - 105, a + 20 - 5 + m);
                Line(g, points[6], points[7]);
            }
        }
        //g.setColor(Color.black);
        g.setColor(new Color(0, 0, 205));
//Viền đua 2
        //WIDTH = 1100;HEIGHT = 650;
        points[8] = new Point(WIDTH / 2 + 100, 0);
        points[9] = new Point(WIDTH / 2 + 100, HEIGHT);
        points[10] = new Point(WIDTH / 2 + 120, 0);
        points[11] = new Point(WIDTH / 2 + 120, HEIGHT);
        Line(g, points[8], points[9]);
        Line(g, points[10], points[11]);
        for (int i = 0, a = 0; i <= 16; i++, a += 40) {
            for (int n = 0, m = 0; n <= 3; n++, m += 5) {
                points[12] = new Point(WIDTH / 2 + 120, a + m);
                points[13] = new Point(WIDTH / 2 + 100, a + 20 + m);
                Line(g, points[12], points[13]);
            }
        }
        //g.setColor(Color.red);
        g.setColor(new Color(205, 133, 63));
        for (int i = 0, a = 20; i <= 15; i++, a += 40) {
            g2d.fillRect(WIDTH / 2 + 105, 0, 5, 5);
            g2d.fillRect(WIDTH / 2 + 105, 5, 5, 5);
            g2d.fillRect(WIDTH / 2 + 110, 0, 5, 5);
            for (int n = 0, m = 0; n < 3; n++, m += 5) {
                points[14] = new Point(WIDTH / 2 + 115, a + 5 + m);// + 5 để xóa chấm đỏ ở viền
                points[15] = new Point(WIDTH / 2 + 105, a + 20 - 5 + m);
                Line(g, points[14], points[15]);
            }
        }
//Trang trí

            g.setColor(Color.LIGHT_GRAY);
            //WIDTH = 1100;HEIGHT = 650;
            for (int i = 0, a = 0; i <= 16; i++, a += 200) {
                for (int n = 0, m = 0; n <= 3; n++, m += 200) {
                    points[16] = new Point(WIDTH / 2 - 350, a + TinhTienTree -500-160  + m);
                    points[17] = new Point(WIDTH / 2 - 125, a + TinhTienTree-160 + m);
                    Line(g, points[16], points[17]);
                    points[16] = new Point(WIDTH / 2 - 350, a + TinhTienTree  -160 + m);
                    points[17] = new Point(WIDTH / 2 - 125, a + TinhTienTree -500 -160+ m);
                    Line(g, points[16], points[17]);
                }
            }
            for (int i = 0, a = 0; i <= 16; i++, a += 200) {
                for (int n = 0, m = 0; n <= 3; n++, m += 200) {
                    points[18] = new Point(WIDTH / 2 + 345, a + TinhTienTree -500-160  + m);
                    points[19] = new Point(WIDTH / 2 + 125, a + TinhTienTree  -160+ m);
                    Line(g, points[18], points[19]);
                    points[18] = new Point(WIDTH / 2 + 345, a + TinhTienTree  -160 + m);
                    points[19] = new Point(WIDTH / 2 + 125, a + TinhTienTree -500-160 + m);
                    Line(g, points[18], points[19]);
                }
            }
        

// vạch kẻ đường đua
        g2d.setColor(Color.white);
        for (Rectangle rect : line) {
            g2d.fillRect(rect.x+2, rect.y, rect.width, rect.height);
        }
        


// ô tô tương lai
        g2d.setColor(Color.BLACK);
        g2d.fillRect(car.x - 10, car.y - 10, car.width / 3, car.height / 3);
        g2d.fillRect(car.x + 65, car.y - 10, car.width / 3, car.height / 3);
        g2d.fillRect(car.x - 10, car.y + 60, car.width / 3, car.height / 3);
        g2d.fillRect(car.x + 65, car.y + 60, car.width / 3, car.height / 3);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(car.x - 10, car.y - 10+TinhTienTree%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x + 65, car.y - 10+TinhTienTree%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x - 10, car.y + 60+TinhTienTree%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x + 65, car.y + 60+TinhTienTree%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x - 10, car.y - 10+(TinhTienTree-10)%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x + 65, car.y - 10+(TinhTienTree-10)%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x - 10, car.y + 60+(TinhTienTree-10)%(car.width/3)-5, car.width / 3, 5);
        g2d.fillRect(car.x + 65, car.y + 60+(TinhTienTree-10)%(car.width/3)-5, car.width / 3, 5);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(car.x, car.y, car.width, car.height);
        //g.setColor(Color.BLUE);
        g2d.setColor(new Color(220, 20, 60));
        g2d.fillRect(car.x + 15, car.y + 15, car.width - 30, car.height - 30);

// vẽ vật cản random 
        for (Rectangle rect : rcars) {
            float R = rand.nextFloat();
            float G = rand.nextFloat();
            float B = rand.nextFloat();
            Color randomColor = new Color(R, G, B);
            //Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            g2d.setColor(randomColor);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(rect.x - 10, rect.y - 10, rect.width / 3, rect.height / 3);
            g2d.fillRect(rect.x + 65, rect.y - 10, rect.width / 3, rect.height / 3);
            g2d.fillRect(rect.x - 10, rect.y + 60, rect.width / 3, rect.height / 3);
            g2d.fillRect(rect.x + 65, rect.y + 60, rect.width / 3, rect.height / 3);
            g2d.setColor(Color.GRAY);
            g2d.fillRect(rect.x - 10, rect.y - 10+TinhTienTree%(rect.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x + 65, rect.y - 10+TinhTienTree%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x - 10, rect.y + 60+TinhTienTree%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x + 65, rect.y + 60+TinhTienTree%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x - 10, rect.y - 10+(TinhTienTree-10)%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x + 65, rect.y - 10+(TinhTienTree-10)%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x - 10, rect.y + 60+(TinhTienTree-10)%(car.width/3)-1, car.width / 3, 5);
            g2d.fillRect(rect.x + 65, rect.y + 60+(TinhTienTree-10)%(car.width/3)-1, car.width / 3, 5);g2d.setColor(randomColor);
            g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
        }
        //g.drawString("Game over",200,100);

// vẽ cục cây
        if(delayTinhTien++ %2 == 0)
        TinhTienTree += 5;
        if (TinhTienTree == 300) {
            TinhTienTree = 100;
        }
        for (int i = 0; i < 5; i++) {
            trees[i] = new Point5Pixel(300/5,(  TinhTienTree - 100 +i*200)/5);
            
            // Sao chép cây bên trái 
            trees[i+4] = new Point5Pixel(trees[i]);
            // Chuyển sang hệ tọa độ người dùng
            trees[i+4].SwitchToAxisPoint();
            // Lấy đối xứng qua OY
            trees[i+4] = PhepBienDoi2D.doiXungQuaTrucOy(trees[i+4]);
            // Chuyển sang hệ tọa độ Máy tính.
            trees[i+4].SwitchToMTPoint();
            // VẼ CÂY
            addTree(g2d, trees[i].x*5, trees[i].y*5,20,40);
            //doiXung
//            addTree(g2d, 775, TinhTienTree - 100 +i*200);
            addTree(g2d, trees[i+4].x*5, trees[i+4].y*5,20,40);
            trees[i].SwitchToAxisPoint();
            trees[i+4].SwitchToAxisPoint();
            
        }
        
       
                 //======================= VẼ TRỤC TỌA ĐỘ LÊN =========================
                if (AxisVisible) {
                    g2d.setColor(Color.LIGHT_GRAY);
                    g2d.setColor(new Color(60, 60, 100));
                    int y = 2, x = 2;
                    while (y < HEIGHT) {
                        g2d.drawLine(0, y, WIDTH, y);
                        y += 5;
                    }
                    while (x < WIDTH) {
                        g2d.drawLine(x, HEIGHT, x, 0);
                        x += 5;
                    }
                    g2d.setColor(new Color(0, 0, 20));
                    //Ox 300, 301
                    g2d.drawLine(0, HEIGHT / 2 +3, WIDTH, HEIGHT / 2 +3);
                    //Oy 301, 302
                    g2d.drawLine(WIDTH / 2+3, 0, WIDTH / 2+3, HEIGHT);
                }
                //====================================================================
        
        
// vẽ cánh quạt thứ nhất
//        g.setColor(Color.RED);
//        int a = 150, b = 170;
//        g.drawLine(2*a, a, 2*b, a);
//        g.drawLine(2*b, a, 2*b, b);
//        g.drawLine(2*b, b, 2*a, a);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(hetXang)
        {
            time.stop();
            time.removeActionListener(this);
            
            return;
        }
                
        Rectangle rect;
        count++;
        for (int i = 0; i < rcars.size(); i++) {
            rect = rcars.get(i);
            if (count % 1000 == 0) {
                speed++;
                if (move < 10) {
                    move += 10;
                }
            }
            rect.y += speed;
        }

        //cars crashing with openents
        for (Rectangle r : rcars) {
            if (r.intersects(car)) {
                car.y = r.y + height;
            }
        }
        for (int i = 0; i < rcars.size(); i++) {
            rect = rcars.get(1);
            if (rect.y + rect.height > HEIGHT) {
                rcars.remove(rect);
                addrcars(false);
            }
        }
        for (int i = 0; i < line.size(); i++) {
            rect = line.get(i);
            if (count % 1000 == 0) {
                speed++;
                if (move < 50) {
                    move += 10;
                }
            }
            rect.y += speed;
        }

        for (int i = 0; i < line.size(); i++) {
            rect = line.get(1);
            if (rect.y > HEIGHT) {
                line.remove(rect);
                addline(false);
            }
        }
        repaint();
    }
    //movingup

    public void moveup() {
        if (car.y - move < 0) {
            System.out.println("\b");
        } else {
            TinhTien(car, 0, -move/5);
        }
    }

    public void movedown() {
        if (car.y + move + car.height > HEIGHT - 1) {
            System.out.println("\b");
        } else {
            TinhTien(car, 0, move/5);
        }
    }

    public void moveleft() {
        if (car.x - move < WIDTH / 2 - 90) {
            System.out.println("\b");

        } else {
            TinhTien(car, -move, 0);
        }
    }

    public void moveright() {
        if (car.x + move > WIDTH / 2 + 10) {
            System.out.println("\b");
        } else {
            TinhTien(car, move, 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                moveup();
                break;
            case KeyEvent.VK_DOWN:
                movedown();
                break;
            case KeyEvent.VK_LEFT :
                moveleft();
                break;
            case KeyEvent.VK_RIGHT:
                moveright();
                break;
            default :{
            }
        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
