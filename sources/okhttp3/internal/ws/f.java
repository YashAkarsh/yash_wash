package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.text.a0;
import kotlin.text.b0;
import kotlin.text.c0;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f38360g = "Sec-WebSocket-Extensions";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f38361h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public final boolean f38362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Integer f38363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @h5.e
    public final boolean f38364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Integer f38365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @h5.e
    public final boolean f38366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @h5.e
    public final boolean f38367f;

    public static final class a {
        private a() {
        }

        /* JADX WARN: Code duplicated, block: B:51:0x00c3 A[PHI: r7 r9
          0x00c3: PHI (r7v6 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v4 java.lang.Integer), (r7v8 java.lang.Integer) binds: [B:45:0x00b9, B:42:0x00b0, B:26:0x0089] A[DONT_GENERATE, DONT_INLINE]
          0x00c3: PHI (r9v9 java.lang.Integer) = (r9v4 java.lang.Integer), (r9v6 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:45:0x00b9, B:42:0x00b0, B:26:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
        @a7.d
        public final f a(@a7.d Headers responseHeaders) throws IOException {
            l0.p(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z7 = false;
            Integer numX0 = null;
            boolean z8 = false;
            Integer numX1 = null;
            boolean z9 = false;
            boolean z10 = false;
            for (int i7 = 0; i7 < size; i7++) {
                if (b0.K1(responseHeaders.name(i7), f.f38360g, true)) {
                    String strValue = responseHeaders.value(i7);
                    int i8 = 0;
                    while (i8 < strValue.length()) {
                        int iR = okhttp3.internal.d.r(strValue, ',', i8, 0, 4, null);
                        int iP = okhttp3.internal.d.p(strValue, ';', i8, iR);
                        String strG0 = okhttp3.internal.d.g0(strValue, i8, iP);
                        int i9 = iP + 1;
                        if (b0.K1(strG0, "permessage-deflate", true)) {
                            if (z7) {
                                z10 = true;
                            }
                            while (i9 < iR) {
                                int iP2 = okhttp3.internal.d.p(strValue, ';', i9, iR);
                                int iP3 = okhttp3.internal.d.p(strValue, '=', i9, iP2);
                                String strG1 = okhttp3.internal.d.g0(strValue, i9, iP3);
                                String strL4 = iP3 < iP2 ? c0.l4(okhttp3.internal.d.g0(strValue, iP3 + 1, iP2), "\"") : null;
                                int i10 = iP2 + 1;
                                if (b0.K1(strG1, "client_max_window_bits", true)) {
                                    if (numX0 != null) {
                                        z10 = true;
                                    }
                                    numX0 = strL4 != null ? a0.X0(strL4) : null;
                                    if (numX0 == null) {
                                        z10 = true;
                                    }
                                } else if (b0.K1(strG1, "client_no_context_takeover", true)) {
                                    if (z8) {
                                        z10 = true;
                                    }
                                    if (strL4 != null) {
                                        z10 = true;
                                    }
                                    z8 = true;
                                } else if (b0.K1(strG1, "server_max_window_bits", true)) {
                                    if (numX1 != null) {
                                        z10 = true;
                                    }
                                    numX1 = strL4 != null ? a0.X0(strL4) : null;
                                    if (numX1 == null) {
                                        z10 = true;
                                    }
                                } else if (b0.K1(strG1, "server_no_context_takeover", true)) {
                                    if (z9) {
                                        z10 = true;
                                    }
                                    if (strL4 != null) {
                                        z10 = true;
                                    }
                                    z9 = true;
                                } else {
                                    z10 = true;
                                }
                                i9 = i10;
                            }
                            i8 = i9;
                            z7 = true;
                        } else {
                            i8 = i9;
                            z10 = true;
                        }
                    }
                }
            }
            return new f(z7, numX0, z8, numX1, z9, z10);
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public f() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ f h(f fVar, boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = fVar.f38362a;
        }
        if ((i7 & 2) != 0) {
            num = fVar.f38363b;
        }
        Integer num3 = num;
        if ((i7 & 4) != 0) {
            z8 = fVar.f38364c;
        }
        boolean z11 = z8;
        if ((i7 & 8) != 0) {
            num2 = fVar.f38365d;
        }
        Integer num4 = num2;
        if ((i7 & 16) != 0) {
            z9 = fVar.f38366e;
        }
        boolean z12 = z9;
        if ((i7 & 32) != 0) {
            z10 = fVar.f38367f;
        }
        return fVar.g(z7, num3, z11, num4, z12, z10);
    }

    public final boolean a() {
        return this.f38362a;
    }

    @a7.e
    public final Integer b() {
        return this.f38363b;
    }

    public final boolean c() {
        return this.f38364c;
    }

    @a7.e
    public final Integer d() {
        return this.f38365d;
    }

    public final boolean e() {
        return this.f38366e;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f38362a == fVar.f38362a && l0.g(this.f38363b, fVar.f38363b) && this.f38364c == fVar.f38364c && l0.g(this.f38365d, fVar.f38365d) && this.f38366e == fVar.f38366e && this.f38367f == fVar.f38367f;
    }

    public final boolean f() {
        return this.f38367f;
    }

    @a7.d
    public final f g(boolean z7, @a7.e Integer num, boolean z8, @a7.e Integer num2, boolean z9, boolean z10) {
        return new f(z7, num, z8, num2, z9, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z7 = this.f38362a;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i7 = r7 * 31;
        Integer num = this.f38363b;
        int iHashCode = (i7 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z8 = this.f38364c;
        ?? r8 = z8;
        if (z8) {
            r8 = 1;
        }
        int i8 = (iHashCode + r8) * 31;
        Integer num2 = this.f38365d;
        int iHashCode2 = (i8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z9 = this.f38366e;
        ?? r9 = z9;
        if (z9) {
            r9 = 1;
        }
        int i9 = (iHashCode2 + r9) * 31;
        boolean z10 = this.f38367f;
        return i9 + (z10 ? 1 : z10);
    }

    public final boolean i(boolean z7) {
        return z7 ? this.f38364c : this.f38366e;
    }

    @a7.d
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f38362a + ", clientMaxWindowBits=" + this.f38363b + ", clientNoContextTakeover=" + this.f38364c + ", serverMaxWindowBits=" + this.f38365d + ", serverNoContextTakeover=" + this.f38366e + ", unknownValues=" + this.f38367f + ")";
    }

    public f(boolean z7, @a7.e Integer num, boolean z8, @a7.e Integer num2, boolean z9, boolean z10) {
        this.f38362a = z7;
        this.f38363b = num;
        this.f38364c = z8;
        this.f38365d = num2;
        this.f38366e = z9;
        this.f38367f = z10;
    }

    public /* synthetic */ f(boolean z7, Integer num, boolean z8, Integer num2, boolean z9, boolean z10, int i7, w wVar) {
        this((i7 & 1) != 0 ? false : z7, (i7 & 2) != 0 ? null : num, (i7 & 4) != 0 ? false : z8, (i7 & 8) == 0 ? num2 : null, (i7 & 16) != 0 ? false : z9, (i7 & 32) != 0 ? false : z10);
    }
}
