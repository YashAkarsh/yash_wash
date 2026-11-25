package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public interface e<F, T> {

    public static abstract class a {
        protected static Type a(int i7, ParameterizedType parameterizedType) {
            return u.i(i7, parameterizedType);
        }

        protected static Class<?> b(Type type) {
            return u.j(type);
        }

        @Nullable
        public e<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        @Nullable
        public e<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        @Nullable
        public e<?, String> e(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }
    }

    T a(F f8) throws IOException;
}
