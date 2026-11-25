package retrofit2.converter.gson;

import com.google.gson.f;
import com.google.gson.x;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.e;

/* JADX INFO: loaded from: classes3.dex */
final class c<T> implements e<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f40157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f40158b;

    c(f fVar, x<T> xVar) {
        this.f40157a = fVar;
        this.f40158b = xVar;
    }

    @Override // retrofit2.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(ResponseBody responseBody) throws IOException {
        try {
            return this.f40158b.e(this.f40157a.v(responseBody.charStream()));
        } finally {
            responseBody.close();
        }
    }
}
