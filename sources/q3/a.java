package q3;

import com.haier.uhome.usdk.api.interfaces.IuSDKBleOTACallback;
import com.haier.uhome.usdk.api.uSDKErrorConst;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static void a(IuSDKBleOTACallback iuSDKBleOTACallback, uSDKErrorConst usdkerrorconst) {
        iuSDKBleOTACallback.onCallback(usdkerrorconst.toError());
    }
}
