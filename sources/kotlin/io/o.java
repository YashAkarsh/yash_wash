package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
class o extends n {

    static final class a extends n0 implements i5.l<String, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f34788a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList<String> arrayList) {
            super(1);
            this.f34788a = arrayList;
        }

        public final void b(@a7.d String it) {
            l0.p(it, "it");
            this.f34788a.add(it);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(String str) {
            b(str);
            return l2.f34958a;
        }
    }

    @kotlin.internal.f
    private static final InputStreamReader A(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader B(File file, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    public static final <T> T C(@a7.d File file, @a7.d Charset charset, @a7.d i5.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        l0.p(block, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            T tZ = block.z(y.h(bufferedReader));
            i0.d(1);
            c.a(bufferedReader, null);
            i0.c(1);
            return tZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i0.d(1);
                c.a(bufferedReader, th);
                i0.c(1);
                throw th2;
            }
        }
    }

    public static /* synthetic */ Object D(File file, Charset charset, i5.l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            Object objZ = lVar.z(y.h(bufferedReader));
            i0.d(1);
            c.a(bufferedReader, null);
            i0.c(1);
            return objZ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                i0.d(1);
                c.a(bufferedReader, th);
                i0.c(1);
                throw th2;
            }
        }
    }

    public static final void E(@a7.d File file, @a7.d byte[] array) {
        l0.p(file, "<this>");
        l0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            l2 l2Var = l2.f34958a;
            c.a(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void F(@a7.d File file, @a7.d String text, @a7.d Charset charset) {
        l0.p(file, "<this>");
        l0.p(text, "text");
        l0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        E(file, bytes);
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        F(file, str, charset);
    }

    @kotlin.internal.f
    private static final OutputStreamWriter H(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    public static final void g(@a7.d File file, @a7.d byte[] array) {
        l0.p(file, "<this>");
        l0.p(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            l2 l2Var = l2.f34958a;
            c.a(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void h(@a7.d File file, @a7.d String text, @a7.d Charset charset) {
        l0.p(file, "<this>");
        l0.p(text, "text");
        l0.p(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        g(file, bytes);
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        h(file, str, charset);
    }

    @kotlin.internal.f
    private static final BufferedReader j(File file, Charset charset, int i7) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i7);
    }

    static /* synthetic */ BufferedReader k(File file, Charset charset, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, i7);
    }

    @kotlin.internal.f
    private static final BufferedWriter l(File file, Charset charset, int i7) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i7);
    }

    static /* synthetic */ BufferedWriter m(File file, Charset charset, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        if ((i8 & 2) != 0) {
            i7 = 8192;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.lang.Object] */
    public static final void n(@a7.d File file, int i7, @a7.d i5.p<? super byte[], ? super Integer, l2> action) {
        l0.p(file, "<this>");
        l0.p(action, "action");
        ?? r7 = new byte[kotlin.ranges.q.n(i7, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i8 = fileInputStream.read(r7);
                if (i8 <= 0) {
                    l2 l2Var = l2.f34958a;
                    c.a(fileInputStream, null);
                    return;
                }
                action.a0(r7, Integer.valueOf(i8));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    c.a(fileInputStream, th);
                    throw th2;
                }
            }
        }
    }

    public static final void o(@a7.d File file, @a7.d i5.p<? super byte[], ? super Integer, l2> action) {
        l0.p(file, "<this>");
        l0.p(action, "action");
        n(file, 4096, action);
    }

    public static final void p(@a7.d File file, @a7.d Charset charset, @a7.d i5.l<? super String, l2> action) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        l0.p(action, "action");
        y.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    public static /* synthetic */ void q(File file, Charset charset, i5.l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        p(file, charset, lVar);
    }

    @kotlin.internal.f
    private static final FileInputStream r(File file) {
        l0.p(file, "<this>");
        return new FileInputStream(file);
    }

    @kotlin.internal.f
    private static final FileOutputStream s(File file) {
        l0.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @kotlin.internal.f
    private static final PrintWriter t(File file, Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    static /* synthetic */ PrintWriter u(File file, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    @a7.d
    public static final byte[] v(@a7.d File file) {
        l0.p(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i7 = (int) length;
            byte[] bArrW0 = new byte[i7];
            int i8 = i7;
            int i9 = 0;
            while (i8 > 0) {
                int i10 = fileInputStream.read(bArrW0, i9, i8);
                if (i10 < 0) {
                    break;
                }
                i8 -= i10;
                i9 += i10;
            }
            if (i8 > 0) {
                bArrW0 = Arrays.copyOf(bArrW0, i9);
                l0.o(bArrW0, "copyOf(this, newSize)");
            } else {
                int i11 = fileInputStream.read();
                if (i11 != -1) {
                    g gVar = new g(8193);
                    gVar.write(i11);
                    b.l(fileInputStream, gVar, 0, 2, null);
                    int size = gVar.size() + i7;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = gVar.b();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrW0, size);
                    l0.o(bArrCopyOf, "copyOf(this, newSize)");
                    bArrW0 = kotlin.collections.o.W0(bArrB, bArrCopyOf, i7, 0, gVar.size());
                }
            }
            c.a(fileInputStream, null);
            return bArrW0;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    @a7.d
    public static final List<String> w(@a7.d File file, @a7.d Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        p(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        return w(file, charset);
    }

    @a7.d
    public static final String y(@a7.d File file, @a7.d Charset charset) {
        l0.p(file, "<this>");
        l0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strK = y.k(inputStreamReader);
            c.a(inputStreamReader, null);
            return strK;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ String z(File file, Charset charset, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            charset = kotlin.text.f.f35353b;
        }
        return y(file, charset);
    }
}
