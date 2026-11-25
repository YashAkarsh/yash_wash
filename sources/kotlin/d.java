package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @g1(version = "1.5")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final char a(int i7) {
        if (i7 >= 0 && i7 <= 65535) {
            return (char) i7;
        }
        throw new IllegalArgumentException("Invalid Char code: " + i7);
    }

    private static final int b(char c8) {
        return c8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    public static /* synthetic */ void c(char c8) {
    }
}
