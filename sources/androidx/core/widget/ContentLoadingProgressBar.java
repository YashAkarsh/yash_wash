package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import c.f1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f6951g = 500;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f6952h = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f6953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f6957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f6958f;

    public ContentLoadingProgressBar(@m0 Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @f1
    public void f() {
        this.f6956d = true;
        removeCallbacks(this.f6958f);
        this.f6955c = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j7 = this.f6953a;
        long j8 = jCurrentTimeMillis - j7;
        if (j8 >= 500 || j7 == -1) {
            setVisibility(8);
        } else {
            if (this.f6954b) {
                return;
            }
            postDelayed(this.f6957e, 500 - j8);
            this.f6954b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f6954b = false;
        this.f6953a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f6955c = false;
        if (this.f6956d) {
            return;
        }
        this.f6953a = System.currentTimeMillis();
        setVisibility(0);
    }

    private void i() {
        removeCallbacks(this.f6957e);
        removeCallbacks(this.f6958f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @f1
    public void k() {
        this.f6953a = -1L;
        this.f6956d = false;
        removeCallbacks(this.f6957e);
        this.f6954b = false;
        if (this.f6955c) {
            return;
        }
        postDelayed(this.f6958f, 500L);
        this.f6955c = true;
    }

    public void e() {
        post(new Runnable() { // from class: androidx.core.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f7041a.f();
            }
        });
    }

    public void j() {
        post(new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f7031a.k();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public ContentLoadingProgressBar(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6953a = -1L;
        this.f6954b = false;
        this.f6955c = false;
        this.f6956d = false;
        this.f6957e = new Runnable() { // from class: androidx.core.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f7043a.g();
            }
        };
        this.f6958f = new Runnable() { // from class: androidx.core.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f7044a.h();
            }
        };
    }
}
