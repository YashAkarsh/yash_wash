package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.o0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class f extends ViewPager2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f11226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager2.m f11227b;

    f(LinearLayoutManager linearLayoutManager) {
        this.f11226a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void a(int i7) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void b(int i7, float f8, int i8) {
        if (this.f11227b == null) {
            return;
        }
        float f9 = -f8;
        for (int i9 = 0; i9 < this.f11226a.Q(); i9++) {
            View viewP = this.f11226a.P(i9);
            if (viewP == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i9), Integer.valueOf(this.f11226a.Q())));
            }
            this.f11227b.a(viewP, (this.f11226a.s0(viewP) - i7) + f9);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void c(int i7) {
    }

    ViewPager2.m d() {
        return this.f11227b;
    }

    void e(@o0 ViewPager2.m mVar) {
        this.f11227b = mVar;
    }
}
