package androidx.core.view;

/* JADX INFO: loaded from: classes.dex */
public interface t1 {
    boolean dispatchNestedFling(float f8, float f9, boolean z7);

    boolean dispatchNestedPreFling(float f8, float f9);

    boolean dispatchNestedPreScroll(int i7, int i8, @c.o0 int[] iArr, @c.o0 int[] iArr2);

    boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, @c.o0 int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z7);

    boolean startNestedScroll(int i7);

    void stopNestedScroll();
}
