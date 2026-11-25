package paytm.assist.easypay.easypay.appinvoke;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataBinderMapperImpl extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f40104a = new SparseIntArray(0);

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f40105a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f40105a = sparseArray;
            sparseArray.put(0, "_all");
        }

        private a() {
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f40106a = new HashMap<>(0);

        private b() {
        }
    }

    @Override // androidx.databinding.j
    public List<j> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.j
    public String b(int i7) {
        return a.f40105a.get(i7);
    }

    @Override // androidx.databinding.j
    public ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i7) {
        if (f40104a.get(i7) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.j
    public ViewDataBinding d(DataBindingComponent dataBindingComponent, View[] viewArr, int i7) {
        if (viewArr == null || viewArr.length == 0 || f40104a.get(i7) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.j
    public int e(String str) {
        Integer num;
        if (str == null || (num = b.f40106a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
