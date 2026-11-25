package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class z3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5926b = "TypefaceCompatBaseImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5927c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, androidx.core.content.res.f.d> f5928a = new ConcurrentHashMap<>();

    class a implements c<androidx.core.provider.j.c> {
        a() {
        }

        @Override // androidx.core.graphics.z3.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(androidx.core.provider.j.c cVar) {
            return cVar.e();
        }

        @Override // androidx.core.graphics.z3.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(androidx.core.provider.j.c cVar) {
            return cVar.f();
        }
    }

    class b implements c<androidx.core.content.res.f.e> {
        b() {
        }

        @Override // androidx.core.graphics.z3.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(androidx.core.content.res.f.e eVar) {
            return eVar.e();
        }

        @Override // androidx.core.graphics.z3.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(androidx.core.content.res.f.e eVar) {
            return eVar.f();
        }
    }

    private interface c<T> {
        int a(T t7);

        boolean b(T t7);
    }

    z3() {
    }

    private void a(Typeface typeface, androidx.core.content.res.f.d dVar) {
        long j7 = j(typeface);
        if (j7 != 0) {
            this.f5928a.put(Long.valueOf(j7), dVar);
        }
    }

    private androidx.core.content.res.f.e f(androidx.core.content.res.f.d dVar, int i7) {
        return (androidx.core.content.res.f.e) g(dVar.a(), i7, new b());
    }

    private static <T> T g(T[] tArr, int i7, c<T> cVar) {
        int i8 = (i7 & 1) == 0 ? 400 : androidx.constraintlayout.core.motion.utils.w.h.f3152j;
        boolean z7 = (i7 & 2) != 0;
        T t7 = null;
        int i9 = Integer.MAX_VALUE;
        for (T t8 : tArr) {
            int iAbs = (Math.abs(cVar.a(t8) - i8) * 2) + (cVar.b(t8) == z7 ? 0 : 1);
            if (t7 == null || i9 > iAbs) {
                t7 = t8;
                i9 = iAbs;
            }
        }
        return t7;
    }

    private static long j(@c.o0 Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e8) {
            Log.e(f5926b, "Could not retrieve font from family.", e8);
            return 0L;
        } catch (NoSuchFieldException e9) {
            Log.e(f5926b, "Could not retrieve font from family.", e9);
            return 0L;
        }
    }

    @c.o0
    public Typeface b(Context context, androidx.core.content.res.f.d dVar, Resources resources, int i7) {
        androidx.core.content.res.f.e eVarF = f(dVar, i7);
        if (eVarF == null) {
            return null;
        }
        Typeface typefaceG = q2.g(context, resources, eVarF.b(), eVarF.a(), 0, i7);
        a(typefaceG, dVar);
        return typefaceG;
    }

    @c.o0
    public Typeface c(Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (cVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(cVarArr, i7).d());
            try {
                Typeface typefaceD = d(context, inputStreamOpenInputStream);
                a4.a(inputStreamOpenInputStream);
                return typefaceD;
            } catch (IOException unused) {
                a4.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                a4.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = a4.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (a4.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    @c.o0
    public Typeface e(Context context, Resources resources, int i7, String str, int i8) {
        File fileE = a4.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (a4.c(fileE, resources, i7)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected androidx.core.provider.j.c h(androidx.core.provider.j.c[] cVarArr, int i7) {
        return (androidx.core.provider.j.c) g(cVarArr, i7, new a());
    }

    @c.o0
    androidx.core.content.res.f.d i(Typeface typeface) {
        long j7 = j(typeface);
        if (j7 == 0) {
            return null;
        }
        return this.f5928a.get(Long.valueOf(j7));
    }
}
