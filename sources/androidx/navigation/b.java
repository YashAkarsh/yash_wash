package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import c.m0;
import c.o0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@w.b("activity")
public class b extends w<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8783c = "android-support-navigation:ActivityNavigator:source";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8784d = "android-support-navigation:ActivityNavigator:current";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8785e = "android-support-navigation:ActivityNavigator:popEnterAnim";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8786f = "android-support-navigation:ActivityNavigator:popExitAnim";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f8788b;

    @l.a(Activity.class)
    public static class a extends l {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Intent f8789j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f8790k;

        public a(@m0 x xVar) {
            this((w<? extends a>) xVar.d(b.class));
        }

        @Override // androidx.navigation.l
        boolean G() {
            return false;
        }

        @o0
        public final String H() {
            Intent intent = this.f8789j;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @o0
        public final ComponentName I() {
            Intent intent = this.f8789j;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        @o0
        public final Uri J() {
            Intent intent = this.f8789j;
            if (intent == null) {
                return null;
            }
            return intent.getData();
        }

        @o0
        public final String K() {
            return this.f8790k;
        }

        @o0
        public final Intent L() {
            return this.f8789j;
        }

        @o0
        public final String M() {
            Intent intent = this.f8789j;
            if (intent == null) {
                return null;
            }
            return intent.getPackage();
        }

        @m0
        public final a N(@o0 String str) {
            if (this.f8789j == null) {
                this.f8789j = new Intent();
            }
            this.f8789j.setAction(str);
            return this;
        }

        @m0
        public final a O(@o0 ComponentName componentName) {
            if (this.f8789j == null) {
                this.f8789j = new Intent();
            }
            this.f8789j.setComponent(componentName);
            return this;
        }

        @m0
        public final a P(@o0 Uri uri) {
            if (this.f8789j == null) {
                this.f8789j = new Intent();
            }
            this.f8789j.setData(uri);
            return this;
        }

        @m0
        public final a Q(@o0 String str) {
            this.f8790k = str;
            return this;
        }

        @m0
        public final a S(@o0 Intent intent) {
            this.f8789j = intent;
            return this;
        }

        @m0
        public final a T(@o0 String str) {
            if (this.f8789j == null) {
                this.f8789j = new Intent();
            }
            this.f8789j.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.l
        @m0
        public String toString() {
            ComponentName componentNameI = I();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentNameI != null) {
                sb.append(" class=");
                sb.append(componentNameI.getClassName());
            } else {
                String strH = H();
                if (strH != null) {
                    sb.append(" action=");
                    sb.append(strH);
                }
            }
            return sb.toString();
        }

        @Override // androidx.navigation.l
        @c.i
        public void u(@m0 Context context, @m0 AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = typedArrayObtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace(s.f8903g, context.getPackageName());
            }
            T(string);
            String string2 = typedArrayObtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                O(new ComponentName(context, string2));
            }
            N(typedArrayObtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = typedArrayObtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                P(Uri.parse(string3));
            }
            Q(typedArrayObtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            typedArrayObtainAttributes.recycle();
        }

        public a(@m0 w<? extends a> wVar) {
            super(wVar);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.b$b, reason: collision with other inner class name */
    public static final class C0112b implements w.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.app.i f8792b;

        /* JADX INFO: renamed from: androidx.navigation.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f8793a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private androidx.core.app.i f8794b;

            @m0
            public a a(int i7) {
                this.f8793a = i7 | this.f8793a;
                return this;
            }

            @m0
            public C0112b b() {
                return new C0112b(this.f8793a, this.f8794b);
            }

            @m0
            public a c(@m0 androidx.core.app.i iVar) {
                this.f8794b = iVar;
                return this;
            }
        }

        C0112b(int i7, @o0 androidx.core.app.i iVar) {
            this.f8791a = i7;
            this.f8792b = iVar;
        }

        @o0
        public androidx.core.app.i a() {
            return this.f8792b;
        }

        public int b() {
            return this.f8791a;
        }
    }

    public b(@m0 Context context) {
        this.f8787a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f8788b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public static void f(@m0 Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(f8785e, -1);
        int intExtra2 = intent.getIntExtra(f8786f, -1);
        if (intExtra == -1 && intExtra2 == -1) {
            return;
        }
        if (intExtra == -1) {
            intExtra = 0;
        }
        if (intExtra2 == -1) {
            intExtra2 = 0;
        }
        activity.overridePendingTransition(intExtra, intExtra2);
    }

    @Override // androidx.navigation.w
    public boolean e() {
        Activity activity = this.f8788b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.w
    @m0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a a() {
        return new a(this);
    }

    @m0
    final Context h() {
        return this.f8787a;
    }

    @Override // androidx.navigation.w
    @o0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public l b(@m0 a aVar, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar2) {
        androidx.core.app.i iVarA;
        Intent intent;
        int intExtra;
        if (aVar.L() == null) {
            throw new IllegalStateException("Destination " + aVar.m() + " does not have an Intent set.");
        }
        Intent intent2 = new Intent(aVar.L());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String strK = aVar.K();
            if (!TextUtils.isEmpty(strK)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(strK);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (!bundle.containsKey(strGroup)) {
                        throw new IllegalArgumentException("Could not find " + strGroup + " in " + bundle + " to fill data pattern " + strK);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(strGroup).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z7 = aVar2 instanceof C0112b;
        if (z7) {
            intent2.addFlags(((C0112b) aVar2).b());
        }
        if (!(this.f8787a instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        if (tVar != null && tVar.g()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.f8788b;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra(f8784d, 0)) != 0) {
            intent2.putExtra(f8783c, intExtra);
        }
        intent2.putExtra(f8784d, aVar.m());
        if (tVar != null) {
            intent2.putExtra(f8785e, tVar.c());
            intent2.putExtra(f8786f, tVar.d());
        }
        if (!z7 || (iVarA = ((C0112b) aVar2).a()) == null) {
            this.f8787a.startActivity(intent2);
        } else {
            androidx.core.content.d.t(this.f8787a, intent2, iVarA.l());
        }
        if (tVar == null || this.f8788b == null) {
            return null;
        }
        int iA = tVar.a();
        int iB = tVar.b();
        if (iA == -1 && iB == -1) {
            return null;
        }
        if (iA == -1) {
            iA = 0;
        }
        this.f8788b.overridePendingTransition(iA, iB != -1 ? iB : 0);
        return null;
    }
}
