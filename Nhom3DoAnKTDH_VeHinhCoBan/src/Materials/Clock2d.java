package Materials;

import Shape2D.Point5Pixel;
//import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.abs;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Clock2d extends JPanel{

    GregorianCalendar cal;
    Timer clockTimer = new Timer();
    public static Point5Pixel tamDongHo = new Point5Pixel(0, 0);
    public static Point5Pixel kimGio = new Point5Pixel(0, 0);
    public static Point5Pixel kimPhut = new Point5Pixel(0, 0);
    public static Point5Pixel kimGiay = new Point5Pixel(0, 0);
    
    public int xcount = 0;
    TimeZone clockTimeZone = TimeZone.getDefault();
    //Vị trí tâm đồng hồ
    private int xTam = 550;
    private int yTam = 325;
    //Chiều dài kim giờ, kim phút, kim dây sẽ cộng thêm cho dài thêm
    private int lHour = 40;
    Point[] pointClocks = new Point[50];
    public boolean AxisVisible = true;

    public Clock2d() {
        clockTimer.schedule(new TickTimerTask(), 0, 1000);
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
    public void NhapNho() 
    {
                if(xcount++ %32 < 16)
                    if(xcount%32 < 8)
                            yTam-=10;
                    else
                        yTam+=10;
                else
                    if(xcount%32 > 24)
                            yTam+=10;
                    else
                        yTam-=10;
    }
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        NhapNho();
        tamDongHo = new Point5Pixel(xTam/5, yTam/5);
        tamDongHo.SwitchToAxisPoint();
        Graphics2D g2d = (Graphics2D) g;
        pointClocks[0] = new Point(xTam, yTam);
        drawClock(g);
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
    }

    /* 1 độ = pi/180 rad
    - đường tròn 360 độ, kim giây phải nhích 60 lần suy ra 1 lần nhích số radian bằng (số giây * 6) * pi/180 rad
    - tương tự với số phút, nhưng khi kim giây nhích thì kim phút cũng phải nhích theo 
    nên ta công thêm số giây/60 vào để kim phút nhích, ví dụ 1 phút 30 giây thì bằng 1,5 phút
    - đối với kim giờ thì quay 1 vòng tròn là 12 giờ, vậy mỗi giờ tăng 1 góc là  
    số giờ x 30 (vì 12x30=360), và phải cộng thêm số phút để cho chính xác
    lưu ý phải trừ ra pi/2 rad để đồng hồ quay đúng, vì đường tròn lượng giác có chiều quay ngược kim đồng hồ 
    tương ứng 9h=pi rad,12=pi/2 rad... nên phải trừ ra pi/2
     */
    public void drawClock(Graphics g) {
        g.setColor(Color.PINK);
        for (int i = 0, a = 0; i < 30; i++, a += 5) {
            HinhTron(g, pointClocks[0], 95 - a);
        }
        double second = cal.get(Calendar.SECOND);
        double minute = cal.get(Calendar.MINUTE);
        double hours = cal.get(Calendar.HOUR);
        //double milis = cal.get(Calendar.MILLISECOND);
        //Vẽ mặt đồng hồ
        for (int i = 0; i < 60; i++) {
            int length = 100;
            int length2 = 100;
            double rad = (i * 6) * (Math.PI) / 180;
            if (i % 5 == 0) {
                g.setColor(Color.BLUE);
                length = 85;
            } else {
                g.setColor(Color.BLACK);
            }

            int x = xTam + (int) (length2 * Math.cos(rad - (Math.PI / 2)));
            int y = yTam + (int) (length2 * Math.sin(rad - (Math.PI / 2)));
            int x1 = xTam + (int) (length * Math.cos(rad - (Math.PI / 2)));
            int y1 = yTam + (int) (length * Math.sin(rad - (Math.PI / 2)));
            pointClocks[1] = new Point(x, y);
            pointClocks[2] = new Point(x1, y1);
            Line(g, pointClocks[1], pointClocks[2]);
            //vẽ vòng ngoài viền
            for (int n = 0, a = 0; n < 5; n++, a += 5) {
                int xx = xTam + (int) ((length2 + a) * Math.cos(rad - (Math.PI / 2)));
                int yy = yTam + (int) ((length2 + a) * Math.sin(rad - (Math.PI / 2)));
                int xx1 = xTam + (int) ((length + a) * Math.cos(rad - (Math.PI / 2)));
                int yy1 = yTam + (int) ((length + a) * Math.sin(rad - (Math.PI / 2)));

                if (xx % 5 < 3) {
                    xx -= xx % 5;
                } else {
                    xx = xx - xx % 5 + 5;
                }
                if (yy % 5 < 3) {
                    yy -= yy % 5;
                } else {
                    yy = yy - yy % 5 + 5;
                }
                if (xx1 % 5 < 3) {
                    xx1 -= xx1 % 5;
                } else {
                    xx1 = xx1 - xx1 % 5 + 5;
                }
                if (yy1 % 5 < 3) {
                    yy1 -= yy1 % 5;
                } else {
                    yy1 = yy1 - yy1 % 5 + 5;
                }

                pointClocks[6] = new Point(xx, yy);
                pointClocks[7] = new Point(xx1, yy1);
                Line(g, pointClocks[6], pointClocks[7]);
            }
        }
        //vẽ kim đồng hồ
        drawHands(g, second, minute, hours);
    }
    public void drawHands(Graphics g, double second, double minute, double hours) {
        double rSecond = (second * 6) * (Math.PI) / 180;
        double rMinute = ((minute + (second / 60)) * 6) * (Math.PI) / 180;
        double rHours = ((hours + (minute / 60)) * 30) * (Math.PI) / 180;
        g.setColor(Color.RED);

        int xx, yy;
        xx = xTam + (int) ((lHour + 50) * Math.cos(rSecond - (Math.PI / 2)));
        yy = yTam + (int) ((lHour + 50) * Math.sin(rSecond - (Math.PI / 2)));

        if (xx % 5 < 3) {
            xx -= xx % 5;
        } else {
            xx = xx - xx % 5 + 5;
        }
        if (yy % 5 < 3) {
            yy -= yy % 5;
        } else {
            yy = yy - yy % 5 + 5;
        }
        kimGiay = new Point5Pixel(xx/5, yy/5);
        pointClocks[3] = new Point(xx, yy);

        Line(g, pointClocks[0], pointClocks[3]);
        g.setColor(Color.BLACK);

        xx = xTam + (int) ((lHour + 20) * Math.cos(rMinute - (Math.PI / 2)));
        yy = yTam + (int) ((lHour + 20) * Math.sin((rMinute - (Math.PI / 2))));
        if (xx % 5 < 3) {
            xx -= xx % 5;
        } else {
            xx = xx - xx % 5 + 5;
        }
        if (yy % 5 < 3) {
            yy -= yy % 5;
        } else {
            yy = yy - yy % 5 + 5;
        }
        
        kimPhut = new Point5Pixel(xx/5, yy/5);
        
        pointClocks[4] = new Point(xx, yy);
        Line(g, pointClocks[0], pointClocks[4]);

        xx = xTam + (int) (lHour * Math.cos(rHours - (Math.PI / 2)));
        yy = yTam + (int) (lHour * Math.sin(rHours - (Math.PI / 2)));
        if (xx % 5 < 3) {
            xx -= xx % 5;
        } else {
            xx = xx - xx % 5 + 5;
        }
        if (yy % 5 < 3) {
            yy -= yy % 5;
        } else {
            yy = yy - yy % 5 + 5;
        }
        
        kimGio = new Point5Pixel(xx/5, yy/5);
        
        pointClocks[5] = new Point(xx, yy);
        Line(g, pointClocks[0], pointClocks[5]);
            Clock2d.kimGio.SwitchToAxisPoint();
            Clock2d.kimPhut.SwitchToAxisPoint();
            Clock2d.kimGiay.SwitchToAxisPoint();
    }
    private void RotatePoint(Point pt[], int iRotate, int iAngle) {
        Point ptTemp = new Point();
        for (int i=0; i<iRotate; i++) {
            ptTemp.x = (int)(pt[i].x*Math.cos(2*Math.PI*iAngle/360) - pt[i].y*Math.sin(2*Math.PI*iAngle/360));
            ptTemp.y = (int)(pt[i].y*Math.cos(2*Math.PI*iAngle/360) - pt[i].x*Math.sin(2*Math.PI*iAngle/360));
            pt[i] = ptTemp;
        }
    }
    class TickTimerTask extends TimerTask {

        @Override
        public void run() {
            //throw new UnsupportedOperationException("Not supported yet.");
            cal = (GregorianCalendar) GregorianCalendar.getInstance(clockTimeZone);
            repaint();
        }
    }

    
}
