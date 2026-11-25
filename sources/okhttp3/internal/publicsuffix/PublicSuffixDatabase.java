package okhttp3.internal.publicsuffix;

import a7.d;
import a7.e;
import com.alibaba.android.arouter.utils.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.g0;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.i0;
import kotlin.io.c;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlin.sequences.u;
import kotlin.text.c0;
import okhttp3.internal.platform.k;
import okio.a0;
import okio.o;
import okio.v;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "", "i", "domainLabels", "d", "Lkotlin/l2;", "g", "f", "e", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "h", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/CountDownLatch;", "b", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "c", "[B", "<init>", "()V", "j", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d
    public static final String f38285e = "publicsuffixes.gz";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f38288h = '!';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f38291a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f38292b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f38293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f38294d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f38290j = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f38286f = {(byte) 42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f38287g = x.l("*");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final PublicSuffixDatabase f38289i = new PublicSuffixDatabase();

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i7) {
            int i8;
            boolean z7;
            int iB;
            int iB2;
            int length = bArr.length;
            int i9 = 0;
            while (i9 < length) {
                int i10 = (i9 + length) / 2;
                while (i10 > -1 && bArr[i10] != ((byte) 10)) {
                    i10--;
                }
                int i11 = i10 + 1;
                int i12 = 1;
                while (true) {
                    i8 = i11 + i12;
                    if (bArr[i8] == ((byte) 10)) {
                        break;
                    }
                    i12++;
                }
                int i13 = i8 - i11;
                int i14 = i7;
                boolean z8 = false;
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    if (z8) {
                        iB = 46;
                        z7 = false;
                    } else {
                        z7 = z8;
                        iB = okhttp3.internal.d.b(bArr2[i14][i15], 255);
                    }
                    iB2 = iB - okhttp3.internal.d.b(bArr[i11 + i16], 255);
                    if (iB2 != 0) {
                        break;
                    }
                    i16++;
                    i15++;
                    if (i16 == i13) {
                        break;
                    }
                    if (bArr2[i14].length != i15) {
                        z8 = z7;
                    } else {
                        if (i14 == bArr2.length - 1) {
                            break;
                        }
                        i14++;
                        i15 = -1;
                        z8 = true;
                    }
                }
                if (iB2 >= 0) {
                    if (iB2 <= 0) {
                        int i17 = i13 - i16;
                        int length2 = bArr2[i14].length - i15;
                        int length3 = bArr2.length;
                        for (int i18 = i14 + 1; i18 < length3; i18++) {
                            length2 += bArr2[i18].length;
                        }
                        if (length2 >= i17) {
                            if (length2 <= i17) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                l0.o(UTF_8, "UTF_8");
                                return new String(bArr, i11, i13, UTF_8);
                            }
                        }
                    }
                    i9 = i8 + 1;
                }
                length = i11 - 1;
            }
            return null;
        }

        @d
        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f38289i;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public static final /* synthetic */ byte[] b(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.f38293c;
        if (bArr == null) {
            l0.S("publicSuffixListBytes");
        }
        return bArr;
    }

    private final List<String> d(List<String> list) {
        String str;
        String strB;
        String str2;
        List<String> listF;
        List<String> listF2;
        if (this.f38291a.get() || !this.f38291a.compareAndSet(false, true)) {
            try {
                this.f38292b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            g();
        }
        if (!(this.f38293c != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i7 = 0; i7 < size; i7++) {
            String str3 = list.get(i7);
            Charset UTF_8 = StandardCharsets.UTF_8;
            l0.o(UTF_8, "UTF_8");
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(UTF_8);
            l0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i7] = bytes;
        }
        int i8 = 0;
        while (true) {
            str = null;
            if (i8 >= size) {
                strB = null;
                break;
            }
            a aVar = f38290j;
            byte[] bArr2 = this.f38293c;
            if (bArr2 == null) {
                l0.S("publicSuffixListBytes");
            }
            strB = aVar.b(bArr2, bArr, i8);
            if (strB != null) {
                break;
            }
            i8++;
        }
        if (size <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                str2 = null;
                break;
            }
            bArr3[i9] = f38286f;
            a aVar2 = f38290j;
            byte[] bArr4 = this.f38293c;
            if (bArr4 == null) {
                l0.S("publicSuffixListBytes");
            }
            String strB2 = aVar2.b(bArr4, bArr3, i9);
            if (strB2 != null) {
                str2 = strB2;
                break;
            }
            i9++;
        }
        if (str2 != null) {
            int i10 = size - 1;
            for (int i11 = 0; i11 < i10; i11++) {
                a aVar3 = f38290j;
                byte[] bArr5 = this.f38294d;
                if (bArr5 == null) {
                    l0.S("publicSuffixExceptionListBytes");
                }
                String strB3 = aVar3.b(bArr5, bArr, i11);
                if (strB3 != null) {
                    str = strB3;
                    break;
                }
            }
        }
        if (str != null) {
            return c0.S4(f38288h + str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, null);
        }
        if (strB == null && str2 == null) {
            return f38287g;
        }
        if (strB == null || (listF = c0.S4(strB, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, null)) == null) {
            listF = y.F();
        }
        if (str2 == null || (listF2 = c0.S4(str2, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, null)) == null) {
            listF2 = y.F();
        }
        return listF.size() > listF2.size() ? listF : listF2;
    }

    private final void f() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            o oVarD = a0.d(new v(a0.m(resourceAsStream)));
            try {
                byte[] bArrH1 = oVarD.h1(oVarD.readInt());
                byte[] bArrH2 = oVarD.h1(oVarD.readInt());
                l2 l2Var = l2.f34958a;
                c.a(oVarD, null);
                synchronized (this) {
                    l0.m(bArrH1);
                    this.f38293c = bArrH1;
                    l0.m(bArrH2);
                    this.f38294d = bArrH2;
                }
                this.f38292b.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    c.a(oVarD, th);
                    throw th2;
                }
            }
        }
    }

    private final void g() {
        boolean z7 = false;
        while (true) {
            try {
                try {
                    f();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z7 = true;
                } catch (IOException e8) {
                    k.f38284e.g().m("Failed to read public suffix list", 5, e8);
                    if (z7) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> i(String str) {
        List<String> listS4 = c0.S4(str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR}, false, 0, 6, null);
        return l0.g((String) g0.k3(listS4), "") ? g0.Y1(listS4, 1) : listS4;
    }

    @e
    public final String e(@d String domain) {
        int size;
        int size2;
        l0.p(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        l0.o(unicodeDomain, "unicodeDomain");
        List<String> listI = i(unicodeDomain);
        List<String> listD = d(listI);
        if (listI.size() == listD.size() && listD.get(0).charAt(0) != '!') {
            return null;
        }
        if (listD.get(0).charAt(0) == '!') {
            size = listI.size();
            size2 = listD.size();
        } else {
            size = listI.size();
            size2 = listD.size() + 1;
        }
        return u.e1(u.k0(g0.v1(i(domain)), size - size2), b.f12515h, null, null, 0, null, null, 62, null);
    }

    public final void h(@d byte[] publicSuffixListBytes, @d byte[] publicSuffixExceptionListBytes) {
        l0.p(publicSuffixListBytes, "publicSuffixListBytes");
        l0.p(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.f38293c = publicSuffixListBytes;
        this.f38294d = publicSuffixExceptionListBytes;
        this.f38291a.set(true);
        this.f38292b.countDown();
    }
}
