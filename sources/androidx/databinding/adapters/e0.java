package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import c.x0;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f7216a = Pattern.compile("\\s*,\\s*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7217b = 20;

    private static SparseBooleanArray a(CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (charSequence == null) {
            return sparseBooleanArray;
        }
        for (String str : f7216a.split(charSequence)) {
            try {
                int i7 = Integer.parseInt(str);
                if (i7 >= 0) {
                    sparseBooleanArray.put(i7, true);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return sparseBooleanArray;
    }

    @androidx.databinding.d({"android:collapseColumns"})
    public static void b(TableLayout tableLayout, CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArrayA = a(charSequence);
        for (int i7 = 0; i7 < 20; i7++) {
            boolean z7 = sparseBooleanArrayA.get(i7, false);
            if (z7 != tableLayout.isColumnCollapsed(i7)) {
                tableLayout.setColumnCollapsed(i7, z7);
            }
        }
    }

    @androidx.databinding.d({"android:shrinkColumns"})
    public static void c(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setShrinkAllColumns(true);
            return;
        }
        tableLayout.setShrinkAllColumns(false);
        SparseBooleanArray sparseBooleanArrayA = a(charSequence);
        int size = sparseBooleanArrayA.size();
        for (int i7 = 0; i7 < size; i7++) {
            int iKeyAt = sparseBooleanArrayA.keyAt(i7);
            boolean zValueAt = sparseBooleanArrayA.valueAt(i7);
            if (zValueAt) {
                tableLayout.setColumnShrinkable(iKeyAt, zValueAt);
            }
        }
    }

    @androidx.databinding.d({"android:stretchColumns"})
    public static void d(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setStretchAllColumns(true);
            return;
        }
        tableLayout.setStretchAllColumns(false);
        SparseBooleanArray sparseBooleanArrayA = a(charSequence);
        int size = sparseBooleanArrayA.size();
        for (int i7 = 0; i7 < size; i7++) {
            int iKeyAt = sparseBooleanArrayA.keyAt(i7);
            boolean zValueAt = sparseBooleanArrayA.valueAt(i7);
            if (zValueAt) {
                tableLayout.setColumnStretchable(iKeyAt, zValueAt);
            }
        }
    }
}
