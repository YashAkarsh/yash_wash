package androidx.databinding.adapters;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:selectedItemPosition", type = AdapterView.class), @androidx.databinding.n(attribute = "android:selection", event = "android:selectedItemPositionAttrChanged", method = "getSelectedItemPosition", type = AdapterView.class)})
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:onItemClick", method = "setOnItemClickListener", type = AdapterView.class), @androidx.databinding.g(attribute = "android:onItemLongClick", method = "setOnItemLongClickListener", type = AdapterView.class)})
public class e {

    public interface a {
        void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7);
    }

    public static class b implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f7213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f7214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.databinding.m f7215c;

        public b(a aVar, c cVar, androidx.databinding.m mVar) {
            this.f7213a = aVar;
            this.f7214b = cVar;
            this.f7215c = mVar;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i7, long j7) {
            a aVar = this.f7213a;
            if (aVar != null) {
                aVar.onItemSelected(adapterView, view, i7, j7);
            }
            androidx.databinding.m mVar = this.f7215c;
            if (mVar != null) {
                mVar.a();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            c cVar = this.f7214b;
            if (cVar != null) {
                cVar.onNothingSelected(adapterView);
            }
            androidx.databinding.m mVar = this.f7215c;
            if (mVar != null) {
                mVar.a();
            }
        }
    }

    public interface c {
        void onNothingSelected(AdapterView<?> adapterView);
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onItemSelected", "android:onNothingSelected", "android:selectedItemPositionAttrChanged"})
    public static void a(AdapterView adapterView, a aVar, c cVar, androidx.databinding.m mVar) {
        if (aVar == null && cVar == null && mVar == null) {
            adapterView.setOnItemSelectedListener(null);
        } else {
            adapterView.setOnItemSelectedListener(new b(aVar, cVar, mVar));
        }
    }

    @androidx.databinding.d({"android:selectedItemPosition"})
    public static void b(AdapterView adapterView, int i7) {
        if (adapterView.getSelectedItemPosition() != i7) {
            adapterView.setSelection(i7);
        }
    }

    @androidx.databinding.d({"android:selectedItemPosition", "android:adapter"})
    public static void c(AdapterView adapterView, int i7, Adapter adapter) {
        if (adapter != adapterView.getAdapter()) {
            adapterView.setAdapter(adapter);
            adapterView.setSelection(i7);
        } else if (adapterView.getSelectedItemPosition() != i7) {
            adapterView.setSelection(i7);
        }
    }

    @androidx.databinding.d({"android:selection"})
    public static void d(AdapterView adapterView, int i7) {
        b(adapterView, i7);
    }

    @androidx.databinding.d({"android:selection", "android:adapter"})
    public static void e(AdapterView adapterView, int i7, Adapter adapter) {
        c(adapterView, i7, adapter);
    }
}
