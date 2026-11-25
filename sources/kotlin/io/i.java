package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.collections.g0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final File f34759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final List<File> f34760b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@a7.d File root, @a7.d List<? extends File> segments) {
        l0.p(root, "root");
        l0.p(segments, "segments");
        this.f34759a = root;
        this.f34760b = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i d(i iVar, File file, List list, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            file = iVar.f34759a;
        }
        if ((i7 & 2) != 0) {
            list = iVar.f34760b;
        }
        return iVar.c(file, list);
    }

    @a7.d
    public final File a() {
        return this.f34759a;
    }

    @a7.d
    public final List<File> b() {
        return this.f34760b;
    }

    @a7.d
    public final i c(@a7.d File root, @a7.d List<? extends File> segments) {
        l0.p(root, "root");
        l0.p(segments, "segments");
        return new i(root, segments);
    }

    @a7.d
    public final File e() {
        return this.f34759a;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return l0.g(this.f34759a, iVar.f34759a) && l0.g(this.f34760b, iVar.f34760b);
    }

    @a7.d
    public final String f() {
        String path = this.f34759a.getPath();
        l0.o(path, "root.path");
        return path;
    }

    @a7.d
    public final List<File> g() {
        return this.f34760b;
    }

    public final int h() {
        return this.f34760b.size();
    }

    public int hashCode() {
        return (this.f34759a.hashCode() * 31) + this.f34760b.hashCode();
    }

    public final boolean i() {
        String path = this.f34759a.getPath();
        l0.o(path, "root.path");
        return path.length() > 0;
    }

    @a7.d
    public final File j(int i7, int i8) {
        if (i7 < 0 || i7 > i8 || i8 > h()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.f34760b.subList(i7, i8);
        String separator = File.separator;
        l0.o(separator, "separator");
        return new File(g0.h3(listSubList, separator, null, null, 0, null, null, 62, null));
    }

    @a7.d
    public String toString() {
        return "FilePathComponents(root=" + this.f34759a + ", segments=" + this.f34760b + ')';
    }
}
