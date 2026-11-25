package okhttp3;

import a7.d;
import a7.e;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.i0;
import kotlin.jvm.internal.l0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@i0(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/WebSocketListener;", "", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lkotlin/l2;", "onOpen", "", ViewHierarchyConstants.TEXT_KEY, "onMessage", "Lokio/p;", "bytes", "", "code", "reason", "onClosing", "onClosed", "", "t", "onFailure", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class WebSocketListener {
    public void onClosed(@d WebSocket webSocket, int i7, @d String reason) {
        l0.p(webSocket, "webSocket");
        l0.p(reason, "reason");
    }

    public void onClosing(@d WebSocket webSocket, int i7, @d String reason) {
        l0.p(webSocket, "webSocket");
        l0.p(reason, "reason");
    }

    public void onFailure(@d WebSocket webSocket, @d Throwable t7, @e Response response) {
        l0.p(webSocket, "webSocket");
        l0.p(t7, "t");
    }

    public void onMessage(@d WebSocket webSocket, @d String text) {
        l0.p(webSocket, "webSocket");
        l0.p(text, "text");
    }

    public void onOpen(@d WebSocket webSocket, @d Response response) {
        l0.p(webSocket, "webSocket");
        l0.p(response, "response");
    }

    public void onMessage(@d WebSocket webSocket, @d p bytes) {
        l0.p(webSocket, "webSocket");
        l0.p(bytes, "bytes");
    }
}
