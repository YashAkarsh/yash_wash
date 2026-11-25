package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f3288b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, g> f3289a = new HashMap<>();

    public static f c() {
        return f3288b;
    }

    public String a(String str) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    public String b(String str) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    public long d(String str) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            return gVar.h();
        }
        return Long.MAX_VALUE;
    }

    public Set<String> e() {
        return this.f3289a.keySet();
    }

    public void f(String str, g gVar) {
        this.f3289a.put(str, gVar);
    }

    public void g(String str, int i7) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            gVar.c(i7);
        }
    }

    public void h(String str, int i7) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            gVar.d(i7);
        }
    }

    public void i(String str, g gVar) {
        this.f3289a.remove(str);
    }

    public void j(String str, String str2) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            gVar.a(str2);
        }
    }

    public void k(String str, int i7, int i8) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            gVar.f(i7, i8);
        }
    }

    public void l(String str, float f8) {
        g gVar = this.f3289a.get(str);
        if (gVar != null) {
            gVar.e(f8);
        }
    }
}
