package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<E> extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final Activity f8001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Context f8002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final Handler f8003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FragmentManager f8005e;

    public h(@m0 Context context, @m0 Handler handler, int i7) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i7);
    }

    @Override // androidx.fragment.app.e
    @o0
    public View c(int i7) {
        return null;
    }

    @Override // androidx.fragment.app.e
    public boolean d() {
        return true;
    }

    @o0
    Activity e() {
        return this.f8001a;
    }

    @m0
    Context f() {
        return this.f8002b;
    }

    @m0
    Handler g() {
        return this.f8003c;
    }

    public void h(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
    }

    @o0
    public abstract E i();

    @m0
    public LayoutInflater j() {
        return LayoutInflater.from(this.f8002b);
    }

    public int k() {
        return this.f8004d;
    }

    public boolean l() {
        return true;
    }

    @Deprecated
    public void m(@m0 Fragment fragment, @m0 String[] strArr, int i7) {
    }

    public boolean n(@m0 Fragment fragment) {
        return true;
    }

    public boolean o(@m0 String str) {
        return false;
    }

    public void p(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i7) {
        q(fragment, intent, i7, null);
    }

    public void q(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i7, @o0 Bundle bundle) {
        if (i7 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.d.t(this.f8002b, intent, bundle);
    }

    @Deprecated
    public void r(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10, @o0 Bundle bundle) throws IntentSender.SendIntentException {
        if (i7 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.b.O(this.f8001a, intentSender, i7, intent, i8, i9, i10, bundle);
    }

    public void s() {
    }

    h(@m0 FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    h(@o0 Activity activity, @m0 Context context, @m0 Handler handler, int i7) {
        this.f8005e = new k();
        this.f8001a = activity;
        this.f8002b = (Context) androidx.core.util.w.m(context, "context == null");
        this.f8003c = (Handler) androidx.core.util.w.m(handler, "handler == null");
        this.f8004d = i7;
    }
}
