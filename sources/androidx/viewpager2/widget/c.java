package androidx.viewpager2.widget;

import android.view.View;
import c.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements ViewPager2.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.m> f11216a = new ArrayList();

    @Override // androidx.viewpager2.widget.ViewPager2.m
    public void a(@m0 View view, float f8) {
        Iterator<ViewPager2.m> it = this.f11216a.iterator();
        while (it.hasNext()) {
            it.next().a(view, f8);
        }
    }

    public void b(@m0 ViewPager2.m mVar) {
        this.f11216a.add(mVar);
    }

    public void c(@m0 ViewPager2.m mVar) {
        this.f11216a.remove(mVar);
    }
}
