package org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    private o() {
    }

    static void a(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
        }
    }

    static void b(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("ByteBuffer is already full.");
        }
    }
}
