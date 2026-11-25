package c0;

import e0.b;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b(ordinal = 1)
    private String f11508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b(ordinal = 2)
    private String f11509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b(ordinal = 3)
    private String f11510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b(ordinal = 4)
    private String f11511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b(ordinal = 5)
    private String f11512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b(ordinal = 6)
    private String f11513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b(ordinal = 7)
    private int f11514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b(ordinal = 8)
    private List<C0139a> f11515h;

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    public static class C0139a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @b(ordinal = 1)
        private String f11516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b(ordinal = 2)
        private String f11517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @b(ordinal = 3)
        private String f11518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @b(ordinal = 4)
        private boolean f11519d;

        public String a() {
            return this.f11518c;
        }

        public String b() {
            return this.f11516a;
        }

        public String c() {
            return this.f11517b;
        }

        public boolean d() {
            return this.f11519d;
        }

        public void e(String str) {
            if (StringUtils.isNotEmpty(str)) {
                this.f11518c = str;
            }
        }

        public void f(String str) {
            this.f11516a = str;
        }

        public void g(boolean z7) {
            this.f11519d = z7;
        }

        public void h(String str) {
            this.f11517b = str;
        }
    }

    public void a(String str) {
        if (StringUtils.isNotEmpty(h())) {
            p(str);
            return;
        }
        p(h() + ", " + str);
    }

    public String b() {
        return this.f11512e;
    }

    public String c() {
        return this.f11510c;
    }

    public String d() {
        return this.f11508a;
    }

    public int e() {
        return this.f11514g;
    }

    public List<C0139a> f() {
        return this.f11515h;
    }

    public String g() {
        return this.f11509b;
    }

    public String h() {
        return this.f11511d;
    }

    public String i() {
        return this.f11513f;
    }

    public void j(String str) {
        this.f11512e = str;
    }

    public void k(String str) {
        if (StringUtils.isNotEmpty(str)) {
            this.f11510c = str;
        }
    }

    public void l(String str) {
        this.f11508a = str;
    }

    public void m(int i7) {
        this.f11514g = i7;
    }

    public void n(List<C0139a> list) {
        this.f11515h = list;
    }

    public void o(String str) {
        this.f11509b = str;
    }

    public void p(String str) {
        this.f11511d = str;
    }

    public void q(String str) {
        this.f11513f = str;
    }
}
