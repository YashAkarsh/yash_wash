package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class r5 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5470g = "name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5471h = "icon";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5472i = "uri";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f5473j = "key";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5474k = "isBot";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f5475l = "isImportant";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    CharSequence f5476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    IconCompat f5477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    String f5478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    String f5479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f5480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5481f;

    @c.t0(22)
    static class a {
        private a() {
        }

        @c.t
        static r5 a(PersistableBundle persistableBundle) {
            return new c().f(persistableBundle.getString("name")).g(persistableBundle.getString("uri")).e(persistableBundle.getString("key")).b(persistableBundle.getBoolean(r5.f5474k)).d(persistableBundle.getBoolean(r5.f5475l)).a();
        }

        @c.t
        static PersistableBundle b(r5 r5Var) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = r5Var.f5476a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString("uri", r5Var.f5478c);
            persistableBundle.putString("key", r5Var.f5479d);
            persistableBundle.putBoolean(r5.f5474k, r5Var.f5480e);
            persistableBundle.putBoolean(r5.f5475l, r5Var.f5481f);
            return persistableBundle;
        }
    }

    @c.t0(28)
    static class b {
        private b() {
        }

        @c.t
        static r5 a(Person person) {
            return new c().f(person.getName()).c(person.getIcon() != null ? IconCompat.m(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        @c.t
        static Person b(r5 r5Var) {
            x5.a();
            return w5.a().setName(r5Var.f()).setIcon(r5Var.d() != null ? r5Var.d().L() : null).setUri(r5Var.g()).setKey(r5Var.e()).setBot(r5Var.h()).setImportant(r5Var.i()).build();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        CharSequence f5482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.o0
        IconCompat f5483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        String f5484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        String f5485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f5486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f5487f;

        public c() {
        }

        @c.m0
        public r5 a() {
            return new r5(this);
        }

        @c.m0
        public c b(boolean z7) {
            this.f5486e = z7;
            return this;
        }

        @c.m0
        public c c(@c.o0 IconCompat iconCompat) {
            this.f5483b = iconCompat;
            return this;
        }

        @c.m0
        public c d(boolean z7) {
            this.f5487f = z7;
            return this;
        }

        @c.m0
        public c e(@c.o0 String str) {
            this.f5485d = str;
            return this;
        }

        @c.m0
        public c f(@c.o0 CharSequence charSequence) {
            this.f5482a = charSequence;
            return this;
        }

        @c.m0
        public c g(@c.o0 String str) {
            this.f5484c = str;
            return this;
        }

        c(r5 r5Var) {
            this.f5482a = r5Var.f5476a;
            this.f5483b = r5Var.f5477b;
            this.f5484c = r5Var.f5478c;
            this.f5485d = r5Var.f5479d;
            this.f5486e = r5Var.f5480e;
            this.f5487f = r5Var.f5481f;
        }
    }

    r5(c cVar) {
        this.f5476a = cVar.f5482a;
        this.f5477b = cVar.f5483b;
        this.f5478c = cVar.f5484c;
        this.f5479d = cVar.f5485d;
        this.f5480e = cVar.f5486e;
        this.f5481f = cVar.f5487f;
    }

    @c.t0(28)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    public static r5 a(@c.m0 Person person) {
        return b.a(person);
    }

    @c.m0
    public static r5 b(@c.m0 Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f5471h);
        return new c().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.k(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean(f5474k)).d(bundle.getBoolean(f5475l)).a();
    }

    @c.t0(22)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    public static r5 c(@c.m0 PersistableBundle persistableBundle) {
        return a.a(persistableBundle);
    }

    @c.o0
    public IconCompat d() {
        return this.f5477b;
    }

    @c.o0
    public String e() {
        return this.f5479d;
    }

    @c.o0
    public CharSequence f() {
        return this.f5476a;
    }

    @c.o0
    public String g() {
        return this.f5478c;
    }

    public boolean h() {
        return this.f5480e;
    }

    public boolean i() {
        return this.f5481f;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    public String j() {
        String str = this.f5478c;
        if (str != null) {
            return str;
        }
        if (this.f5476a == null) {
            return "";
        }
        return "name:" + ((Object) this.f5476a);
    }

    @c.t0(28)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    public Person k() {
        return b.b(this);
    }

    @c.m0
    public c l() {
        return new c(this);
    }

    @c.m0
    public Bundle m() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f5476a);
        IconCompat iconCompat = this.f5477b;
        bundle.putBundle(f5471h, iconCompat != null ? iconCompat.a() : null);
        bundle.putString("uri", this.f5478c);
        bundle.putString("key", this.f5479d);
        bundle.putBoolean(f5474k, this.f5480e);
        bundle.putBoolean(f5475l, this.f5481f);
        return bundle;
    }

    @c.t0(22)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.m0
    public PersistableBundle n() {
        return a.b(this);
    }
}
