package com.google.common.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class j {
    protected j() {
    }

    private void g(Iterator<? extends CharSequence> it, String str) throws IOException {
        com.google.common.base.e0.E(str);
        Writer writerA = a();
        while (it.hasNext()) {
            try {
                writerA.append(it.next()).append((CharSequence) str);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (writerA != null) {
                        try {
                            writerA.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (writerA != null) {
            writerA.close();
        }
    }

    public Writer a() throws IOException {
        Writer writerB = b();
        return writerB instanceof BufferedWriter ? (BufferedWriter) writerB : new BufferedWriter(writerB);
    }

    public abstract Writer b() throws IOException;

    public void c(CharSequence charSequence) throws Throwable {
        com.google.common.base.e0.E(charSequence);
        s sVarB = s.b();
        try {
            Writer writer = (Writer) sVarB.c(b());
            writer.append(charSequence);
            writer.flush();
            sVarB.close();
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @u1.a
    public long d(Readable readable) throws Throwable {
        com.google.common.base.e0.E(readable);
        s sVarB = s.b();
        try {
            Writer writer = (Writer) sVarB.c(b());
            long jB = q.b(readable, writer);
            writer.flush();
            sVarB.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public void e(Iterable<? extends CharSequence> iterable) throws IOException {
        f(iterable, System.getProperty("line.separator"));
    }

    public void f(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        g(iterable.iterator(), str);
    }

    @s1.a
    public void h(Stream<? extends CharSequence> stream) throws IOException {
        i(stream, System.getProperty("line.separator"));
    }

    @s1.a
    public void i(Stream<? extends CharSequence> stream, String str) throws IOException {
        g(stream.iterator(), str);
    }
}
