package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.w;
import androidx.recyclerview.widget.RecyclerView;
import c.m0;
import c.r0;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ViewPager2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11225a;

    public e(@r0 int i7) {
        w.j(i7, "Margin must be non-negative");
        this.f11225a = i7;
    }

    private ViewPager2 b(@m0 View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.m
    public void a(@m0 View view, float f8) {
        ViewPager2 viewPager2B = b(view);
        float f9 = this.f11225a * f8;
        if (viewPager2B.getOrientation() != 0) {
            view.setTranslationY(f9);
            return;
        }
        if (viewPager2B.k()) {
            f9 = -f9;
        }
        view.setTranslationX(f9);
    }
}
