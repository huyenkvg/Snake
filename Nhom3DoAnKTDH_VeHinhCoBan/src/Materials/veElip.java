/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class veElip {

    int i = 0;

    Diem tam;
    int a, b;

    void ve4Poin(Diem tam, int x, int y, Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(tam.x + x, tam.y + y, 5, 5);
        g2d.fillRect(tam.x + x, tam.y - y, 5, 5);
        g2d.fillRect(tam.x - x, tam.y - y, 5, 5);
        g2d.fillRect(tam.x - x, tam.y + y, 5, 5);
    }

    public void ElipTren(Graphics g, Diem tam, int a, int b) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        int x, y, kx, ky;

        kx = tam.x;
        ky = tam.y;

        x = 0;
        y = b;

        int A, B;

        A = a * a;
        B = b * b;
        double p = B + A / 4 - A * b;
        p = Math.round(p);

        int Dx = 0;
        int Dy = 2 * A * y;
        ve4Poin(tam, x, y, g);

        while (Dx < Dy) {
            x += 5;
            Dx += 10 * B;
            if (p < 0) {
                p += B * (2 * x + 3);
            } else {
                y -= 5;
                p += B * (2 * x + 3) + A * (2 - 2 * y);
                Dy -= 10 * A;
            }
            ve4Poin(tam, x, y, g);
        }

        while (y > 0) {
            y -= 5;
            Dy -= 10 * A;
            if (p >= 0) {
                p += A * (3 - 2 * y);
            } else {
                x += 5;
                Dx += 10 * B;
                p += B * (2 * x + 2) + A * (3 - 2 * y);
            }
            ve4Poin(tam, x, y, g);
        }
    }

    public void ElipDuoi(Graphics g, Diem tam, int a, int b) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        int x, y, kx, ky;
        int dem1=0,dem2=0;
        kx = tam.x;
        ky = tam.y;

        x = 0;
        y = b;

        int A, B;

        A = a * a;
        B = b * b;
        double p = B + A / 4 - A * b;
        p = Math.round(p);

        int Dx = 0;
        int Dy = 2 * A * y;
        ve4Poin(tam, x, y, g);

        while (Dx < Dy) {
            x += 5;
            Dx += 10 * B;
            if (p < 0) {
                p += B * (2 * x + 3);
            } else {
                y -= 5;
                p += B * (2 * x + 3) + A * (2 - 2 * y);
                Dy -= 10 * A;
            }
             if (dem1 < 3) {
                 g2d.fillRect(tam.x + x, tam.y + y, 5, 5);
                 g2d.fillRect(tam.x - x, tam.y + y, 5, 5);
                 dem1++;
             } else if (dem1 >= 3 && dem1 <= 5) {
                 ve4Poin(tam, x, y, g);
                 dem1++;
             }else{
            ve4Poin(tam, x, y, g);
            dem1=0;
        }
        }

        while (y > 0) {
            y -= 5;
            Dy -= 10 * A;
            if (p >= 0) {
                p += A * (3 - 2 * y);
            } else {
                x += 5;
                Dx += 10 * B;
                p += B * (2 * x + 2) + A * (3 - 2 * y);
            }
            if (dem2 < 3) {
                g2d.fillRect(tam.x + x, tam.y + y, 5, 5);
                g2d.fillRect(tam.x - x, tam.y + y, 5, 5);
                dem2++;
            } else if (dem2 >= 3 && dem2 <= 5) {
                ve4Poin(tam, x, y, g);
                dem2++;
            } else {
                ve4Poin(tam, x, y, g);
                dem2 = 0;
            }
        }
    }
    
    
//    public void ElipDuoi(Graphics g, Diem tam, int a, int b) {
//        {
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.setColor(Color.black);
//            int x, y, dem1 = 0, dem2 = 0;
//            x = 0;
//            y = b;
//
//            float x0 = (float) (a * a / Math.sqrt(a * a + b * b));
//            float p = (float) (a * a * (1 - 2 * b) + b * b);
//            ve4Poin(tam, x, y, g);
//
//            while (x <= x0) {
//                if (p < 0) {
//                    p += 2 * b * b * (2 * x + 3);
//                } else {
//                    p += (2 * b * b) * (2 * x + 3) + 4 * a * a * (1 - y);
//                    y -= 5;
//                }
//                x += 5;
//
//                if (dem1 < 3) {
//                    g2d.fillRect(tam.x + x, tam.y + y, 5, 5);
//                    g2d.fillRect(tam.x - x, tam.y + y, 5, 5);
//                    dem1++;
//                } else if (dem1 >= 3 && dem1 <= 5) {
//                    ve4Poin(tam, x, y, g);
//                    dem1++;
//                } else {
//                    ve4Poin(tam, x, y, g);
//                    dem1 = 0;
//                }
//
//            }
//            x = a;
//            y = 0;
//            p = b * b * (1 - 2 * a) + a * a;
//            ve4Poin(tam, x, y, g);
//            while (x > x0) {
//                if (p < 0) {
//                    p += (2 * a * a) * (2 * y + 3);
//                } else {
//                    p += (2 * a * a) * (2 * y + 3) + 4 * b * b * (1 - x);
//                    x -= 5;
//                }
//                y += 5;
//                if (dem2 < 3) {
//                    g2d.fillRect(tam.x + x, tam.y + y, 5, 5);
//                    g2d.fillRect(tam.x - x, tam.y + y, 5, 5);
//                    dem2++;
//                } else if (dem2 >= 3 && dem2 <= 5) {
//                    ve4Poin(tam, x, y, g);
//                    dem2++;
//                } else {
//                    ve4Poin(tam, x, y, g);
//                    dem2 = 0;
//                }
//            }
//
//        }
//    }

}
