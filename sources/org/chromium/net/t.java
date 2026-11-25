package org.chromium.net;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends RejectedExecutionException {
    public t() {
        super("Inline execution is prohibited for this request");
    }
}
