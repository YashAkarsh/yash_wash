package retrofit2.converter.gson;

import com.google.gson.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.e;
import retrofit2.s;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f40152a;

    private a(f fVar) {
        this.f40152a = fVar;
    }

    public static a f() {
        return g(new f());
    }

    public static a g(f fVar) {
        if (fVar != null) {
            return new a(fVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.e.a
    public e<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.f40152a, this.f40152a.p(com.google.gson.reflect.a.get(type)));
    }

    @Override // retrofit2.e.a
    public e<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.f40152a, this.f40152a.p(com.google.gson.reflect.a.get(type)));
    }
}
