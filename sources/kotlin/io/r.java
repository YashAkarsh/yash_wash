package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final r f34794a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f34795b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CharsetDecoder f34796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f34797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final byte[] f34798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final char[] f34799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private static final ByteBuffer f34800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private static final CharBuffer f34801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    private static final StringBuilder f34802i;

    static {
        byte[] bArr = new byte[32];
        f34798e = bArr;
        char[] cArr = new char[32];
        f34799f = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        l0.o(byteBufferWrap, "wrap(bytes)");
        f34800g = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        l0.o(charBufferWrap, "wrap(chars)");
        f34801h = charBufferWrap;
        f34802i = new StringBuilder();
    }

    private r() {
    }

    private final int a() {
        ByteBuffer byteBuffer = f34800g;
        byteBuffer.compact();
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        return iPosition;
    }

    private final int b(boolean z7) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = f34796c;
            if (charsetDecoder == null) {
                l0.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f34800g;
            CharBuffer charBuffer = f34801h;
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, z7);
            l0.o(coderResultDecode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (coderResultDecode.isError()) {
                e();
                coderResultDecode.throwException();
            }
            int iPosition = charBuffer.position();
            if (!coderResultDecode.isOverflow()) {
                return iPosition;
            }
            StringBuilder sb = f34802i;
            char[] cArr = f34799f;
            int i7 = iPosition - 1;
            sb.append(cArr, 0, i7);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i7]);
        }
    }

    private final int c(int i7, int i8) throws CharacterCodingException {
        ByteBuffer byteBuffer = f34800g;
        byteBuffer.limit(i7);
        f34801h.position(i8);
        int iB = b(true);
        CharsetDecoder charsetDecoder = f34796c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return iB;
    }

    private final void e() {
        CharsetDecoder charsetDecoder = f34796c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f34800g.position(0);
        f34802i.setLength(0);
    }

    private final void f() {
        StringBuilder sb = f34802i;
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void g(Charset charset) {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        l0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        f34796c = charsetDecoderNewDecoder;
        ByteBuffer byteBuffer = f34800g;
        byteBuffer.clear();
        CharBuffer charBuffer = f34801h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f34796c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        boolean z7 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z7 = true;
        }
        f34797d = z7;
        e();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0022 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0012, B:7:0x0018, B:11:0x0028, B:13:0x0034, B:22:0x0047, B:36:0x007c, B:38:0x0084, B:40:0x0088, B:42:0x0090, B:43:0x0092, B:48:0x009e, B:51:0x00a7, B:53:0x00bb, B:54:0x00be, B:23:0x004c, B:26:0x0057, B:30:0x005e, B:32:0x006e, B:34:0x0076, B:57:0x00c3, B:9:0x0022), top: B:62:0x0001 }] */
    @a7.e
    public final synchronized String d(@a7.d InputStream inputStream, @a7.d Charset charset) {
        boolean z7;
        int iC;
        l0.p(inputStream, "inputStream");
        l0.p(charset, "charset");
        CharsetDecoder charsetDecoder = f34796c;
        if (charsetDecoder == null) {
            g(charset);
        } else {
            if (charsetDecoder == null) {
                l0.S("decoder");
                charsetDecoder = null;
            }
            if (!l0.g(charsetDecoder.charset(), charset)) {
                g(charset);
            }
        }
        int iA = 0;
        int iB = 0;
        while (true) {
            int i7 = inputStream.read();
            z7 = true;
            if (i7 == -1) {
                if (!(f34802i.length() == 0) || iA != 0 || iB != 0) {
                    iC = c(iA, iB);
                    break;
                }
                return null;
            }
            int i8 = iA + 1;
            f34798e[iA] = (byte) i7;
            if (i7 == 10 || i8 == 32 || !f34797d) {
                ByteBuffer byteBuffer = f34800g;
                byteBuffer.limit(i8);
                f34801h.position(iB);
                iB = b(false);
                if (iB > 0 && f34799f[iB - 1] == '\n') {
                    byteBuffer.position(0);
                    iC = iB;
                    break;
                }
                iA = a();
            } else {
                iA = i8;
            }
        }
        if (iC > 0) {
            char[] cArr = f34799f;
            if (cArr[iC - 1] == '\n' && (iC = iC - 1) > 0 && cArr[iC - 1] == '\r') {
                iC--;
            }
        }
        StringBuilder sb = f34802i;
        if (sb.length() != 0) {
            z7 = false;
        }
        if (z7) {
            return new String(f34799f, 0, iC);
        }
        sb.append(f34799f, 0, iC);
        String string = sb.toString();
        l0.o(string, "sb.toString()");
        if (sb.length() > 32) {
            f();
        }
        sb.setLength(0);
        return string;
    }
}
