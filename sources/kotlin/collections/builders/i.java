package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.b1;
import kotlin.collections.c1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
final class i implements Externalizable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f34505b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f34506c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private Map<?, ?> f34507a;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public i(@a7.d Map<?, ?> map) {
        l0.p(map, "map");
        this.f34507a = map;
    }

    private final Object readResolve() {
        return this.f34507a;
    }

    @Override // java.io.Externalizable
    public void readExternal(@a7.d ObjectInput input) throws IOException {
        l0.p(input, "input");
        byte b8 = input.readByte();
        if (b8 != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b8));
        }
        int i7 = input.readInt();
        if (i7 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        Map mapH = b1.h(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            mapH.put(input.readObject(), input.readObject());
        }
        this.f34507a = b1.d(mapH);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@a7.d ObjectOutput output) throws IOException {
        l0.p(output, "output");
        output.writeByte(0);
        output.writeInt(this.f34507a.size());
        for (Map.Entry<?, ?> entry : this.f34507a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public i() {
        this(c1.z());
    }
}
