package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class b {

    @s1.b
    private static class a extends AbstractList<Byte> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22306d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final byte[] f22307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22309c;

        a(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Byte.valueOf(this.f22307a[this.f22308b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte set(int i7, Byte b8) {
            com.google.common.base.e0.C(i7, size());
            byte[] bArr = this.f22307a;
            int i8 = this.f22308b;
            byte b9 = bArr[i8 + i7];
            bArr[i8 + i7] = ((Byte) com.google.common.base.e0.E(b8)).byteValue();
            return Byte.valueOf(b9);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && b.i(this.f22307a, ((Byte) obj).byteValue(), this.f22308b, this.f22309c) != -1;
        }

        byte[] d() {
            return Arrays.copyOfRange(this.f22307a, this.f22308b, this.f22309c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f22307a[this.f22308b + i7] != aVar.f22307a[aVar.f22308b + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iG = 1;
            for (int i7 = this.f22308b; i7 < this.f22309c; i7++) {
                iG = (iG * 31) + b.g(this.f22307a[i7]);
            }
            return iG;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int i7;
            if (!(obj instanceof Byte) || (i7 = b.i(this.f22307a, ((Byte) obj).byteValue(), this.f22308b, this.f22309c)) < 0) {
                return -1;
            }
            return i7 - this.f22308b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iL;
            if (!(obj instanceof Byte) || (iL = b.l(this.f22307a, ((Byte) obj).byteValue(), this.f22308b, this.f22309c)) < 0) {
                return -1;
            }
            return iL - this.f22308b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22309c - this.f22308b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            byte[] bArr = this.f22307a;
            int i9 = this.f22308b;
            return new a(bArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.f22307a[this.f22308b]);
            int i7 = this.f22308b;
            while (true) {
                i7++;
                if (i7 >= this.f22309c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.f22307a[i7]);
            }
        }

        a(byte[] bArr, int i7, int i8) {
            this.f22307a = bArr;
            this.f22308b = i7;
            this.f22309c = i8;
        }
    }

    private b() {
    }

    public static List<Byte> c(byte... bArr) {
        return bArr.length == 0 ? Collections.emptyList() : new a(bArr);
    }

    public static byte[] d(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean e(byte[] bArr, byte b8) {
        for (byte b9 : bArr) {
            if (b9 == b8) {
                return true;
            }
        }
        return false;
    }

    public static byte[] f(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return bArr.length < i7 ? Arrays.copyOf(bArr, i7 + i8) : bArr;
    }

    public static int g(byte b8) {
        return b8;
    }

    public static int h(byte[] bArr, byte b8) {
        return i(bArr, b8, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(byte[] bArr, byte b8, int i7, int i8) {
        while (i7 < i8) {
            if (bArr[i7] == b8) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int j(byte[] bArr, byte[] bArr2) {
        com.google.common.base.e0.F(bArr, "array");
        com.google.common.base.e0.F(bArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (bArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (bArr.length - bArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < bArr2.length; i8++) {
                if (bArr[i7 + i8] != bArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static int k(byte[] bArr, byte b8) {
        return l(bArr, b8, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(byte[] bArr, byte b8, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (bArr[i9] == b8) {
                return i9;
            }
        }
        return -1;
    }

    public static void m(byte[] bArr) {
        com.google.common.base.e0.E(bArr);
        n(bArr, 0, bArr.length);
    }

    public static void n(byte[] bArr, int i7, int i8) {
        com.google.common.base.e0.E(bArr);
        com.google.common.base.e0.f0(i7, i8, bArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            byte b8 = bArr[i7];
            bArr[i7] = bArr[i9];
            bArr[i9] = b8;
            i7++;
        }
    }

    public static byte[] o(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).byteValue();
        }
        return bArr;
    }
}
