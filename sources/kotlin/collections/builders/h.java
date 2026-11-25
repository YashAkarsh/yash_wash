package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.m1;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Externalizable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final a f34499c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f34500d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f34501e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34502f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private Collection<?> f34503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34504b;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public h(@a7.d Collection<?> collection, int i7) {
        l0.p(collection, "collection");
        this.f34503a = collection;
        this.f34504b = i7;
    }

    private final Object readResolve() {
        return this.f34503a;
    }

    @Override // java.io.Externalizable
    public void readExternal(@a7.d ObjectInput input) throws IOException {
        Collection<?> collectionB;
        l0.p(input, "input");
        byte b8 = input.readByte();
        int i7 = b8 & 1;
        if ((b8 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b8) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        int i8 = input.readInt();
        if (i8 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i8 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        int i9 = 0;
        if (i7 == 0) {
            List listK = x.k(i8);
            while (i9 < i8) {
                listK.add(input.readObject());
                i9++;
            }
            collectionB = x.b(listK);
        } else {
            if (i7 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            Set setE = m1.e(i8);
            while (i9 < i8) {
                setE.add(input.readObject());
                i9++;
            }
            collectionB = m1.a(setE);
        }
        this.f34503a = collectionB;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@a7.d ObjectOutput output) throws IOException {
        l0.p(output, "output");
        output.writeByte(this.f34504b);
        output.writeInt(this.f34503a.size());
        Iterator<?> it = this.f34503a.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public h() {
        this(y.F(), 0);
    }
}
