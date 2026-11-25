package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c.m0;
import c.o0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final TabLayout f18578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final ViewPager2 f18579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f18580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f18581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f18582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private RecyclerView.g<?> f18583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private C0205c f18585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private TabLayout.f f18586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private RecyclerView.i f18587j;

    private class a extends RecyclerView.i {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i7, int i8) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i7, int i8, @o0 Object obj) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i7, int i8) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i7, int i8, int i9) {
            c.this.d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i7, int i8) {
            c.this.d();
        }
    }

    public interface b {
        void a(@m0 TabLayout.i iVar, int i7);
    }

    /* JADX INFO: renamed from: com.google.android.material.tabs.c$c, reason: collision with other inner class name */
    private static class C0205c extends ViewPager2.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final WeakReference<TabLayout> f18589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f18590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f18591c;

        C0205c(TabLayout tabLayout) {
            this.f18589a = new WeakReference<>(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void a(int i7) {
            this.f18590b = this.f18591c;
            this.f18591c = i7;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void b(int i7, float f8, int i8) {
            TabLayout tabLayout = this.f18589a.get();
            if (tabLayout != null) {
                int i9 = this.f18591c;
                tabLayout.setScrollPosition(i7, f8, i9 != 2 || this.f18590b == 1, (i9 == 2 && this.f18590b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.j
        public void c(int i7) {
            TabLayout tabLayout = this.f18589a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i7 || i7 >= tabLayout.getTabCount()) {
                return;
            }
            int i8 = this.f18591c;
            tabLayout.N(tabLayout.z(i7), i8 == 0 || (i8 == 2 && this.f18590b == 0));
        }

        void d() {
            this.f18591c = 0;
            this.f18590b = 0;
        }
    }

    private static class d implements TabLayout.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager2 f18592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f18593b;

        d(ViewPager2 viewPager2, boolean z7) {
            this.f18592a = viewPager2;
            this.f18593b = z7;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@m0 TabLayout.i iVar) {
            this.f18592a.setCurrentItem(iVar.k(), this.f18593b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.i iVar) {
        }
    }

    public c(@m0 TabLayout tabLayout, @m0 ViewPager2 viewPager2, @m0 b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (this.f18584g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.g<?> adapter = this.f18579b.getAdapter();
        this.f18583f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f18584g = true;
        C0205c c0205c = new C0205c(this.f18578a);
        this.f18585h = c0205c;
        this.f18579b.n(c0205c);
        d dVar = new d(this.f18579b, this.f18581d);
        this.f18586i = dVar;
        this.f18578a.d(dVar);
        if (this.f18580c) {
            a aVar = new a();
            this.f18587j = aVar;
            this.f18583f.C(aVar);
        }
        d();
        this.f18578a.setScrollPosition(this.f18579b.getCurrentItem(), 0.0f, true);
    }

    public void b() {
        RecyclerView.g<?> gVar;
        if (this.f18580c && (gVar = this.f18583f) != null) {
            gVar.E(this.f18587j);
            this.f18587j = null;
        }
        this.f18578a.I(this.f18586i);
        this.f18579b.w(this.f18585h);
        this.f18586i = null;
        this.f18585h = null;
        this.f18583f = null;
        this.f18584g = false;
    }

    public boolean c() {
        return this.f18584g;
    }

    void d() {
        this.f18578a.G();
        RecyclerView.g<?> gVar = this.f18583f;
        if (gVar != null) {
            int iE = gVar.e();
            for (int i7 = 0; i7 < iE; i7++) {
                TabLayout.i iVarD = this.f18578a.D();
                this.f18582e.a(iVarD, i7);
                this.f18578a.h(iVarD, false);
            }
            if (iE > 0) {
                int iMin = Math.min(this.f18579b.getCurrentItem(), this.f18578a.getTabCount() - 1);
                if (iMin != this.f18578a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f18578a;
                    tabLayout.M(tabLayout.z(iMin));
                }
            }
        }
    }

    public c(@m0 TabLayout tabLayout, @m0 ViewPager2 viewPager2, boolean z7, @m0 b bVar) {
        this(tabLayout, viewPager2, z7, true, bVar);
    }

    public c(@m0 TabLayout tabLayout, @m0 ViewPager2 viewPager2, boolean z7, boolean z8, @m0 b bVar) {
        this.f18578a = tabLayout;
        this.f18579b = viewPager2;
        this.f18580c = z7;
        this.f18581d = z8;
        this.f18582e = bVar;
    }
}
