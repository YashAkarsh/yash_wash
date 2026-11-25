package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import c.b1;
import c.m0;
import c.o0;
import c.r0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7054a = "TextViewCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7055b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7056c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f7057d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7058e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f7059f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f7060g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f7061h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f7062i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Field f7063j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f7064k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f7065l = 1;

    @t0(16)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        @c.t
        static int b(TextView textView) {
            return textView.getMaxLines();
        }

        @c.t
        static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    @t0(17)
    static class b {
        private b() {
        }

        @c.t
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @c.t
        static int b(View view) {
            return view.getLayoutDirection();
        }

        @c.t
        static int c(View view) {
            return view.getTextDirection();
        }

        @c.t
        static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        @c.t
        static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        @c.t
        static void f(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i7, i8, i9, i10);
        }

        @c.t
        static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @c.t
        static void h(View view, int i7) {
            view.setTextDirection(i7);
        }
    }

    @t0(23)
    static class c {
        private c() {
        }

        @c.t
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        @c.t
        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        @c.t
        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        @c.t
        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        @c.t
        static void e(TextView textView, int i7) {
            textView.setBreakStrategy(i7);
        }

        @c.t
        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        @c.t
        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        @c.t
        static void h(TextView textView, int i7) {
            textView.setHyphenationFrequency(i7);
        }
    }

    @t0(24)
    static class d {
        private d() {
        }

        @c.t
        static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    @t0(26)
    static class e {
        private e() {
        }

        @c.t
        static int a(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        @c.t
        static int b(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        @c.t
        static int c(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @c.t
        static int[] d(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        @c.t
        static int e(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        @c.t
        static void f(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        @c.t
        static void g(TextView textView, int[] iArr, int i7) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        @c.t
        static void h(TextView textView, int i7) {
            textView.setAutoSizeTextTypeWithDefaults(i7);
        }
    }

    @t0(28)
    static class f {
        private f() {
        }

        @c.t
        static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        @c.t
        static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        @c.t
        static void c(TextView textView, int i7) {
            textView.setFirstBaselineToTopHeight(i7);
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    @t0(26)
    private static class h implements ActionMode.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f7066g = 100;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionMode.Callback f7067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextView f7068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f7069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Method f7070d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f7071e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f7072f = false;

        h(ActionMode.Callback callback, TextView textView) {
            this.f7067a = callback;
            this.f7068b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        private void g(Menu menu) {
            Context context = this.f7068b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f7072f) {
                this.f7072f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f7069c = cls;
                    this.f7070d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f7071e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f7069c = null;
                    this.f7070d = null;
                    this.f7071e = false;
                }
            }
            try {
                Method declaredMethod = (this.f7071e && this.f7069c.isInstance(menu)) ? this.f7070d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listC = c(context, packageManager);
                for (int i7 = 0; i7 < listC.size(); i7++) {
                    ResolveInfo resolveInfo = listC.get(i7);
                    menu.add(0, 0, i7 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f7068b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @m0
        ActionMode.Callback d() {
            return this.f7067a;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f7067a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f7067a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f7067a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f7067a.onPrepareActionMode(actionMode, menu);
        }
    }

    private u() {
    }

    public static void A(@m0 TextView textView, @c.e0(from = 0) @r0 int i7) {
        androidx.core.util.w.i(i7);
        if (Build.VERSION.SDK_INT >= 28) {
            f.c(textView, i7);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i8 = a.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i7 > Math.abs(i8)) {
            textView.setPadding(textView.getPaddingLeft(), i7 + i8, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void B(@m0 TextView textView, @c.e0(from = 0) @r0 int i7) {
        androidx.core.util.w.i(i7);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i8 = a.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i7 > Math.abs(i8)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i7 - i8);
        }
    }

    public static void C(@m0 TextView textView, @c.e0(from = 0) @r0 int i7) {
        androidx.core.util.w.i(i7);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i7 != fontMetricsInt) {
            textView.setLineSpacing(i7 - fontMetricsInt, 1.0f);
        }
    }

    public static void D(@m0 TextView textView, @m0 androidx.core.text.i0 i0Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(i0Var.f());
        } else {
            if (!o(textView).a(i0Var.e())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(i0Var);
        }
    }

    public static void E(@m0 TextView textView, @b1 int i7) {
        textView.setTextAppearance(i7);
    }

    public static void F(@m0 TextView textView, @m0 androidx.core.text.i0.a aVar) {
        b.h(textView, m(aVar.d()));
        textView.getPaint().set(aVar.e());
        c.e(textView, aVar.b());
        c.h(textView, aVar.c());
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback G(@o0 ActionMode.Callback callback) {
        return (!(callback instanceof h) || Build.VERSION.SDK_INT < 26) ? callback : ((h) callback).d();
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback H(@m0 TextView textView, @o0 ActionMode.Callback callback) {
        int i7 = Build.VERSION.SDK_INT;
        return (i7 < 26 || i7 > 27 || (callback instanceof h) || callback == null) ? callback : new h(callback, textView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.a(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.b(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.c(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m0
    public static int[] d(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.d(textView);
        }
        return textView instanceof androidx.core.widget.b ? ((androidx.core.widget.b) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int e(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.e(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeTextType();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @o0
    public static ColorStateList f(@m0 TextView textView) {
        androidx.core.util.w.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return c.b(textView);
        }
        if (textView instanceof i0) {
            return ((i0) textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @o0
    public static PorterDuff.Mode g(@m0 TextView textView) {
        androidx.core.util.w.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return c.c(textView);
        }
        if (textView instanceof i0) {
            return ((i0) textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    @m0
    public static Drawable[] h(@m0 TextView textView) {
        return b.a(textView);
    }

    public static int i(@m0 TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int j(@m0 TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int k(@m0 TextView textView) {
        return a.b(textView);
    }

    public static int l(@m0 TextView textView) {
        return a.c(textView);
    }

    @t0(18)
    private static int m(@m0 TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    @t0(18)
    private static TextDirectionHeuristic n(@m0 TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(f.a(d.a(b.d(textView)))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z7 = b.b(textView) == 1;
        switch (b.c(textView)) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z7 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    @m0
    public static androidx.core.text.i0.a o(@m0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new androidx.core.text.i0.a(f.b(textView));
        }
        androidx.core.text.i0.a.C0073a c0073a = new androidx.core.text.i0.a.C0073a(new TextPaint(textView.getPaint()));
        c0073a.b(c.a(textView));
        c0073a.c(c.d(textView));
        c0073a.d(n(textView));
        return c0073a.a();
    }

    private static Field p(String str) {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Log.e(f7054a, "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }

    private static int q(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d(f7054a, "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r(@m0 TextView textView, int i7, int i8, int i9, int i10) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            e.f(textView, i7, i8, i9, i10);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void s(@m0 TextView textView, @m0 int[] iArr, int i7) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            e.g(textView, iArr, i7);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void t(@m0 TextView textView, int i7) {
        if (Build.VERSION.SDK_INT >= 27) {
            e.h(textView, i7);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeWithDefaults(i7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u(@m0 TextView textView, @o0 ColorStateList colorStateList) {
        androidx.core.util.w.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.f(textView, colorStateList);
        } else if (textView instanceof i0) {
            ((i0) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v(@m0 TextView textView, @o0 PorterDuff.Mode mode) {
        androidx.core.util.w.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.g(textView, mode);
        } else if (textView instanceof i0) {
            ((i0) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void w(@m0 TextView textView, @o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        b.e(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void x(@m0 TextView textView, @c.u int i7, @c.u int i8, @c.u int i9, @c.u int i10) {
        b.f(textView, i7, i8, i9, i10);
    }

    public static void y(@m0 TextView textView, @o0 Drawable drawable, @o0 Drawable drawable2, @o0 Drawable drawable3, @o0 Drawable drawable4) {
        b.g(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void z(@m0 TextView textView, @m0 ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(H(textView, callback));
    }
}
