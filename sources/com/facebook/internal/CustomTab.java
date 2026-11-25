package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;

/* JADX INFO: loaded from: classes.dex */
public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        androidx.browser.customtabs.c cVarD = new androidx.browser.customtabs.c.a().d();
        cVarD.f2190a.setPackage(str);
        cVarD.f2190a.addFlags(1073741824);
        cVarD.b(activity, this.uri);
    }
}
