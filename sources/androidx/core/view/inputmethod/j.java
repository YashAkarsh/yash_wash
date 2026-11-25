package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.w;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.t;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6604a = "InputConnectionCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f6605b = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6606c = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6607d = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f6608e = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f6609f = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f6610g = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f6611h = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f6612i = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f6613j = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f6614k = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f6615l = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f6616m = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f6617n = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f6618o = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f6619p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f6620q = "androidx.core.view.extra.INPUT_CONTENT_INFO";

    class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6621a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InputConnection inputConnection, boolean z7, d dVar) {
            super(inputConnection, z7);
            this.f6621a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i7, Bundle bundle) {
            if (this.f6621a.a(s.g(inputContentInfo), i7, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i7, bundle);
        }
    }

    class b extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6622a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InputConnection inputConnection, boolean z7, d dVar) {
            super(inputConnection, z7);
            this.f6622a = dVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String str, Bundle bundle) {
            if (j.f(str, bundle, this.f6622a)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    @t0(25)
    static class c {
        private c() {
        }

        @t
        static boolean a(InputConnection inputConnection, InputContentInfo inputContentInfo, int i7, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i7, bundle);
        }
    }

    public interface d {
        boolean a(@m0 s sVar, int i7, @o0 Bundle bundle);
    }

    @Deprecated
    public j() {
    }

    public static boolean b(@m0 InputConnection inputConnection, @m0 EditorInfo editorInfo, @m0 s sVar, int i7, @o0 Bundle bundle) {
        boolean z7;
        if (Build.VERSION.SDK_INT >= 25) {
            return c.a(inputConnection, h.a(sVar.f()), i7, bundle);
        }
        int iE = g.e(editorInfo);
        if (iE != 2) {
            z7 = false;
            if (iE != 3 && iE != 4) {
                return false;
            }
        } else {
            z7 = true;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(z7 ? f6608e : f6607d, sVar.a());
        bundle2.putParcelable(z7 ? f6610g : f6609f, sVar.b());
        bundle2.putParcelable(z7 ? f6612i : f6611h, sVar.c());
        bundle2.putInt(z7 ? f6616m : f6615l, i7);
        bundle2.putParcelable(z7 ? f6614k : f6613j, bundle);
        return inputConnection.performPrivateCommand(z7 ? f6606c : f6605b, bundle2);
    }

    @m0
    private static d c(@m0 final View view) {
        w.l(view);
        return new d() { // from class: androidx.core.view.inputmethod.i
            @Override // androidx.core.view.inputmethod.j.d
            public final boolean a(s sVar, int i7, Bundle bundle) {
                return j.g(view, sVar, i7, bundle);
            }
        };
    }

    @m0
    public static InputConnection d(@m0 View view, @m0 InputConnection inputConnection, @m0 EditorInfo editorInfo) {
        return e(inputConnection, editorInfo, c(view));
    }

    @m0
    @Deprecated
    public static InputConnection e(@m0 InputConnection inputConnection, @m0 EditorInfo editorInfo, @m0 d dVar) {
        androidx.core.util.r.e(inputConnection, "inputConnection must be non-null");
        androidx.core.util.r.e(editorInfo, "editorInfo must be non-null");
        androidx.core.util.r.e(dVar, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new a(inputConnection, false, dVar);
        }
        return g.a(editorInfo).length == 0 ? inputConnection : new b(inputConnection, false, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    static boolean f(@o0 String str, @o0 Bundle bundle, @m0 d dVar) throws Throwable {
        boolean z7;
        ResultReceiver resultReceiver;
        boolean zA;
        ?? r7 = 0;
        r7 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(f6605b, str)) {
            z7 = false;
        } else {
            if (!TextUtils.equals(f6606c, str)) {
                return false;
            }
            z7 = true;
        }
        try {
            resultReceiver = (ResultReceiver) bundle.getParcelable(z7 ? f6618o : f6617n);
            try {
                Uri uri = (Uri) bundle.getParcelable(z7 ? f6608e : f6607d);
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z7 ? f6610g : f6609f);
                Uri uri2 = (Uri) bundle.getParcelable(z7 ? f6612i : f6611h);
                int i7 = bundle.getInt(z7 ? f6616m : f6615l);
                Bundle bundle2 = (Bundle) bundle.getParcelable(z7 ? f6614k : f6613j);
                if (uri != null && clipDescription != null) {
                    zA = dVar.a(new s(uri, clipDescription, uri2), i7, bundle2);
                }
                if (resultReceiver != 0) {
                    r7 = zA;
                    resultReceiver.send(r7, null);
                }
                r7 = zA;
                return r7;
            } catch (Throwable th) {
                th = th;
                if (resultReceiver != 0) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean g(View view, s sVar, int i7, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i7 & 1) != 0) {
            try {
                sVar.e();
                InputContentInfo inputContentInfoA = h.a(sVar.f());
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable(f6620q, inputContentInfoA);
            } catch (Exception e8) {
                Log.w(f6604a, "Can't insert content from IME; requestPermission() failed", e8);
                return false;
            }
        }
        return n2.m1(view, new androidx.core.view.k.b(new ClipData(sVar.b(), new ClipData.Item(sVar.a())), 2).e(sVar.c()).c(bundle).a()) == null;
    }
}
