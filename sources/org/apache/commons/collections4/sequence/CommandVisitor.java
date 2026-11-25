package org.apache.commons.collections4.sequence;

/* JADX INFO: loaded from: classes3.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t7);

    void visitInsertCommand(T t7);

    void visitKeepCommand(T t7);
}
