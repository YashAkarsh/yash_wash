package org.checkerframework.checker.signedness;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.g2;
import okhttp3.internal.ws.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f38597a = false;

    private a() {
        throw new Error("Do not instantiate");
    }

    public static ByteBuffer A(ByteBuffer byteBuffer, int i7, short s7) {
        return byteBuffer.putShort(i7, s7);
    }

    public static ByteBuffer B(ByteBuffer byteBuffer, short s7) {
        return byteBuffer.putShort(s7);
    }

    public static void C(RandomAccessFile randomAccessFile, byte[] bArr) throws IOException {
        randomAccessFile.readFully(bArr);
    }

    public static int D(RandomAccessFile randomAccessFile, byte[] bArr, int i7, int i8) throws IOException {
        return randomAccessFile.read(bArr, i7, i8);
    }

    public static byte E(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.readByte();
    }

    public static char F(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.readChar();
    }

    public static int G(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.readInt();
    }

    public static long H(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.readLong();
    }

    public static short I(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.readShort();
    }

    public static short J(double d8) {
        return (short) d8;
    }

    public static short K(float f8) {
        return (short) f8;
    }

    public static double L(byte b8) {
        return T(X(b8)).doubleValue();
    }

    public static double M(int i7) {
        return T(Z(i7)).doubleValue();
    }

    public static double N(long j7) {
        return T(j7).doubleValue();
    }

    public static double O(short s7) {
        return T(a0(s7)).doubleValue();
    }

    public static float P(byte b8) {
        return T(X(b8)).floatValue();
    }

    public static float Q(int i7) {
        return T(Z(i7)).floatValue();
    }

    public static float R(long j7) {
        return T(j7).floatValue();
    }

    public static float S(short s7) {
        return T(a0(s7)).floatValue();
    }

    private static BigInteger T(long j7) {
        if (j7 >= 0) {
            return BigInteger.valueOf(j7);
        }
        return BigInteger.valueOf(Z((int) (j7 >>> 32))).shiftLeft(32).add(BigInteger.valueOf(Z((int) j7)));
    }

    public static int U(byte b8) {
        return b8 & 255;
    }

    public static int V(char c8) {
        return c8 & 255;
    }

    public static int W(short s7) {
        return s7 & g2.f34732d;
    }

    public static long X(byte b8) {
        return ((long) b8) & 255;
    }

    public static long Y(char c8) {
        return ((long) c8) & 255;
    }

    public static long Z(int i7) {
        return ((long) i7) & 4294967295L;
    }

    public static byte a(double d8) {
        return (byte) d8;
    }

    public static long a0(short s7) {
        return ((long) s7) & g.f38386s;
    }

    public static byte b(float f8) {
        return (byte) f8;
    }

    public static short b0(byte b8) {
        return (short) (b8 & 255);
    }

    public static int c(byte b8, byte b9) {
        return d(U(b8), U(b9));
    }

    public static short c0(char c8) {
        return (short) (c8 & 255);
    }

    public static int d(int i7, int i8) {
        return Integer.compare(i7 - Integer.MIN_VALUE, i8 - Integer.MIN_VALUE);
    }

    public static String d0(byte b8) {
        return Long.toString(X(b8));
    }

    public static int e(long j7, long j8) {
        return Long.compare(j7 - Long.MIN_VALUE, j8 - Long.MIN_VALUE);
    }

    public static String e0(byte b8, int i7) {
        return Long.toString(X(b8), i7);
    }

    public static int f(short s7, short s8) {
        return d(W(s7), W(s8));
    }

    public static String f0(int i7) {
        return Long.toString(Z(i7));
    }

    public static byte g(ByteBuffer byteBuffer) {
        return byteBuffer.get();
    }

    public static String g0(int i7, int i8) {
        return Long.toString(Z(i7), i8);
    }

    public static byte h(ByteBuffer byteBuffer, int i7) {
        return byteBuffer.get(i7);
    }

    public static String h0(long j7) {
        return T(j7).toString();
    }

    public static int i(IntBuffer intBuffer, int i7) {
        return intBuffer.get(i7);
    }

    public static String i0(long j7, int i7) {
        return T(j7).toString(i7);
    }

    public static ByteBuffer j(ByteBuffer byteBuffer, byte[] bArr, int i7, int i8) {
        return byteBuffer.get(bArr, i7, i8);
    }

    public static String j0(short s7) {
        return Long.toString(a0(s7));
    }

    public static void k(ByteBuffer byteBuffer, byte[] bArr) {
        byteBuffer.get(bArr);
    }

    public static String k0(short s7, int i7) {
        return Long.toString(a0(s7), i7);
    }

    public static int l(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    public static ByteBuffer l0(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public static short m(ByteBuffer byteBuffer) {
        return byteBuffer.getShort();
    }

    public static ByteBuffer m0(byte[] bArr, int i7, int i8) {
        return ByteBuffer.wrap(bArr, i7, i8);
    }

    public static int n(double d8) {
        return (int) d8;
    }

    public static void n0(RandomAccessFile randomAccessFile, byte[] bArr, int i7, int i8) throws IOException {
        randomAccessFile.write(bArr, i7, i8);
    }

    public static int o(float f8) {
        return (int) f8;
    }

    public static void o0(RandomAccessFile randomAccessFile, byte b8) throws IOException {
        randomAccessFile.writeByte(U(b8));
    }

    public static long p(double d8) {
        return (long) d8;
    }

    public static void p0(RandomAccessFile randomAccessFile, char c8) throws IOException {
        randomAccessFile.writeChar(V(c8));
    }

    public static long q(float f8) {
        return (long) f8;
    }

    public static void q0(RandomAccessFile randomAccessFile, int i7) throws IOException {
        randomAccessFile.writeInt(i7);
    }

    public static ByteBuffer r(ByteBuffer byteBuffer, byte b8) {
        return byteBuffer.put(b8);
    }

    public static void r0(RandomAccessFile randomAccessFile, long j7) throws IOException {
        randomAccessFile.writeLong(j7);
    }

    public static ByteBuffer s(ByteBuffer byteBuffer, int i7, byte b8) {
        return byteBuffer.put(i7, b8);
    }

    public static void s0(RandomAccessFile randomAccessFile, short s7) throws IOException {
        randomAccessFile.writeShort(W(s7));
    }

    public static IntBuffer t(IntBuffer intBuffer, int i7) {
        return intBuffer.put(i7);
    }

    public static IntBuffer u(IntBuffer intBuffer, int i7, int i8) {
        return intBuffer.put(i7, i8);
    }

    public static IntBuffer v(IntBuffer intBuffer, int[] iArr) {
        return intBuffer.put(iArr);
    }

    public static IntBuffer w(IntBuffer intBuffer, int[] iArr, int i7, int i8) {
        return intBuffer.put(iArr, i7, i8);
    }

    public static ByteBuffer x(ByteBuffer byteBuffer, int i7) {
        return byteBuffer.putInt(i7);
    }

    public static ByteBuffer y(ByteBuffer byteBuffer, int i7, int i8) {
        return byteBuffer.putInt(i7, i8);
    }

    public static ByteBuffer z(ByteBuffer byteBuffer, int i7, long j7) {
        return byteBuffer.putLong(i7, j7);
    }
}
