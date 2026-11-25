package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.u;
import androidx.constraintlayout.core.motion.utils.v;
import androidx.constraintlayout.core.parser.d;
import androidx.constraintlayout.core.parser.f;
import androidx.constraintlayout.core.parser.g;
import androidx.constraintlayout.core.parser.h;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        int get(int i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface b {
        int c(String str);
    }

    public static void a(String[] strArr) {
        c("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static u b(String str, b bVar, a aVar) {
        u uVar = new u();
        try {
            f fVarD = g.d(str);
            int size = fVarD.size();
            for (int i7 = 0; i7 < size; i7++) {
                d dVar = (d) fVarD.A(i7);
                String strB = dVar.b();
                androidx.constraintlayout.core.parser.c cVarF0 = dVar.f0();
                int iC = bVar.c(strB);
                if (iC == -1) {
                    System.err.println("unknown type " + strB);
                } else {
                    int i8 = aVar.get(iC);
                    if (i8 == 1) {
                        uVar.d(iC, fVarD.H(i7));
                    } else if (i8 == 2) {
                        uVar.b(iC, cVarF0.j());
                        System.out.println("parse " + strB + " INT_MASK > " + cVarF0.j());
                    } else if (i8 == 4) {
                        uVar.a(iC, cVarF0.h());
                        System.out.println("parse " + strB + " FLOAT_MASK > " + cVarF0.h());
                    } else if (i8 == 8) {
                        uVar.c(iC, cVarF0.b());
                        System.out.println("parse " + strB + " STRING_MASK > " + cVarF0.b());
                    }
                }
            }
        } catch (h e8) {
            e8.printStackTrace();
        }
        return uVar;
    }

    public static u c(String str) {
        return b(str, new b() { // from class: androidx.constraintlayout.core.motion.parse.a
            @Override // androidx.constraintlayout.core.motion.parse.c.b
            public final int c(String str2) {
                return v.a(str2);
            }
        }, new a() { // from class: androidx.constraintlayout.core.motion.parse.b
            @Override // androidx.constraintlayout.core.motion.parse.c.a
            public final int get(int i7) {
                return v.b(i7);
            }
        });
    }
}
