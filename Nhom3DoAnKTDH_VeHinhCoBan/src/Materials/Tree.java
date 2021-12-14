
package Materials;

import Shape2D.Affine2D;
import Shape2D.Point5Pixel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.abs;
import javax.swing.JPanel;
public class Tree extends JPanel{
    
    Point5Pixel t1 = new Point5Pixel(10,10);
    Point[] pointTree = new Point[10];
    private int WIDTH = 1100, HEIGHT = 650;// kích thước panel
    private int xdau, ydau;
    public boolean AxisVisible = true;
    Point5Pixel mangLuoiPixel[][] = new Point5Pixel[130][220];
    public static Point5Pixel tilePhong = new Point5Pixel(1,1);
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
    public static Point5Pixel biendoi2D(Affine2D T, Point5Pixel P)
    {
        Point5Pixel t =  new Point5Pixel(0,0);
        t.x = (int) (T.Matrix[0][0] * P.x + T.Matrix[1][0] * P.y + T.Matrix[2][0]);
        t.y = (int) (T.Matrix[0][1] * P.x + T.Matrix[1][1] * P.y + T.Matrix[2][1]);   
        return t;
    }
    public static Affine2D tiLe(double sx, double sy)
    {
        Affine2D T = new Affine2D();
        T.Matrix[0][0] = sx; T.Matrix[0][1] = 0; T.Matrix[0][2] = 0;
        T.Matrix[1][0] = 0; T.Matrix[1][1] = sy; T.Matrix[1][2] = 0;
        T.Matrix[2][0] = 0; T.Matrix[2][1] = 0; T.Matrix[2][2] = 1;
        return T;
    }
    
//    private void tiLe(Graphics g, int dw, int dh) {
//        this.wT += dw;
//        this.hT += dh;
//    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
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
        //addTree(g,300,100,20,40);
        t1.x = 5;
        t1.y = 5;
        for(int i=0,m=300, n =100; i<=3;i++,m+=20*tilePhong.x, n+=20*tilePhong.y) {
            t1 = biendoi2D(tiLe(tilePhong.x,tilePhong.y), t1);
            if(i%2 == 1)
              addTree(g,m,n,t1.x,t1.y);
            System.out.println(t1.x);
            System.out.println(t1.y); //xem kết quả cho run á nha huyền
        }
        
        
    }
}
