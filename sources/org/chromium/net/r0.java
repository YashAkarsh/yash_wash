package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f39497a;

        a(File file) {
            this.f39497a = file;
        }

        @Override // org.chromium.net.r0.d
        public FileChannel a() throws IOException {
            return new FileInputStream(this.f39497a).getChannel();
        }
    }

    class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f39498a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f39498a = parcelFileDescriptor;
        }

        @Override // org.chromium.net.r0.d
        public FileChannel a() throws IOException {
            if (this.f39498a.getStatSize() != -1) {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.f39498a).getChannel();
            }
            this.f39498a.close();
            throw new IllegalArgumentException("Not a file: " + this.f39498a);
        }
    }

    private static final class c extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f39499a;

        /* synthetic */ c(ByteBuffer byteBuffer, a aVar) {
            this(byteBuffer);
        }

        @Override // org.chromium.net.q0
        public long b() {
            return this.f39499a.limit();
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.f39499a.remaining()) {
                byteBuffer.put(this.f39499a);
            } else {
                int iLimit = this.f39499a.limit();
                ByteBuffer byteBuffer2 = this.f39499a;
                byteBuffer2.limit(byteBuffer2.position() + byteBuffer.remaining());
                byteBuffer.put(this.f39499a);
                this.f39499a.limit(iLimit);
            }
            s0Var.b(false);
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) {
            this.f39499a.position(0);
            s0Var.d();
        }

        private c(ByteBuffer byteBuffer) {
            this.f39499a = byteBuffer;
        }
    }

    private interface d {
        FileChannel a() throws IOException;
    }

    private static final class e extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile FileChannel f39500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f39501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f39502c;

        /* synthetic */ e(d dVar, a aVar) {
            this(dVar);
        }

        private FileChannel q() throws IOException {
            if (this.f39500a == null) {
                synchronized (this.f39502c) {
                    if (this.f39500a == null) {
                        this.f39500a = this.f39501b.a();
                    }
                }
            }
            return this.f39500a;
        }

        @Override // org.chromium.net.q0
        public long b() throws IOException {
            return q().size();
        }

        @Override // org.chromium.net.q0
        public void c(s0 s0Var, ByteBuffer byteBuffer) throws IOException {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel fileChannelQ = q();
            int i7 = 0;
            while (i7 == 0) {
                int i8 = fileChannelQ.read(byteBuffer);
                if (i8 == -1) {
                    break;
                } else {
                    i7 += i8;
                }
            }
            s0Var.b(false);
        }

        @Override // org.chromium.net.q0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileChannel fileChannel = this.f39500a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        @Override // org.chromium.net.q0
        public void e(s0 s0Var) throws IOException {
            q().position(0L);
            s0Var.d();
        }

        private e(d dVar) {
            this.f39502c = new Object();
            this.f39501b = dVar;
        }
    }

    private r0() {
    }

    public static q0 a(ParcelFileDescriptor parcelFileDescriptor) {
        return new e(new b(parcelFileDescriptor), null);
    }

    public static q0 b(File file) {
        return new e(new a(file), null);
    }

    public static q0 c(ByteBuffer byteBuffer) {
        return new c(byteBuffer.slice(), null);
    }

    public static q0 d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static q0 e(byte[] bArr, int i7, int i8) {
        return new c(ByteBuffer.wrap(bArr, i7, i8).slice(), null);
    }
}
