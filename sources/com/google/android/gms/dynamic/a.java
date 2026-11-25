package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.dynamic.e;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class a<T extends e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f16015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private Bundle f16016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<q> f16017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g<T> f16018d = new j(this);

    @c1.a
    public a() {
    }

    @c1.a
    public static void o(@m0 FrameLayout frameLayout) {
        com.google.android.gms.common.g gVarX = com.google.android.gms.common.g.x();
        Context context = frameLayout.getContext();
        int iJ = gVarX.j(context);
        String strD = j0.d(context, iJ);
        String strC = j0.c(context, iJ);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strD);
        linearLayout.addView(textView);
        Intent intentE = gVarX.e(context, iJ, null);
        if (intentE != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strC);
            linearLayout.addView(button);
            button.setOnClickListener(new n(context, intentE));
        }
    }

    private final void t(int i7) {
        while (!this.f16017c.isEmpty() && this.f16017c.getLast().b() >= i7) {
            this.f16017c.removeLast();
        }
    }

    private final void u(@o0 Bundle bundle, q qVar) {
        T t7 = this.f16015a;
        if (t7 != null) {
            qVar.a(t7);
            return;
        }
        if (this.f16017c == null) {
            this.f16017c = new LinkedList<>();
        }
        this.f16017c.add(qVar);
        if (bundle != null) {
            Bundle bundle2 = this.f16016b;
            if (bundle2 == null) {
                this.f16016b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f16018d);
    }

    @c1.a
    protected abstract void a(@m0 g<T> gVar);

    @c1.a
    @m0
    public T b() {
        return this.f16015a;
    }

    @c1.a
    protected void c(@m0 FrameLayout frameLayout) {
        o(frameLayout);
    }

    @c1.a
    public void d(@o0 Bundle bundle) {
        u(bundle, new l(this, bundle));
    }

    @c1.a
    @m0
    public View e(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        u(bundle, new m(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f16015a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    @c1.a
    public void f() {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.k();
        } else {
            t(1);
        }
    }

    @c1.a
    public void g() {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.I();
        } else {
            t(2);
        }
    }

    @c1.a
    public void h(@m0 Activity activity, @m0 Bundle bundle, @o0 Bundle bundle2) {
        u(bundle2, new k(this, activity, bundle, bundle2));
    }

    @c1.a
    public void i() {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.onLowMemory();
        }
    }

    @c1.a
    public void j() {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.j();
        } else {
            t(5);
        }
    }

    @c1.a
    public void k() {
        u(null, new p(this));
    }

    @c1.a
    public void l(@m0 Bundle bundle) {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.n(bundle);
            return;
        }
        Bundle bundle2 = this.f16016b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @c1.a
    public void m() {
        u(null, new o(this));
    }

    @c1.a
    public void n() {
        T t7 = this.f16015a;
        if (t7 != null) {
            t7.g();
        } else {
            t(4);
        }
    }
}
