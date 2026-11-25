package com.haier.globalwasher.mvp_api.volley.myvolley;

import android.graphics.Bitmap;
import android.util.Log;
import com.haier.globalwasher.mvp_api.volley.toolbox.l;

/* JADX INFO: loaded from: classes2.dex */
public class a extends androidx.collection.g<String, Bitmap> implements l.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f24847i;

    public a(int i7) {
        super(i7);
        this.f24847i = getClass().getSimpleName();
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.f
    public Bitmap a(String str) {
        Log.v(this.f24847i, "Retrieved item from Mem Cache");
        return h(str);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.f
    public void b(String str, Bitmap bitmap) {
        Log.v(this.f24847i, "Added item to Mem Cache");
        l(str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.g
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int r(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
