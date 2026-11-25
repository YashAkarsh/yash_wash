package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewStub f7273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewDataBinding f7274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f7275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewStub.OnInflateListener f7276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ViewDataBinding f7277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewStub.OnInflateListener f7278f;

    class a implements ViewStub.OnInflateListener {
        a() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            b0.this.f7275c = view;
            b0 b0Var = b0.this;
            b0Var.f7274b = k.c(b0Var.f7277e.f7188l, view, viewStub.getLayoutResource());
            b0.this.f7273a = null;
            if (b0.this.f7276d != null) {
                b0.this.f7276d.onInflate(viewStub, view);
                b0.this.f7276d = null;
            }
            b0.this.f7277e.m0();
            b0.this.f7277e.E();
        }
    }

    public b0(@m0 ViewStub viewStub) {
        a aVar = new a();
        this.f7278f = aVar;
        this.f7273a = viewStub;
        viewStub.setOnInflateListener(aVar);
    }

    @o0
    public ViewDataBinding g() {
        return this.f7274b;
    }

    public View h() {
        return this.f7275c;
    }

    @o0
    public ViewStub i() {
        return this.f7273a;
    }

    public boolean j() {
        return this.f7275c != null;
    }

    public void k(@m0 ViewDataBinding viewDataBinding) {
        this.f7277e = viewDataBinding;
    }

    public void l(@o0 ViewStub.OnInflateListener onInflateListener) {
        if (this.f7273a != null) {
            this.f7276d = onInflateListener;
        }
    }
}
