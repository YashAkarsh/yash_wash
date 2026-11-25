package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.SearchView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:onQueryTextFocusChange", method = "setOnQueryTextFocusChangeListener", type = SearchView.class), @androidx.databinding.g(attribute = "android:onSearchClick", method = "setOnSearchClickListener", type = SearchView.class), @androidx.databinding.g(attribute = "android:onClose", method = "setOnCloseListener", type = SearchView.class)})
public class x {

    static class a implements SearchView.OnQueryTextListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f7265b;

        a(d dVar, c cVar) {
            this.f7264a = dVar;
            this.f7265b = cVar;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            c cVar = this.f7265b;
            if (cVar != null) {
                return cVar.onQueryTextChange(str);
            }
            return false;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            d dVar = this.f7264a;
            if (dVar != null) {
                return dVar.onQueryTextSubmit(str);
            }
            return false;
        }
    }

    static class b implements SearchView.OnSuggestionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f7266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f7267b;

        b(f fVar, e eVar) {
            this.f7266a = fVar;
            this.f7267b = eVar;
        }

        @Override // android.widget.SearchView.OnSuggestionListener
        public boolean onSuggestionClick(int i7) {
            e eVar = this.f7267b;
            if (eVar != null) {
                return eVar.onSuggestionClick(i7);
            }
            return false;
        }

        @Override // android.widget.SearchView.OnSuggestionListener
        public boolean onSuggestionSelect(int i7) {
            f fVar = this.f7266a;
            if (fVar != null) {
                return fVar.onSuggestionSelect(i7);
            }
            return false;
        }
    }

    @TargetApi(11)
    public interface c {
        boolean onQueryTextChange(String str);
    }

    @TargetApi(11)
    public interface d {
        boolean onQueryTextSubmit(String str);
    }

    @TargetApi(11)
    public interface e {
        boolean onSuggestionClick(int i7);
    }

    @TargetApi(11)
    public interface f {
        boolean onSuggestionSelect(int i7);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onQueryTextSubmit", "android:onQueryTextChange"})
    public static void a(SearchView searchView, d dVar, c cVar) {
        if (dVar == null && cVar == null) {
            searchView.setOnQueryTextListener(null);
        } else {
            searchView.setOnQueryTextListener(new a(dVar, cVar));
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onSuggestionSelect", "android:onSuggestionClick"})
    public static void b(SearchView searchView, f fVar, e eVar) {
        if (fVar == null && eVar == null) {
            searchView.setOnSuggestionListener(null);
        } else {
            searchView.setOnSuggestionListener(new b(fVar, eVar));
        }
    }
}
