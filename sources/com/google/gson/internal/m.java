package com.google.gson.internal;

import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.p;
import com.google.gson.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private m() {
        throw new UnsupportedOperationException();
    }

    public static com.google.gson.l a(com.google.gson.stream.a aVar) throws p {
        boolean z7;
        try {
            try {
                aVar.J0();
                z7 = false;
                try {
                    return TypeAdapters.X.e(aVar);
                } catch (EOFException e8) {
                    e = e8;
                    if (z7) {
                        return com.google.gson.n.f23245a;
                    }
                    throw new v(e);
                }
            } catch (EOFException e9) {
                e = e9;
                z7 = true;
            }
        } catch (com.google.gson.stream.e e10) {
            throw new v(e10);
        } catch (IOException e11) {
            throw new com.google.gson.m(e11);
        } catch (NumberFormatException e12) {
            throw new v(e12);
        }
    }

    public static void b(com.google.gson.l lVar, com.google.gson.stream.d dVar) throws IOException {
        TypeAdapters.X.i(dVar, lVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    private static final class a extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f23232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C0307a f23233b = new C0307a();

        /* JADX INFO: renamed from: com.google.gson.internal.m$a$a, reason: collision with other inner class name */
        static class C0307a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            char[] f23234a;

            C0307a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i7) {
                return this.f23234a[i7];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f23234a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i7, int i8) {
                return new String(this.f23234a, i7, i8 - i7);
            }
        }

        a(Appendable appendable) {
            this.f23232a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) throws IOException {
            C0307a c0307a = this.f23233b;
            c0307a.f23234a = cArr;
            this.f23232a.append(c0307a, i7, i8 + i7);
        }

        @Override // java.io.Writer
        public void write(int i7) throws IOException {
            this.f23232a.append((char) i7);
        }
    }
}
