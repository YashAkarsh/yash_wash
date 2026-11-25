package com.haier.library.okhttp.b.b;

import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.p;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final com.haier.library.okhttp.f f26939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.haier.library.okhttp.a f26940b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f26941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.haier.library.okhttp.f f26942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.haier.library.okhttp.a f26943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f26944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f26945e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f26946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f26947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f26948h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f26949i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f26950j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f26951k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f26952l;

        public a(long j7, com.haier.library.okhttp.f fVar, com.haier.library.okhttp.a aVar) {
            this.f26952l = -1;
            this.f26941a = j7;
            this.f26942b = fVar;
            this.f26943c = aVar;
            if (aVar != null) {
                this.f26949i = aVar.x0();
                this.f26950j = aVar.s0();
                g0 g0VarG = aVar.G();
                int iA = g0VarG.a();
                for (int i7 = 0; i7 < iA; i7++) {
                    String strD = g0VarG.d(i7);
                    String strH = g0VarG.h(i7);
                    if (com.google.common.net.c.f22138d.equalsIgnoreCase(strD)) {
                        this.f26944d = com.haier.library.okhttp.b.e.d.b(strH);
                        this.f26945e = strH;
                    } else if (com.google.common.net.c.f22151j0.equalsIgnoreCase(strD)) {
                        this.f26948h = com.haier.library.okhttp.b.e.d.b(strH);
                    } else if (com.google.common.net.c.f22153k0.equalsIgnoreCase(strD)) {
                        this.f26946f = com.haier.library.okhttp.b.e.d.b(strH);
                        this.f26947g = strH;
                    } else if (com.google.common.net.c.f22149i0.equalsIgnoreCase(strD)) {
                        this.f26951k = strH;
                    } else if (com.google.common.net.c.U.equalsIgnoreCase(strD)) {
                        this.f26952l = com.haier.library.okhttp.b.e.e.n(strH, -1);
                    }
                }
            }
        }

        private static boolean b(com.haier.library.okhttp.f fVar) {
            return (fVar.c(com.google.common.net.c.f22180y) == null && fVar.c(com.google.common.net.c.f22182z) == null) ? false : true;
        }

        private c c() {
            String str;
            if (this.f26943c == null) {
                return new c(this.f26942b, null);
            }
            if (this.f26942b.k() && this.f26943c.C() == null) {
                return new c(this.f26942b, null);
            }
            if (!c.a(this.f26943c, this.f26942b)) {
                return new c(this.f26942b, null);
            }
            p pVarJ = this.f26942b.j();
            if (pVarJ.b() || b(this.f26942b)) {
                return new c(this.f26942b, null);
            }
            p pVarE = this.f26943c.e();
            long jE = e();
            long jD = d();
            if (pVarJ.d() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(pVarJ.d()));
            }
            long millis = 0;
            long millis2 = pVarJ.j() != -1 ? TimeUnit.SECONDS.toMillis(pVarJ.j()) : 0L;
            if (!pVarE.h() && pVarJ.i() != -1) {
                millis = TimeUnit.SECONDS.toMillis(pVarJ.i());
            }
            if (!pVarE.b()) {
                long j7 = millis2 + jE;
                if (j7 < millis + jD) {
                    com.haier.library.okhttp.a.C0352a c0352aL0 = this.f26943c.l0();
                    if (j7 >= jD) {
                        c0352aL0.p(com.google.common.net.c.f22144g, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jE > DateUtils.MILLIS_PER_DAY && f()) {
                        c0352aL0.p(com.google.common.net.c.f22144g, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, c0352aL0.k());
                }
            }
            String str2 = this.f26951k;
            if (str2 != null) {
                str = com.google.common.net.c.f22182z;
            } else {
                if (this.f26946f != null) {
                    str2 = this.f26947g;
                } else {
                    if (this.f26944d == null) {
                        return new c(this.f26942b, null);
                    }
                    str2 = this.f26945e;
                }
                str = com.google.common.net.c.f22180y;
            }
            g0.a aVarM = this.f26942b.f().m();
            n.b.f27684a.k(aVarM, str, str2);
            return new c(this.f26942b.i().d(aVarM.e()).s(), this.f26943c);
        }

        private long d() {
            p pVarE = this.f26943c.e();
            if (pVarE.d() != -1) {
                return TimeUnit.SECONDS.toMillis(pVarE.d());
            }
            if (this.f26948h != null) {
                Date date = this.f26944d;
                long time = this.f26948h.getTime() - (date != null ? date.getTime() : this.f26950j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f26946f == null || this.f26943c.v0().a().M() != null) {
                return 0L;
            }
            Date date2 = this.f26944d;
            long time2 = (date2 != null ? date2.getTime() : this.f26949i) - this.f26946f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private long e() {
            Date date = this.f26944d;
            long jMax = date != null ? Math.max(0L, this.f26950j - date.getTime()) : 0L;
            int i7 = this.f26952l;
            if (i7 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i7));
            }
            long j7 = this.f26950j;
            return jMax + (j7 - this.f26949i) + (this.f26941a - j7);
        }

        private boolean f() {
            return this.f26943c.e().d() == -1 && this.f26948h == null;
        }

        public c a() {
            c cVarC = c();
            return (cVarC.f26939a == null || !this.f26942b.j().k()) ? cVarC : new c(null, null);
        }
    }

    c(com.haier.library.okhttp.f fVar, com.haier.library.okhttp.a aVar) {
        this.f26939a = fVar;
        this.f26940b = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.e().f() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.haier.library.okhttp.a r3, com.haier.library.okhttp.f r4) {
        /*
            int r0 = r3.u()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.E(r0)
            if (r0 != 0) goto L5a
            com.haier.library.okhttp.p r0 = r3.e()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            com.haier.library.okhttp.p r0 = r3.e()
            boolean r0 = r0.g()
            if (r0 != 0) goto L5a
            com.haier.library.okhttp.p r0 = r3.e()
            boolean r0 = r0.f()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.haier.library.okhttp.p r3 = r3.e()
            boolean r3 = r3.c()
            if (r3 != 0) goto L6f
            com.haier.library.okhttp.p r3 = r4.j()
            boolean r3 = r3.c()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.haier.library.okhttp.b.b.c.a(com.haier.library.okhttp.a, com.haier.library.okhttp.f):boolean");
    }
}
