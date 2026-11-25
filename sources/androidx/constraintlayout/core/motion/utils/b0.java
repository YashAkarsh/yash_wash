package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 {
    static {
        String str = w.g.f3124a;
    }

    public static int a(String str) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                return w.g.f3132i;
            case "percentWidth":
                return w.g.f3134k;
            case "percentHeight":
                return w.g.f3135l;
            case "drawPath":
                return w.g.f3133j;
            case "sizePercent":
                return w.g.f3136m;
            case "percentX":
                return w.g.f3137n;
            case "percentY":
                return w.g.f3138o;
            default:
                return -1;
        }
    }

    public static int b(int i7) {
        if (i7 == 100) {
            return 2;
        }
        if (i7 == 101) {
            return 8;
        }
        switch (i7) {
            case w.g.f3132i /* 501 */:
            case w.g.f3133j /* 502 */:
                return 8;
            case w.g.f3134k /* 503 */:
            case w.g.f3135l /* 504 */:
            case w.g.f3136m /* 505 */:
            case w.g.f3137n /* 506 */:
            case w.g.f3138o /* 507 */:
                return 4;
            case w.g.f3139p /* 508 */:
                return 2;
            default:
                return -1;
        }
    }
}
