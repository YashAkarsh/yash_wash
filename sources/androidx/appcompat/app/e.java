package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q1;
import c.b0;
import c.b1;
import c.h0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f808a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f809b = "AppCompatDelegate";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f810c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f811d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f812e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f813f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f814g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f815h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f816i = -100;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f817j = -100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final androidx.collection.b<WeakReference<e>> f818k = new androidx.collection.b<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f819l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f820m = 108;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f821n = 109;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f822o = 10;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    e() {
    }

    static void G(@m0 e eVar) {
        synchronized (f819l) {
            H(eVar);
        }
    }

    private static void H(@m0 e eVar) {
        synchronized (f819l) {
            Iterator<WeakReference<e>> it = f818k.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void J(boolean z7) {
        q1.c(z7);
    }

    public static void N(int i7) {
        if (i7 != -1 && i7 != 0 && i7 != 1 && i7 != 2 && i7 != 3) {
            Log.d(f809b, "setDefaultNightMode() called with an unknown mode");
        } else if (f817j != i7) {
            f817j = i7;
            f();
        }
    }

    static void c(@m0 e eVar) {
        synchronized (f819l) {
            H(eVar);
            f818k.add(new WeakReference<>(eVar));
        }
    }

    private static void f() {
        synchronized (f819l) {
            Iterator<WeakReference<e>> it = f818k.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                if (eVar != null) {
                    eVar.e();
                }
            }
        }
    }

    @m0
    public static e i(@m0 Activity activity, @o0 d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    @m0
    public static e j(@m0 Dialog dialog, @o0 d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    @m0
    public static e k(@m0 Context context, @m0 Activity activity, @o0 d dVar) {
        return new AppCompatDelegateImpl(context, activity, dVar);
    }

    @m0
    public static e l(@m0 Context context, @m0 Window window, @o0 d dVar) {
        return new AppCompatDelegateImpl(context, window, dVar);
    }

    public static int o() {
        return f817j;
    }

    public static boolean w() {
        return q1.b();
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D(Bundle bundle);

    public abstract void E();

    public abstract void F();

    public abstract boolean I(int i7);

    public abstract void K(@h0 int i7);

    public abstract void L(View view);

    public abstract void M(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void O(boolean z7);

    @t0(17)
    public abstract void P(int i7);

    public abstract void Q(@o0 Toolbar toolbar);

    public void R(@b1 int i7) {
    }

    public abstract void S(@o0 CharSequence charSequence);

    @o0
    public abstract androidx.appcompat.view.b T(@m0 androidx.appcompat.view.b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean e();

    @Deprecated
    public void g(Context context) {
    }

    @c.i
    @m0
    public Context h(@m0 Context context) {
        g(context);
        return context;
    }

    public abstract View m(@o0 View view, String str, @m0 Context context, @m0 AttributeSet attributeSet);

    @o0
    public abstract <T extends View> T n(@b0 int i7);

    @o0
    public abstract androidx.appcompat.app.a.b p();

    public int q() {
        return -100;
    }

    public abstract MenuInflater r();

    @o0
    public abstract ActionBar s();

    public abstract boolean t(int i7);

    public abstract void u();

    public abstract void v();

    public abstract boolean x();

    public abstract void y(Configuration configuration);

    public abstract void z(Bundle bundle);
}
