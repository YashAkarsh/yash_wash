package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 {
    static {
        String str = w.h.f3143a;
    }

    public static int a(String str) {
        str.hashCode();
        switch (str) {
            case "transitionFlags":
                return w.h.f3159q;
            case "duration":
                return w.h.f3152j;
            case "motionInterpolator":
                return w.h.f3157o;
            case "autoTransition":
                return w.h.f3156n;
            case "to":
                return w.h.f3154l;
            case "from":
                return w.h.f3153k;
            case "pathMotionArc":
                return 509;
            case "staggered":
                return w.h.f3158p;
            default:
                return -1;
        }
    }

    public static int b(int i7) {
        if (i7 == 509) {
            return 2;
        }
        switch (i7) {
            case w.h.f3152j /* 700 */:
                return 2;
            case w.h.f3153k /* 701 */:
            case w.h.f3154l /* 702 */:
                return 8;
            default:
                switch (i7) {
                    case w.h.f3157o /* 705 */:
                    case w.h.f3159q /* 707 */:
                        return 8;
                    case w.h.f3158p /* 706 */:
                        return 4;
                    default:
                        return -1;
                }
        }
    }
}
