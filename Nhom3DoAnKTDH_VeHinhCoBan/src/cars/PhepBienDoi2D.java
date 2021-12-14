/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import Materials.Diem;
import Materials.HinhTron;
import Shape2D.Point5Pixel;
import Shape2D.TheSnake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;

public class PhepBienDoi2D {

    static final double PI = 3.14;
    public static final int DXOX = 0;
    public static final int DXOY = 1;
    public static final int DXOO = 2;

    public static Point5Pixel biendoi2D(Affine2D T, Point5Pixel P) {
        double x, y;
        x = (T.Matrix[0][0] * P.x + T.Matrix[1][0] * P.y + T.Matrix[2][0]);
        y = (int) (T.Matrix[0][1] * P.x + T.Matrix[1][1] * P.y + T.Matrix[2][1]);
        return new Point5Pixel((int) x, (int) y);
    }

    public static Affine2D tinhtien(double tx, double ty) {
        Affine2D T = new Affine2D();
        T.Matrix[0][0] = 1;
        T.Matrix[0][1] = 0;
        T.Matrix[0][2] = 0;
        T.Matrix[1][0] = 0;
        T.Matrix[1][1] = 1;
        T.Matrix[1][2] = 0;
        T.Matrix[2][0] = tx;
        T.Matrix[2][1] = ty;
        T.Matrix[2][2] = 1;
        return T;
    }

    // phép quay
    public static Affine2D XuayQuanh1Diem(double alpha, int x, int y) {
        Affine2D T = new Affine2D();

        T.Matrix[0][0] = cos(alpha);
        T.Matrix[0][1] = sin(alpha);
        T.Matrix[0][2] = 0;
        T.Matrix[1][0] = -sin(alpha);
        T.Matrix[1][1] = cos(alpha);
        T.Matrix[1][2] = 0;
        T.Matrix[2][0] = (1 - cos(alpha)) * x + sin(alpha) * y;
        T.Matrix[2][1] = -sin(alpha) * x + (1 - cos(alpha)) * y;
        T.Matrix[2][2] = 1;
        return T;
    }

    static Point quayMotDiem(Point Q, Point A, double gocquay) // quay điểm Q quanh điểm A bất kì
    {
        Point P = new Point();
        double temp = (int) gocquay * 3.14159265359 / 180;
        P.x =(int)( 1.0*Q.x *  Math.cos(temp) + 1.0*Q.y * (- Math.sin(temp)) + 1.0*(A.x * (1 -  Math.cos(temp)) + A.y *  Math.sin(temp)));
        P.y =(int)(  1.0*Q.x *  Math.sin(temp) + 1.0*Q.y *  Math.cos(temp) + 1.0*(A.y * (1 -  Math.cos(temp)) + A.x * - Math.sin(temp)));
        return P;
    }

    public static Affine2D doiXung(double tx, double ty) {
        Affine2D T = new Affine2D();
        T.Matrix[0][0] = 1;
        T.Matrix[0][1] = 0;
        T.Matrix[0][2] = 0;
        T.Matrix[1][0] = 0;
        T.Matrix[1][1] = 1;
        T.Matrix[1][2] = 0;
        T.Matrix[2][0] = tx;
        T.Matrix[2][1] = ty;
        T.Matrix[2][2] = 1;
        return T;
    }

    public static Point5Pixel doiXungQuaTrucOy(Point5Pixel A) {
        Point5Pixel Q = new Point5Pixel(A);
        Q.x = -Q.x;
        return Q;
    }

    public static Point5Pixel doiXungQuaTrucOx(Point5Pixel A) {
        Point5Pixel Q = new Point5Pixel(A);
        Q.y = -Q.y;
        return Q;
    }

    public static Point5Pixel doiXungQuaO(Point5Pixel A) {
        Point5Pixel Q = new Point5Pixel(-A.x, -A.y);
        return Q;
    }

    public static TheSnake XoayRan(TheSnake sn, Point5Pixel tam, double goc) {
        Point5Pixel p;
        Point pt;
        TheSnake s = new TheSnake(sn.length, sn.x, sn.y);

        p = new Point5Pixel(sn.mat1);
        p.SwitchToAxisPoint();
        pt = quayMotDiem(new Point(p.x, p.y), new Point(tam.x, tam.y), goc);
        p.x = pt.x;
        p.y = pt.y;
        p.SwitchToMTPoint();
        s.mat1 = new Point5Pixel(p);

        p = new Point5Pixel(sn.mat2);
        p.SwitchToAxisPoint();
        pt = quayMotDiem(new Point(p.x, p.y),new Point(tam.x, tam.y), goc);
        p.x = pt.x;
        p.y = pt.y;
        p.SwitchToMTPoint();
        s.mat2 = new Point5Pixel(p);
//            System.out.println("--->mat ran doi xung: " + s.mat1.x+" : " + s.mat2.y);

        s.thanran.clear();
        s.duoiran.clear();
        s.luoi.clear();
        for (int i = 0; i < sn.thanran.size(); i++) {
            p = new Point5Pixel(sn.thanran.get(i));
            p.SwitchToAxisPoint();
            pt = quayMotDiem(new Point(p.x, p.y), new Point(tam.x, tam.y), goc);
            p.x = pt.x;
            p.y = pt.y;
            p.SwitchToMTPoint();
//            System.out.println("----" + p.x+"  " +p.y);
            s.thanran.add(new Point5Pixel(p));
            s.thanran.get(i).color = sn.thanran.get(i).color;

        }
        for (int i = 0; i < sn.luoi.size(); i++) {
            p = new Point5Pixel(sn.luoi.get(i));
            p.SwitchToAxisPoint();
            pt = quayMotDiem(new Point(p.x, p.y), new Point(tam.x, tam.y), goc);
            p.x = pt.x;
            p.y = pt.y;
            p.SwitchToMTPoint();
            s.luoi.add(new Point5Pixel(p));

            s.luoi.get(i).color = sn.luoi.get(i).color;

        }
        for (int i = 0; i < sn.duoiran.size(); i++) {
            p = new Point5Pixel(sn.duoiran.get(i));
            p.SwitchToAxisPoint();
            pt = quayMotDiem(new Point(p.x, p.y), new Point(tam.x, tam.y), goc);
            p.x = pt.x;
            p.y = pt.y;
            p.SwitchToMTPoint();
            s.duoiran.add(new Point5Pixel(p));
            s.duoiran.get(i).color = Color.BLACK;

        }
        for (int i = 0; i < sn.them.size(); i++) {
            p = new Point5Pixel(sn.them.get(i).tam.x,sn.them.get(i).tam.y);
            p.SwitchToAxisPoint();
            pt = quayMotDiem(new Point(p.x, p.y), new Point(tam.x, tam.y), goc);
            p.x = pt.x;
            p.y = pt.y;
            p.SwitchToMTPoint();
            s.them.add(new HinhTron(new Diem(p.x, p.y), sn.them.get(i).radius));
       

        }
        return s;
    }

    public static TheSnake DoiXungConRanQuaO(TheSnake sn) {
        Point5Pixel p;
        TheSnake s = new TheSnake(sn.length, sn.x, sn.y);

        p = new Point5Pixel(sn.mat1);
        p.SwitchToAxisPoint();
        p = doiXungQuaO(p);
        p.SwitchToMTPoint();
        s.mat1 = new Point5Pixel(p);

        p = new Point5Pixel(sn.mat2);
        p.SwitchToAxisPoint();
        p = doiXungQuaO(p);
        p.SwitchToMTPoint();
        s.mat2 = new Point5Pixel(p);
//            System.out.println("--->mat ran doi xung: " + s.mat1.x+" : " + s.mat2.y);

        s.thanran.clear();
        s.duoiran.clear();
        s.luoi.clear();
        for (int i = 0; i < sn.thanran.size(); i++) {
            p = new Point5Pixel(sn.thanran.get(i));
            p.SwitchToAxisPoint();

            p = doiXungQuaO(p);
            p.SwitchToMTPoint();
//            System.out.println("----" + p.x+"  " +p.y);
            s.thanran.add(new Point5Pixel(p));
            s.thanran.get(i).color = sn.thanran.get(i).color;

        }
        for (int i = 0; i < sn.luoi.size(); i++) {
            p = new Point5Pixel(sn.luoi.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaO(p);
            p.SwitchToMTPoint();
            s.luoi.add(new Point5Pixel(p));

            s.luoi.get(i).color = sn.luoi.get(i).color;

        }
        for (int i = 0; i < sn.duoiran.size(); i++) {
            p = new Point5Pixel(sn.duoiran.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaO(p);
            p.SwitchToMTPoint();
            s.duoiran.add(new Point5Pixel(p));
            s.duoiran.get(i).color = Color.BLACK;

        }
        Point pt;
        for (int i = 0; i < sn.them.size(); i++) {
            p = new Point5Pixel(sn.them.get(i).tam.x,sn.them.get(i).tam.y);
            p.SwitchToAxisPoint();
            p = doiXungQuaO(p);
            p.SwitchToMTPoint();
            s.them.add(new HinhTron(new Diem(p.x, p.y), sn.them.get(i).radius));
       

        }
        return s;
    }

    public static TheSnake DoiXungConRanQuaOx(TheSnake sn) {
        Point5Pixel p;
        TheSnake s = new TheSnake(sn.length, sn.x, sn.y);

        p = new Point5Pixel(sn.mat1);
        p.SwitchToAxisPoint();
        p = doiXungQuaTrucOx(p);
        p.SwitchToMTPoint();
        s.mat1 = new Point5Pixel(p);

        p = new Point5Pixel(sn.mat2);
        p.SwitchToAxisPoint();
        p = doiXungQuaTrucOx(p);
        p.SwitchToMTPoint();
        s.mat2 = new Point5Pixel(p);
//            System.out.println("--->mat ran doi xung: " + s.mat1.x+" : " + s.mat2.y);

        s.thanran.clear();
        s.duoiran.clear();
        s.luoi.clear();
        for (int i = 0; i < sn.thanran.size(); i++) {
            p = new Point5Pixel(sn.thanran.get(i));
            p.SwitchToAxisPoint();

            p = doiXungQuaTrucOx(p);
            p.SwitchToMTPoint();
//            System.out.println("----" + p.x+"  " +p.y);
            s.thanran.add(new Point5Pixel(p));
            s.thanran.get(i).color = sn.thanran.get(i).color;

        }
        for (int i = 0; i < sn.luoi.size(); i++) {
            p = new Point5Pixel(sn.luoi.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOx(p);
            p.SwitchToMTPoint();
            s.luoi.add(new Point5Pixel(p));

            s.luoi.get(i).color = sn.luoi.get(i).color;

        }
        for (int i = 0; i < sn.duoiran.size(); i++) {
            p = new Point5Pixel(sn.duoiran.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOx(p);
            p.SwitchToMTPoint();
            s.duoiran.add(new Point5Pixel(p));
            s.duoiran.get(i).color = Color.BLACK;

        }for (int i = 0; i < sn.them.size(); i++) {
            p = new Point5Pixel(sn.them.get(i).tam.x,sn.them.get(i).tam.y);
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOx(p);
            p.SwitchToMTPoint();
            s.them.add(new HinhTron(new Diem(p.x, p.y), sn.them.get(i).radius));
       

        }
        return s;
    }

    public static TheSnake DoiXungConRanQuaOy(TheSnake sn) {
        Point5Pixel p;
        TheSnake s = new TheSnake(sn.length, sn.x, sn.y);

        p = new Point5Pixel(sn.mat1);
        p.SwitchToAxisPoint();
        p = doiXungQuaTrucOy(p);
        p.SwitchToMTPoint();
        s.mat1 = new Point5Pixel(p);

        p = new Point5Pixel(sn.mat2);
        p.SwitchToAxisPoint();
        p = doiXungQuaTrucOy(p);
        p.SwitchToMTPoint();
        s.mat2 = new Point5Pixel(p);
//            System.out.println("--->mat ran doi xung: " + s.mat1.x+" : " + s.mat2.y);

        s.thanran.clear();
        s.duoiran.clear();
        s.luoi.clear();
        for (int i = 0; i < sn.thanran.size(); i++) {
            p = new Point5Pixel(sn.thanran.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOy(p);
            p.SwitchToMTPoint();
//            System.out.println("----" + p.x+"  " +p.y);
            s.thanran.add(new Point5Pixel(p));
            s.thanran.get(i).color = sn.thanran.get(i).color;

        }
        for (int i = 0; i < sn.luoi.size(); i++) {
            p = new Point5Pixel(sn.luoi.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOy(p);
            p.SwitchToMTPoint();
            s.luoi.add(new Point5Pixel(p));

            s.luoi.get(i).color = sn.luoi.get(i).color;

        }
        for (int i = 0; i < sn.duoiran.size(); i++) {
            p = new Point5Pixel(sn.duoiran.get(i));
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOy(p);
            p.SwitchToMTPoint();
            s.duoiran.add(new Point5Pixel(p));
            s.duoiran.get(i).color = Color.BLACK;

        }
        for (int i = 0; i < sn.them.size(); i++) {
            p = new Point5Pixel(sn.them.get(i).tam.x,sn.them.get(i).tam.y);
            p.SwitchToAxisPoint();
            p = doiXungQuaTrucOy(p);
            p.SwitchToMTPoint();
            s.them.add(new HinhTron(new Diem(p.x, p.y), sn.them.get(i).radius));
       

        }
        return s;
    }

    public static Void TinhTien(Rectangle A, int dx, int dy) {
        A.x += dx;
        A.y += dy;
        return null;
    }

}
