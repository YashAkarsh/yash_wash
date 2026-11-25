package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public class j extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final File f34761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final File f34762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private final String f34763c;

    public /* synthetic */ j(File file, File file2, String str, int i7, kotlin.jvm.internal.w wVar) {
        this(file, (i7 & 2) != 0 ? null : file2, (i7 & 4) != 0 ? null : str);
    }

    @a7.d
    public final File a() {
        return this.f34761a;
    }

    @a7.e
    public final File b() {
        return this.f34762b;
    }

    @a7.e
    public final String c() {
        return this.f34763c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@a7.d File file, @a7.e File file2, @a7.e String str) {
        super(f.b(file, file2, str));
        l0.p(file, "file");
        this.f34761a = file;
        this.f34762b = file2;
        this.f34763c = str;
    }
}
