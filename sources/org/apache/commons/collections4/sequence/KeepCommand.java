package org.apache.commons.collections4.sequence;

/* JADX INFO: loaded from: classes3.dex */
public class KeepCommand<T> extends EditCommand<T> {
    public KeepCommand(T t7) {
        super(t7);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitKeepCommand(getObject());
    }
}
