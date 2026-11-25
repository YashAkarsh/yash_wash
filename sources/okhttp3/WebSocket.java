package okhttp3;

import a7.d;
import a7.e;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.x;
import kotlin.i0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0013"}, d2 = {"Lokhttp3/WebSocket;", "", "Lokhttp3/Request;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "", "queueSize", "", ViewHierarchyConstants.TEXT_KEY, "", "send", "Lokio/p;", "bytes", "", "code", "reason", "close", "Lkotlin/l2;", "cancel", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface WebSocket {

    @i0(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lokhttp3/WebSocket$Factory;", "", "newWebSocket", "Lokhttp3/WebSocket;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lokhttp3/Request;", x.a.f15818a, "Lokhttp3/WebSocketListener;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        @d
        WebSocket newWebSocket(@d Request request, @d WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i7, @e String str);

    long queueSize();

    @d
    Request request();

    boolean send(@d String str);

    boolean send(@d p pVar);
}
