package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.core.graphics.q2;
import c.m0;
import c.o0;
import c.z;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final androidx.collection.g<String, Typeface> f6135a = new androidx.collection.g<>(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f6136b = k.a("fonts-androidx", 10, com.haier.library.sumhttp.plugin.h.f27948e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f6137c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @z("LOCK")
    static final androidx.collection.i<String, ArrayList<androidx.core.util.e<e>>> f6138d = new androidx.collection.i<>();

    class a implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f6140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f6141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6142d;

        a(String str, Context context, h hVar, int i7) {
            this.f6139a = str;
            this.f6140b = context;
            this.f6141c = hVar;
            this.f6142d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return i.c(this.f6139a, this.f6140b, this.f6141c, this.f6142d);
        }
    }

    class b implements androidx.core.util.e<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.a f6143a;

        b(androidx.core.provider.a aVar) {
            this.f6143a = aVar;
        }

        @Override // androidx.core.util.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f6143a.b(eVar);
        }
    }

    class c implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f6145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f6146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6147d;

        c(String str, Context context, h hVar, int i7) {
            this.f6144a = str;
            this.f6145b = context;
            this.f6146c = hVar;
            this.f6147d = i7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return i.c(this.f6144a, this.f6145b, this.f6146c, this.f6147d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements androidx.core.util.e<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6148a;

        d(String str) {
            this.f6148a = str;
        }

        @Override // androidx.core.util.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (i.f6137c) {
                androidx.collection.i<String, ArrayList<androidx.core.util.e<e>>> iVar = i.f6138d;
                ArrayList<androidx.core.util.e<e>> arrayList = iVar.get(this.f6148a);
                if (arrayList == null) {
                    return;
                }
                iVar.remove(this.f6148a);
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    arrayList.get(i7).accept(eVar);
                }
            }
        }
    }

    private i() {
    }

    private static String a(@m0 h hVar, int i7) {
        return hVar.d() + "-" + i7;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@m0 j.b bVar) {
        int i7 = 1;
        if (bVar.c() != 0) {
            return bVar.c() != 1 ? -3 : -2;
        }
        j.c[] cVarArrB = bVar.b();
        if (cVarArrB != null && cVarArrB.length != 0) {
            i7 = 0;
            for (j.c cVar : cVarArrB) {
                int iB = cVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i7;
    }

    @m0
    static e c(@m0 String str, @m0 Context context, @m0 h hVar, int i7) {
        androidx.collection.g<String, Typeface> gVar = f6135a;
        Typeface typefaceH = gVar.h(str);
        if (typefaceH != null) {
            return new e(typefaceH);
        }
        try {
            j.b bVarE = g.e(context, hVar, null);
            int iB = b(bVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceC = q2.c(context, null, bVarE.b(), i7);
            if (typefaceC == null) {
                return new e(-3);
            }
            gVar.l(str, typefaceC);
            return new e(typefaceC);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(@m0 Context context, @m0 h hVar, int i7, @o0 Executor executor, @m0 androidx.core.provider.a aVar) {
        String strA = a(hVar, i7);
        Typeface typefaceH = f6135a.h(strA);
        if (typefaceH != null) {
            aVar.b(new e(typefaceH));
            return typefaceH;
        }
        b bVar = new b(aVar);
        synchronized (f6137c) {
            androidx.collection.i<String, ArrayList<androidx.core.util.e<e>>> iVar = f6138d;
            ArrayList<androidx.core.util.e<e>> arrayList = iVar.get(strA);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<androidx.core.util.e<e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            iVar.put(strA, arrayList2);
            c cVar = new c(strA, context, hVar, i7);
            if (executor == null) {
                executor = f6136b;
            }
            k.c(executor, cVar, new d(strA));
            return null;
        }
    }

    static Typeface e(@m0 Context context, @m0 h hVar, @m0 androidx.core.provider.a aVar, int i7, int i8) {
        String strA = a(hVar, i7);
        Typeface typefaceH = f6135a.h(strA);
        if (typefaceH != null) {
            aVar.b(new e(typefaceH));
            return typefaceH;
        }
        if (i8 == -1) {
            e eVarC = c(strA, context, hVar, i7);
            aVar.b(eVarC);
            return eVarC.f6149a;
        }
        try {
            e eVar = (e) k.d(f6136b, new a(strA, context, hVar, i7), i8);
            aVar.b(eVar);
            return eVar.f6149a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    static void f() {
        f6135a.f();
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f6149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f6150b;

        e(int i7) {
            this.f6149a = null;
            this.f6150b = i7;
        }

        @SuppressLint({"WrongConstant"})
        boolean a() {
            return this.f6150b == 0;
        }

        @SuppressLint({"WrongConstant"})
        e(@m0 Typeface typeface) {
            this.f6149a = typeface;
            this.f6150b = 0;
        }
    }
}
