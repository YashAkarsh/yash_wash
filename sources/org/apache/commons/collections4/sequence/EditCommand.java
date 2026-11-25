package org.apache.commons.collections4.sequence;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EditCommand<T> {
    private final T object;

    protected EditCommand(T t7) {
        this.object = t7;
    }

    public abstract void accept(CommandVisitor<T> commandVisitor);

    protected T getObject() {
        return this.object;
    }
}
