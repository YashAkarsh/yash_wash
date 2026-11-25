package com.alibaba.fastjson.serializer;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class o implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f13153a = new o();

    private Object j(com.alibaba.fastjson.parser.b bVar, Object obj) {
        com.alibaba.fastjson.parser.d dVarH0 = bVar.h0();
        dVarH0.v0(4);
        String strX0 = dVarH0.x0();
        bVar.Z1(bVar.C(), obj);
        bVar.g(new com.alibaba.fastjson.parser.b.a(bVar.C(), strX0));
        bVar.R1();
        bVar.e2(1);
        dVarH0.Q(13);
        bVar.b(13);
        return null;
    }

    public static boolean k(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        T t7;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() == 8) {
            dVar.Q(16);
            return null;
        }
        if (dVar.L0() != 12 && dVar.L0() != 16) {
            throw new com.alibaba.fastjson.d("syntax error");
        }
        dVar.E();
        if (type == Point.class) {
            t7 = (T) h(bVar, obj);
        } else if (type == Rectangle.class) {
            t7 = (T) i(bVar);
        } else if (type == Color.class) {
            t7 = (T) f(bVar);
        } else {
            if (type != Font.class) {
                throw new com.alibaba.fastjson.d("not support awt class : " + type);
            }
            t7 = (T) g(bVar);
        }
        com.alibaba.fastjson.parser.i iVarC = bVar.C();
        bVar.Z1(t7, obj);
        bVar.a2(iVarC);
        return t7;
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            j1Var.a1(l(j1Var, Point.class, '{'), "x", point.x);
            j1Var.a1(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            j1Var.i1(l(j1Var, Font.class, '{'), "name", font.getName());
            j1Var.a1(',', AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, font.getStyle());
            j1Var.a1(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            j1Var.a1(l(j1Var, Rectangle.class, '{'), "x", rectangle.x);
            j1Var.a1(',', "y", rectangle.y);
            j1Var.a1(',', ViewHierarchyConstants.DIMENSION_WIDTH_KEY, rectangle.width);
            j1Var.a1(',', ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new com.alibaba.fastjson.d("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            j1Var.a1(l(j1Var, Color.class, '{'), "r", color.getRed());
            j1Var.a1(',', "g", color.getGreen());
            j1Var.a1(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                j1Var.a1(',', "alpha", color.getAlpha());
            }
        }
        j1Var.write(125);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 12;
    }

    protected Color f(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (dVar.L0() != 13) {
            if (dVar.L0() != 4) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            String strX0 = dVar.x0();
            dVar.v0(2);
            if (dVar.L0() != 2) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            int iH = dVar.H();
            dVar.E();
            if (strX0.equalsIgnoreCase("r")) {
                i7 = iH;
            } else if (strX0.equalsIgnoreCase("g")) {
                i8 = iH;
            } else if (strX0.equalsIgnoreCase("b")) {
                i9 = iH;
            } else {
                if (!strX0.equalsIgnoreCase("alpha")) {
                    throw new com.alibaba.fastjson.d("syntax error, " + strX0);
                }
                i10 = iH;
            }
            if (dVar.L0() == 16) {
                dVar.Q(4);
            }
        }
        dVar.E();
        return new Color(i7, i8, i9, i10);
    }

    protected Font g(com.alibaba.fastjson.parser.b bVar) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iH = 0;
        String strX0 = null;
        int iH2 = 0;
        while (dVar.L0() != 13) {
            if (dVar.L0() != 4) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            String strX1 = dVar.x0();
            dVar.v0(2);
            if (strX1.equalsIgnoreCase("name")) {
                if (dVar.L0() != 4) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                strX0 = dVar.x0();
                dVar.E();
            } else if (strX1.equalsIgnoreCase(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                if (dVar.L0() != 2) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                iH = dVar.H();
                dVar.E();
            } else {
                if (!strX1.equalsIgnoreCase("size")) {
                    throw new com.alibaba.fastjson.d("syntax error, " + strX1);
                }
                if (dVar.L0() != 2) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                iH2 = dVar.H();
                dVar.E();
            }
            if (dVar.L0() == 16) {
                dVar.Q(4);
            }
        }
        dVar.E();
        return new Font(strX0, iH, iH2);
    }

    protected Point h(com.alibaba.fastjson.parser.b bVar, Object obj) {
        int iI0;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int i7 = 0;
        int i8 = 0;
        while (dVar.L0() != 13) {
            if (dVar.L0() != 4) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            String strX0 = dVar.x0();
            if (com.alibaba.fastjson.a.f12529c.equals(strX0)) {
                bVar.e("java.awt.Point");
            } else {
                if ("$ref".equals(strX0)) {
                    return (Point) j(bVar, obj);
                }
                dVar.v0(2);
                int iL0 = dVar.L0();
                if (iL0 == 2) {
                    iI0 = dVar.H();
                    dVar.E();
                } else {
                    if (iL0 != 3) {
                        throw new com.alibaba.fastjson.d("syntax error : " + dVar.A1());
                    }
                    iI0 = (int) dVar.I0();
                    dVar.E();
                }
                if (strX0.equalsIgnoreCase("x")) {
                    i7 = iI0;
                } else {
                    if (!strX0.equalsIgnoreCase("y")) {
                        throw new com.alibaba.fastjson.d("syntax error, " + strX0);
                    }
                    i8 = iI0;
                }
                if (dVar.L0() == 16) {
                    dVar.Q(4);
                }
            }
        }
        dVar.E();
        return new Point(i7, i8);
    }

    protected Rectangle i(com.alibaba.fastjson.parser.b bVar) {
        int iI0;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (dVar.L0() != 13) {
            if (dVar.L0() != 4) {
                throw new com.alibaba.fastjson.d("syntax error");
            }
            String strX0 = dVar.x0();
            dVar.v0(2);
            int iL0 = dVar.L0();
            if (iL0 == 2) {
                iI0 = dVar.H();
                dVar.E();
            } else {
                if (iL0 != 3) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                iI0 = (int) dVar.I0();
                dVar.E();
            }
            if (strX0.equalsIgnoreCase("x")) {
                i7 = iI0;
            } else if (strX0.equalsIgnoreCase("y")) {
                i8 = iI0;
            } else if (strX0.equalsIgnoreCase(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                i9 = iI0;
            } else {
                if (!strX0.equalsIgnoreCase(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                    throw new com.alibaba.fastjson.d("syntax error, " + strX0);
                }
                i10 = iI0;
            }
            if (dVar.L0() == 16) {
                dVar.Q(4);
            }
        }
        dVar.E();
        return new Rectangle(i7, i8, i9, i10);
    }

    protected char l(j1 j1Var, Class<?> cls, char c8) {
        if (!j1Var.G(k1.WriteClassName)) {
            return c8;
        }
        j1Var.write(123);
        j1Var.J0(com.alibaba.fastjson.a.f12529c);
        j1Var.a2(cls.getName());
        return ',';
    }
}
