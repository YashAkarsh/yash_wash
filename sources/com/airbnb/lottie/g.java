package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import c.h1;
import c.o0;
import c.s0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.a0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, o<com.airbnb.lottie.f>> f11786a = new HashMap();

    class a implements com.airbnb.lottie.j<com.airbnb.lottie.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11787a;

        a(String str) {
            this.f11787a = str;
        }

        @Override // com.airbnb.lottie.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.f fVar) {
            g.f11786a.remove(this.f11787a);
        }
    }

    class b implements com.airbnb.lottie.j<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11788a;

        b(String str) {
            this.f11788a = str;
        }

        @Override // com.airbnb.lottie.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            g.f11786a.remove(this.f11788a);
        }
    }

    class c implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11791c;

        c(Context context, String str, String str2) {
            this.f11789a = context;
            this.f11790b = str;
            this.f11791c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return com.airbnb.lottie.network.c.e(this.f11789a, this.f11790b, this.f11791c);
        }
    }

    class d implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f11794c;

        d(Context context, String str, String str2) {
            this.f11792a = context;
            this.f11793b = str;
            this.f11794c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.h(this.f11792a, this.f11793b, this.f11794c);
        }
    }

    class e implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f11795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f11796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f11797c;

        e(WeakReference weakReference, Context context, int i7) {
            this.f11795a = weakReference;
            this.f11796b = context;
            this.f11797c = i7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            Context context = (Context) this.f11795a.get();
            if (context == null) {
                context = this.f11796b;
            }
            return g.u(context, this.f11797c);
        }
    }

    class f implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f11798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11799b;

        f(InputStream inputStream, String str) {
            this.f11798a = inputStream;
            this.f11799b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.k(this.f11798a, this.f11799b);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.g$g, reason: collision with other inner class name */
    class CallableC0142g implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f11800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11801b;

        CallableC0142g(JSONObject jSONObject, String str) {
            this.f11800a = jSONObject;
            this.f11801b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.r(this.f11800a, this.f11801b);
        }
    }

    class h implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11803b;

        h(String str, String str2) {
            this.f11802a = str;
            this.f11803b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.q(this.f11802a, this.f11803b);
        }
    }

    class i implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.parser.moshi.c f11804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11805b;

        i(com.airbnb.lottie.parser.moshi.c cVar, String str) {
            this.f11804a = cVar;
            this.f11805b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.n(this.f11804a, this.f11805b);
        }
    }

    class j implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZipInputStream f11806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11807b;

        j(ZipInputStream zipInputStream, String str) {
            this.f11806a = zipInputStream;
            this.f11807b = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return g.B(this.f11806a, this.f11807b);
        }
    }

    class k implements Callable<n<com.airbnb.lottie.f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.f f11808a;

        k(com.airbnb.lottie.f fVar) {
            this.f11808a = fVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n<com.airbnb.lottie.f> call() {
            return new n<>(this.f11808a);
        }
    }

    private g() {
    }

    public static o<com.airbnb.lottie.f> A(ZipInputStream zipInputStream, @o0 String str) {
        return b(str, new j(zipInputStream, str));
    }

    @h1
    public static n<com.airbnb.lottie.f> B(ZipInputStream zipInputStream, @o0 String str) {
        try {
            return C(zipInputStream, str);
        } finally {
            com.airbnb.lottie.utils.j.c(zipInputStream);
        }
    }

    @h1
    private static n<com.airbnb.lottie.f> C(ZipInputStream zipInputStream, @o0 String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.f fVarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    fVarB = o(com.airbnb.lottie.parser.moshi.c.g0(a0.d(a0.m(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    String[] strArrSplit = name.split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (fVarB == null) {
                return new n<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                com.airbnb.lottie.i iVarD = d(fVarB, (String) entry.getKey());
                if (iVarD != null) {
                    iVarD.g(com.airbnb.lottie.utils.j.m((Bitmap) entry.getValue(), iVarD.f(), iVarD.d()));
                }
            }
            for (Map.Entry<String, com.airbnb.lottie.i> entry2 : fVarB.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new n<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            if (str != null) {
                com.airbnb.lottie.model.g.c().d(str, fVarB);
            }
            return new n<>(fVarB);
        } catch (IOException e8) {
            return new n<>((Throwable) e8);
        }
    }

    private static boolean D(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String E(Context context, @s0 int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(D(context) ? "_night_" : "_day_");
        sb.append(i7);
        return sb.toString();
    }

    public static void F(int i7) {
        com.airbnb.lottie.model.g.c().e(i7);
    }

    private static o<com.airbnb.lottie.f> b(@o0 String str, Callable<n<com.airbnb.lottie.f>> callable) {
        com.airbnb.lottie.f fVarB = str == null ? null : com.airbnb.lottie.model.g.c().b(str);
        if (fVarB != null) {
            return new o<>(new k(fVarB));
        }
        if (str != null) {
            Map<String, o<com.airbnb.lottie.f>> map = f11786a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        o<com.airbnb.lottie.f> oVar = new o<>(callable);
        if (str != null) {
            oVar.f(new a(str));
            oVar.e(new b(str));
            f11786a.put(str, oVar);
        }
        return oVar;
    }

    public static void c(Context context) {
        f11786a.clear();
        com.airbnb.lottie.model.g.c().a();
        new com.airbnb.lottie.network.b(context).a();
    }

    @o0
    private static com.airbnb.lottie.i d(com.airbnb.lottie.f fVar, String str) {
        for (com.airbnb.lottie.i iVar : fVar.i().values()) {
            if (iVar.c().equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    public static o<com.airbnb.lottie.f> e(Context context, String str) {
        return f(context, str, "asset_" + str);
    }

    public static o<com.airbnb.lottie.f> f(Context context, String str, @o0 String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @h1
    public static n<com.airbnb.lottie.f> g(Context context, String str) {
        return h(context, str, "asset_" + str);
    }

    @h1
    public static n<com.airbnb.lottie.f> h(Context context, String str, @o0 String str2) {
        try {
            return str.endsWith(".zip") ? B(new ZipInputStream(context.getAssets().open(str)), str2) : k(context.getAssets().open(str), str2);
        } catch (IOException e8) {
            return new n<>((Throwable) e8);
        }
    }

    @Deprecated
    public static o<com.airbnb.lottie.f> i(JSONObject jSONObject, @o0 String str) {
        return b(str, new CallableC0142g(jSONObject, str));
    }

    public static o<com.airbnb.lottie.f> j(InputStream inputStream, @o0 String str) {
        return b(str, new f(inputStream, str));
    }

    @h1
    public static n<com.airbnb.lottie.f> k(InputStream inputStream, @o0 String str) {
        return l(inputStream, str, true);
    }

    @h1
    private static n<com.airbnb.lottie.f> l(InputStream inputStream, @o0 String str, boolean z7) {
        try {
            return n(com.airbnb.lottie.parser.moshi.c.g0(a0.d(a0.m(inputStream))), str);
        } finally {
            if (z7) {
                com.airbnb.lottie.utils.j.c(inputStream);
            }
        }
    }

    public static o<com.airbnb.lottie.f> m(com.airbnb.lottie.parser.moshi.c cVar, @o0 String str) {
        return b(str, new i(cVar, str));
    }

    @h1
    public static n<com.airbnb.lottie.f> n(com.airbnb.lottie.parser.moshi.c cVar, @o0 String str) {
        return o(cVar, str, true);
    }

    private static n<com.airbnb.lottie.f> o(com.airbnb.lottie.parser.moshi.c cVar, @o0 String str, boolean z7) {
        try {
            com.airbnb.lottie.f fVarA = com.airbnb.lottie.parser.t.a(cVar);
            if (str != null) {
                com.airbnb.lottie.model.g.c().d(str, fVarA);
            }
            return new n<>(fVarA);
        } catch (Exception e8) {
            return new n<>((Throwable) e8);
        } finally {
            if (z7) {
                com.airbnb.lottie.utils.j.c(cVar);
            }
        }
    }

    public static o<com.airbnb.lottie.f> p(String str, @o0 String str2) {
        return b(str2, new h(str, str2));
    }

    @h1
    public static n<com.airbnb.lottie.f> q(String str, @o0 String str2) {
        return n(com.airbnb.lottie.parser.moshi.c.g0(a0.d(a0.m(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @h1
    @Deprecated
    public static n<com.airbnb.lottie.f> r(JSONObject jSONObject, @o0 String str) {
        return q(jSONObject.toString(), str);
    }

    public static o<com.airbnb.lottie.f> s(Context context, @s0 int i7) {
        return t(context, i7, E(context, i7));
    }

    public static o<com.airbnb.lottie.f> t(Context context, @s0 int i7, @o0 String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i7));
    }

    @h1
    public static n<com.airbnb.lottie.f> u(Context context, @s0 int i7) {
        return v(context, i7, E(context, i7));
    }

    @h1
    public static n<com.airbnb.lottie.f> v(Context context, @s0 int i7, @o0 String str) {
        try {
            return k(context.getResources().openRawResource(i7), str);
        } catch (Resources.NotFoundException e8) {
            return new n<>((Throwable) e8);
        }
    }

    public static o<com.airbnb.lottie.f> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static o<com.airbnb.lottie.f> x(Context context, String str, @o0 String str2) {
        return b(str2, new c(context, str, str2));
    }

    @h1
    public static n<com.airbnb.lottie.f> y(Context context, String str) {
        return z(context, str, str);
    }

    @h1
    public static n<com.airbnb.lottie.f> z(Context context, String str, @o0 String str2) {
        return com.airbnb.lottie.network.c.e(context, str, str2);
    }
}
