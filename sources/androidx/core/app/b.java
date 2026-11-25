package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.core.content.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static j f5090e;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f5091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f5092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f5093c;

        a(String[] strArr, Activity activity, int i7) {
            this.f5091a = strArr;
            this.f5092b = activity;
            this.f5093c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f5091a.length];
            PackageManager packageManager = this.f5092b.getPackageManager();
            String packageName = this.f5092b.getPackageName();
            int length = this.f5091a.length;
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = packageManager.checkPermission(this.f5091a[i7], packageName);
            }
            ((i) this.f5092b).onRequestPermissionsResult(this.f5093c, this.f5091a, iArr);
        }
    }

    /* JADX INFO: renamed from: androidx.core.app.b$b, reason: collision with other inner class name */
    @c.t0(16)
    static class C0051b {
        private C0051b() {
        }

        @c.t
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        @c.t
        static void b(Activity activity, Intent intent, int i7, Bundle bundle) {
            activity.startActivityForResult(intent, i7, bundle);
        }

        @c.t
        static void c(Activity activity, IntentSender intentSender, int i7, Intent intent, int i8, int i9, int i10, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
        }
    }

    @c.t0(21)
    static class c {
        private c() {
        }

        @c.t
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @c.t
        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @c.t
        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @c.t
        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @c.t
        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    @c.t0(22)
    static class d {
        private d() {
        }

        @c.t
        static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    @c.t0(23)
    static class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @c.t
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @c.t
        static void b(Activity activity, String[] strArr, int i7) {
            activity.requestPermissions(strArr, i7);
        }

        @c.t
        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    @c.t0(28)
    static class f {
        private f() {
        }

        @c.t
        static <T> T a(Activity activity, int i7) {
            return (T) activity.requireViewById(i7);
        }
    }

    @c.t0(30)
    static class g {
        private g() {
        }

        @c.t
        static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        @c.t
        static void b(@c.m0 Activity activity, @c.o0 androidx.core.content.p pVar, @c.o0 Bundle bundle) {
            activity.setLocusContext(pVar == null ? null : pVar.c(), bundle);
        }
    }

    @c.t0(31)
    static class h {
        private h() {
        }

        @c.t
        static boolean a(@c.m0 Activity activity) {
            return activity.isLaunchedFromBubble();
        }
    }

    public interface i {
        void onRequestPermissionsResult(int i7, @c.m0 String[] strArr, @c.m0 int[] iArr);
    }

    public interface j {
        boolean a(@c.m0 Activity activity, @c.e0(from = 0) int i7, int i8, @c.o0 Intent intent);

        boolean b(@c.m0 Activity activity, @c.m0 String[] strArr, @c.e0(from = 0) int i7);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public interface k {
        void validateRequestPermissionsRequestCode(int i7);
    }

    @c.t0(21)
    static class l extends SharedElementCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d7 f5094a;

        l(d7 d7Var) {
            this.f5094a = d7Var;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f5094a.b(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f5094a.c(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f5094a.d(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f5094a.e(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f5094a.f(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f5094a.g(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        @c.t0(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f5094a.h(list, list2, new d7.a() { // from class: androidx.core.app.g
                @Override // androidx.core.app.d7.a
                public final void a() {
                    b.e.a(onSharedElementsReadyListener);
                }
            });
        }
    }

    protected b() {
    }

    @Deprecated
    public static boolean A(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean B(@c.m0 Activity activity) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            return h.a(activity);
        }
        if (i7 == 30) {
            return (g.a(activity) == null || g.a(activity).getDisplayId() == 0) ? false : true;
        }
        if (i7 == 29) {
            return (activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Activity activity) {
        if (activity.isFinishing() || androidx.core.app.l.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void D(@c.m0 Activity activity) {
        c.b(activity);
    }

    public static void E(@c.m0 final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.C(activity);
                }
            });
        }
    }

    @c.o0
    public static androidx.core.view.i0 F(@c.m0 Activity activity, @c.m0 DragEvent dragEvent) {
        return androidx.core.view.i0.b(activity, dragEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void G(@c.m0 Activity activity, @c.m0 String[] strArr, @c.e0(from = 0) int i7) {
        j jVar = f5090e;
        if (jVar == null || !jVar.b(activity, strArr, i7)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (activity instanceof k) {
                ((k) activity).validateRequestPermissionsRequestCode(i7);
            }
            e.b(activity, strArr, i7);
        }
    }

    @c.m0
    public static <T extends View> T H(@c.m0 Activity activity, @c.b0 int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) f.a(activity, i7);
        }
        T t7 = (T) activity.findViewById(i7);
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void I(@c.m0 Activity activity, @c.o0 d7 d7Var) {
        c.c(activity, d7Var != null ? new l(d7Var) : null);
    }

    public static void J(@c.m0 Activity activity, @c.o0 d7 d7Var) {
        c.d(activity, d7Var != null ? new l(d7Var) : null);
    }

    public static void K(@c.m0 Activity activity, @c.o0 androidx.core.content.p pVar, @c.o0 Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            g.b(activity, pVar, bundle);
        }
    }

    public static void L(@c.o0 j jVar) {
        f5090e = jVar;
    }

    public static boolean M(@c.m0 Activity activity, @c.m0 String str) {
        return e.c(activity, str);
    }

    public static void N(@c.m0 Activity activity, @c.m0 Intent intent, int i7, @c.o0 Bundle bundle) {
        C0051b.b(activity, intent, i7, bundle);
    }

    public static void O(@c.m0 Activity activity, @c.m0 IntentSender intentSender, int i7, @c.o0 Intent intent, int i8, int i9, int i10, @c.o0 Bundle bundle) throws IntentSender.SendIntentException {
        C0051b.c(activity, intentSender, i7, intent, i8, i9, i10, bundle);
    }

    public static void P(@c.m0 Activity activity) {
        c.e(activity);
    }

    public static void w(@c.m0 Activity activity) {
        C0051b.a(activity);
    }

    public static void x(@c.m0 Activity activity) {
        c.a(activity);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public static j y() {
        return f5090e;
    }

    @c.o0
    public static Uri z(@c.m0 Activity activity) {
        return d.a(activity);
    }
}
