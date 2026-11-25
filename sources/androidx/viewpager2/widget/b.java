package androidx.viewpager2.widget;

import c.m0;
import c.r0;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends ViewPager2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final List<ViewPager2.j> f11215a;

    b(int i7) {
        this.f11215a = new ArrayList(i7);
    }

    private void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void a(int i7) {
        try {
            Iterator<ViewPager2.j> it = this.f11215a.iterator();
            while (it.hasNext()) {
                it.next().a(i7);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void b(int i7, float f8, @r0 int i8) {
        try {
            Iterator<ViewPager2.j> it = this.f11215a.iterator();
            while (it.hasNext()) {
                it.next().b(i7, f8, i8);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.j
    public void c(int i7) {
        try {
            Iterator<ViewPager2.j> it = this.f11215a.iterator();
            while (it.hasNext()) {
                it.next().c(i7);
            }
        } catch (ConcurrentModificationException e8) {
            f(e8);
        }
    }

    void d(ViewPager2.j jVar) {
        this.f11215a.add(jVar);
    }

    void e(ViewPager2.j jVar) {
        this.f11215a.remove(jVar);
    }
}
