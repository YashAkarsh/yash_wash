package androidx.databinding.adapters;

import android.widget.AbsListView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:listSelector", method = "setSelector", type = AbsListView.class), @androidx.databinding.g(attribute = "android:scrollingCache", method = "setScrollingCacheEnabled", type = AbsListView.class), @androidx.databinding.g(attribute = "android:smoothScrollbar", method = "setSmoothScrollbarEnabled", type = AbsListView.class), @androidx.databinding.g(attribute = "android:onMovedToScrapHeap", method = "setRecyclerListener", type = AbsListView.class)})
public class a {

    /* JADX INFO: renamed from: androidx.databinding.adapters.a$a, reason: collision with other inner class name */
    static class C0087a implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f7210b;

        C0087a(c cVar, b bVar) {
            this.f7209a = cVar;
            this.f7210b = bVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
            b bVar = this.f7210b;
            if (bVar != null) {
                bVar.onScroll(absListView, i7, i8, i9);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i7) {
            c cVar = this.f7209a;
            if (cVar != null) {
                cVar.onScrollStateChanged(absListView, i7);
            }
        }
    }

    public interface b {
        void onScroll(AbsListView absListView, int i7, int i8, int i9);
    }

    public interface c {
        void onScrollStateChanged(AbsListView absListView, int i7);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onScroll", "android:onScrollStateChanged"})
    public static void a(AbsListView absListView, b bVar, c cVar) {
        absListView.setOnScrollListener(new C0087a(cVar, bVar));
    }
}
