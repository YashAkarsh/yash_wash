package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        l0.o(string, "sb.toString()");
        return string;
    }
}
