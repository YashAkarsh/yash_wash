package org.chromium.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.io.File;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38788a = false;

    private static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f38789c = 500;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f38790d = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f38791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38792b;

        a(Activity activity) {
            this.f38791a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f38791a.finishAndRemoveTask();
            this.f38792b++;
            if (this.f38791a.isFinishing()) {
                return;
            }
            if (this.f38792b < 3) {
                ThreadUtils.h(this, f38789c);
            } else {
                this.f38791a.finish();
            }
        }
    }

    private static class b extends LayerDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f38793a;

        b(@c.m0 Drawable[] drawableArr) {
            super(drawableArr);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        @c.m0
        public Drawable mutate() {
            if (this.f38793a) {
                return this;
            }
            Rect[] rectArrU = i.u(this);
            Drawable drawableMutate = super.mutate();
            if (drawableMutate != this) {
                return drawableMutate;
            }
            i.I(this, rectArrU);
            this.f38793a = true;
            return this;
        }
    }

    private static class c extends TransitionDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f38794a;

        c(@c.m0 Drawable[] drawableArr) {
            super(drawableArr);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        @c.m0
        public Drawable mutate() {
            if (this.f38794a) {
                return this;
            }
            Rect[] rectArrU = i.u(this);
            Drawable drawableMutate = super.mutate();
            if (drawableMutate != this) {
                return drawableMutate;
            }
            i.I(this, rectArrU);
            this.f38794a = true;
            return this;
        }
    }

    private i() {
    }

    public static boolean A(Context context) {
        if (Build.VERSION.SDK_INT < 25) {
            return false;
        }
        return ((UserManager) context.getSystemService("user")).isDemoUser();
    }

    public static boolean B() {
        return true;
    }

    public static boolean C(Activity activity) {
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return activity.isInMultiWindowMode();
    }

    public static boolean D(Context context) {
        return ((PowerManager) context.getSystemService("power")).isInteractive();
    }

    private static boolean E(int i7) {
        int i8 = i7 & 4095;
        return i8 == 129 || i8 == 225 || i8 == 18;
    }

    public static boolean F() {
        return true;
    }

    @c.m0
    public static <T> T G(T t7) {
        t7.getClass();
        return t7;
    }

    @c.m0
    public static <T> T H(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(LayerDrawable layerDrawable, Rect[] rectArr) {
        for (int i7 = 0; i7 < layerDrawable.getNumberOfLayers(); i7++) {
            layerDrawable.getDrawable(i7).setBounds(rectArr[i7]);
        }
    }

    public static void J(View view, int i7) {
        view.setAccessibilityTraversalBefore(i7);
    }

    @TargetApi(21)
    public static boolean K(View view, float f8) {
        if (!B()) {
            return false;
        }
        view.setElevation(f8);
        return true;
    }

    @TargetApi(21)
    public static boolean L(PopupWindow popupWindow, float f8) {
        if (!B()) {
            return false;
        }
        popupWindow.setElevation(f8);
        return true;
    }

    public static void M(@c.m0 ImageView imageView, @c.o0 ColorStateList colorStateList) {
        androidx.core.widget.n.c(imageView, colorStateList);
    }

    public static void N(EditText editText) {
        if (Build.VERSION.SDK_INT < 24 && E(editText.getInputType()) && !TextUtils.isEmpty(editText.getHint())) {
            editText.setContentDescription(editText.getHint());
        }
    }

    public static void O(Window window, int i7) {
        if (Build.VERSION.SDK_INT < 26 && i7 == -16777216 && window.getNavigationBarColor() == -16777216) {
            window.clearFlags(Integer.MIN_VALUE);
        } else {
            window.addFlags(Integer.MIN_VALUE);
        }
        window.setStatusBarColor(i7);
    }

    public static void P(View view, boolean z7) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z7 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static void Q(Activity activity, String str, Bitmap bitmap, int i7) {
        activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i7));
    }

    public static void R(TextView textView, int i7) {
        textView.setTextAppearance(i7);
    }

    public static void S(Window window) {
    }

    public static boolean T(ContentResolver contentResolver) {
        return Settings.Secure.getInt(contentResolver, "skip_first_use_hints", 0) != 0;
    }

    public static String U(Spanned spanned, int i7) {
        return Build.VERSION.SDK_INT >= 24 ? Html.toHtml(spanned, i7) : Html.toHtml(spanned);
    }

    public static int c(Context context, String str, int i7, int i8) {
        try {
            return context.checkPermission(str, i7, i8);
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public static int d(boolean z7, boolean z8) {
        if (z7 == z8) {
            return 0;
        }
        return z7 ? 1 : -1;
    }

    public static int e(long j7, long j8) {
        if (j7 < j8) {
            return -1;
        }
        return j7 == j8 ? 0 : 1;
    }

    public static Bundle f(int i7) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        activityOptionsMakeBasic.setLaunchDisplayId(i7);
        return activityOptionsMakeBasic.toBundle();
    }

    public static LayerDrawable g(@c.m0 Drawable[] drawableArr) {
        return new LayerDrawable(drawableArr);
    }

    public static TransitionDrawable h(@c.m0 Drawable[] drawableArr) {
        return new TransitionDrawable(drawableArr);
    }

    @TargetApi(26)
    public static void i(TextView textView) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        textView.setTextClassifier(TextClassifier.NO_OP);
    }

    public static void j(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void k(Activity activity) {
        activity.finishAndRemoveTask();
    }

    public static int l() {
        return 524288;
    }

    public static long m(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    public static long n(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    public static long o(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    public static byte[] p(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalStateException("UTF-8 encoding not available.", e8);
        }
    }

    public static int q(Resources resources, int i7) throws Resources.NotFoundException {
        return resources.getColor(i7, null);
    }

    public static ColorFilter r(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static Drawable s(Resources resources, int i7) throws Resources.NotFoundException {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return resources.getDrawable(i7, null);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static Drawable t(Resources resources, int i7, int i8) {
        return resources.getDrawableForDensity(i7, i8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect[] u(LayerDrawable layerDrawable) {
        Rect[] rectArr = new Rect[layerDrawable.getNumberOfLayers()];
        for (int i7 = 0; i7 < layerDrawable.getNumberOfLayers(); i7++) {
            rectArr[i7] = layerDrawable.getDrawable(i7).getBounds();
        }
        return rectArr;
    }

    public static String v(InputMethodSubtype inputMethodSubtype) {
        return Build.VERSION.SDK_INT >= 24 ? inputMethodSubtype.getLanguageTag() : inputMethodSubtype.getLocale();
    }

    public static Intent w(Context context) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
        }
        return intent;
    }

    public static Uri x(File file) {
        return Build.VERSION.SDK_INT > 23 ? q.g(file) : Uri.fromFile(file);
    }

    public static Drawable y(Context context, Drawable drawable, Rect rect, int i7) {
        return context.getPackageManager().getUserBadgedDrawableForDensity(drawable, Process.myUserHandle(), rect, i7);
    }

    public static Drawable z(Context context, int i7) {
        return context.getPackageManager().getUserBadgedIcon(s(context.getResources(), i7), Process.myUserHandle());
    }
}
