package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocusId f5638b;

    @t0(29)
    private static class a {
        private a() {
        }

        @m0
        static LocusId a(@m0 String str) {
            o.a();
            return n.a(str);
        }

        @m0
        static String b(@m0 LocusId locusId) {
            return locusId.getId();
        }
    }

    public p(@m0 String str) {
        this.f5637a = (String) androidx.core.util.w.q(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f5638b = a.a(str);
        } else {
            this.f5638b = null;
        }
    }

    @m0
    private String b() {
        return this.f5637a.length() + "_chars";
    }

    @t0(29)
    @m0
    public static p d(@m0 LocusId locusId) {
        androidx.core.util.w.m(locusId, "locusId cannot be null");
        return new p((String) androidx.core.util.w.q(a.b(locusId), "id cannot be empty"));
    }

    @m0
    public String a() {
        return this.f5637a;
    }

    @t0(29)
    @m0
    public LocusId c() {
        return this.f5638b;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.f5637a;
        if (str == null) {
            return pVar.f5637a == null;
        }
        return str.equals(pVar.f5637a);
    }

    public int hashCode() {
        String str = this.f5637a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @m0
    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
