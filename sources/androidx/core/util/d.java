package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.AtomicFile;
import c.t0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class d {
    @a7.d
    @t0(17)
    public static final byte[] a(@a7.d AtomicFile atomicFile) throws IOException {
        l0.p(atomicFile, "<this>");
        byte[] fully = atomicFile.readFully();
        l0.o(fully, "readFully()");
        return fully;
    }

    @a7.d
    @t0(17)
    public static final String b(@a7.d AtomicFile atomicFile, @a7.d Charset charset) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(charset, "charset");
        byte[] fully = atomicFile.readFully();
        l0.o(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String c(AtomicFile atomicFile, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        return b(atomicFile, charset);
    }

    @t0(17)
    public static final void d(@a7.d AtomicFile atomicFile, @a7.d i5.l<? super FileOutputStream, l2> block) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(block, "block");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            l0.o(stream, "stream");
            block.z(stream);
            i0.d(1);
            atomicFile.finishWrite(stream);
        } finally {
            i0.d(1);
            atomicFile.failWrite(stream);
            i0.c(1);
        }
    }

    @t0(17)
    public static final void e(@a7.d AtomicFile atomicFile, @a7.d byte[] array) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(array, "array");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            l0.o(stream, "stream");
            stream.write(array);
            atomicFile.finishWrite(stream);
        } catch (Throwable th) {
            atomicFile.failWrite(stream);
            throw th;
        }
    }

    @t0(17)
    public static final void f(@a7.d AtomicFile atomicFile, @a7.d String text, @a7.d Charset charset) throws IOException {
        l0.p(atomicFile, "<this>");
        l0.p(text, "text");
        l0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        e(atomicFile, bytes);
    }

    public static /* synthetic */ void g(AtomicFile atomicFile, String str, Charset charset, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        f(atomicFile, str, charset);
    }
}
