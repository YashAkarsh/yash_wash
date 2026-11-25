package com.alibaba.android.arouter.facade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.app.i;
import c.o0;
import c.t0;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.a;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Postcard extends RouteMeta {
    private String action;
    private int enterAnim;
    private int exitAnim;
    private int flags;
    private boolean greenChannel;
    private Bundle mBundle;
    private Bundle optionsCompat;
    private IProvider provider;
    private SerializationService serializationService;
    private Object tag;
    private int timeout;
    private Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagInt {
    }

    public Postcard() {
        this(null, null);
    }

    public String getAction() {
        return this.action;
    }

    public int getEnterAnim() {
        return this.enterAnim;
    }

    public int getExitAnim() {
        return this.exitAnim;
    }

    public Bundle getExtras() {
        return this.mBundle;
    }

    public int getFlags() {
        return this.flags;
    }

    public Bundle getOptionsBundle() {
        return this.optionsCompat;
    }

    public IProvider getProvider() {
        return this.provider;
    }

    public Object getTag() {
        return this.tag;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Uri getUri() {
        return this.uri;
    }

    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public boolean isGreenChannel() {
        return this.greenChannel;
    }

    public Object navigation() {
        return navigation(null);
    }

    public Postcard setProvider(IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public Postcard setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public Postcard setTimeout(int i7) {
        this.timeout = i7;
        return this;
    }

    public Postcard setUri(Uri uri) {
        this.uri = uri;
        return this;
    }

    @Override // com.alibaba.android.arouter.facade.model.RouteMeta
    public String toString() {
        return "Postcard{uri=" + this.uri + ", tag=" + this.tag + ", mBundle=" + this.mBundle + ", flags=" + this.flags + ", timeout=" + this.timeout + ", provider=" + this.provider + ", greenChannel=" + this.greenChannel + ", optionsCompat=" + this.optionsCompat + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + "}\n" + super.toString();
    }

    public Postcard with(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public Postcard withAction(String str) {
        this.action = str;
        return this;
    }

    public Postcard withBoolean(@o0 String str, boolean z7) {
        this.mBundle.putBoolean(str, z7);
        return this;
    }

    public Postcard withBundle(@o0 String str, @o0 Bundle bundle) {
        this.mBundle.putBundle(str, bundle);
        return this;
    }

    public Postcard withByte(@o0 String str, byte b8) {
        this.mBundle.putByte(str, b8);
        return this;
    }

    public Postcard withByteArray(@o0 String str, @o0 byte[] bArr) {
        this.mBundle.putByteArray(str, bArr);
        return this;
    }

    public Postcard withChar(@o0 String str, char c8) {
        this.mBundle.putChar(str, c8);
        return this;
    }

    public Postcard withCharArray(@o0 String str, @o0 char[] cArr) {
        this.mBundle.putCharArray(str, cArr);
        return this;
    }

    public Postcard withCharSequence(@o0 String str, @o0 CharSequence charSequence) {
        this.mBundle.putCharSequence(str, charSequence);
        return this;
    }

    public Postcard withCharSequenceArray(@o0 String str, @o0 CharSequence[] charSequenceArr) {
        this.mBundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public Postcard withCharSequenceArrayList(@o0 String str, @o0 ArrayList<CharSequence> arrayList) {
        this.mBundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public Postcard withDouble(@o0 String str, double d8) {
        this.mBundle.putDouble(str, d8);
        return this;
    }

    public Postcard withFlags(int i7) {
        this.flags = i7;
        return this;
    }

    public Postcard withFloat(@o0 String str, float f8) {
        this.mBundle.putFloat(str, f8);
        return this;
    }

    public Postcard withFloatArray(@o0 String str, @o0 float[] fArr) {
        this.mBundle.putFloatArray(str, fArr);
        return this;
    }

    public Postcard withInt(@o0 String str, int i7) {
        this.mBundle.putInt(str, i7);
        return this;
    }

    public Postcard withIntegerArrayList(@o0 String str, @o0 ArrayList<Integer> arrayList) {
        this.mBundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public Postcard withLong(@o0 String str, long j7) {
        this.mBundle.putLong(str, j7);
        return this;
    }

    public Postcard withObject(@o0 String str, @o0 Object obj) {
        SerializationService serializationService = (SerializationService) a.i().o(SerializationService.class);
        this.serializationService = serializationService;
        this.mBundle.putString(str, serializationService.object2Json(obj));
        return this;
    }

    @t0(16)
    public Postcard withOptionsCompat(i iVar) {
        if (iVar != null) {
            this.optionsCompat = iVar.l();
        }
        return this;
    }

    public Postcard withParcelable(@o0 String str, @o0 Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    public Postcard withParcelableArray(@o0 String str, @o0 Parcelable[] parcelableArr) {
        this.mBundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public Postcard withParcelableArrayList(@o0 String str, @o0 ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public Postcard withSerializable(@o0 String str, @o0 Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    public Postcard withShort(@o0 String str, short s7) {
        this.mBundle.putShort(str, s7);
        return this;
    }

    public Postcard withShortArray(@o0 String str, @o0 short[] sArr) {
        this.mBundle.putShortArray(str, sArr);
        return this;
    }

    public Postcard withSparseParcelableArray(@o0 String str, @o0 SparseArray<? extends Parcelable> sparseArray) {
        this.mBundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public Postcard withString(@o0 String str, @o0 String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    public Postcard withStringArrayList(@o0 String str, @o0 ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
        return this;
    }

    public Postcard withTransition(int i7, int i8) {
        this.enterAnim = i7;
        this.exitAnim = i8;
        return this;
    }

    public Postcard(String str, String str2) {
        this(str, str2, null, null);
    }

    public Object navigation(Context context) {
        return navigation(context, (NavigationCallback) null);
    }

    public Postcard(String str, String str2, Uri uri, Bundle bundle) {
        this.flags = -1;
        this.timeout = 300;
        this.enterAnim = -1;
        this.exitAnim = -1;
        setPath(str);
        setGroup(str2);
        setUri(uri);
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public Object navigation(Context context, NavigationCallback navigationCallback) {
        return a.i().n(context, this, -1, navigationCallback);
    }

    public void navigation(Activity activity, int i7) {
        navigation(activity, i7, null);
    }

    public void navigation(Activity activity, int i7, NavigationCallback navigationCallback) {
        a.i().n(activity, this, i7, navigationCallback);
    }
}
