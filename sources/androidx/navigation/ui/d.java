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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class d extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<CollapsingToolbarLayout> f8950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<Toolbar> f8951g;

    d(@m0 CollapsingToolbarLayout collapsingToolbarLayout, @m0 Toolbar toolbar, @m0 c cVar) {
        super(collapsingToolbarLayout.getContext(), cVar);
        this.f8950f = new WeakReference<>(collapsingToolbarLayout);
        this.f8951g = new WeakReference<>(toolbar);
    }

    @Override // androidx.navigation.ui.a, androidx.navigation.NavController.b
    public void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f8950f.get();
        Toolbar toolbar = this.f8951g.get();
        if (collapsingToolbarLayout == null || toolbar == null) {
            navController.L(this);
        } else {
            super.a(navController, lVar, bundle);
        }
    }

    @Override // androidx.navigation.ui.a
    protected void c(Drawable drawable, @a1 int i7) {
        Toolbar toolbar = this.f8951g.get();
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
        CollapsingToolbarLayout collapsingToolbarLayout = this.f8950f.get();
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(charSequence);
        }
    }
}
