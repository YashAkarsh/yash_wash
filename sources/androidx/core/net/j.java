package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    @a7.d
    public static final File a(@a7.d Uri uri) {
        l0.p(uri, "<this>");
        if (!l0.g(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    @a7.d
    public static final Uri b(@a7.d File file) {
        l0.p(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        l0.o(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }

    @a7.d
    public static final Uri c(@a7.d String str) {
        l0.p(str, "<this>");
        Uri uri = Uri.parse(str);
        l0.o(uri, "parse(this)");
        return uri;
    }
}
