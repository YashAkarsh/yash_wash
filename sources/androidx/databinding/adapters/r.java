package androidx.databinding.adapters;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> f7249a = new SparseArray<>();

    public static <T> T a(View view, int i7) {
        return (T) view.getTag(i7);
    }

    public static <T> T b(View view, T t7, int i7) {
        T t8 = (T) view.getTag(i7);
        view.setTag(i7, t7);
        return t8;
    }
}
