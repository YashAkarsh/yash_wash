package org.checkerframework.checker.nullness;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38596a = false;

    private a() {
        throw new AssertionError("shouldn't be instantiated");
    }

    @g6.b({"#1"})
    public static <T> T a(T t7) {
        return t7;
    }

    private static <T> T[] b(T[] tArr) {
        for (T t7 : tArr) {
            h(t7);
        }
        return tArr;
    }

    @g6.b({"#1"})
    public static <T> T[] c(T[] tArr) {
        return (T[]) b(tArr);
    }

    @g6.b({"#1"})
    public static <T> T[][] d(T[][] tArr) {
        return (T[][]) ((Object[][]) b(tArr));
    }

    @g6.b({"#1"})
    public static <T> T[][][] e(T[][][] tArr) {
        return (T[][][]) ((Object[][][]) b(tArr));
    }

    @g6.b({"#1"})
    public static <T> T[][][][] f(T[][][][] tArr) {
        return (T[][][][]) ((Object[][][][]) b(tArr));
    }

    @g6.b({"#1"})
    public static <T> T[][][][][] g(T[][][][][] tArr) {
        return (T[][][][][]) ((Object[][][][][]) b(tArr));
    }

    private static void h(Object obj) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType == null || componentType.isPrimitive()) {
            return;
        }
        b((Object[]) obj);
    }
}
