package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z3 f5855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final androidx.collection.g<String, Typeface> f5856b;

    @c.x0({c.x0.a.LIBRARY})
    public static class a extends androidx.core.provider.j.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @c.o0
        private androidx.core.content.res.i.g f5857j;

        public a(@c.o0 androidx.core.content.res.i.g gVar) {
            this.f5857j = gVar;
        }

        @Override // androidx.core.provider.j.d
        public void a(int i7) {
            androidx.core.content.res.i.g gVar = this.f5857j;
            if (gVar != null) {
                gVar.f(i7);
            }
        }

        @Override // androidx.core.provider.j.d
        public void b(@c.m0 Typeface typeface) {
            androidx.core.content.res.i.g gVar = this.f5857j;
            if (gVar != null) {
                gVar.g(typeface);
            }
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 29) {
            f5855a = new y3();
        } else if (i7 >= 28) {
            f5855a = new a3();
        } else if (i7 >= 26) {
            f5855a = new z2();
        } else if (i7 < 24 || !s2.m()) {
            f5855a = new r2();
        } else {
            f5855a = new s2();
        }
        f5856b = new androidx.collection.g<>(16);
    }

    private q2() {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.g1
    public static void a() {
        f5856b.f();
    }

    @c.m0
    public static Typeface b(@c.m0 Context context, @c.o0 Typeface typeface, int i7) {
        if (context != null) {
            return Typeface.create(typeface, i7);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static Typeface c(@c.m0 Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) {
        return f5855a.c(context, cancellationSignal, cVarArr, i7);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface d(@c.m0 Context context, @c.m0 androidx.core.content.res.f.b bVar, @c.m0 Resources resources, int i7, int i8, @c.o0 androidx.core.content.res.i.g gVar, @c.o0 Handler handler, boolean z7) {
        return e(context, bVar, resources, i7, null, 0, i8, gVar, handler, z7);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY})
    public static Typeface e(@c.m0 Context context, @c.m0 androidx.core.content.res.f.b bVar, @c.m0 Resources resources, int i7, @c.o0 String str, int i8, int i9, @c.o0 androidx.core.content.res.i.g gVar, @c.o0 Handler handler, boolean z7) {
        Typeface typefaceB;
        if (bVar instanceof androidx.core.content.res.f.C0059f) {
            androidx.core.content.res.f.C0059f c0059f = (androidx.core.content.res.f.C0059f) bVar;
            Typeface typefaceL = l(c0059f.c());
            if (typefaceL != null) {
                if (gVar != null) {
                    gVar.d(typefaceL, handler);
                }
                return typefaceL;
            }
            boolean z8 = !z7 ? gVar != null : c0059f.a() != 0;
            int iD = z7 ? c0059f.d() : -1;
            typefaceB = androidx.core.provider.j.f(context, c0059f.b(), i9, z8, iD, androidx.core.content.res.i.g.e(handler), new a(gVar));
        } else {
            typefaceB = f5855a.b(context, (androidx.core.content.res.f.d) bVar, resources, i9);
            if (gVar != null) {
                if (typefaceB != null) {
                    gVar.d(typefaceB, handler);
                } else {
                    gVar.c(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f5856b.l(h(resources, i7, str, i8, i9), typefaceB);
        }
        return typefaceB;
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface f(@c.m0 Context context, @c.m0 Resources resources, int i7, String str, int i8) {
        return g(context, resources, i7, str, 0, i8);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY})
    public static Typeface g(@c.m0 Context context, @c.m0 Resources resources, int i7, String str, int i8, int i9) {
        Typeface typefaceE = f5855a.e(context, resources, i7, str, i9);
        if (typefaceE != null) {
            f5856b.l(h(resources, i7, str, i8, i9), typefaceE);
        }
        return typefaceE;
    }

    private static String h(Resources resources, int i7, String str, int i8, int i9) {
        return resources.getResourcePackageName(i7) + '-' + str + '-' + i8 + '-' + i7 + '-' + i9;
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface i(@c.m0 Resources resources, int i7, int i8) {
        return j(resources, i7, null, 0, i8);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY})
    public static Typeface j(@c.m0 Resources resources, int i7, @c.o0 String str, int i8, int i9) {
        return f5856b.h(h(resources, i7, str, i8, i9));
    }

    @c.o0
    private static Typeface k(Context context, Typeface typeface, int i7) {
        z3 z3Var = f5855a;
        androidx.core.content.res.f.d dVarI = z3Var.i(typeface);
        if (dVarI == null) {
            return null;
        }
        return z3Var.b(context, dVarI, context.getResources(), i7);
    }

    private static Typeface l(@c.o0 String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
