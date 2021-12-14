/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape2D;

import Materials.Diem;
import Materials.DoanThang;
import Materials.HinhTron;
import static Shape2D.FoodOfSnake.BOOM;
import static Shape2D.FoodOfSnake.FOOD;
import static Shape2D.MangLuoi2D_VeConRanVersion1.diemAn;
import static Shape2D.MangLuoi2D_VeConRanVersion1.toadoBoom1;
import static Shape2D.MangLuoi2D_VeConRanVersion1.toadoBoom2;
import static Shape2D.MangLuoi2D_VeConRanVersion1.toadoBoom3;
import static Shape2D.MangLuoi2D_VeConRanVersion1.toadoDauRan;
import static Shape2D.MangLuoi2D_VeConRanVersion1.toadoThucAn;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 *
 * @author HUYENKUTE
 */
public class ToMauVe {

    public static void ToMauNenChoLuoiPixel3(Point5Pixel[][] mangLuoiPixel) {
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 230; j++) {

                        mangLuoiPixel[i][j] = new Point5Pixel(i, j);
                        if (i <= 3 || j <= 3 || i >= 127 || j >= 215 ) {

                            mangLuoiPixel[i][j].color = Color.BLUE;
                        }
                    
                    
            }
        }
    }
    public static void ToMauNenChoLuoiPixel2(Point5Pixel[][] mangLuoiPixel) {
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 230; j++) {

                        mangLuoiPixel[i][j] = new Point5Pixel(i, j);
                        if (i <= 3 || j <= 3 || i >= 127 || j >= 215 || (i > 63 && i < 67) || (j > 108 && j < 112)) {

                            mangLuoiPixel[i][j].color = Color.BLACK;
                        }
                    
                    
            }
        }
    }

    public static void ToMauNenChoLuoiPixel(Point5Pixel[][] mangLuoiPixel) {
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 230; j++) {
                mangLuoiPixel[i][j] = new Point5Pixel(i, j);
                if (i <= 3 || j <= 3 || i >= 127 || j >= 215) {

                    mangLuoiPixel[i][j].color = Color.BLACK;
                }
                if ((j > 146 && j < 178) && (i > 35 && i < 45) || (j > 36 && j < 68 && (i > 85 && i < 95))) {
                    if (j % 5 == 0) {
                        mangLuoiPixel[i][j].color = Color.WHITE;
                    } else {
                        mangLuoiPixel[i][j].color = Color.black;
                    }
                }
                if ((j > 10 && j < 17 || j > 80 && j < 87 || j > 120 && j < 127 || j > 190 && j < 197) && (i > 30 && i < 50 || i > 80 && i < 100)) {
                    mangLuoiPixel[i][j].color = Color.BLACK;
                }
            }
        }
    }

    public static boolean VeThucAn(Point5Pixel mang_i_j, int i, int j, FoodOfSnake food, double kc) {
        boolean eat = false;
        //if (foodVisible || boomVisible) {
        if (kc < food.inerFood.radius) {
            if (mang_i_j.color == Color.BLUE) {
                diemAn++;
                eat = true;

            }
            mang_i_j.color = food.foodColor2;
            if (food.type == BOOM) {
                if (i >= food.y && j <= food.x && (abs(i - food.y) > 1 || abs(j - food.x) > 1)) {
                    mang_i_j.color = food.boomColor2;
                } else {
                    mang_i_j.color = food.boomColor;
                }
            }

        } else if (kc <= food.food.radius + 1) {
            if (mang_i_j.color == Color.BLUE) {
                if (food.type == FOOD) // ăn trúng thức ăn
                {
                    diemAn++;
                }
                eat = true;

            }
            if (mang_i_j.color != Color.RED) {
                if (food.type == FOOD) {
                    mang_i_j.color = food.foodColor;
                } else {
                    mang_i_j.color = food.boomColor;
                }
            }

        }
        return eat;
    }

    public static void VeConRanDaChet(Point5Pixel[][] mangLuoiPixel, TheSnake snake) {
        Point5Pixel v;
        if (snake.thanran.size() > 0) {

            for (int i = 0; i < snake.thanran.size(); i += 5) {
                v = snake.thanran.get(i);
                mangLuoiPixel[v.y + 5][v.x].color = v.color;
                mangLuoiPixel[v.y - 3][v.x].color = v.color;
                mangLuoiPixel[v.y][v.x + 5].color = v.color;
                mangLuoiPixel[v.y][v.x - 3].color = v.color;
                mangLuoiPixel[v.y + 2][v.x - 2].color = v.color;
                mangLuoiPixel[v.y - 2][v.x + 2].color = v.color;
            }

            mangLuoiPixel[snake.mat1.y][snake.mat1.x].color = Color.BLUE;
            mangLuoiPixel[snake.mat2.y][snake.mat2.x].color = Color.BLUE;
            mangLuoiPixel[snake.mat1.y + 2][snake.mat1.x].color = Color.BLUE;
            mangLuoiPixel[snake.mat2.y - 2][snake.mat2.x].color = Color.BLUE;
            mangLuoiPixel[snake.mat1.y][snake.mat1.x + 2].color = Color.BLUE;
            mangLuoiPixel[snake.mat2.y][snake.mat2.x - 2].color = Color.BLUE;

        }
    }

    public static void VeConRanRa(Point5Pixel[][] mangLuoiPixel, TheSnake snake, int trangthaiLeLuoi) {
        if (snake.thanran.size() > 0) {

            for (Point5Pixel v : snake.duoiran) {
                if (v.x > 2 && v.x < 230 && v.y > 2 && v.y < 130) {
                    mangLuoiPixel[v.y][v.x].color = v.color;
                }
            }
//            timer.start(); 
            if ((trangthaiLeLuoi) % 20 <= 50) {
                for (Point5Pixel v : snake.luoi) {
                    if (v.x > 2 && v.x < 230 && v.y > 2 && v.y < 130) {
                        mangLuoiPixel[v.y][v.x].color = new Color(249, 67, 0);
                    }

                }
//                food.NhapNho(1.5);
            } else if (trangthaiLeLuoi % 20 <= 10 || trangthaiLeLuoi % 20 > 15) {
                for (Point5Pixel v : snake.luoi)// LƯỠI RẮN plezz
                {
                    if (v.x > 2 && v.x < 230 && v.y > 2 && v.y < 130) {
                        mangLuoiPixel[v.y][v.x - 2].color = new Color(249, 67, 0);
                    }
                }

            }
            for (Point5Pixel v : snake.thanran) {
                if (v.x > 2 && v.x < 230 && v.y > 2 && v.y < 130) {
                    mangLuoiPixel[v.y][v.x].color = v.color;
                }
            }

            if (snake.mat1.x > 2 && snake.mat1.x < 230 && snake.mat1.y > 2 && snake.mat1.y < 130) {
                mangLuoiPixel[snake.mat1.y][snake.mat1.x].color = Color.BLUE;
            }
            if (snake.mat2.x > 2 && snake.mat2.x < 230 && snake.mat2.y > 2 && snake.mat2.y < 130) {
                mangLuoiPixel[snake.mat2.y][snake.mat2.x].color = Color.BLUE;
            }

        }
    }

    public static void VeVongQueo(Point5Pixel[][] mangLuoiPixel, TheSnake snake) {
        if (snake.them.size() > 0) {
            for (HinhTron c : snake.them) {
                for (int i = c.tam.x - c.radius + 1; i < c.tam.x + c.radius; i++) {
                    for (int j = c.tam.y - c.radius + 1; j < c.tam.y + c.radius; j++) {

                        if (abs((int) sqrt((i - c.tam.x) * (i - c.tam.x) + (j - c.tam.y) * (j - c.tam.y))) < c.radius) {
                            if(j > 1 && j <130 && i > 1 && i < 220 )
                            mangLuoiPixel[j][i].color = snake.mauthan2;
                        }
                    }
                }
            }
        }
    }

    public static void VeDoanThang(Point5Pixel[][] mangLuoi, DoanThang d, Color color) {
        // ================================ VẼ ĐƯỜNG THẲNG ==================================
        Diem dau = new Diem(d.dau.x, d.dau.y);
        Diem cuoi = new Diem(d.cuoi.x, d.cuoi.y);
        Diem p = new Diem(), pe = new Diem();
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
//                        g2d.fillRect(p.x, p.y, 5, 5);
            if (p.x > 0 && p.x < 130 && p.y > 0 && p.y < 130) {
                mangLuoi[p.y][p.x].color = color;
            }

            for (int j = 0; p.x < pe.x; j++) {
                p.x++;
                if (s1 < 0) {
                    s1 = s1 + 2 * dy1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.y++;
                    } else {
                        p.y--;
                    }
                    s1 = s1 + 2 * (dy1 - dx1);
                }
//                            g2d.fillRect(p.x, p.y, 5, 5);
                if (p.x > 0 && p.x < 130 && p.y > 0 && p.y < 130) {
                    mangLuoi[p.y][p.x].color = color;
                }
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
//                        g2d.fillRect(p.x, p.y, 5, 5);

            if (p.x > 0 && p.x < 130 && p.y > 0 && p.y < 130) {
                mangLuoi[p.y][p.x].color = color;
            }
            for (int j = 0; p.y < pe.y; j++) {
                p.y++;
                if (s2 <= 0) {
                    s2 = s2 + 2 * dx1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.x++;
                    } else {
                        p.x--;
                    }
                    s2 = s2 + 2 * (dx1 - dy1);
                }
//                            g2d.fillRect(p.x, p.y, 5, 5);

                if (p.x > 0 && p.x < 130 && p.y > 0 && p.y < 130) {
                    mangLuoi[p.y][p.x].color = color;
                }
            }
        }
    }

    public static void VeNgoiBoom(Point5Pixel[][] mangLuoi, Diem dau, Diem cuoi, Color color) {
        // ================================ VẼ ĐƯỜNG THẲNG ==================================

        Diem p = new Diem(), pe = new Diem();
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
//                        g2d.fillRect(p.x, p.y, 5, 5);
            mangLuoi[p.y][p.x].color = color;

            for (int j = 0; p.x < pe.x; j++) {
                p.x++;
                if (s1 < 0) {
                    s1 = s1 + 2 * dy1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.y++;
                    } else {
                        p.y--;
                    }
                    s1 = s1 + 2 * (dy1 - dx1);
                }
//                            g2d.fillRect(p.x, p.y, 5, 5);
                mangLuoi[p.y][p.x].color = color;
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
//                        g2d.fillRect(p.x, p.y, 5, 5);

            mangLuoi[p.y][p.x].color = color;
            for (int j = 0; p.y < pe.y; j++) {
                p.y++;
                if (s2 <= 0) {
                    s2 = s2 + 2 * dx1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        p.x++;
                    } else {
                        p.x--;
                    }
                    s2 = s2 + 2 * (dx1 - dy1);
                }
//                            g2d.fillRect(p.x, p.y, 5, 5);

                mangLuoi[p.y][p.x].color = color;
            }
        }
        // ================== VẼ HÌNH TRÒN NÈ - NGÒI ĐANG BỊ CHÁY XÈ XÈ ============
        mangLuoi[cuoi.y + 1][cuoi.x + 1].color = color;
        VeHinhTron(mangLuoi, new Diem(cuoi.x + 1, cuoi.y + 1), 2);

    }

    static void ve4Diem(Diem tam, int x, int y, Point5Pixel[][] mangLuoi) {
//        mangLuoi[x+tam.x][ y+tam.y ].color = Color.RED;
//        mangLuoi[x+tam.x][ -y+tam.y ].color = Color.RED;
//        mangLuoi[-x+tam.x][ y+tam.y ].color = Color.RED;
//        mangLuoi[-x+tam.x][ -y+tam.y ].color = Color.RED;
        mangLuoi[y + tam.y][x + tam.x].color = Color.RED;
        mangLuoi[y + tam.y][-x + tam.x].color = Color.RED;
        mangLuoi[-y + tam.y][x + tam.x].color = Color.RED;
        mangLuoi[-y + tam.y][-x + tam.x].color = Color.RED;
    }

    public static void VeHinhTron(Point5Pixel[][] mangLuoi, Diem tam, int r) {

        int count = 0;
        int x = 0, y = r;
        int f = 1 - r;
        if (count % 2 == 0) {
            ve4Diem(tam, x, y, mangLuoi);
        }
        count++;
        //ve8Diem(x,y,g);

        while (x < y) {
            if (f < 0) {
                f += (x << 1) + 1;
            } else {
                y--;
                f += ((x - y) << 1) + 1;
            }
            x++;
            if (count % 2 == 0) {
                ve4Diem(tam, x, y, mangLuoi);

            }
            count++;
        }
    }

}
