package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends j {
    public /* synthetic */ t(File file, File file2, String str, int i7, kotlin.jvm.internal.w wVar) {
        this(file, (i7 & 2) != 0 ? null : file2, (i7 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@a7.d File file, @a7.e File file2, @a7.e String str) {
        super(file, file2, str);
        l0.p(file, "file");
    }
}
