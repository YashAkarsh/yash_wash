package com.google.common.io;

import com.google.common.collect.d7;
import com.google.common.collect.f7;
import com.google.common.collect.ib;
import com.google.common.collect.ri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class p {

    private final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Charset f21996a;

        a(Charset charset) {
            this.f21996a = (Charset) com.google.common.base.e0.E(charset);
        }

        @Override // com.google.common.io.g
        public p a(Charset charset) {
            return charset.equals(this.f21996a) ? p.this : super.a(charset);
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return new e2(p.this.q(), this.f21996a, 8192);
        }

        public String toString() {
            return p.this.toString() + ".asByteSource(" + this.f21996a + ")";
        }
    }

    private static class b extends p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.google.common.base.k0 f21998b = com.google.common.base.k0.m("\r\n|\n|\r");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final CharSequence f21999a;

        class a extends com.google.common.collect.e<String> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Iterator<String> f22000c;

            a() {
                this.f22000c = b.f21998b.n(b.this.f21999a).iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public String a() {
                if (this.f22000c.hasNext()) {
                    String next = this.f22000c.next();
                    if (this.f22000c.hasNext() || !next.isEmpty()) {
                        return next;
                    }
                }
                return b();
            }
        }

        protected b(CharSequence charSequence) {
            this.f21999a = (CharSequence) com.google.common.base.e0.E(charSequence);
        }

        private Iterator<String> x() {
            return new a();
        }

        @Override // com.google.common.io.p
        public boolean k() {
            return this.f21999a.length() == 0;
        }

        @Override // com.google.common.io.p
        public long m() {
            return this.f21999a.length();
        }

        @Override // com.google.common.io.p
        public com.google.common.base.a0<Long> n() {
            return com.google.common.base.a0.g(Long.valueOf(this.f21999a.length()));
        }

        @Override // com.google.common.io.p
        public Stream<String> o() {
            return ri.F(x());
        }

        @Override // com.google.common.io.p
        public Reader q() {
            return new i(this.f21999a);
        }

        @Override // com.google.common.io.p
        public String r() {
            return this.f21999a.toString();
        }

        @Override // com.google.common.io.p
        public String s() {
            Iterator<String> itX = x();
            if (itX.hasNext()) {
                return itX.next();
            }
            return null;
        }

        @Override // com.google.common.io.p
        public d7<String> t() {
            return d7.t(x());
        }

        public String toString() {
            return "CharSource.wrap(" + com.google.common.base.c.k(this.f21999a, 30, "...") + ")";
        }

        @Override // com.google.common.io.p
        public <T> T u(b0<T> b0Var) throws IOException {
            Iterator<String> itX = x();
            while (itX.hasNext() && b0Var.b(itX.next())) {
            }
            return b0Var.a();
        }
    }

    private static final class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterable<? extends p> f22002a;

        c(Iterable<? extends p> iterable) {
            this.f22002a = (Iterable) com.google.common.base.e0.E(iterable);
        }

        @Override // com.google.common.io.p
        public boolean k() throws IOException {
            Iterator<? extends p> it = this.f22002a.iterator();
            while (it.hasNext()) {
                if (!it.next().k()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.p
        public long m() throws IOException {
            Iterator<? extends p> it = this.f22002a.iterator();
            long jM = 0;
            while (it.hasNext()) {
                jM += it.next().m();
            }
            return jM;
        }

        @Override // com.google.common.io.p
        public com.google.common.base.a0<Long> n() {
            Iterator<? extends p> it = this.f22002a.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                com.google.common.base.a0<Long> a0VarN = it.next().n();
                if (!a0VarN.f()) {
                    return com.google.common.base.a0.a();
                }
                jLongValue += a0VarN.e().longValue();
            }
            return com.google.common.base.a0.g(Long.valueOf(jLongValue));
        }

        @Override // com.google.common.io.p
        public Reader q() throws IOException {
            return new c2(this.f22002a.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.f22002a + ")";
        }
    }

    private static final class d extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final d f22003c = new d();

        private d() {
            super("");
        }

        @Override // com.google.common.io.p.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    private static class e extends b {
        protected e(String str) {
            super(str);
        }

        @Override // com.google.common.io.p
        public long f(j jVar) throws Throwable {
            com.google.common.base.e0.E(jVar);
            s sVarB = s.b();
            try {
                ((Writer) sVarB.c(jVar.b())).write((String) this.f21999a);
                long length = this.f21999a.length();
                sVarB.close();
                return length;
            } catch (Throwable th) {
                try {
                    throw sVarB.e(th);
                } catch (Throwable th2) {
                    sVarB.close();
                    throw th2;
                }
            }
        }

        @Override // com.google.common.io.p
        public long g(Appendable appendable) throws IOException {
            appendable.append(this.f21999a);
            return this.f21999a.length();
        }

        @Override // com.google.common.io.p.b, com.google.common.io.p
        public Reader q() {
            return new StringReader((String) this.f21999a);
        }
    }

    protected p() {
    }

    public static p c(Iterable<? extends p> iterable) {
        return new c(iterable);
    }

    public static p d(Iterator<? extends p> it) {
        return c(d7.t(it));
    }

    public static p e(p... pVarArr) {
        return c(d7.u(pVarArr));
    }

    private long h(Reader reader) throws IOException {
        long j7 = 0;
        while (true) {
            long jSkip = reader.skip(Long.MAX_VALUE);
            if (jSkip == 0) {
                return j7;
            }
            j7 += jSkip;
        }
    }

    public static p i() {
        return d.f22003c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e8) {
            n.a();
            throw m.a(e8);
        }
    }

    public static p v(CharSequence charSequence) {
        return charSequence instanceof String ? new e((String) charSequence) : new b(charSequence);
    }

    @s1.a
    public g b(Charset charset) {
        return new a(charset);
    }

    @u1.a
    public long f(j jVar) throws Throwable {
        com.google.common.base.e0.E(jVar);
        s sVarB = s.b();
        try {
            long jB = q.b((Reader) sVarB.c(q()), (Writer) sVarB.c(jVar.b()));
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

    @u1.a
    public long g(Appendable appendable) throws Throwable {
        com.google.common.base.e0.E(appendable);
        s sVarB = s.b();
        try {
            long jB = q.b((Reader) sVarB.c(q()), appendable);
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

    @s1.a
    public void j(Consumer<? super String> consumer) throws IOException {
        try {
            Stream<String> streamO = o();
            try {
                streamO.forEachOrdered(consumer);
                if (streamO != null) {
                    streamO.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (streamO != null) {
                        try {
                            streamO.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (UncheckedIOException e8) {
            throw e8.getCause();
        }
    }

    public boolean k() throws Throwable {
        com.google.common.base.a0<Long> a0VarN = n();
        if (a0VarN.f()) {
            return a0VarN.e().longValue() == 0;
        }
        s sVarB = s.b();
        try {
            boolean z7 = ((Reader) sVarB.c(q())).read() == -1;
            sVarB.close();
            return z7;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @s1.a
    public long m() throws Throwable {
        com.google.common.base.a0<Long> a0VarN = n();
        if (a0VarN.f()) {
            return a0VarN.e().longValue();
        }
        s sVarB = s.b();
        try {
            long jH = h((Reader) sVarB.c(q()));
            sVarB.close();
            return jH;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @s1.a
    public com.google.common.base.a0<Long> n() {
        return com.google.common.base.a0.a();
    }

    @s1.a
    @u1.l
    public Stream<String> o() throws IOException {
        final BufferedReader bufferedReaderP = p();
        return f7.a(bufferedReaderP.lines().onClose(new Runnable() { // from class: com.google.common.io.o
            @Override // java.lang.Runnable
            public final void run() {
                p.l(bufferedReaderP);
            }
        }));
    }

    public BufferedReader p() throws IOException {
        Reader readerQ = q();
        return readerQ instanceof BufferedReader ? (BufferedReader) readerQ : new BufferedReader(readerQ);
    }

    public abstract Reader q() throws IOException;

    public String r() throws Throwable {
        s sVarB = s.b();
        try {
            String strK = q.k((Reader) sVarB.c(q()));
            sVarB.close();
            return strK;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public String s() throws Throwable {
        s sVarB = s.b();
        try {
            String line = ((BufferedReader) sVarB.c(p())).readLine();
            sVarB.close();
            return line;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public d7<String> t() throws Throwable {
        s sVarB = s.b();
        try {
            BufferedReader bufferedReader = (BufferedReader) sVarB.c(p());
            ArrayList arrayListQ = ib.q();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    d7<String> d7VarR = d7.r(arrayListQ);
                    sVarB.close();
                    return d7VarR;
                }
                arrayListQ.add(line);
            }
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @s1.a
    @u1.a
    public <T> T u(b0<T> b0Var) throws Throwable {
        com.google.common.base.e0.E(b0Var);
        s sVarB = s.b();
        try {
            T t7 = (T) q.h((Reader) sVarB.c(q()), b0Var);
            sVarB.close();
            return t7;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }
}
