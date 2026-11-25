package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final f f34789a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Path f34790b = Paths.get("", new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Path f34791c = Paths.get("..", new String[0]);

    private f() {
    }

    @a7.d
    public final Path a(@a7.d Path path, @a7.d Path base) {
        kotlin.jvm.internal.l0.p(path, "path");
        kotlin.jvm.internal.l0.p(base, "base");
        Path pathNormalize = base.normalize();
        Path r7 = path.normalize();
        Path pathRelativize = pathNormalize.relativize(r7);
        int iMin = Math.min(pathNormalize.getNameCount(), r7.getNameCount());
        int i7 = 0;
        while (i7 < iMin) {
            int i8 = i7 + 1;
            Path name = pathNormalize.getName(i7);
            Path path2 = f34791c;
            if (!kotlin.jvm.internal.l0.g(name, path2)) {
                break;
            }
            if (!kotlin.jvm.internal.l0.g(r7.getName(i7), path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
            i7 = i8;
        }
        if (kotlin.jvm.internal.l0.g(r7, pathNormalize) || !kotlin.jvm.internal.l0.g(pathNormalize, f34790b)) {
            String string = pathRelativize.toString();
            String separator = pathRelativize.getFileSystem().getSeparator();
            kotlin.jvm.internal.l0.o(separator, "rn.fileSystem.separator");
            r7 = kotlin.text.b0.J1(string, separator, false, 2, null) ? pathRelativize.getFileSystem().getPath(kotlin.text.e0.C6(string, pathRelativize.getFileSystem().getSeparator().length()), new String[0]) : pathRelativize;
        }
        kotlin.jvm.internal.l0.o(r7, "r");
        return r7;
    }
}
