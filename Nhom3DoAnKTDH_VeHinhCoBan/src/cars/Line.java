
package cars;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.abs;

public class Line {
    private Point dau;
    private Point cuoi;
    public Line() {

    }
    public Line(Point dau, Point cuoi) {
        this.dau = dau;
        this.cuoi = cuoi;
    }
    public void setDau(Point dau) {
        this.dau = dau;
    }
    public Point getDau() {
        return dau;
    }
    public void setCuoi(Point cuoi) {
        this.cuoi = cuoi;
    }
    public Point getCuoi() {
        return cuoi;
    }
    
    private void veLine(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Point p = new Point(), pe = new Point();
        int dx, dy, dx1, dy1, s1, s2;
        dx = cuoi.x - dau.x;
        dy = cuoi.y - dau.y;
        dx1 = abs(dx);
        dy1 = abs(dy);
        s1 = 2 * dy1 - dx1;
        s2 = 2 * dx1 - dy1;
        if (dy1 <= dx1){
            if (dx >= 0){
                p.x= dau.x;
                p.y =dau.y;
                pe.x = cuoi.x;
            }else{
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.x = dau.x;
            }
            g2d.fillRect(p.x, p.y, 5, 5);
            for (int j = 0; p.x < pe.x; j++){
                p.x = p.x + 5;
                if (s1 < 0) s1 = s1 + 2 * dy1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.y = p.y + 5;
                    else p.y = p.y - 5;
                    s1 = s1 + 2 * (dy1 - dx1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        }else{
            if (dy >= 0){
                p.x = dau.x;
                p.y = dau.y;
                pe.y = cuoi.y;
            }else{
                p.x = cuoi.x;
                p.y = cuoi.y;
                pe.y = dau.y;
            }
            g2d.fillRect(p.x, p.y, 5, 5);
            for (int j = 0; p.y < pe.y; j++){
                p.y = p.y + 5;
                if (s2 <= 0) s2 = s2 + 2 * dx1;
                else{
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) p.x = p.x + 5;
                    else p.x = p.x - 5;
                    s2 = s2 + 2 * (dx1 - dy1);
                }
                g2d.fillRect(p.x, p.y, 5, 5);
            }
        }
    }
}
