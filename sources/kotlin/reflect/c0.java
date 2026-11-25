package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.s
final class c0 implements WildcardType, y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final a f35070c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final c0 f35071d = new c0(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Type f35072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private final Type f35073b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        @a7.d
        public final c0 a() {
            return c0.f35071d;
        }

        private a() {
        }
    }

    public c0(@a7.e Type type, @a7.e Type type2) {
        this.f35072a = type;
        this.f35073b = type2;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @a7.d
    public Type[] getLowerBounds() {
        Type type = this.f35073b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.y
    @a7.d
    public String getTypeName() {
        if (this.f35073b != null) {
            return "? super " + b0.j(this.f35073b);
        }
        Type type = this.f35072a;
        if (type == null || l0.g(type, Object.class)) {
            return "?";
        }
        return "? extends " + b0.j(this.f35072a);
    }

    @Override // java.lang.reflect.WildcardType
    @a7.d
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.f35072a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @a7.d
    public String toString() {
        return getTypeName();
    }
}
