package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
final class f extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c.a f40159a = new f();

    class a implements c<Object, b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f40160a;

        a(Type type) {
            this.f40160a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f40160a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b<Object> b(b<Object> bVar) {
            return bVar;
        }
    }

    f() {
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.c(type) != b.class) {
            return null;
        }
        return new a(u.g(type));
    }
}
