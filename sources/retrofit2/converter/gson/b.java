package retrofit2.converter.gson;

import com.google.gson.f;
import com.google.gson.x;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.m;
import retrofit2.e;

/* JADX INFO: loaded from: classes3.dex */
final class b<T> implements e<T, RequestBody> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MediaType f40153c = MediaType.parse("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f40154d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f40155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f40156b;

    b(f fVar, x<T> xVar) {
        this.f40155a = fVar;
        this.f40156b = xVar;
    }

    @Override // retrofit2.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RequestBody a(T t7) throws IOException {
        m mVar = new m();
        com.google.gson.stream.d dVarW = this.f40155a.w(new OutputStreamWriter(mVar.J1(), f40154d));
        this.f40156b.i(dVarW, t7);
        dVarW.close();
        return RequestBody.create(f40153c, mVar.E0());
    }
}
