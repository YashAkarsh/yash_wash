package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.u0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    public static final class a extends u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseBooleanArray f6356b;

        a(SparseBooleanArray sparseBooleanArray) {
            this.f6356b = sparseBooleanArray;
        }

        @Override // kotlin.collections.u0
        public int b() {
            SparseBooleanArray sparseBooleanArray = this.f6356b;
            int i7 = this.f6355a;
            this.f6355a = i7 + 1;
            return sparseBooleanArray.keyAt(i7);
        }

        public final int d() {
            return this.f6355a;
        }

        public final void e(int i7) {
            this.f6355a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6355a < this.f6356b.size();
        }
    }

    public static final class b extends kotlin.collections.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SparseBooleanArray f6358b;

        b(SparseBooleanArray sparseBooleanArray) {
            this.f6358b = sparseBooleanArray;
        }

        @Override // kotlin.collections.r
        public boolean b() {
            SparseBooleanArray sparseBooleanArray = this.f6358b;
            int i7 = this.f6357a;
            this.f6357a = i7 + 1;
            return sparseBooleanArray.valueAt(i7);
        }

        public final int d() {
            return this.f6357a;
        }

        public final void e(int i7) {
            this.f6357a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6357a < this.f6358b.size();
        }
    }

    public static final boolean a(@a7.d SparseBooleanArray sparseBooleanArray, int i7) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i7) >= 0;
    }

    public static final boolean b(@a7.d SparseBooleanArray sparseBooleanArray, int i7) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i7) >= 0;
    }

    public static final boolean c(@a7.d SparseBooleanArray sparseBooleanArray, boolean z7) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z7) >= 0;
    }

    public static final void d(@a7.d SparseBooleanArray sparseBooleanArray, @a7.d i5.p<? super Integer, ? super Boolean, l2> action) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(action, "action");
        int size = sparseBooleanArray.size();
        for (int i7 = 0; i7 < size; i7++) {
            action.a0(Integer.valueOf(sparseBooleanArray.keyAt(i7)), Boolean.valueOf(sparseBooleanArray.valueAt(i7)));
        }
    }

    public static final boolean e(@a7.d SparseBooleanArray sparseBooleanArray, int i7, boolean z7) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i7, z7);
    }

    public static final boolean f(@a7.d SparseBooleanArray sparseBooleanArray, int i7, @a7.d i5.a<Boolean> defaultValue) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i7);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int g(@a7.d SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean h(@a7.d SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean i(@a7.d SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    @a7.d
    public static final u0 j(@a7.d SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return new a(sparseBooleanArray);
    }

    @a7.d
    public static final SparseBooleanArray k(@a7.d SparseBooleanArray sparseBooleanArray, @a7.d SparseBooleanArray other) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(other, "other");
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(sparseBooleanArray.size() + other.size());
        l(sparseBooleanArray2, sparseBooleanArray);
        l(sparseBooleanArray2, other);
        return sparseBooleanArray2;
    }

    public static final void l(@a7.d SparseBooleanArray sparseBooleanArray, @a7.d SparseBooleanArray other) {
        l0.p(sparseBooleanArray, "<this>");
        l0.p(other, "other");
        int size = other.size();
        for (int i7 = 0; i7 < size; i7++) {
            sparseBooleanArray.put(other.keyAt(i7), other.valueAt(i7));
        }
    }

    public static final boolean m(@a7.d SparseBooleanArray sparseBooleanArray, int i7, boolean z7) {
        l0.p(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i7);
        if (iIndexOfKey < 0 || z7 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i7);
        return true;
    }

    public static final void n(@a7.d SparseBooleanArray sparseBooleanArray, int i7, boolean z7) {
        l0.p(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i7, z7);
    }

    @a7.d
    public static final kotlin.collections.r o(@a7.d SparseBooleanArray sparseBooleanArray) {
        l0.p(sparseBooleanArray, "<this>");
        return new b(sparseBooleanArray);
    }
}
