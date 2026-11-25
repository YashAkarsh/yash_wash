package androidx.emoji2.text;

import android.content.res.AssetManager;
import c.e0;
import c.m0;
import c.t0;
import c.x0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g2;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
@c.d
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7673a = 1164798569;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7674b = 1701669481;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7675c = 1835365473;

    private static class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final ByteBuffer f7676c;

        a(@m0 ByteBuffer byteBuffer) {
            this.f7676c = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.o.d
        public int a() throws IOException {
            return this.f7676c.getInt();
        }

        @Override // androidx.emoji2.text.o.d
        public void b(int i7) throws IOException {
            ByteBuffer byteBuffer = this.f7676c;
            byteBuffer.position(byteBuffer.position() + i7);
        }

        @Override // androidx.emoji2.text.o.d
        public long c() throws IOException {
            return o.e(this.f7676c.getInt());
        }

        @Override // androidx.emoji2.text.o.d
        public long getPosition() {
            return this.f7676c.position();
        }

        @Override // androidx.emoji2.text.o.d
        public int readUnsignedShort() throws IOException {
            return o.f(this.f7676c.getShort());
        }
    }

    private static class b implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final byte[] f7677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private final ByteBuffer f7678d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @m0
        private final InputStream f7679e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f7680f = 0;

        b(@m0 InputStream inputStream) {
            this.f7679e = inputStream;
            byte[] bArr = new byte[4];
            this.f7677c = bArr;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f7678d = byteBufferWrap;
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        }

        private void d(@e0(from = 0, to = 4) int i7) throws IOException {
            if (this.f7679e.read(this.f7677c, 0, i7) != i7) {
                throw new IOException("read failed");
            }
            this.f7680f += (long) i7;
        }

        @Override // androidx.emoji2.text.o.d
        public int a() throws IOException {
            this.f7678d.position(0);
            d(4);
            return this.f7678d.getInt();
        }

        @Override // androidx.emoji2.text.o.d
        public void b(int i7) throws IOException {
            while (i7 > 0) {
                int iSkip = (int) this.f7679e.skip(i7);
                if (iSkip < 1) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i7 -= iSkip;
                this.f7680f += (long) iSkip;
            }
        }

        @Override // androidx.emoji2.text.o.d
        public long c() throws IOException {
            this.f7678d.position(0);
            d(4);
            return o.e(this.f7678d.getInt());
        }

        @Override // androidx.emoji2.text.o.d
        public long getPosition() {
            return this.f7680f;
        }

        @Override // androidx.emoji2.text.o.d
        public int readUnsignedShort() throws IOException {
            this.f7678d.position(0);
            d(2);
            return o.f(this.f7678d.getShort());
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f7681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f7682b;

        c(long j7, long j8) {
            this.f7681a = j7;
            this.f7682b = j8;
        }

        long a() {
            return this.f7682b;
        }

        long b() {
            return this.f7681a;
        }
    }

    private interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f7683a = 2;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7684b = 4;

        int a() throws IOException;

        void b(int i7) throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private o() {
    }

    private static c a(d dVar) throws IOException {
        long jC;
        dVar.b(4);
        int unsignedShort = dVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        dVar.b(6);
        int i7 = 0;
        while (true) {
            if (i7 >= unsignedShort) {
                jC = -1;
                break;
            }
            int iA = dVar.a();
            dVar.b(4);
            jC = dVar.c();
            dVar.b(4);
            if (f7675c == iA) {
                break;
            }
            i7++;
        }
        if (jC != -1) {
            dVar.b((int) (jC - dVar.getPosition()));
            dVar.b(12);
            long jC2 = dVar.c();
            for (int i8 = 0; i8 < jC2; i8++) {
                int iA2 = dVar.a();
                long jC3 = dVar.c();
                long jC4 = dVar.c();
                if (f7673a == iA2 || f7674b == iA2) {
                    return new c(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static androidx.emoji2.text.flatbuffer.p b(AssetManager assetManager, String str) throws IOException {
        InputStream inputStreamOpen = assetManager.open(str);
        try {
            androidx.emoji2.text.flatbuffer.p pVarC = c(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return pVarC;
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    static androidx.emoji2.text.flatbuffer.p c(InputStream inputStream) throws IOException {
        b bVar = new b(inputStream);
        c cVarA = a(bVar);
        bVar.b((int) (cVarA.b() - bVar.getPosition()));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) cVarA.a());
        int i7 = inputStream.read(byteBufferAllocate.array());
        if (i7 == cVarA.a()) {
            return androidx.emoji2.text.flatbuffer.p.G(byteBufferAllocate);
        }
        throw new IOException("Needed " + cVarA.a() + " bytes, got " + i7);
    }

    static androidx.emoji2.text.flatbuffer.p d(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).b());
        return androidx.emoji2.text.flatbuffer.p.G(byteBufferDuplicate);
    }

    static long e(int i7) {
        return ((long) i7) & 4294967295L;
    }

    static int f(short s7) {
        return s7 & g2.f34732d;
    }
}
