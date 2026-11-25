package kotlin.reflect;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.s
final class x implements ParameterizedType, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Class<?> f35092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final Type f35093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Type[] f35094c;

    /* synthetic */ class a extends h0 implements i5.l<Type, String> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f35095j = new a();

        a() {
            super(1, b0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d Type p7) {
            l0.p(p7, "p0");
            return b0.j(p7);
        }
    }

    public x(@a7.d Class<?> rawType, @a7.e Type type, @a7.d List<? extends Type> typeArguments) {
        l0.p(rawType, "rawType");
        l0.p(typeArguments, "typeArguments");
        this.f35092a = rawType;
        this.f35093b = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f35094c = (Type[]) array;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (l0.g(this.f35092a, parameterizedType.getRawType()) && l0.g(this.f35093b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @a7.d
    public Type[] getActualTypeArguments() {
        return this.f35094c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @a7.e
    public Type getOwnerType() {
        return this.f35093b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @a7.d
    public Type getRawType() {
        return this.f35092a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.y
    @a7.d
    public String getTypeName() throws IOException {
        StringBuilder sb = new StringBuilder();
        Type type = this.f35093b;
        if (type != null) {
            sb.append(b0.j(type));
            sb.append("$");
            sb.append(this.f35092a.getSimpleName());
        } else {
            sb.append(b0.j(this.f35092a));
        }
        Type[] typeArr = this.f35094c;
        if (!(typeArr.length == 0)) {
            kotlin.collections.p.lh(typeArr, sb, (null & 2) != 0 ? ", " : null, (null & 4) != 0 ? "" : "<", (null & 8) == 0 ? ">" : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : a.f35095j);
        }
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.f35092a.hashCode();
        Type type = this.f35093b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @a7.d
    public String toString() {
        return getTypeName();
    }
}
