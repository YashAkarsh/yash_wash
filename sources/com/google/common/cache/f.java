package com.google.common.cache;

import com.google.common.base.k0;
import com.google.common.collect.d7;
import com.google.common.collect.v7;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public final class f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final k0 f19649o = k0.h(',').q();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final k0 f19650p = k0.h('=').q();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final v7<String, m> f19651q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    Integer f19652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    Long f19653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.d
    Long f19654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s1.d
    Integer f19655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s1.d
    r.t f19656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.d
    r.t f19657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @s1.d
    Boolean f19658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.d
    long f19659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @s1.d
    TimeUnit f19660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.d
    long f19661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.d
    TimeUnit f19662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @s1.d
    long f19663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @s1.d
    TimeUnit f19664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f19665n;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19666a;

        static {
            int[] iArr = new int[r.t.values().length];
            f19666a = iArr;
            try {
                iArr[r.t.f19827c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19666a[r.t.f19826b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class b extends d {
        b() {
        }

        @Override // com.google.common.cache.f.d
        protected void b(f fVar, long j7, TimeUnit timeUnit) {
            com.google.common.base.e0.e(fVar.f19662k == null, "expireAfterAccess already set");
            fVar.f19661j = j7;
            fVar.f19662k = timeUnit;
        }
    }

    static class c extends AbstractC0230f {
        c() {
        }

        @Override // com.google.common.cache.f.AbstractC0230f
        protected void b(f fVar, int i7) {
            Integer num = fVar.f19655d;
            com.google.common.base.e0.u(num == null, "concurrency level was already set to ", num);
            fVar.f19655d = Integer.valueOf(i7);
        }
    }

    static abstract class d implements m {
        d() {
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            TimeUnit timeUnit;
            com.google.common.base.e0.u((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                char cCharAt = str2.charAt(str2.length() - 1);
                if (cCharAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (cCharAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (cCharAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (cCharAt != 's') {
                        throw new IllegalArgumentException(f.d("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", str, str2));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                b(fVar, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(f.d("key %s value set to %s, must be integer", str, str2));
            }
        }

        protected abstract void b(f fVar, long j7, TimeUnit timeUnit);
    }

    static class e extends AbstractC0230f {
        e() {
        }

        @Override // com.google.common.cache.f.AbstractC0230f
        protected void b(f fVar, int i7) {
            Integer num = fVar.f19652a;
            com.google.common.base.e0.u(num == null, "initial capacity was already set to ", num);
            fVar.f19652a = Integer.valueOf(i7);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.f$f, reason: collision with other inner class name */
    static abstract class AbstractC0230f implements m {
        AbstractC0230f() {
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            com.google.common.base.e0.u((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                b(fVar, Integer.parseInt(str2));
            } catch (NumberFormatException e8) {
                throw new IllegalArgumentException(f.d("key %s value set to %s, must be integer", str, str2), e8);
            }
        }

        protected abstract void b(f fVar, int i7);
    }

    static class g implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r.t f19667a;

        public g(r.t tVar) {
            this.f19667a = tVar;
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            com.google.common.base.e0.u(str2 == null, "key %s does not take values", str);
            r.t tVar = fVar.f19656e;
            com.google.common.base.e0.y(tVar == null, "%s was already set to %s", str, tVar);
            fVar.f19656e = this.f19667a;
        }
    }

    static abstract class h implements m {
        h() {
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            com.google.common.base.e0.u((str2 == null || str2.isEmpty()) ? false : true, "value of key %s omitted", str);
            try {
                b(fVar, Long.parseLong(str2));
            } catch (NumberFormatException e8) {
                throw new IllegalArgumentException(f.d("key %s value set to %s, must be integer", str, str2), e8);
            }
        }

        protected abstract void b(f fVar, long j7);
    }

    static class i extends h {
        i() {
        }

        @Override // com.google.common.cache.f.h
        protected void b(f fVar, long j7) {
            Long l7 = fVar.f19653b;
            com.google.common.base.e0.u(l7 == null, "maximum size was already set to ", l7);
            Long l8 = fVar.f19654c;
            com.google.common.base.e0.u(l8 == null, "maximum weight was already set to ", l8);
            fVar.f19653b = Long.valueOf(j7);
        }
    }

    static class j extends h {
        j() {
        }

        @Override // com.google.common.cache.f.h
        protected void b(f fVar, long j7) {
            Long l7 = fVar.f19654c;
            com.google.common.base.e0.u(l7 == null, "maximum weight was already set to ", l7);
            Long l8 = fVar.f19653b;
            com.google.common.base.e0.u(l8 == null, "maximum size was already set to ", l8);
            fVar.f19654c = Long.valueOf(j7);
        }
    }

    static class k implements m {
        k() {
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            com.google.common.base.e0.e(str2 == null, "recordStats does not take values");
            com.google.common.base.e0.e(fVar.f19658g == null, "recordStats already set");
            fVar.f19658g = Boolean.TRUE;
        }
    }

    static class l extends d {
        l() {
        }

        @Override // com.google.common.cache.f.d
        protected void b(f fVar, long j7, TimeUnit timeUnit) {
            com.google.common.base.e0.e(fVar.f19664m == null, "refreshAfterWrite already set");
            fVar.f19663l = j7;
            fVar.f19664m = timeUnit;
        }
    }

    private interface m {
        void a(f fVar, String str, String str2);
    }

    static class n implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r.t f19668a;

        public n(r.t tVar) {
            this.f19668a = tVar;
        }

        @Override // com.google.common.cache.f.m
        public void a(f fVar, String str, String str2) {
            com.google.common.base.e0.u(str2 == null, "key %s does not take values", str);
            r.t tVar = fVar.f19657f;
            com.google.common.base.e0.y(tVar == null, "%s was already set to %s", str, tVar);
            fVar.f19657f = this.f19668a;
        }
    }

    static class o extends d {
        o() {
        }

        @Override // com.google.common.cache.f.d
        protected void b(f fVar, long j7, TimeUnit timeUnit) {
            com.google.common.base.e0.e(fVar.f19660i == null, "expireAfterWrite already set");
            fVar.f19659h = j7;
            fVar.f19660i = timeUnit;
        }
    }

    static {
        v7.b bVarF = v7.b().f("initialCapacity", new e()).f("maximumSize", new i()).f("maximumWeight", new j()).f("concurrencyLevel", new c());
        r.t tVar = r.t.f19827c;
        f19651q = bVarF.f("weakKeys", new g(tVar)).f("softValues", new n(r.t.f19826b)).f("weakValues", new n(tVar)).f("recordStats", new k()).f("expireAfterAccess", new b()).f("expireAfterWrite", new o()).f("refreshAfterWrite", new l()).f("refreshInterval", new l()).a();
    }

    private f(String str) {
        this.f19665n = str;
    }

    public static f b() {
        return e("maximumSize=0");
    }

    private static Long c(long j7, TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f e(String str) {
        f fVar = new f(str);
        if (!str.isEmpty()) {
            for (String str2 : f19649o.n(str)) {
                d7 d7VarP = d7.p(f19650p.n(str2));
                com.google.common.base.e0.e(!d7VarP.isEmpty(), "blank key-value pair");
                com.google.common.base.e0.u(d7VarP.size() <= 2, "key-value pair %s with more than one equals sign", str2);
                String str3 = (String) d7VarP.get(0);
                m mVar = f19651q.get(str3);
                com.google.common.base.e0.u(mVar != null, "unknown key %s", str3);
                mVar.a(fVar, str3, d7VarP.size() == 1 ? null : (String) d7VarP.get(1));
            }
        }
        return fVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return com.google.common.base.y.a(this.f19652a, fVar.f19652a) && com.google.common.base.y.a(this.f19653b, fVar.f19653b) && com.google.common.base.y.a(this.f19654c, fVar.f19654c) && com.google.common.base.y.a(this.f19655d, fVar.f19655d) && com.google.common.base.y.a(this.f19656e, fVar.f19656e) && com.google.common.base.y.a(this.f19657f, fVar.f19657f) && com.google.common.base.y.a(this.f19658g, fVar.f19658g) && com.google.common.base.y.a(c(this.f19659h, this.f19660i), c(fVar.f19659h, fVar.f19660i)) && com.google.common.base.y.a(c(this.f19661j, this.f19662k), c(fVar.f19661j, fVar.f19662k)) && com.google.common.base.y.a(c(this.f19663l, this.f19664m), c(fVar.f19663l, fVar.f19664m));
    }

    com.google.common.cache.e<Object, Object> f() {
        com.google.common.cache.e<Object, Object> eVarF = com.google.common.cache.e.F();
        Integer num = this.f19652a;
        if (num != null) {
            eVarF.z(num.intValue());
        }
        Long l7 = this.f19653b;
        if (l7 != null) {
            eVarF.D(l7.longValue());
        }
        Long l8 = this.f19654c;
        if (l8 != null) {
            eVarF.E(l8.longValue());
        }
        Integer num2 = this.f19655d;
        if (num2 != null) {
            eVarF.e(num2.intValue());
        }
        r.t tVar = this.f19656e;
        if (tVar != null) {
            if (a.f19666a[tVar.ordinal()] != 1) {
                throw new AssertionError();
            }
            eVarF.P();
        }
        r.t tVar2 = this.f19657f;
        if (tVar2 != null) {
            int i7 = a.f19666a[tVar2.ordinal()];
            if (i7 == 1) {
                eVarF.Q();
            } else {
                if (i7 != 2) {
                    throw new AssertionError();
                }
                eVarF.M();
            }
        }
        Boolean bool = this.f19658g;
        if (bool != null && bool.booleanValue()) {
            eVarF.G();
        }
        TimeUnit timeUnit = this.f19660i;
        if (timeUnit != null) {
            eVarF.h(this.f19659h, timeUnit);
        }
        TimeUnit timeUnit2 = this.f19662k;
        if (timeUnit2 != null) {
            eVarF.f(this.f19661j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f19664m;
        if (timeUnit3 != null) {
            eVarF.H(this.f19663l, timeUnit3);
        }
        return eVarF;
    }

    public String g() {
        return this.f19665n;
    }

    public int hashCode() {
        return com.google.common.base.y.b(this.f19652a, this.f19653b, this.f19654c, this.f19655d, this.f19656e, this.f19657f, this.f19658g, c(this.f19659h, this.f19660i), c(this.f19661j, this.f19662k), c(this.f19663l, this.f19664m));
    }

    public String toString() {
        return com.google.common.base.x.c(this).p(g()).toString();
    }
}
