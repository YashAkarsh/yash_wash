package org.apache.commons.collections4.sequence;

/* JADX INFO: loaded from: classes3.dex */
public class InsertCommand<T> extends EditCommand<T> {
    public InsertCommand(T t7) {
        super(t7);
    }

    @Override // org.apache.commons.collections4.sequence.EditCommand
    public void accept(CommandVisitor<T> commandVisitor) {
        commandVisitor.visitInsertCommand(getObject());
    }
}
