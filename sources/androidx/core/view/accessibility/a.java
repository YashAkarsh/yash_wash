package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public static final String f6423d = "ACCESSIBILITY_CLICKABLE_SPAN_ID";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f6425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6426c;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public a(int i7, @c.m0 l0 l0Var, int i8) {
        this.f6424a = i7;
        this.f6425b = l0Var;
        this.f6426c = i8;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@c.m0 View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(f6423d, this.f6424a);
        this.f6425b.H0(this.f6426c, bundle);
    }
}
