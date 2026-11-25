package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5131a = "android.activity.usage_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5132b = "android.usage_time_packages";

    @c.t0(16)
    private static class a extends i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ActivityOptions f5133c;

        a(ActivityOptions activityOptions) {
            this.f5133c = activityOptions;
        }

        @Override // androidx.core.app.i
        public Rect a() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return e.a(this.f5133c);
        }

        @Override // androidx.core.app.i
        public void j(@c.m0 PendingIntent pendingIntent) {
            d.c(this.f5133c, pendingIntent);
        }

        @Override // androidx.core.app.i
        @c.m0
        public i k(@c.o0 Rect rect) {
            return Build.VERSION.SDK_INT < 24 ? this : new a(e.b(this.f5133c, rect));
        }

        @Override // androidx.core.app.i
        public Bundle l() {
            return this.f5133c.toBundle();
        }

        @Override // androidx.core.app.i
        public void m(@c.m0 i iVar) {
            if (iVar instanceof a) {
                this.f5133c.update(((a) iVar).f5133c);
            }
        }
    }

    @c.t0(16)
    static class b {
        private b() {
        }

        @c.t
        static ActivityOptions a(Context context, int i7, int i8) {
            return ActivityOptions.makeCustomAnimation(context, i7, i8);
        }

        @c.t
        static ActivityOptions b(View view, int i7, int i8, int i9, int i10) {
            return ActivityOptions.makeScaleUpAnimation(view, i7, i8, i9, i10);
        }

        @c.t
        static ActivityOptions c(View view, Bitmap bitmap, int i7, int i8) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i7, i8);
        }
    }

    @c.t0(21)
    static class c {
        private c() {
        }

        @c.t
        static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @SafeVarargs
        @c.t
        static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        @c.t
        static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    @c.t0(23)
    static class d {
        private d() {
        }

        @c.t
        static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }

        @c.t
        static ActivityOptions b(View view, int i7, int i8, int i9, int i10) {
            return ActivityOptions.makeClipRevealAnimation(view, i7, i8, i9, i10);
        }

        @c.t
        static void c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    @c.t0(24)
    static class e {
        private e() {
        }

        @c.t
        static Rect a(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        @c.t
        static ActivityOptions b(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    protected i() {
    }

    @c.m0
    public static i b() {
        return new a(d.a());
    }

    @c.m0
    public static i c(@c.m0 View view, int i7, int i8, int i9, int i10) {
        return new a(d.b(view, i7, i8, i9, i10));
    }

    @c.m0
    public static i d(@c.m0 Context context, int i7, int i8) {
        return new a(b.a(context, i7, i8));
    }

    @c.m0
    public static i e(@c.m0 View view, int i7, int i8, int i9, int i10) {
        return new a(b.b(view, i7, i8, i9, i10));
    }

    @c.m0
    public static i f(@c.m0 Activity activity, @c.m0 View view, @c.m0 String str) {
        return new a(c.a(activity, view, str));
    }

    @c.m0
    public static i g(@c.m0 Activity activity, @c.o0 androidx.core.util.s<View, String>... sVarArr) {
        Pair[] pairArr;
        if (sVarArr != null) {
            pairArr = new Pair[sVarArr.length];
            for (int i7 = 0; i7 < sVarArr.length; i7++) {
                androidx.core.util.s<View, String> sVar = sVarArr[i7];
                pairArr[i7] = Pair.create(sVar.f6387a, sVar.f6388b);
            }
        } else {
            pairArr = null;
        }
        return new a(c.b(activity, pairArr));
    }

    @c.m0
    public static i h() {
        return new a(c.c());
    }

    @c.m0
    public static i i(@c.m0 View view, @c.m0 Bitmap bitmap, int i7, int i8) {
        return new a(b.c(view, bitmap, i7, i8));
    }

    @c.o0
    public Rect a() {
        return null;
    }

    public void j(@c.m0 PendingIntent pendingIntent) {
    }

    @c.m0
    public i k(@c.o0 Rect rect) {
        return this;
    }

    @c.o0
    public Bundle l() {
        return null;
    }

    public void m(@c.m0 i iVar) {
    }
}
