package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import h5.e;
import h5.h;
import i5.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.c1;
import kotlin.collections.g0;
import kotlin.collections.u0;
import kotlin.collections.y;
import kotlin.collections.z;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.s1;
import kotlin.jvm.internal.t1;
import kotlin.l2;
import kotlin.ranges.k;
import kotlin.ranges.q;
import kotlin.text.c0;
import kotlin.text.f;
import kotlin.text.o;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.d0;
import okio.m;
import okio.m0;
import okio.n;
import okio.o0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@h(name = "Util")
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @e
    public static final byte[] f37854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    @e
    public static final Headers f37855b = Headers.Companion.of(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @e
    public static final ResponseBody f37856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @e
    public static final RequestBody f37857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d0 f37858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @e
    public static final TimeZone f37859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final o f37860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @e
    public static final boolean f37861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.d
    @e
    public static final String f37862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.d
    public static final String f37863j = "okhttp/4.9.1";

    static final class a implements EventListener.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ EventListener f37864a;

        a(EventListener eventListener) {
            this.f37864a = eventListener;
        }

        @Override // okhttp3.EventListener.Factory
        @a7.d
        public final EventListener create(@a7.d Call it) {
            l0.p(it, "it");
            return this.f37864a;
        }
    }

    static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37866b;

        b(String str, boolean z7) {
            this.f37865a = str;
            this.f37866b = z7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f37865a);
            thread.setDaemon(this.f37866b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f37854a = bArr;
        f37856c = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        f37857d = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        d0.a aVar = d0.f38425d;
        p.a aVar2 = p.f38508f;
        f37858e = aVar.d(aVar2.i("efbbbf"), aVar2.i("feff"), aVar2.i("fffe"), aVar2.i("0000ffff"), aVar2.i("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        l0.m(timeZone);
        f37859f = timeZone;
        f37860g = new o("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f37861h = false;
        String name = OkHttpClient.class.getName();
        l0.o(name, "OkHttpClient::class.java.name");
        f37862i = c0.i4(c0.c4(name, "okhttp3."), "Client");
    }

    public static final int A(@a7.d String[] indexOf, @a7.d String value, @a7.d Comparator<String> comparator) {
        l0.p(indexOf, "$this$indexOf");
        l0.p(value, "value");
        l0.p(comparator, "comparator");
        int length = indexOf.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (comparator.compare(indexOf[i7], value) == 0) {
                return i7;
            }
        }
        return -1;
    }

    public static final int B(@a7.d String indexOfControlOrNonAscii) {
        l0.p(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = indexOfControlOrNonAscii.charAt(i7);
            if (l0.t(cCharAt, 31) <= 0 || l0.t(cCharAt, 127) >= 0) {
                return i7;
            }
        }
        return -1;
    }

    public static final int C(@a7.d String indexOfFirstNonAsciiWhitespace, int i7, int i8) {
        l0.p(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i7 < i8) {
            char cCharAt = indexOfFirstNonAsciiWhitespace.charAt(i7);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static /* synthetic */ int D(String str, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return C(str, i7, i8);
    }

    public static final int E(@a7.d String indexOfLastNonAsciiWhitespace, int i7, int i8) {
        l0.p(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i9 = i8 - 1;
        if (i9 >= i7) {
            while (true) {
                char cCharAt = indexOfLastNonAsciiWhitespace.charAt(i9);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i9 + 1;
                }
                if (i9 == i7) {
                    break;
                }
                i9--;
            }
        }
        return i7;
    }

    public static /* synthetic */ int F(String str, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return E(str, i7, i8);
    }

    public static final int G(@a7.d String indexOfNonWhitespace, int i7) {
        l0.p(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i7 < length) {
            char cCharAt = indexOfNonWhitespace.charAt(i7);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i7;
            }
            i7++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int H(String str, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        return G(str, i7);
    }

    @a7.d
    public static final String[] I(@a7.d String[] intersect, @a7.d String[] other, @a7.d Comparator<? super String> comparator) {
        l0.p(intersect, "$this$intersect");
        l0.p(other, "other");
        l0.p(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            for (String str2 : other) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean J(@a7.d okhttp3.internal.io.a isCivilized, @a7.d File file) throws IOException {
        l0.p(isCivilized, "$this$isCivilized");
        l0.p(file, "file");
        m0 m0VarB = isCivilized.b(file);
        try {
            try {
                isCivilized.f(file);
                kotlin.io.c.a(m0VarB, null);
                return true;
            } catch (IOException unused) {
                l2 l2Var = l2.f34958a;
                kotlin.io.c.a(m0VarB, null);
                isCivilized.f(file);
                return false;
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(m0VarB, th);
                throw th2;
            }
        }
    }

    public static final boolean K(@a7.d Socket isHealthy, @a7.d okio.o source) {
        l0.p(isHealthy, "$this$isHealthy");
        l0.p(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                return !source.N();
            } finally {
                isHealthy.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void L(@a7.d Object notify) {
        l0.p(notify, "$this$notify");
        notify.notify();
    }

    public static final void M(@a7.d Object notifyAll) {
        l0.p(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int N(char c8) {
        if ('0' <= c8 && '9' >= c8) {
            return c8 - '0';
        }
        char c9 = 'a';
        if ('a' > c8 || 'f' < c8) {
            c9 = 'A';
            if ('A' > c8 || 'F' < c8) {
                return -1;
            }
        }
        return (c8 - c9) + 10;
    }

    @a7.d
    public static final String O(@a7.d Socket peerName) {
        l0.p(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        l0.o(hostName, "address.hostName");
        return hostName;
    }

    @a7.d
    public static final Charset P(@a7.d okio.o readBomAsCharset, @a7.d Charset charset) throws IOException {
        l0.p(readBomAsCharset, "$this$readBomAsCharset");
        l0.p(charset, "default");
        int iV1 = readBomAsCharset.V1(f37858e);
        if (iV1 == -1) {
            return charset;
        }
        if (iV1 == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            l0.o(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iV1 == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            l0.o(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iV1 == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            l0.o(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iV1 == 3) {
            return f.f35352a.b();
        }
        if (iV1 == 4) {
            return f.f35352a.c();
        }
        throw new AssertionError();
    }

    @a7.e
    public static final <T> T Q(@a7.d Object instance, @a7.d Class<T> fieldType, @a7.d String fieldName) throws IllegalAccessException {
        Object objQ;
        l0.p(instance, "instance");
        l0.p(fieldType, "fieldType");
        l0.p(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            T tCast = null;
            if (!(!l0.g(superclass, Object.class))) {
                if (!(!l0.g(fieldName, "delegate")) || (objQ = Q(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) Q(objQ, fieldType, fieldName);
            }
            try {
                Field field = superclass.getDeclaredField(fieldName);
                l0.o(field, "field");
                field.setAccessible(true);
                Object obj = field.get(instance);
                if (fieldType.isInstance(obj)) {
                    tCast = fieldType.cast(obj);
                }
                return tCast;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                l0.o(superclass, "c.superclass");
            }
        }
    }

    public static final int R(@a7.d okio.o readMedium) throws IOException {
        l0.p(readMedium, "$this$readMedium");
        return b(readMedium.readByte(), 255) | (b(readMedium.readByte(), 255) << 16) | (b(readMedium.readByte(), 255) << 8);
    }

    public static final int S(@a7.d m skipAll, byte b8) throws EOFException {
        l0.p(skipAll, "$this$skipAll");
        int i7 = 0;
        while (!skipAll.N() && skipAll.v0(0L) == b8) {
            i7++;
            skipAll.readByte();
        }
        return i7;
    }

    public static final boolean T(@a7.d o0 skipAll, int i7, @a7.d TimeUnit timeUnit) throws IOException {
        l0.p(skipAll, "$this$skipAll");
        l0.p(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jD = skipAll.timeout().f() ? skipAll.timeout().d() - jNanoTime : Long.MAX_VALUE;
        skipAll.timeout().e(Math.min(jD, timeUnit.toNanos(i7)) + jNanoTime);
        try {
            m mVar = new m();
            while (skipAll.read(mVar, PlaybackStateCompat.f450z) != -1) {
                mVar.q();
            }
            if (jD == Long.MAX_VALUE) {
                skipAll.timeout().a();
            } else {
                skipAll.timeout().e(jNanoTime + jD);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jD == Long.MAX_VALUE) {
                skipAll.timeout().a();
            } else {
                skipAll.timeout().e(jNanoTime + jD);
            }
            return false;
        } catch (Throwable th) {
            if (jD == Long.MAX_VALUE) {
                skipAll.timeout().a();
            } else {
                skipAll.timeout().e(jNanoTime + jD);
            }
            throw th;
        }
    }

    @a7.d
    public static final ThreadFactory U(@a7.d String name, boolean z7) {
        l0.p(name, "name");
        return new b(name, z7);
    }

    public static final void V(@a7.d String name, @a7.d i5.a<l2> block) {
        l0.p(name, "name");
        l0.p(block, "block");
        Thread currentThread = Thread.currentThread();
        l0.o(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            i0.d(1);
            currentThread.setName(name2);
            i0.c(1);
        }
    }

    @a7.d
    public static final List<okhttp3.internal.http2.c> W(@a7.d Headers toHeaderList) {
        l0.p(toHeaderList, "$this$toHeaderList");
        k kVarZ1 = q.z1(0, toHeaderList.size());
        ArrayList arrayList = new ArrayList(z.Z(kVarZ1, 10));
        Iterator<Integer> it = kVarZ1.iterator();
        while (it.hasNext()) {
            int iB = ((u0) it).b();
            arrayList.add(new okhttp3.internal.http2.c(toHeaderList.name(iB), toHeaderList.value(iB)));
        }
        return arrayList;
    }

    @a7.d
    public static final Headers X(@a7.d List<okhttp3.internal.http2.c> toHeaders) {
        l0.p(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (okhttp3.internal.http2.c cVar : toHeaders) {
            builder.addLenient$okhttp(cVar.a().l0(), cVar.b().l0());
        }
        return builder.build();
    }

    @a7.d
    public static final String Y(int i7) {
        String hexString = Integer.toHexString(i7);
        l0.o(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    @a7.d
    public static final String Z(long j7) {
        String hexString = Long.toHexString(j7);
        l0.o(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final <E> void a(@a7.d List<E> addIfAbsent, E e8) {
        l0.p(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e8)) {
            return;
        }
        addIfAbsent.add(e8);
    }

    @a7.d
    public static final String a0(@a7.d HttpUrl toHostHeader, boolean z7) {
        String strHost;
        l0.p(toHostHeader, "$this$toHostHeader");
        if (c0.V2(toHostHeader.host(), ":", false, 2, null)) {
            strHost = '[' + toHostHeader.host() + ']';
        } else {
            strHost = toHostHeader.host();
        }
        if (!z7 && toHostHeader.port() == HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return strHost;
        }
        return strHost + ':' + toHostHeader.port();
    }

    public static final int b(byte b8, int i7) {
        return b8 & i7;
    }

    public static /* synthetic */ String b0(HttpUrl httpUrl, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return a0(httpUrl, z7);
    }

    public static final int c(short s7, int i7) {
        return s7 & i7;
    }

    @a7.d
    public static final <T> List<T> c0(@a7.d List<? extends T> toImmutableList) {
        l0.p(toImmutableList, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(g0.T5(toImmutableList));
        l0.o(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final long d(int i7, long j7) {
        return ((long) i7) & j7;
    }

    @a7.d
    public static final <K, V> Map<K, V> d0(@a7.d Map<K, ? extends V> toImmutableMap) {
        l0.p(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            return c1.z();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        l0.o(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    @a7.d
    public static final EventListener.Factory e(@a7.d EventListener asFactory) {
        l0.p(asFactory, "$this$asFactory");
        return new a(asFactory);
    }

    public static final long e0(@a7.d String toLongOrDefault, long j7) {
        l0.p(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j7;
        }
    }

    public static final void f(@a7.d Object assertThreadDoesntHoldLock) {
        l0.p(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (f37861h && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb.toString());
        }
    }

    public static final int f0(@a7.e String str, int i7) {
        if (str != null) {
            try {
                long j7 = Long.parseLong(str);
                if (j7 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j7 < 0) {
                    return 0;
                }
                return (int) j7;
            } catch (NumberFormatException unused) {
            }
        }
        return i7;
    }

    public static final void g(@a7.d Object assertThreadHoldsLock) {
        l0.p(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!f37861h || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(assertThreadHoldsLock);
        throw new AssertionError(sb.toString());
    }

    @a7.d
    public static final String g0(@a7.d String trimSubstring, int i7, int i8) {
        l0.p(trimSubstring, "$this$trimSubstring");
        int iC = C(trimSubstring, i7, i8);
        String strSubstring = trimSubstring.substring(iC, E(trimSubstring, iC, i8));
        l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean h(@a7.d String canParseAsIpAddress) {
        l0.p(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return f37860g.k(canParseAsIpAddress);
    }

    public static /* synthetic */ String h0(String str, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return g0(str, i7, i8);
    }

    public static final boolean i(@a7.d HttpUrl canReuseConnectionFor, @a7.d HttpUrl other) {
        l0.p(canReuseConnectionFor, "$this$canReuseConnectionFor");
        l0.p(other, "other");
        return l0.g(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && l0.g(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final void i0(@a7.d Object wait) throws InterruptedException {
        l0.p(wait, "$this$wait");
        wait.wait();
    }

    public static final int j(@a7.d String name, long j7, @a7.e TimeUnit timeUnit) {
        l0.p(name, "name");
        boolean z7 = true;
        if (!(j7 >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j7);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis == 0 && j7 > 0) {
            z7 = false;
        }
        if (z7) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    @a7.d
    public static final Throwable j0(@a7.d Exception withSuppressed, @a7.d List<? extends Exception> suppressed) {
        l0.p(withSuppressed, "$this$withSuppressed");
        l0.p(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            kotlin.p.a(withSuppressed, it.next());
        }
        return withSuppressed;
    }

    public static final void k(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void k0(@a7.d n writeMedium, int i7) throws IOException {
        l0.p(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i7 >>> 16) & 255);
        writeMedium.writeByte((i7 >>> 8) & 255);
        writeMedium.writeByte(i7 & 255);
    }

    public static final void l(@a7.d Closeable closeQuietly) {
        l0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e8) {
            throw e8;
        } catch (Exception unused) {
        }
    }

    public static final void m(@a7.d ServerSocket closeQuietly) {
        l0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e8) {
            throw e8;
        } catch (Exception unused) {
        }
    }

    public static final void n(@a7.d Socket closeQuietly) {
        l0.p(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e8) {
            throw e8;
        } catch (RuntimeException e9) {
            if (!l0.g(e9.getMessage(), "bio == null")) {
                throw e9;
            }
        } catch (Exception unused) {
        }
    }

    @a7.d
    public static final String[] o(@a7.d String[] concat, @a7.d String value) {
        l0.p(concat, "$this$concat");
        l0.p(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(concat, concat.length + 1);
        l0.o(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) objArrCopyOf;
        strArr[kotlin.collections.p.Xe(strArr)] = value;
        return strArr;
    }

    public static final int p(@a7.d String delimiterOffset, char c8, int i7, int i8) {
        l0.p(delimiterOffset, "$this$delimiterOffset");
        while (i7 < i8) {
            if (delimiterOffset.charAt(i7) == c8) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static final int q(@a7.d String delimiterOffset, @a7.d String delimiters, int i7, int i8) {
        l0.p(delimiterOffset, "$this$delimiterOffset");
        l0.p(delimiters, "delimiters");
        while (i7 < i8) {
            if (c0.U2(delimiters, delimiterOffset.charAt(i7), false, 2, null)) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static /* synthetic */ int r(String str, char c8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = str.length();
        }
        return p(str, c8, i7, i8);
    }

    public static /* synthetic */ int s(String str, String str2, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = str.length();
        }
        return q(str, str2, i7, i8);
    }

    public static final boolean t(@a7.d o0 discard, int i7, @a7.d TimeUnit timeUnit) {
        l0.p(discard, "$this$discard");
        l0.p(timeUnit, "timeUnit");
        try {
            return T(discard, i7, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @a7.d
    public static final <T> List<T> u(@a7.d Iterable<? extends T> filterList, @a7.d l<? super T, Boolean> predicate) {
        l0.p(filterList, "$this$filterList");
        l0.p(predicate, "predicate");
        List<T> listF = y.F();
        for (T t7 : filterList) {
            if (predicate.z(t7).booleanValue()) {
                if (listF.isEmpty()) {
                    listF = new ArrayList<>();
                }
                t1.g(listF).add(t7);
            }
        }
        return listF;
    }

    @a7.d
    public static final String v(@a7.d String format, @a7.d Object... args) {
        l0.p(format, "format");
        l0.p(args, "args");
        s1 s1Var = s1.f34921a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        l0.o(str, "java.lang.String.format(locale, format, *args)");
        return str;
    }

    public static final boolean w(@a7.d String[] hasIntersection, @a7.e String[] strArr, @a7.d Comparator<? super String> comparator) {
        l0.p(hasIntersection, "$this$hasIntersection");
        l0.p(comparator, "comparator");
        if (!(hasIntersection.length == 0) && strArr != null) {
            if (!(strArr.length == 0)) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long x(@a7.d Response headersContentLength) {
        l0.p(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get(com.google.common.net.c.f22134b);
        if (str != null) {
            return e0(str, -1L);
        }
        return -1L;
    }

    public static final void y(@a7.d i5.a<l2> block) {
        l0.p(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @a7.d
    @SafeVarargs
    public static final <T> List<T> z(@a7.d T... elements) {
        l0.p(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(y.M(Arrays.copyOf(objArr, objArr.length)));
        l0.o(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }
}
