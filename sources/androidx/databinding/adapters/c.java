package androidx.databinding.adapters;

import android.R;
import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class c {
    @androidx.databinding.d({"android:entries"})
    public static <T> void a(AbsSpinner absSpinner, List<T> list) {
        if (list == null) {
            absSpinner.setAdapter((SpinnerAdapter) null);
            return;
        }
        SpinnerAdapter adapter = absSpinner.getAdapter();
        if (adapter instanceof t) {
            ((t) adapter).b(list);
        } else {
            absSpinner.setAdapter((SpinnerAdapter) new t(absSpinner.getContext(), list, R.layout.simple_spinner_item, R.layout.simple_spinner_dropdown_item, 0));
        }
    }

    @androidx.databinding.d({"android:entries"})
    public static <T extends CharSequence> void b(AbsSpinner absSpinner, T[] tArr) {
        if (tArr == null) {
            absSpinner.setAdapter((SpinnerAdapter) null);
            return;
        }
        SpinnerAdapter adapter = absSpinner.getAdapter();
        boolean z7 = true;
        if (adapter != null && adapter.getCount() == tArr.length) {
            int i7 = 0;
            while (true) {
                if (i7 >= tArr.length) {
                    z7 = false;
                    break;
                } else if (!tArr[i7].equals(adapter.getItem(i7))) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        if (z7) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(absSpinner.getContext(), R.layout.simple_spinner_item, tArr);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            absSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }
}
