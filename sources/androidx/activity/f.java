package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.r0;
import c.b1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes.dex */
public class f extends Dialog implements q, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private r f575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final OnBackPressedDispatcher f576b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @h5.i
    public f(@a7.d Context context) {
        this(context, 0, 2, null);
        l0.p(context, "context");
    }

    private final r b() {
        r rVar = this.f575a;
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(this);
        this.f575a = rVar2;
        return rVar2;
    }

    private final void c() {
        Window window = getWindow();
        l0.m(window);
        r0.b(window.getDecorView(), this);
        Window window2 = getWindow();
        l0.m(window2);
        View decorView = window2.getDecorView();
        l0.o(decorView, "window!!.decorView");
        i.b(decorView, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(f this$0) {
        l0.p(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(@a7.d View view, @a7.e ViewGroup.LayoutParams layoutParams) {
        l0.p(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.q
    @a7.d
    public final m getLifecycle() {
        return b();
    }

    @Override // androidx.activity.h
    @a7.d
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f576b;
    }

    @Override // android.app.Dialog
    @c.i
    public void onBackPressed() {
        this.f576b.e();
    }

    @Override // android.app.Dialog
    @c.i
    protected void onCreate(@a7.e Bundle bundle) {
        super.onCreate(bundle);
        b().j(m.b.ON_CREATE);
    }

    @Override // android.app.Dialog
    @c.i
    protected void onStart() {
        super.onStart();
        b().j(m.b.ON_RESUME);
    }

    @Override // android.app.Dialog
    @c.i
    protected void onStop() {
        b().j(m.b.ON_DESTROY);
        this.f575a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i7) {
        c();
        super.setContentView(i7);
    }

    public /* synthetic */ f(Context context, int i7, int i8, w wVar) {
        this(context, (i8 & 2) != 0 ? 0 : i7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @h5.i
    public f(@a7.d Context context, @b1 int i7) {
        super(context, i7);
        l0.p(context, "context");
        this.f576b = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d(this.f574a);
            }
        });
    }

    @Override // android.app.Dialog
    public void setContentView(@a7.d View view) {
        l0.p(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(@a7.d View view, @a7.e ViewGroup.LayoutParams layoutParams) {
        l0.p(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
