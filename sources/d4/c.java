package d4;

import android.os.ParcelUuid;
import android.support.v4.media.session.PlaybackStateCompat;
import c.m0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ParcelUuid f33453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ParcelUuid f33454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ParcelUuid f33455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ParcelUuid f33456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ParcelUuid f33457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ParcelUuid f33458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ParcelUuid f33459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ParcelUuid f33460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ParcelUuid f33461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ParcelUuid f33462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ParcelUuid f33463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ParcelUuid f33464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ParcelUuid f33465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ParcelUuid f33466n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ParcelUuid f33467o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ParcelUuid f33468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ParcelUuid f33469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ParcelUuid f33470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ParcelUuid f33471s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ParcelUuid f33472t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ParcelUuid f33473u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f33474v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f33475w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f33476x = 16;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ParcelUuid[] f33477y;

    static {
        ParcelUuid parcelUuidFromString = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        f33453a = parcelUuidFromString;
        ParcelUuid parcelUuidFromString2 = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        f33454b = parcelUuidFromString2;
        ParcelUuid parcelUuidFromString3 = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        f33455c = parcelUuidFromString3;
        ParcelUuid parcelUuidFromString4 = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        f33456d = parcelUuidFromString4;
        f33457e = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString5 = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        f33458f = parcelUuidFromString5;
        f33459g = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString6 = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        f33460h = parcelUuidFromString6;
        ParcelUuid parcelUuidFromString7 = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        f33461i = parcelUuidFromString7;
        ParcelUuid parcelUuidFromString8 = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        f33462j = parcelUuidFromString8;
        f33463k = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
        f33464l = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
        ParcelUuid parcelUuidFromString9 = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        f33465m = parcelUuidFromString9;
        ParcelUuid parcelUuidFromString10 = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        f33466n = parcelUuidFromString10;
        f33467o = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
        f33468p = ParcelUuid.fromString("0000112e-0000-1000-8000-00805F9B34FB");
        f33469q = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
        ParcelUuid parcelUuidFromString11 = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
        f33470r = parcelUuidFromString11;
        ParcelUuid parcelUuidFromString12 = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
        f33471s = parcelUuidFromString12;
        ParcelUuid parcelUuidFromString13 = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
        f33472t = parcelUuidFromString13;
        f33473u = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
        f33477y = new ParcelUuid[]{parcelUuidFromString, parcelUuidFromString2, parcelUuidFromString3, parcelUuidFromString4, parcelUuidFromString5, parcelUuidFromString6, parcelUuidFromString7, parcelUuidFromString8, parcelUuidFromString9, parcelUuidFromString10, parcelUuidFromString11, parcelUuidFromString12, parcelUuidFromString13};
    }

    public static ParcelUuid A(byte[] bArr) {
        long j7;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j7 = ((long) (bArr[1] & 255)) + ((long) ((bArr[0] & 255) << 8));
        } else {
            j7 = ((long) ((bArr[0] & 255) << 24)) + ((long) (bArr[3] & 255)) + ((long) ((bArr[2] & 255) << 8)) + ((long) ((bArr[1] & 255) << 16));
        }
        ParcelUuid parcelUuid = f33473u;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j7 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }

    public static int B(@m0 UUID uuid) {
        return (int) ((uuid.getMostSignificantBits() >> 32) & okhttp3.internal.ws.g.f38386s);
    }

    public static boolean a(@m0 UUID uuid) {
        return (uuid.getMostSignificantBits() & (-281470681743361L)) == 0 && uuid.getLeastSignificantBits() == 0;
    }

    public static boolean b(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return true;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (!hashSet.contains(parcelUuid)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(ParcelUuid[] parcelUuidArr, ParcelUuid[] parcelUuidArr2) {
        if (parcelUuidArr == null && parcelUuidArr2 == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return parcelUuidArr2.length == 0;
        }
        if (parcelUuidArr2 == null) {
            return parcelUuidArr.length == 0;
        }
        HashSet hashSet = new HashSet(Arrays.asList(parcelUuidArr));
        for (ParcelUuid parcelUuid : parcelUuidArr2) {
            if (hashSet.contains(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    @m0
    public static UUID d(int i7) {
        return UUID.fromString("0000" + String.format("%04X", Integer.valueOf(i7 & 65535)) + "-0000-1000-8000-00805F9B34FB");
    }

    @m0
    public static UUID e(@m0 String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException unused) {
            return UUID.fromString("0000" + str + "-0000-1000-8000-00805F9B34FB");
        }
    }

    public static int f(ParcelUuid parcelUuid) {
        return (int) ((parcelUuid.getUuid().getMostSignificantBits() & 281470681743360L) >>> 32);
    }

    public static boolean g(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == f33473u.getUuid().getLeastSignificantBits() && (uuid.getMostSignificantBits() & (-281470681743361L)) == PlaybackStateCompat.f449y;
    }

    public static boolean h(ParcelUuid parcelUuid) {
        UUID uuid = parcelUuid.getUuid();
        return uuid.getLeastSignificantBits() == f33473u.getUuid().getLeastSignificantBits() && !g(parcelUuid) && (uuid.getMostSignificantBits() & 4294967295L) == PlaybackStateCompat.f449y;
    }

    public static boolean i(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33455c);
    }

    public static boolean j(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33453a);
    }

    public static boolean k(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33454b);
    }

    public static boolean l(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33460h);
    }

    public static boolean m(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33461i);
    }

    public static boolean n(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33467o);
    }

    public static boolean o(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33458f);
    }

    public static boolean p(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33456d);
    }

    public static boolean q(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33463k);
    }

    public static boolean r(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33470r);
    }

    public static boolean s(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33472t);
    }

    public static boolean t(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33471s);
    }

    public static boolean u(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33466n);
    }

    public static boolean v(ParcelUuid parcelUuid) {
        return parcelUuid.equals(f33465m);
    }

    public static boolean w(ParcelUuid[] parcelUuidArr, ParcelUuid parcelUuid) {
        if ((parcelUuidArr == null || parcelUuidArr.length == 0) && parcelUuid == null) {
            return true;
        }
        if (parcelUuidArr == null) {
            return false;
        }
        for (ParcelUuid parcelUuid2 : parcelUuidArr) {
            if (parcelUuid2.equals(parcelUuid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean x(@m0 UUID uuid, @m0 UUID uuid2) {
        if (a(uuid) || a(uuid2)) {
            return (uuid.getMostSignificantBits() & 281470681743360L) == (uuid2.getMostSignificantBits() & 281470681743360L);
        }
        return uuid.equals(uuid2);
    }

    @m0
    public static ParcelUuid y(int i7) {
        return ParcelUuid.fromString("0000" + String.format("%04X", Integer.valueOf(i7 & 65535)) + "-0000-1000-8000-00805F9B34FB");
    }

    public static ParcelUuid z(byte[] bArr) {
        long j7;
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        }
        if (length == 16) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(byteBufferOrder.getLong(8), byteBufferOrder.getLong(0)));
        }
        if (length == 2) {
            j7 = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
        } else {
            j7 = ((long) ((bArr[3] & 255) << 24)) + ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16));
        }
        ParcelUuid parcelUuid = f33473u;
        return new ParcelUuid(new UUID(parcelUuid.getUuid().getMostSignificantBits() + (j7 << 32), parcelUuid.getUuid().getLeastSignificantBits()));
    }
}
