package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final TransformationMethod f7728a;

    h(@o0 TransformationMethod transformationMethod) {
        this.f7728a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f7728a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@o0 CharSequence charSequence, @m0 View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f7728a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.f.b().f() != 1) ? charSequence : androidx.emoji2.text.f.b().u(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i7, Rect rect) {
        TransformationMethod transformationMethod = this.f7728a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z7, i7, rect);
        }
    }
}
