package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.globalwasher.mvp_api.volley.o f24994a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f24996c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f25000g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24995b = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, e> f24997d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap<String, e> f24998e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f24999f = new Handler(Looper.getMainLooper());

    class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f25002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f25003c;

        a(int i7, ImageView imageView, int i8) {
            this.f25001a = i7;
            this.f25002b = imageView;
            this.f25003c = i8;
        }

        @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.h
        public void a(g gVar, boolean z7) {
            if (gVar.d() != null) {
                this.f25002b.setImageBitmap(gVar.d());
                return;
            }
            int i7 = this.f25003c;
            if (i7 != 0) {
                this.f25002b.setImageResource(i7);
            }
        }

        @Override // com.haier.globalwasher.mvp_api.volley.p.a
        public void c(com.haier.globalwasher.mvp_api.volley.u uVar) {
            int i7 = this.f25001a;
            if (i7 != 0) {
                this.f25002b.setImageResource(i7);
            }
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25004a;

        b(String str) {
            this.f25004a = str;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            l.this.m(this.f25004a, (com.haier.globalwasher.mvp_api.volley.u) exc);
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap) {
            l.this.n(this.f25004a, bitmap);
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25006a;

        c(String str) {
            this.f25006a = str;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            l.this.m(this.f25006a, (com.haier.globalwasher.mvp_api.volley.u) exc);
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void b(Object obj) {
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e eVar : l.this.f24998e.values()) {
                for (g gVar : eVar.f25012d) {
                    if (gVar.f25015b != null) {
                        if (eVar.e() == null) {
                            gVar.f25014a = eVar.f25010b;
                            gVar.f25015b.a(gVar, false);
                        } else {
                            gVar.f25015b.c(eVar.e());
                        }
                    }
                }
            }
            l.this.f24998e.clear();
            l.this.f25000g = null;
        }
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.globalwasher.mvp_api.volley.n<?> f25009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f25010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.haier.globalwasher.mvp_api.volley.u f25011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final LinkedList<g> f25012d;

        public e(com.haier.globalwasher.mvp_api.volley.n<?> nVar, g gVar) {
            LinkedList<g> linkedList = new LinkedList<>();
            this.f25012d = linkedList;
            this.f25009a = nVar;
            linkedList.add(gVar);
        }

        public void d(g gVar) {
            this.f25012d.add(gVar);
        }

        public com.haier.globalwasher.mvp_api.volley.u e() {
            return this.f25011c;
        }

        public boolean f(g gVar) {
            this.f25012d.remove(gVar);
            if (this.f25012d.size() != 0) {
                return false;
            }
            this.f25009a.c();
            return true;
        }

        public void g(com.haier.globalwasher.mvp_api.volley.u uVar) {
            this.f25011c = uVar;
        }
    }

    public interface f {
        Bitmap a(String str);

        void b(String str, Bitmap bitmap);
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap f25014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f25015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f25016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f25017d;

        public g(Bitmap bitmap, String str, String str2, h hVar) {
            this.f25014a = bitmap;
            this.f25017d = str;
            this.f25016c = str2;
            this.f25015b = hVar;
        }

        public void c() {
            if (this.f25015b == null) {
                return;
            }
            e eVar = (e) l.this.f24997d.get(this.f25016c);
            if (eVar != null) {
                if (eVar.f(this)) {
                    l.this.f24997d.remove(this.f25016c);
                    return;
                }
                return;
            }
            e eVar2 = (e) l.this.f24998e.get(this.f25016c);
            if (eVar2 != null) {
                eVar2.f(this);
                if (eVar2.f25012d.size() == 0) {
                    l.this.f24998e.remove(this.f25016c);
                }
            }
        }

        public Bitmap d() {
            return this.f25014a;
        }

        public String e() {
            return this.f25017d;
        }
    }

    public interface h extends com.haier.globalwasher.mvp_api.volley.p.a {
        void a(g gVar, boolean z7);
    }

    public l(com.haier.globalwasher.mvp_api.volley.o oVar, f fVar) {
        this.f24994a = oVar;
        this.f24996c = fVar;
    }

    private void d(String str, e eVar) {
        this.f24998e.put(str, eVar);
        if (this.f25000g == null) {
            d dVar = new d();
            this.f25000g = dVar;
            this.f24999f.postDelayed(dVar, this.f24995b);
        }
    }

    private static String h(String str, int i7, int i8, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i7);
        sb.append("#H");
        sb.append(i8);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }

    public static h i(ImageView imageView, int i7, int i8) {
        return new a(i8, imageView, i7);
    }

    private void p() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    public g e(String str, h hVar) {
        return f(str, hVar, 0, 0);
    }

    public g f(String str, h hVar, int i7, int i8) {
        return g(str, hVar, i7, i8, ImageView.ScaleType.CENTER_INSIDE);
    }

    public g g(String str, h hVar, int i7, int i8, ImageView.ScaleType scaleType) {
        p();
        String strH = h(str, i7, i8, scaleType);
        Bitmap bitmapA = this.f24996c.a(strH);
        if (bitmapA != null) {
            g gVar = new g(bitmapA, str, null, null);
            hVar.a(gVar, true);
            return gVar;
        }
        g gVar2 = new g(null, str, strH, hVar);
        hVar.a(gVar2, true);
        e eVar = this.f24997d.get(strH);
        if (eVar != null) {
            eVar.d(gVar2);
            return gVar2;
        }
        com.haier.globalwasher.mvp_api.volley.n<Bitmap> nVarL = l(str, i7, i8, scaleType, strH);
        this.f24994a.a(nVarL);
        this.f24997d.put(strH, new e(nVarL, gVar2));
        return gVar2;
    }

    public boolean j(String str, int i7, int i8) {
        return k(str, i7, i8, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean k(String str, int i7, int i8, ImageView.ScaleType scaleType) {
        p();
        return this.f24996c.a(h(str, i7, i8, scaleType)) != null;
    }

    protected com.haier.globalwasher.mvp_api.volley.n<Bitmap> l(String str, int i7, int i8, ImageView.ScaleType scaleType, String str2) {
        return new m(str, new b(str2), i7, i8, scaleType, Bitmap.Config.RGB_565, new c(str2));
    }

    protected void m(String str, com.haier.globalwasher.mvp_api.volley.u uVar) {
        e eVarRemove = this.f24997d.remove(str);
        if (eVarRemove != null) {
            eVarRemove.g(uVar);
            d(str, eVarRemove);
        }
    }

    protected void n(String str, Bitmap bitmap) {
        this.f24996c.b(str, bitmap);
        e eVarRemove = this.f24997d.remove(str);
        if (eVarRemove != null) {
            eVarRemove.f25010b = bitmap;
            d(str, eVarRemove);
        }
    }

    public void o(int i7) {
        this.f24995b = i7;
    }
}
