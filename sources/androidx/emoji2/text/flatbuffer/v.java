package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f7612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f7613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    x f7616e = x.d();

    class a implements Comparator<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f7617a;

        a(ByteBuffer byteBuffer) {
            this.f7617a = byteBuffer;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return v.this.s(num, num2, this.f7617a);
        }
    }

    protected static boolean a(ByteBuffer byteBuffer, String str) {
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i7 = 0; i7 < 4; i7++) {
            if (str.charAt(i7) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i7))) {
                return false;
            }
        }
        return true;
    }

    protected static int c(int i7, ByteBuffer byteBuffer) {
        return i7 + byteBuffer.getInt(i7);
    }

    protected static int e(int i7, int i8, ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - i8;
        return byteBuffer.getShort((i7 + iCapacity) - byteBuffer.getInt(iCapacity)) + iCapacity;
    }

    protected static String i(int i7, ByteBuffer byteBuffer, x xVar) {
        int i8 = i7 + byteBuffer.getInt(i7);
        return xVar.a(byteBuffer, i8 + 4, byteBuffer.getInt(i8));
    }

    protected static v k(v vVar, int i7, ByteBuffer byteBuffer) {
        vVar.g(c(i7, byteBuffer), byteBuffer);
        return vVar;
    }

    protected static int p(int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i7 + byteBuffer.getInt(i7);
        int i10 = i8 + byteBuffer.getInt(i8);
        int i11 = byteBuffer.getInt(i9);
        int i12 = byteBuffer.getInt(i10);
        int i13 = i9 + 4;
        int i14 = i10 + 4;
        int iMin = Math.min(i11, i12);
        for (int i15 = 0; i15 < iMin; i15++) {
            int i16 = i15 + i13;
            int i17 = i15 + i14;
            if (byteBuffer.get(i16) != byteBuffer.get(i17)) {
                return byteBuffer.get(i16) - byteBuffer.get(i17);
            }
        }
        return i11 - i12;
    }

    protected static int q(int i7, byte[] bArr, ByteBuffer byteBuffer) {
        int i8 = i7 + byteBuffer.getInt(i7);
        int i9 = byteBuffer.getInt(i8);
        int length = bArr.length;
        int i10 = i8 + 4;
        int iMin = Math.min(i9, length);
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = i11 + i10;
            if (byteBuffer.get(i12) != bArr[i11]) {
                return byteBuffer.get(i12) - bArr[i11];
            }
        }
        return i9 - length;
    }

    protected int b(int i7) {
        return i7 + this.f7613b.getInt(i7);
    }

    protected int d(int i7) {
        if (i7 < this.f7615d) {
            return this.f7613b.getShort(this.f7614c + i7);
        }
        return 0;
    }

    public void f() {
        g(0, null);
    }

    protected void g(int i7, ByteBuffer byteBuffer) {
        this.f7613b = byteBuffer;
        if (byteBuffer == null) {
            this.f7612a = 0;
            this.f7614c = 0;
            this.f7615d = 0;
        } else {
            this.f7612a = i7;
            int i8 = i7 - byteBuffer.getInt(i7);
            this.f7614c = i8;
            this.f7615d = this.f7613b.getShort(i8);
        }
    }

    protected String h(int i7) {
        return i(i7, this.f7613b, this.f7616e);
    }

    protected v j(v vVar, int i7) {
        return k(vVar, i7, this.f7613b);
    }

    protected int l(int i7) {
        int i8 = i7 + this.f7612a;
        return i8 + this.f7613b.getInt(i8) + 4;
    }

    protected ByteBuffer m(int i7, int i8) {
        int iD = d(i7);
        if (iD == 0) {
            return null;
        }
        ByteBuffer byteBufferOrder = this.f7613b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int iL = l(iD);
        byteBufferOrder.position(iL);
        byteBufferOrder.limit(iL + (o(iD) * i8));
        return byteBufferOrder;
    }

    protected ByteBuffer n(ByteBuffer byteBuffer, int i7, int i8) {
        int iD = d(i7);
        if (iD == 0) {
            return null;
        }
        int iL = l(iD);
        byteBuffer.rewind();
        byteBuffer.limit((o(iD) * i8) + iL);
        byteBuffer.position(iL);
        return byteBuffer;
    }

    protected int o(int i7) {
        int i8 = i7 + this.f7612a;
        return this.f7613b.getInt(i8 + this.f7613b.getInt(i8));
    }

    public ByteBuffer r() {
        return this.f7613b;
    }

    protected int s(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    protected void t(int[] iArr, ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            numArr[i7] = Integer.valueOf(iArr[i7]);
        }
        Arrays.sort(numArr, new a(byteBuffer));
        for (int i8 = 0; i8 < iArr.length; i8++) {
            iArr[i8] = numArr[i8].intValue();
        }
    }
}
