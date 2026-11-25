package okhttp3.internal.http2;

import androidx.core.view.g2;
import easypay.appinvoke.manager.Constants;
import java.io.IOException;
import kotlin.collections.o;
import kotlin.jvm.internal.l0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f38195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f38196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f38197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f38198d;

    static {
        k kVar = new k();
        f38198d = kVar;
        f38195a = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, g2.f6582r, g2.f6583s, 4090, 8185, 21, 248, 2042, g2.f6584t, g2.f6585u, 249, 2043, androidx.recyclerview.widget.m.f.f9644c, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, g2.f6586v, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 104, 105, Constants.ACTION_SUBMIT_CLICKED, Constants.OTP_FILLER_WEB_SUCCESS, 108, 109, Constants.LOG_ERROR_OTP, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, Constants.OTP_VIEW_GONE, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] bArr = {com.google.common.base.c.f19315o, com.google.common.base.c.A, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.B, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.H, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, com.google.common.base.c.F, 6, 10, 10, com.google.common.base.c.f19314n, com.google.common.base.c.f19315o, 6, 8, com.google.common.base.c.f19313m, 10, 10, 8, com.google.common.base.c.f19313m, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, com.google.common.base.c.f19317q, 6, com.google.common.base.c.f19314n, 10, com.google.common.base.c.f19315o, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, com.google.common.base.c.f19315o, 19, com.google.common.base.c.f19315o, com.google.common.base.c.f19316p, 6, com.google.common.base.c.f19317q, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, com.google.common.base.c.f19317q, com.google.common.base.c.f19313m, com.google.common.base.c.f19316p, com.google.common.base.c.f19315o, com.google.common.base.c.F, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19324x, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.B, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.B, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.A, com.google.common.base.c.f19324x, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.f19324x, 19, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.C, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.B, com.google.common.base.c.C, 19, com.google.common.base.c.f19325y, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.B, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.F, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.f19324x, com.google.common.base.c.B, com.google.common.base.c.f19324x, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.f19325y, com.google.common.base.c.f19325y, com.google.common.base.c.A, com.google.common.base.c.f19326z, com.google.common.base.c.f19326z, com.google.common.base.c.C, com.google.common.base.c.C, com.google.common.base.c.B, com.google.common.base.c.B, com.google.common.base.c.D, com.google.common.base.c.A, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.D, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.F, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.E, com.google.common.base.c.D};
        f38196b = bArr;
        f38197c = new a();
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            kVar.a(i7, f38195a[i7], f38196b[i7]);
        }
    }

    private k() {
    }

    private final void a(int i7, int i8, int i9) {
        a aVar = new a(i7, i9);
        a aVar2 = f38197c;
        while (i9 > 8) {
            i9 -= 8;
            int i10 = (i8 >>> i9) & 255;
            a[] aVarArrA = aVar2.a();
            l0.m(aVarArrA);
            a aVar3 = aVarArrA[i10];
            if (aVar3 == null) {
                aVar3 = new a();
                aVarArrA[i10] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i11 = 8 - i9;
        int i12 = (i8 << i11) & 255;
        a[] aVarArrA2 = aVar2.a();
        l0.m(aVarArrA2);
        o.n2(aVarArrA2, aVar, i12, (1 << i11) + i12);
    }

    public final void b(@a7.d okio.o source, long j7, @a7.d okio.n sink) throws IOException {
        l0.p(source, "source");
        l0.p(sink, "sink");
        a aVar = f38197c;
        int iB = 0;
        int iC = 0;
        for (long j8 = 0; j8 < j7; j8++) {
            iB = (iB << 8) | okhttp3.internal.d.b(source.readByte(), 255);
            iC += 8;
            while (iC >= 8) {
                int i7 = iC - 8;
                a[] aVarArrA = aVar.a();
                l0.m(aVarArrA);
                aVar = aVarArrA[(iB >>> i7) & 255];
                l0.m(aVar);
                if (aVar.a() == null) {
                    sink.writeByte(aVar.b());
                    iC -= aVar.c();
                    aVar = f38197c;
                } else {
                    iC = i7;
                }
            }
        }
        while (iC > 0) {
            a[] aVarArrA2 = aVar.a();
            l0.m(aVarArrA2);
            a aVar2 = aVarArrA2[(iB << (8 - iC)) & 255];
            l0.m(aVar2);
            if (aVar2.a() != null || aVar2.c() > iC) {
                return;
            }
            sink.writeByte(aVar2.b());
            iC -= aVar2.c();
            aVar = f38197c;
        }
    }

    public final void c(@a7.d p source, @a7.d okio.n sink) throws IOException {
        l0.p(source, "source");
        l0.p(sink, "sink");
        int iA0 = source.a0();
        long j7 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < iA0; i8++) {
            int iB = okhttp3.internal.d.b(source.n(i8), 255);
            int i9 = f38195a[iB];
            byte b8 = f38196b[iB];
            j7 = (j7 << b8) | ((long) i9);
            i7 += b8;
            while (i7 >= 8) {
                i7 -= 8;
                sink.writeByte((int) (j7 >> i7));
            }
        }
        if (i7 > 0) {
            sink.writeByte((int) ((j7 << (8 - i7)) | (255 >>> i7)));
        }
    }

    public final int d(@a7.d p bytes) {
        l0.p(bytes, "bytes");
        int iA0 = bytes.a0();
        long j7 = 0;
        for (int i7 = 0; i7 < iA0; i7++) {
            j7 += (long) f38196b[okhttp3.internal.d.b(bytes.n(i7), 255)];
        }
        return (int) ((j7 + ((long) 7)) >> 3);
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.e
        private final a[] f38199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f38201c;

        public a() {
            this.f38199a = new a[256];
            this.f38200b = 0;
            this.f38201c = 0;
        }

        @a7.e
        public final a[] a() {
            return this.f38199a;
        }

        public final int b() {
            return this.f38200b;
        }

        public final int c() {
            return this.f38201c;
        }

        public a(int i7, int i8) {
            this.f38199a = null;
            this.f38200b = i7;
            int i9 = i8 & 7;
            this.f38201c = i9 == 0 ? 8 : i9;
        }
    }
}
