package i3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type[] f34181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f34182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f34183c;

    public c(Type[] typeArr, Type type, Type type2) {
        this.f34181a = typeArr;
        this.f34182b = type;
        this.f34183c = type2;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f34181a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f34182b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f34183c;
    }
}
