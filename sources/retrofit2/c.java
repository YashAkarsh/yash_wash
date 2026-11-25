package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface c<R, T> {

    public static abstract class a {
        protected static Type b(int i7, ParameterizedType parameterizedType) {
            return u.i(i7, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return u.j(type);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, s sVar);
    }

    Type a();

    T b(b<R> bVar);
}
