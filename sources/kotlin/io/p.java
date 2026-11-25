package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class p extends o {
    @a7.d
    public static final k J(@a7.d File file, @a7.d l direction) {
        l0.p(file, "<this>");
        l0.p(direction, "direction");
        return new k(file, direction);
    }

    public static /* synthetic */ k K(File file, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            lVar = l.TOP_DOWN;
        }
        return J(file, lVar);
    }

    @a7.d
    public static final k L(@a7.d File file) {
        l0.p(file, "<this>");
        return J(file, l.BOTTOM_UP);
    }

    @a7.d
    public static final k M(@a7.d File file) {
        l0.p(file, "<this>");
        return J(file, l.TOP_DOWN);
    }
}
