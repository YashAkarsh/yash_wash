package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes3.dex */
abstract class j<T> {

    class a extends j<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                j.this.a(qVar, it.next());
            }
        }
    }

    class b extends j<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.j
        void a(q qVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i7 = 0; i7 < length; i7++) {
                j.this.a(qVar, Array.get(obj, i7));
            }
        }
    }

    static final class c<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, RequestBody> f40191a;

        c(retrofit2.e<T, RequestBody> eVar) {
            this.f40191a = eVar;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) {
            if (t7 == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                qVar.j(this.f40191a.a(t7));
            } catch (IOException e8) {
                throw new RuntimeException("Unable to convert " + t7 + " to RequestBody", e8);
            }
        }
    }

    static final class d<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.e<T, String> f40193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f40194c;

        d(String str, retrofit2.e<T, String> eVar, boolean z7) {
            this.f40192a = (String) u.b(str, "name == null");
            this.f40193b = eVar;
            this.f40194c = z7;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) throws IOException {
            String strA;
            if (t7 == null || (strA = this.f40193b.a(t7)) == null) {
                return;
            }
            qVar.a(this.f40192a, strA, this.f40194c);
        }
    }

    static final class e<T> extends j<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, String> f40195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40196b;

        e(retrofit2.e<T, String> eVar, boolean z7) {
            this.f40195a = eVar;
            this.f40196b = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String strA = this.f40195a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f40195a.getClass().getName() + " for key '" + key + "'.");
                }
                qVar.a(key, strA, this.f40196b);
            }
        }
    }

    static final class f<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.e<T, String> f40198b;

        f(String str, retrofit2.e<T, String> eVar) {
            this.f40197a = (String) u.b(str, "name == null");
            this.f40198b = eVar;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) throws IOException {
            String strA;
            if (t7 == null || (strA = this.f40198b.a(t7)) == null) {
                return;
            }
            qVar.b(this.f40197a, strA);
        }
    }

    static final class g<T> extends j<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, String> f40199a;

        g(retrofit2.e<T, String> eVar) {
            this.f40199a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                qVar.b(key, this.f40199a.a(value));
            }
        }
    }

    static final class h<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Headers f40200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.e<T, RequestBody> f40201b;

        h(Headers headers, retrofit2.e<T, RequestBody> eVar) {
            this.f40200a = headers;
            this.f40201b = eVar;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) {
            if (t7 == null) {
                return;
            }
            try {
                qVar.c(this.f40200a, this.f40201b.a(t7));
            } catch (IOException e8) {
                throw new RuntimeException("Unable to convert " + t7 + " to RequestBody", e8);
            }
        }
    }

    static final class i<T> extends j<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, RequestBody> f40202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f40203b;

        i(retrofit2.e<T, RequestBody> eVar, String str) {
            this.f40202a = eVar;
            this.f40203b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                qVar.c(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", MIME.CONTENT_TRANSFER_ENC, this.f40203b), this.f40202a.a(value));
            }
        }
    }

    /* JADX INFO: renamed from: retrofit2.j$j, reason: collision with other inner class name */
    static final class C0547j<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.e<T, String> f40205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f40206c;

        C0547j(String str, retrofit2.e<T, String> eVar, boolean z7) {
            this.f40204a = (String) u.b(str, "name == null");
            this.f40205b = eVar;
            this.f40206c = z7;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) throws IOException {
            if (t7 != null) {
                qVar.e(this.f40204a, this.f40205b.a(t7), this.f40206c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f40204a + "\" value must not be null.");
        }
    }

    static final class k<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final retrofit2.e<T, String> f40208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f40209c;

        k(String str, retrofit2.e<T, String> eVar, boolean z7) {
            this.f40207a = (String) u.b(str, "name == null");
            this.f40208b = eVar;
            this.f40209c = z7;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) throws IOException {
            String strA;
            if (t7 == null || (strA = this.f40208b.a(t7)) == null) {
                return;
            }
            qVar.f(this.f40207a, strA, this.f40209c);
        }
    }

    static final class l<T> extends j<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, String> f40210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40211b;

        l(retrofit2.e<T, String> eVar, boolean z7) {
            this.f40210a = eVar;
            this.f40211b = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String strA = this.f40210a.a(value);
                if (strA == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f40210a.getClass().getName() + " for key '" + key + "'.");
                }
                qVar.f(key, strA, this.f40211b);
            }
        }
    }

    static final class m<T> extends j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final retrofit2.e<T, String> f40212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f40213b;

        m(retrofit2.e<T, String> eVar, boolean z7) {
            this.f40212a = eVar;
            this.f40213b = z7;
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable T t7) throws IOException {
            if (t7 == null) {
                return;
            }
            qVar.f(this.f40212a.a(t7), null, this.f40213b);
        }
    }

    static final class n extends j<MultipartBody.Part> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final n f40214a = new n();

        private n() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(q qVar, @Nullable MultipartBody.Part part) throws IOException {
            if (part != null) {
                qVar.d(part);
            }
        }
    }

    static final class o extends j<Object> {
        o() {
        }

        @Override // retrofit2.j
        void a(q qVar, @Nullable Object obj) {
            u.b(obj, "@Url parameter is null.");
            qVar.k(obj);
        }
    }

    j() {
    }

    abstract void a(q qVar, @Nullable T t7) throws IOException;

    final j<Object> b() {
        return new b();
    }

    final j<Iterable<T>> c() {
        return new a();
    }
}
