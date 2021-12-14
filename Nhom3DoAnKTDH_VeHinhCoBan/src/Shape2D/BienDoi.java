/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;
import Materials.PointDouble;
import Materials.Diem;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Scanner;
public class BienDoi {
    static final double PI = 3.14;
    public static final int DXOX = 0;
    public static final int DXOY = 1;
    public static final int DXOO = 2;
    
    public static Point5Pixel biendoi2D(Affine2D T, Point5Pixel P)
    {
        double x, y;
        x = (T.Matrix[0][0] * P.x + T.Matrix[1][0] * P.y + T.Matrix[2][0]);
        y = (int) (T.Matrix[0][1] * P.x + T.Matrix[1][1] * P.y + T.Matrix[2][1]);
        
//        if ((x*10)%10 < 5)
//            x--;
//        if ((y*10)%10 < 5)
//            y--;
        return new Point5Pixel((int)x,(int) y);
    }
    public static Affine2D tinhtien (double tx, double ty)
    {
        Affine2D T = new Affine2D();
        T.Matrix[0][0] = 1; T.Matrix[0][1] = 0; T.Matrix[0][2] = 0;
        T.Matrix[1][0] = 0; T.Matrix[1][1] = 1; T.Matrix[1][2] = 0;
        T.Matrix[2][0] = tx; T.Matrix[2][1] = ty; T.Matrix[2][2] = 1;
        return T;
    }
    // phép quay
    public static Affine2D XuayQuanh1Diem(double alpha, int x, int y)
    {
        Affine2D T = new Affine2D();
        
        T.Matrix[0][0] = cos(alpha); T.Matrix[0][1] = sin(alpha); T.Matrix[0][2] = 0;
        T.Matrix[1][0] = -sin(alpha); T.Matrix[1][1] = cos(alpha); T.Matrix[1][2] = 0;
        T.Matrix[2][0] = (1-cos(alpha))*x + sin(alpha)*y;    T.Matrix[2][1] = -sin(alpha)*x+(1-cos(alpha))*y; T.Matrix[2][2] = 1;
        return T;
    }
    public static Affine2D doiXung (double tx, double ty)
    {
        Affine2D T = new Affine2D();
        T.Matrix[0][0] = 1; T.Matrix[0][1] = 0; T.Matrix[0][2] = 0;
        T.Matrix[1][0] = 0; T.Matrix[1][1] = 1; T.Matrix[1][2] = 0;
        T.Matrix[2][0] = tx; T.Matrix[2][1] = ty; T.Matrix[2][2] = 1;
        return T;
    }
}
