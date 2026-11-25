package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.l0;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.s
final class a implements GenericArrayType, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Type f35066a;

    public a(@a7.d Type elementType) {
        l0.p(elementType, "elementType");
        this.f35066a = elementType;
    }

    public boolean equals(@a7.e Object obj) {
        return (obj instanceof GenericArrayType) && l0.g(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @a7.d
    public Type getGenericComponentType() {
        return this.f35066a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.y
    @a7.d
    public String getTypeName() {
        return b0.j(this.f35066a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @a7.d
    public String toString() {
        return getTypeName();
    }
}
