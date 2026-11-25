package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

/* JADX INFO: loaded from: classes.dex */
public interface CallbackManager {

    public static class Factory {
        public static CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i7, int i8, Intent intent);
}
