package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.l;
import androidx.transition.z;
import c.a1;
import c.m0;
import c.o0;
import c.x0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class f extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<Toolbar> f8963f;

    f(@m0 Toolbar toolbar, @m0 c cVar) {
        super(toolbar.getContext(), cVar);
        this.f8963f = new WeakReference<>(toolbar);
    }

    @Override // androidx.navigation.ui.a, androidx.navigation.NavController.b
    public void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle) {
        if (this.f8963f.get() == null) {
            navController.L(this);
        } else {
            super.a(navController, lVar, bundle);
        }
    }

    @Override // androidx.navigation.ui.a
    protected void c(Drawable drawable, @a1 int i7) {
        Toolbar toolbar = this.f8963f.get();
        if (toolbar != null) {
            boolean z7 = drawable == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i7);
            if (z7) {
                z.a(toolbar);
            }
        }
    }

    @Override // androidx.navigation.ui.a
    protected void d(CharSequence charSequence) {
        this.f8963f.get().setTitle(charSequence);
    }
}
