package com.bumptech.glide.load.data;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class k extends h<InputStream> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14229e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f14230f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14231g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f14232h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final UriMatcher f14233i;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f14233i = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public k(Context context, Uri uri) {
        super(context, uri);
    }

    private InputStream h(Uri uri, ContentResolver contentResolver, int i7) throws FileNotFoundException {
        if (i7 != 1 && i7 != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i7 == 1 && (uri = ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return i(contentResolver, uri);
    }

    @TargetApi(14)
    private InputStream i(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.h
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.h
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public InputStream e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        return h(uri, contentResolver, f14233i.match(uri));
    }
}
