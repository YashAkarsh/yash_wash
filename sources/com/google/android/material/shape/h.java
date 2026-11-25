package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f18219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f18220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScrollView f18221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f18222d = new int[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f18223e = new int[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f18224f = new a();

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            h.this.e();
        }
    }

    public h(View view, j jVar, ScrollView scrollView) {
        this.f18219a = view;
        this.f18220b = jVar;
        this.f18221c = scrollView;
    }

    public void a(ScrollView scrollView) {
        this.f18221c = scrollView;
    }

    public void b(j jVar) {
        this.f18220b = jVar;
    }

    public void c(@m0 ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f18224f);
    }

    public void d(@m0 ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f18224f);
    }

    public void e() {
        ScrollView scrollView = this.f18221c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() == 0) {
            throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
        this.f18221c.getLocationInWindow(this.f18222d);
        this.f18221c.getChildAt(0).getLocationInWindow(this.f18223e);
        int top = (this.f18219a.getTop() - this.f18222d[1]) + this.f18223e[1];
        int height = this.f18219a.getHeight();
        int height2 = this.f18221c.getHeight();
        if (top < 0) {
            this.f18220b.o0(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
            this.f18219a.invalidate();
            return;
        }
        int i7 = top + height;
        if (i7 > height2) {
            this.f18220b.o0(Math.max(0.0f, Math.min(1.0f, 1.0f - ((i7 - height2) / height))));
            this.f18219a.invalidate();
        } else if (this.f18220b.z() != 1.0f) {
            this.f18220b.o0(1.0f);
            this.f18219a.invalidate();
        }
    }
}
