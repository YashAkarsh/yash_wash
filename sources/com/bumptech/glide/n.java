package com.bumptech.glide;

import android.widget.AbsListView;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class n<T> implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f14752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c<T> f14753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<T> f14754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14759i;

    class a implements c<T> {
        a() {
        }

        @Override // com.bumptech.glide.n.c
        public List<T> a(int i7) {
            return n.this.d(i7, i7 + 1);
        }

        @Override // com.bumptech.glide.n.c
        public h b(T t7) {
            return n.this.e(t7);
        }
    }

    class b implements d<T> {
        b() {
        }

        @Override // com.bumptech.glide.n.d
        public int[] a(T t7, int i7, int i8) {
            return n.this.c(t7);
        }
    }

    public interface c<U> {
        List<U> a(int i7);

        h b(U u7);
    }

    public interface d<T> {
        int[] a(T t7, int i7, int i8);
    }

    private static class e extends com.bumptech.glide.request.target.b<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14763c;

        private e() {
        }

        @Override // com.bumptech.glide.request.target.m
        public void b(Object obj, com.bumptech.glide.request.animation.e<? super Object> eVar) {
        }

        @Override // com.bumptech.glide.request.target.m
        public void h(com.bumptech.glide.request.target.k kVar) {
            kVar.e(this.f14763c, this.f14762b);
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<e> f14764a;

        public f(int i7) {
            this.f14764a = com.bumptech.glide.util.i.d(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                this.f14764a.offer(new e(null));
            }
        }

        public e a(int i7, int i8) {
            e eVarPoll = this.f14764a.poll();
            this.f14764a.offer(eVarPoll);
            eVarPoll.f14763c = i7;
            eVarPoll.f14762b = i8;
            return eVarPoll;
        }
    }

    @Deprecated
    public n(int i7) {
        this.f14759i = true;
        this.f14753c = new a();
        this.f14754d = new b();
        this.f14751a = i7;
        this.f14752b = new f(i7 + 1);
    }

    private void b() {
        for (int i7 = 0; i7 < this.f14751a; i7++) {
            l.l(this.f14752b.a(0, 0));
        }
    }

    private void f(int i7, int i8) {
        int iMin;
        int iMax;
        if (i7 < i8) {
            iMax = Math.max(this.f14755e, i7);
            iMin = i8;
        } else {
            iMin = Math.min(this.f14756f, i7);
            iMax = i8;
        }
        int iMin2 = Math.min(this.f14758h, iMin);
        int iMin3 = Math.min(this.f14758h, Math.max(0, iMax));
        if (i7 < i8) {
            for (int i9 = iMin3; i9 < iMin2; i9++) {
                h(this.f14753c.a(i9), i9, true);
            }
        } else {
            for (int i10 = iMin2 - 1; i10 >= iMin3; i10--) {
                h(this.f14753c.a(i10), i10, false);
            }
        }
        this.f14756f = iMin3;
        this.f14755e = iMin2;
    }

    private void g(int i7, boolean z7) {
        if (this.f14759i != z7) {
            this.f14759i = z7;
            b();
        }
        f(i7, (z7 ? this.f14751a : -this.f14751a) + i7);
    }

    private void h(List<T> list, int i7, boolean z7) {
        int size = list.size();
        if (z7) {
            for (int i8 = 0; i8 < size; i8++) {
                i(list.get(i8), i7, i8);
            }
            return;
        }
        for (int i9 = size - 1; i9 >= 0; i9--) {
            i(list.get(i9), i7, i9);
        }
    }

    private void i(T t7, int i7, int i8) {
        int[] iArrA = this.f14754d.a(t7, i7, i8);
        if (iArrA != null) {
            this.f14753c.b(t7).F(this.f14752b.a(iArrA[0], iArrA[1]));
        }
    }

    @Deprecated
    protected int[] c(T t7) {
        throw new IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }

    @Deprecated
    protected List<T> d(int i7, int i8) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }

    @Deprecated
    protected h e(T t7) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        this.f14758h = i9;
        int i10 = this.f14757g;
        if (i7 > i10) {
            g(i8 + i7, true);
        } else if (i7 < i10) {
            g(i7, false);
        }
        this.f14757g = i7;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i7) {
    }

    public n(c<T> cVar, d<T> dVar, int i7) {
        this.f14759i = true;
        this.f14753c = cVar;
        this.f14754d = dVar;
        this.f14751a = i7;
        this.f14752b = new f(i7 + 1);
    }
}
