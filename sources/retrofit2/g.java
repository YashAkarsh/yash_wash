package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f40162a;

    class a implements c<Object, retrofit2.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f40163a;

        a(Type type) {
            this.f40163a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f40163a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> b(retrofit2.b<Object> bVar) {
            return new b(g.this.f40162a, bVar);
        }
    }

    static final class b<T> implements retrofit2.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f40165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final retrofit2.b<T> f40166b;

        class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f40167a;

            /* JADX INFO: renamed from: retrofit2.g$b$a$a, reason: collision with other inner class name */
            class RunnableC0545a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ r f40169a;

                RunnableC0545a(r rVar) {
                    this.f40169a = rVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f40166b.isCanceled()) {
                        a aVar = a.this;
                        aVar.f40167a.onFailure(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.f40167a.onResponse(b.this, this.f40169a);
                    }
                }
            }

            /* JADX INFO: renamed from: retrofit2.g$b$a$b, reason: collision with other inner class name */
            class RunnableC0546b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Throwable f40171a;

                RunnableC0546b(Throwable th) {
                    this.f40171a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f40167a.onFailure(b.this, this.f40171a);
                }
            }

            a(d dVar) {
                this.f40167a = dVar;
            }

            @Override // retrofit2.d
            public void onFailure(retrofit2.b<T> bVar, Throwable th) {
                b.this.f40165a.execute(new RunnableC0546b(th));
            }

            @Override // retrofit2.d
            public void onResponse(retrofit2.b<T> bVar, r<T> rVar) {
                b.this.f40165a.execute(new RunnableC0545a(rVar));
            }
        }

        b(Executor executor, retrofit2.b<T> bVar) {
            this.f40165a = executor;
            this.f40166b = bVar;
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f40166b.cancel();
        }

        @Override // retrofit2.b
        public r<T> execute() throws IOException {
            return this.f40166b.execute();
        }

        @Override // retrofit2.b
        public void f(d<T> dVar) {
            u.b(dVar, "callback == null");
            this.f40166b.f(new a(dVar));
        }

        @Override // retrofit2.b
        public boolean isCanceled() {
            return this.f40166b.isCanceled();
        }

        @Override // retrofit2.b
        public boolean isExecuted() {
            return this.f40166b.isExecuted();
        }

        @Override // retrofit2.b
        public Request request() {
            return this.f40166b.request();
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f40165a, this.f40166b.clone());
        }
    }

    g(Executor executor) {
        this.f40162a = executor;
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        return new a(u.g(type));
    }
}
