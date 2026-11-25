package androidx.databinding.adapters;

import android.widget.DatePicker;
import androidx.databinding.library.baseAdapters.R;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:year", type = DatePicker.class), @androidx.databinding.n(attribute = "android:month", type = DatePicker.class), @androidx.databinding.n(attribute = "android:day", method = "getDayOfMonth", type = DatePicker.class)})
@x0({x0.a.LIBRARY})
public class m {

    private static class b implements DatePicker.OnDateChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        DatePicker.OnDateChangedListener f7245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.databinding.m f7246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.databinding.m f7247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.databinding.m f7248d;

        private b() {
        }

        public void a(DatePicker.OnDateChangedListener onDateChangedListener, androidx.databinding.m mVar, androidx.databinding.m mVar2, androidx.databinding.m mVar3) {
            this.f7245a = onDateChangedListener;
            this.f7246b = mVar;
            this.f7247c = mVar2;
            this.f7248d = mVar3;
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public void onDateChanged(DatePicker datePicker, int i7, int i8, int i9) {
            DatePicker.OnDateChangedListener onDateChangedListener = this.f7245a;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(datePicker, i7, i8, i9);
            }
            androidx.databinding.m mVar = this.f7246b;
            if (mVar != null) {
                mVar.a();
            }
            androidx.databinding.m mVar2 = this.f7247c;
            if (mVar2 != null) {
                mVar2.a();
            }
            androidx.databinding.m mVar3 = this.f7248d;
            if (mVar3 != null) {
                mVar3.a();
            }
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:year", "android:month", "android:day", "android:onDateChanged", "android:yearAttrChanged", "android:monthAttrChanged", "android:dayAttrChanged"})
    public static void a(DatePicker datePicker, int i7, int i8, int i9, DatePicker.OnDateChangedListener onDateChangedListener, androidx.databinding.m mVar, androidx.databinding.m mVar2, androidx.databinding.m mVar3) {
        if (i7 == 0) {
            i7 = datePicker.getYear();
        }
        if (i9 == 0) {
            i9 = datePicker.getDayOfMonth();
        }
        if (mVar == null && mVar2 == null && mVar3 == null) {
            datePicker.init(i7, i8, i9, onDateChangedListener);
            return;
        }
        b bVar = (b) r.a(datePicker, R.id.onDateChanged);
        if (bVar == null) {
            bVar = new b();
            r.b(datePicker, bVar, R.id.onDateChanged);
        }
        bVar.a(onDateChangedListener, mVar, mVar2, mVar3);
        datePicker.init(i7, i8, i9, bVar);
    }
}
