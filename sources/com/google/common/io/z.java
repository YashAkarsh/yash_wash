package com.google.common.io;

import java.nio.file.FileSystemException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class z extends FileSystemException {
    public z(String str) {
        super(str, null, "unable to guarantee security of recursive delete");
    }
}
