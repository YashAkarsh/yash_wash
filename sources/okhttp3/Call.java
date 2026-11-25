package okhttp3;

import a7.d;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import kotlin.i0;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0000H&¨\u0006\u0012"}, d2 = {"Lokhttp3/Call;", "", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Response;", "execute", "Lokhttp3/Callback;", "responseCallback", "Lkotlin/l2;", "enqueue", "cancel", "", "isExecuted", "isCanceled", "Lokio/q0;", com.alipay.sdk.data.a.f13674p, "clone", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Call extends Cloneable {

    @i0(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lokhttp3/Call$Factory;", "", "newCall", "Lokhttp3/Call;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Request;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        @d
        Call newCall(@d Request request);
    }

    void cancel();

    @d
    /* JADX INFO: renamed from: clone */
    Call mo136clone();

    void enqueue(@d Callback callback);

    @d
    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    @d
    Request request();

    @d
    q0 timeout();
}
