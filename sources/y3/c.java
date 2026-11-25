package y3;

import android.widget.AbsListView;

/* JADX INFO: loaded from: classes2.dex */
public class c implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.nostra13.universalimageloader.core.d f40616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f40617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f40618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AbsListView.OnScrollListener f40619d;

    public c(com.nostra13.universalimageloader.core.d dVar, boolean z7, boolean z8) {
        this(dVar, z7, z8, null);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        AbsListView.OnScrollListener onScrollListener = this.f40619d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i7, i8, i9);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i7) {
        if (i7 == 0) {
            this.f40616a.K();
        } else if (i7 != 1) {
            if (i7 == 2 && this.f40618c) {
                this.f40616a.J();
            }
        } else if (this.f40617b) {
            this.f40616a.J();
        }
        AbsListView.OnScrollListener onScrollListener = this.f40619d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i7);
        }
    }

    public c(com.nostra13.universalimageloader.core.d dVar, boolean z7, boolean z8, AbsListView.OnScrollListener onScrollListener) {
        this.f40616a = dVar;
        this.f40617b = z7;
        this.f40618c = z8;
        this.f40619d = onScrollListener;
    }
}
