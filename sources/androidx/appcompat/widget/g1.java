package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class g1 extends x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f1844b;

    public g1(@c.m0 Context context, @c.m0 Resources resources) {
        super(resources);
        this.f1844b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.x0, android.content.res.Resources
    public Drawable getDrawable(int i7) throws Resources.NotFoundException {
        Drawable drawableA = a(i7);
        Context context = this.f1844b.get();
        if (drawableA != null && context != null) {
            w0.h().x(context, i7, drawableA);
        }
        return drawableA;
    }
}
