package b;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import c.t0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.b1;
import kotlin.collections.c1;
import kotlin.collections.g0;
import kotlin.collections.p;
import kotlin.collections.y;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.p1;
import kotlin.ranges.q;
import kotlin.u0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a extends b.a<Uri, Boolean> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Boolean> b(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Boolean c(int i7, @a7.e Intent intent) {
            return Boolean.valueOf(i7 == -1);
        }
    }

    public static class c extends b.a<String, Uri> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            l0.o(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Uri> b(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @t0(18)
    public static class d extends b.a<String, List<Uri>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f11252a = new a(null);

        @t0(18)
        public static final class a {
            public /* synthetic */ a(w wVar) {
                this();
            }

            @a7.d
            public final List<Uri> a(@a7.d Intent intent) {
                l0.p(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return y.F();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i7 = 0; i7 < itemCount; i7++) {
                        Uri uri = clipData.getItemAt(i7).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private a() {
            }
        }

        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            l0.o(intentPutExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<List<Uri>> b(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final List<Uri> c(int i7, @a7.e Intent intent) {
            List<Uri> listA;
            if (!(i7 == -1)) {
                intent = null;
            }
            return (intent == null || (listA = f11252a.a(intent)) == null) ? y.F() : listA;
        }
    }

    @t0(19)
    public static class e extends b.a<String[], Uri> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            l0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Uri> b(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @t0(21)
    public static class f extends b.a<Uri, Uri> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.e Uri uri) {
            l0.p(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Uri> b(@a7.d Context context, @a7.e Uri uri) {
            l0.p(context, "context");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @t0(19)
    public static class g extends b.a<String[], List<Uri>> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            l0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<List<Uri>> b(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final List<Uri> c(int i7, @a7.e Intent intent) {
            List<Uri> listA;
            if (!(i7 == -1)) {
                intent = null;
            }
            return (intent == null || (listA = d.f11252a.a(intent)) == null) ? y.F() : listA;
        }
    }

    public static final class h extends b.a<Void, Uri> {
        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.e Void r7) {
            l0.p(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            l0.o(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Uri c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    public static final class i extends b.a<String[], Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f11253a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final String f11254b = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        public static final String f11255c = "androidx.activity.result.contract.extra.PERMISSIONS";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        public static final String f11256d = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class a {
            public /* synthetic */ a(w wVar) {
                this();
            }

            @a7.d
            public final Intent a(@a7.d String[] input) {
                l0.p(input, "input");
                Intent intentPutExtra = new Intent(i.f11254b).putExtra(i.f11255c, input);
                l0.o(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            }

            private a() {
            }
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return f11253a.a(input);
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b.a.C0134a<Map<String, Boolean>> b(@a7.d Context context, @a7.d String[] input) {
            l0.p(context, "context");
            l0.p(input, "input");
            boolean z7 = true;
            if (input.length == 0) {
                return new b.a.C0134a<>(c1.z());
            }
            for (String str : input) {
                if (!(androidx.core.content.d.a(context, str) == 0)) {
                    z7 = false;
                    break;
                }
            }
            if (!z7) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(b1.j(input.length), 16));
            for (String str2 : input) {
                u0 u0VarA = p1.a(str2, Boolean.TRUE);
                linkedHashMap.put(u0VarA.e(), u0VarA.f());
            }
            return new b.a.C0134a<>(linkedHashMap);
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<String, Boolean> c(int i7, @a7.e Intent intent) {
            if (i7 != -1) {
                return c1.z();
            }
            if (intent == null) {
                return c1.z();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(f11255c);
            int[] intArrayExtra = intent.getIntArrayExtra(f11256d);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return c1.z();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i8 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i8 == 0));
            }
            return c1.B0(g0.d6(p.ub(stringArrayExtra), arrayList));
        }
    }

    public static final class j extends b.a<String, Boolean> {
        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return i.f11253a.a(new String[]{input});
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b.a.C0134a<Boolean> b(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            if (androidx.core.content.d.a(context, input) == 0) {
                return new b.a.C0134a<>(Boolean.TRUE);
            }
            return null;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean c(int i7, @a7.e Intent intent) {
            boolean z7;
            if (intent == null || i7 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(i.f11256d);
            boolean z8 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        z7 = false;
                        break;
                    }
                    if (intArrayExtra[i8] == 0) {
                        z7 = true;
                        break;
                    }
                    i8++;
                }
                if (z7) {
                    z8 = true;
                }
            }
            return Boolean.valueOf(z8);
        }
    }

    public static final class k extends b.a<Intent, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f11257a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final String f11258b = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class a {
            public /* synthetic */ a(w wVar) {
                this();
            }

            private a() {
            }
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d Intent input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return input;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i7, @a7.e Intent intent) {
            return new ActivityResult(i7, intent);
        }
    }

    public static final class l extends b.a<IntentSenderRequest, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public static final a f11259a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final String f11260b = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        public static final String f11261c = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        public static final String f11262d = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class a {
            public /* synthetic */ a(w wVar) {
                this();
            }

            private a() {
            }
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d IntentSenderRequest input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent(f11260b).putExtra(f11261c, input);
            l0.o(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i7, @a7.e Intent intent) {
            return new ActivityResult(i7, intent);
        }
    }

    public static class m extends b.a<Uri, Boolean> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Boolean> b(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Boolean c(int i7, @a7.e Intent intent) {
            return Boolean.valueOf(i7 == -1);
        }
    }

    public static class n extends b.a<Void, Bitmap> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.e Void r7) {
            l0.p(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Bitmap> b(@a7.d Context context, @a7.e Void r7) {
            l0.p(context, "context");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Bitmap c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @kotlin.k(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class o extends b.a<Uri, Bitmap> {
        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            l0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Bitmap> b(@a7.d Context context, @a7.d Uri input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Bitmap c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    private b() {
    }

    /* JADX INFO: renamed from: b.b$b, reason: collision with other inner class name */
    @t0(19)
    public static class C0135b extends b.a<String, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final String f11251a;

        public C0135b(@a7.d String mimeType) {
            l0.p(mimeType, "mimeType");
            this.f11251a = mimeType;
        }

        @Override // b.a
        @a7.d
        @c.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f11251a).putExtra("android.intent.extra.TITLE", input);
            l0.o(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intentPutExtra;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final b.a.C0134a<Uri> b(@a7.d Context context, @a7.d String input) {
            l0.p(context, "context");
            l0.p(input, "input");
            return null;
        }

        @Override // b.a
        @a7.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i7, @a7.e Intent intent) {
            if (!(i7 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @kotlin.k(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @kotlin.b1(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public C0135b() {
            this("*/*");
        }
    }
}
