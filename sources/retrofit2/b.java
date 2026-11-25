package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface b<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    b<T> mo142clone();

    r<T> execute() throws IOException;

    void f(d<T> dVar);

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
