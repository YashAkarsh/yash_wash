package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.p0;
import c.b0;
import c.h0;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class l extends androidx.activity.f implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p0.a f825d;

    public l(@m0 Context context) {
        this(context, 0);
    }

    private static int g(Context context, int i7) {
        if (i7 != 0) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void addContentView(@m0 View view, ViewGroup.LayoutParams layoutParams) {
        e().d(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().A();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return p0.e(this.f825d, getWindow().getDecorView(), this, keyEvent);
    }

    @m0
    public e e() {
        if (this.f824c == null) {
            this.f824c = e.j(this, this);
        }
        return this.f824c;
    }

    public ActionBar f() {
        return e().s();
    }

    @Override // android.app.Dialog
    @o0
    public <T extends View> T findViewById(@b0 int i7) {
        return (T) e().n(i7);
    }

    boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean i(int i7) {
        return e().I(i7);
    }

    @Override // android.app.Dialog
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        e().v();
    }

    @Override // androidx.appcompat.app.d
    public void l(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void m(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        e().u();
        super.onCreate(bundle);
        e().z(bundle);
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e().F();
    }

    @Override // androidx.appcompat.app.d
    @o0
    public androidx.appcompat.view.b q(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(@h0 int i7) {
        e().K(i7);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().S(charSequence);
    }

    public l(@m0 Context context, int i7) {
        super(context, g(context, i7));
        this.f825d = new p0.a() { // from class: androidx.appcompat.app.k
            @Override // androidx.core.view.p0.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f823a.h(keyEvent);
            }
        };
        e eVarE = e();
        eVarE.R(g(context, i7));
        eVarE.z(null);
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(@m0 View view) {
        e().L(view);
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void setContentView(@m0 View view, ViewGroup.LayoutParams layoutParams) {
        e().M(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i7) {
        super.setTitle(i7);
        e().S(getContext().getString(i7));
    }

    protected l(@m0 Context context, boolean z7, @o0 DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.f825d = new p0.a() { // from class: androidx.appcompat.app.k
            @Override // androidx.core.view.p0.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f823a.h(keyEvent);
            }
        };
        setCancelable(z7);
        setOnCancelListener(onCancelListener);
    }
}
