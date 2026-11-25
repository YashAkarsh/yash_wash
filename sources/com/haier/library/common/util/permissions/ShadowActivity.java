package com.haier.library.common.util.permissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(23)
public class ShadowActivity extends Activity {
    private void a(int i7, boolean z7, String[] strArr, String[] strArr2) {
        a aVarB = d.d().b(i7);
        if (aVarB != null) {
            aVarB.a(z7, strArr, strArr2);
        }
        finish();
    }

    private void b(Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra(NativeProtocol.RESULT_ARGS_PERMISSIONS);
        int intExtra = getIntent().getIntExtra("sn", 0);
        if (stringArrayExtra != null) {
            requestPermissions(stringArrayExtra, intExtra);
        } else {
            a(intExtra, false, null, null);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            b(getIntent());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        b(intent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z7 = true;
        for (int i8 = 0; i8 < strArr.length; i8++) {
            if (iArr[i8] != 0) {
                if (shouldShowRequestPermissionRationale(strArr[i8])) {
                    arrayList.add(strArr[i8]);
                } else {
                    arrayList2.add(strArr[i8]);
                }
                z7 = false;
            }
        }
        a(i7, z7, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
    }
}
