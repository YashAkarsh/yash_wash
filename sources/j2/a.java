package j2;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<com.google.zxing.a> f34251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<com.google.zxing.a> f34252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<com.google.zxing.a> f34253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<com.google.zxing.a> f34254d;

    static {
        EnumSet enumSetOf = EnumSet.of(com.google.zxing.a.UPC_A, com.google.zxing.a.UPC_E, com.google.zxing.a.EAN_13, com.google.zxing.a.EAN_8, com.google.zxing.a.RSS_14, com.google.zxing.a.RSS_EXPANDED);
        f34251a = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(com.google.zxing.a.CODE_39, com.google.zxing.a.CODE_93, com.google.zxing.a.CODE_128, com.google.zxing.a.ITF, com.google.zxing.a.CODABAR);
        f34252b = enumSetOf2;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf);
        f34253c = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf2);
        f34254d = EnumSet.of(com.google.zxing.a.QR_CODE);
    }

    public static Collection<com.google.zxing.a> a() {
        return f34253c;
    }

    public static Collection<com.google.zxing.a> b() {
        return f34254d;
    }
}
