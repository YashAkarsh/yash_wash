package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<a> f7505b = ThreadLocal.withInitial(new Supplier() { // from class: androidx.emoji2.text.flatbuffer.z
        @Override // java.util.function.Supplier
        public final Object get() {
            return a0.g();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f7508c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ByteBuffer f7509d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharsetEncoder f7506a = StandardCharsets.UTF_8.newEncoder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharsetDecoder f7507b = StandardCharsets.UTF_8.newDecoder();

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a g() {
        return new a();
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public String a(ByteBuffer byteBuffer, int i7, int i8) {
        CharsetDecoder charsetDecoder = f7505b.get().f7507b;
        charsetDecoder.reset();
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i7);
        byteBufferDuplicate.limit(i7 + i8);
        try {
            return charsetDecoder.decode(byteBufferDuplicate).toString();
        } catch (CharacterCodingException e8) {
            throw new IllegalArgumentException("Bad encoding", e8);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        a aVar = f7505b.get();
        if (aVar.f7508c != charSequence) {
            c(charSequence);
        }
        byteBuffer.put(aVar.f7509d);
    }

    @Override // androidx.emoji2.text.flatbuffer.x
    public int c(CharSequence charSequence) {
        a aVar = f7505b.get();
        int length = (int) (charSequence.length() * aVar.f7506a.maxBytesPerChar());
        ByteBuffer byteBuffer = aVar.f7509d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            aVar.f7509d = ByteBuffer.allocate(Math.max(128, length));
        }
        aVar.f7509d.clear();
        aVar.f7508c = charSequence;
        CoderResult coderResultEncode = aVar.f7506a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), aVar.f7509d, true);
        if (coderResultEncode.isError()) {
            try {
                coderResultEncode.throwException();
            } catch (CharacterCodingException e8) {
                throw new IllegalArgumentException("bad character encoding", e8);
            }
        }
        aVar.f7509d.flip();
        return aVar.f7509d.remaining();
    }
}
