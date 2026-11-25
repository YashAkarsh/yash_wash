package m3;

import com.haier.library.okhttp.api.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a<T> f37462d;

    public b(a<T> aVar) {
        this.f37462d = aVar;
    }

    @Override // com.haier.library.okhttp.api.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(com.haier.library.okhttp.a aVar, String str) {
        e3.a.e("HttpResponse ResponseCallControl data = %s", str);
        try {
            Class<T> clsA = a(this.f37462d);
            a<T> aVar2 = this.f37462d;
            if (aVar2 != null) {
                aVar2.onSuccess((T) com.haier.library.json.a.z(str, clsA));
            }
        } catch (Exception e8) {
            e3.a.e("HttpResponse ResponseCallControl e = %s", e8.toString());
            a<T> aVar3 = this.f37462d;
            if (aVar3 != null) {
                aVar3.onError(e8);
            }
        }
    }

    @Override // com.haier.library.okhttp.api.b
    public void onError(com.haier.library.okhttp.a aVar, Exception exc) {
        e3.a.e("HttpResponse ResponseCallControl exception = %s", exc.toString());
        a<T> aVar2 = this.f37462d;
        if (aVar2 != null) {
            aVar2.onError(exc);
        }
    }

    private Class<T> a(a<T> aVar) {
        Type type = aVar.getClass().getGenericInterfaces()[0];
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                return (Class) actualTypeArguments[0];
            }
        }
        return null;
    }
}
