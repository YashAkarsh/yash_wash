package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class f2 {
    @a7.d
    @c.t0(19)
    public static final Path a(@a7.d Path path, @a7.d Path p7) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Path path2 = new Path();
        path2.op(path, p7, Path.Op.INTERSECT);
        return path2;
    }

    @a7.d
    @c.t0(26)
    public static final Iterable<h2> b(@a7.d Path path, float f8) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        Collection<h2> collectionB = j2.b(path, f8);
        kotlin.jvm.internal.l0.o(collectionB, "flatten(this, error)");
        return collectionB;
    }

    public static /* synthetic */ Iterable c(Path path, float f8, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            f8 = 0.5f;
        }
        return b(path, f8);
    }

    @a7.d
    @c.t0(19)
    public static final Path d(@a7.d Path path, @a7.d Path p7) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Path path2 = new Path(path);
        path2.op(p7, Path.Op.DIFFERENCE);
        return path2;
    }

    @a7.d
    @c.t0(19)
    public static final Path e(@a7.d Path path, @a7.d Path p7) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Path path2 = new Path(path);
        path2.op(p7, Path.Op.UNION);
        return path2;
    }

    @a7.d
    @c.t0(19)
    public static final Path f(@a7.d Path path, @a7.d Path p7) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Path path2 = new Path(path);
        path2.op(p7, Path.Op.UNION);
        return path2;
    }

    @a7.d
    @c.t0(19)
    public static final Path g(@a7.d Path path, @a7.d Path p7) {
        kotlin.jvm.internal.l0.p(path, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Path path2 = new Path(path);
        path2.op(p7, Path.Op.XOR);
        return path2;
    }
}
