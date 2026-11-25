package org.apache.commons.collections4.list;

import com.alibaba.android.arouter.utils.b;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

/* JADX INFO: loaded from: classes3.dex */
public class TreeList<E> extends AbstractList<E> {
    private AVLNode<E> root;
    private int size;

    static class TreeListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        private AVLNode<E> current;
        private int currentIndex;
        private int expectedModCount;
        private AVLNode<E> next;
        private int nextIndex;
        private final TreeList<E> parent;

        protected TreeListIterator(TreeList<E> treeList, int i7) throws IndexOutOfBoundsException {
            this.parent = treeList;
            this.expectedModCount = ((AbstractList) treeList).modCount;
            this.next = ((TreeList) treeList).root == null ? null : ((TreeList) treeList).root.get(i7);
            this.nextIndex = i7;
            this.currentIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e8) {
            checkModCount();
            this.parent.add(this.nextIndex, e8);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }

        protected void checkModCount() {
            if (((AbstractList) this.parent).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException("No element at index " + this.nextIndex + b.f12515h);
            }
            if (this.next == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex);
            }
            E value = this.next.getValue();
            AVLNode<E> aVLNode = this.next;
            this.current = aVLNode;
            int i7 = this.nextIndex;
            this.nextIndex = i7 + 1;
            this.currentIndex = i7;
            this.next = aVLNode.next();
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            AVLNode<E> aVLNode = this.next;
            if (aVLNode == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex - 1);
            } else {
                this.next = aVLNode.previous();
            }
            E value = this.next.getValue();
            this.current = this.next;
            int i7 = this.nextIndex - 1;
            this.nextIndex = i7;
            this.currentIndex = i7;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            int i7 = this.currentIndex;
            if (i7 == -1) {
                throw new IllegalStateException();
            }
            this.parent.remove(i7);
            int i8 = this.nextIndex;
            if (i8 != this.currentIndex) {
                this.nextIndex = i8 - 1;
            }
            this.next = null;
            this.current = null;
            this.currentIndex = -1;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e8) {
            checkModCount();
            AVLNode<E> aVLNode = this.current;
            if (aVLNode == null) {
                throw new IllegalStateException();
            }
            aVLNode.setValue(e8);
        }
    }

    public TreeList() {
    }

    private void checkInterval(int i7, int i8, int i9) {
        if (i7 < i8 || i7 > i9) {
            throw new IndexOutOfBoundsException("Invalid index:" + i7 + ", size=" + size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, E e8) {
        ((AbstractList) this).modCount++;
        checkInterval(i7, 0, size());
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode<>(i7, e8, null, null);
        } else {
            this.root = aVLNode.insert(i7, e8);
        }
        this.size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount += collection.size();
        AVLNode<E> aVLNode = new AVLNode<>(collection);
        AVLNode<E> aVLNode2 = this.root;
        if (aVLNode2 != null) {
            aVLNode = aVLNode2.addAll(aVLNode, this.size);
        }
        this.root = aVLNode;
        this.size += collection.size();
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ((AbstractList) this).modCount++;
        this.root = null;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i7) {
        checkInterval(i7, 0, size() - 1);
        return this.root.get(i7).getValue();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, ((AVLNode) aVLNode).relativePosition);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i7) {
        ((AbstractList) this).modCount++;
        checkInterval(i7, 0, size() - 1);
        E e8 = get(i7);
        this.root = this.root.remove(i7);
        this.size--;
        return e8;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i7, E e8) {
        checkInterval(i7, 0, size() - 1);
        AVLNode<E> aVLNode = this.root.get(i7);
        E e9 = (E) ((AVLNode) aVLNode).value;
        aVLNode.setValue(e8);
        return e9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode<E> aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, ((AVLNode) aVLNode).relativePosition);
        }
        return objArr;
    }

    static class AVLNode<E> {
        private int height;
        private AVLNode<E> left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode<E> right;
        private boolean rightIsNext;
        private E value;

        /* JADX INFO: Access modifiers changed from: private */
        public AVLNode<E> addAll(AVLNode<E> aVLNode, int i7) {
            int i8;
            int i9;
            AVLNode<E> aVLNodeMax = max();
            AVLNode<E> aVLNodeMin = aVLNode.min();
            int i10 = 0;
            if (aVLNode.height <= this.height) {
                AVLNode<E> aVLNodeRemoveMin = aVLNode.removeMin();
                ArrayDeque arrayDeque = new ArrayDeque();
                int i11 = this.relativePosition;
                AVLNode<E> aVLNode2 = this;
                loop3: while (true) {
                    int i12 = i10;
                    i10 = i11;
                    i8 = i12;
                    while (true) {
                        if (aVLNode2 == null || aVLNode2.height <= getHeight(aVLNodeRemoveMin)) {
                            break loop3;
                        }
                        arrayDeque.push(aVLNode2);
                        aVLNode2 = aVLNode2.right;
                        if (aVLNode2 != null) {
                            break;
                        }
                        i8 = i10;
                    }
                    i11 = aVLNode2.relativePosition + i10;
                }
                aVLNodeMin.setRight(aVLNodeRemoveMin, null);
                aVLNodeMin.setLeft(aVLNode2, aVLNodeMax);
                if (aVLNodeRemoveMin != null) {
                    aVLNodeRemoveMin.min().setLeft(null, aVLNodeMin);
                    aVLNodeRemoveMin.relativePosition++;
                }
                if (aVLNode2 != null) {
                    aVLNode2.max().setRight(null, aVLNodeMin);
                    aVLNode2.relativePosition = i10 - i7;
                }
                aVLNodeMin.relativePosition = i7 - i8;
                while (!arrayDeque.isEmpty()) {
                    AVLNode aVLNode3 = (AVLNode) arrayDeque.pop();
                    aVLNode3.setRight(aVLNodeMin, null);
                    aVLNodeMin = aVLNode3.balance();
                }
                return aVLNodeMin;
            }
            AVLNode<E> aVLNodeRemoveMax = removeMax();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int i13 = aVLNode.relativePosition + i7;
            AVLNode<E> aVLNode4 = aVLNode;
            loop0: while (true) {
                int i14 = i13;
                i9 = i10;
                i10 = i14;
                while (true) {
                    if (aVLNode4 == null || aVLNode4.height <= getHeight(aVLNodeRemoveMax)) {
                        break loop0;
                    }
                    arrayDeque2.push(aVLNode4);
                    aVLNode4 = aVLNode4.left;
                    if (aVLNode4 != null) {
                        break;
                    }
                    i9 = i10;
                }
                i13 = aVLNode4.relativePosition + i10;
            }
            aVLNodeMax.setLeft(aVLNodeRemoveMax, null);
            aVLNodeMax.setRight(aVLNode4, aVLNodeMin);
            if (aVLNodeRemoveMax != null) {
                aVLNodeRemoveMax.max().setRight(null, aVLNodeMax);
                aVLNodeRemoveMax.relativePosition -= i7 - 1;
            }
            if (aVLNode4 != null) {
                aVLNode4.min().setLeft(null, aVLNodeMax);
                aVLNode4.relativePosition = (i10 - i7) + 1;
            }
            aVLNodeMax.relativePosition = (i7 - 1) - i9;
            aVLNode.relativePosition += i7;
            while (!arrayDeque2.isEmpty()) {
                AVLNode aVLNode5 = (AVLNode) arrayDeque2.pop();
                aVLNode5.setLeft(aVLNodeMax, null);
                aVLNodeMax = aVLNode5.balance();
            }
            return aVLNodeMax;
        }

        private AVLNode<E> balance() {
            int iHeightRightMinusLeft = heightRightMinusLeft();
            if (iHeightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (iHeightRightMinusLeft == -1 || iHeightRightMinusLeft == 0 || iHeightRightMinusLeft == 1) {
                return this;
            }
            if (iHeightRightMinusLeft != 2) {
                throw new RuntimeException("tree inconsistent!");
            }
            if (this.right.heightRightMinusLeft() < 0) {
                setRight(this.right.rotateRight(), null);
            }
            return rotateLeft();
        }

        private int getHeight(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private AVLNode<E> getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private int getOffset(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private AVLNode<E> getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode<E> insertOnLeft(int i7, E e8) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode<>(-1, e8, this, this.left), null);
            } else {
                setLeft(this.left.insert(i7, e8), null);
            }
            int i8 = this.relativePosition;
            if (i8 >= 0) {
                this.relativePosition = i8 + 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> insertOnRight(int i7, E e8) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode<>(1, e8, this.right, this), null);
            } else {
                setRight(this.right.insert(i7, e8), null);
            }
            int i8 = this.relativePosition;
            if (i8 < 0) {
                this.relativePosition = i8 - 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode<E> min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private AVLNode<E> removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i7 = this.relativePosition;
            if (i7 < 0) {
                this.relativePosition = i7 + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i7 = this.relativePosition;
            if (i7 > 0) {
                this.relativePosition = i7 - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i7 = this.relativePosition;
                if (i7 > 0) {
                    this.left.relativePosition += i7 + (i7 <= 0 ? 1 : 0);
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode<E> aVLNode = this.right;
                int i8 = aVLNode.relativePosition;
                int i9 = this.relativePosition;
                aVLNode.relativePosition = i8 + (i9 - (i9 >= 0 ? 1 : 0));
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode<E> aVLNodeMin = this.right.min();
                this.value = aVLNodeMin.value;
                if (this.leftIsPrevious) {
                    this.left = aVLNodeMin.left;
                }
                this.right = this.right.removeMin();
                int i10 = this.relativePosition;
                if (i10 < 0) {
                    this.relativePosition = i10 + 1;
                }
            } else {
                AVLNode<E> aVLNodeMax = this.left.max();
                this.value = aVLNodeMax.value;
                if (this.rightIsNext) {
                    this.right = aVLNodeMax.right;
                }
                AVLNode<E> aVLNode2 = this.left;
                AVLNode<E> aVLNode3 = aVLNode2.left;
                AVLNode<E> aVLNodeRemoveMax = aVLNode2.removeMax();
                this.left = aVLNodeRemoveMax;
                if (aVLNodeRemoveMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i11 = this.relativePosition;
                if (i11 > 0) {
                    this.relativePosition = i11 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode<E> rotateLeft() {
            AVLNode<E> aVLNode = this.right;
            AVLNode<E> leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i7 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i7);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode<E> rotateRight() {
            AVLNode<E> aVLNode = this.left;
            AVLNode<E> rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i7 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i7);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z7 = aVLNode == null;
            this.leftIsPrevious = z7;
            if (z7) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private int setOffset(AVLNode<E> aVLNode, int i7) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i7;
            return offset;
        }

        private void setRight(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z7 = aVLNode == null;
            this.rightIsNext = z7;
            if (z7) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        AVLNode<E> get(int i7) {
            int i8 = i7 - this.relativePosition;
            if (i8 == 0) {
                return this;
            }
            AVLNode<E> leftSubTree = i8 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i8);
        }

        E getValue() {
            return this.value;
        }

        int indexOf(Object obj, int i7) {
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                int iIndexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i7);
                if (iIndexOf != -1) {
                    return iIndexOf;
                }
            }
            E e8 = this.value;
            if (e8 != null ? e8.equals(obj) : e8 == obj) {
                return i7;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode<E> aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i7 + aVLNode2.relativePosition);
        }

        AVLNode<E> insert(int i7, E e8) {
            int i8 = i7 - this.relativePosition;
            return i8 <= 0 ? insertOnLeft(i8, e8) : insertOnRight(i8, e8);
        }

        AVLNode<E> next() {
            AVLNode<E> aVLNode;
            return (this.rightIsNext || (aVLNode = this.right) == null) ? this.right : aVLNode.min();
        }

        AVLNode<E> previous() {
            AVLNode<E> aVLNode;
            return (this.leftIsPrevious || (aVLNode = this.left) == null) ? this.left : aVLNode.max();
        }

        AVLNode<E> remove(int i7) {
            int i8 = i7 - this.relativePosition;
            if (i8 == 0) {
                return removeSelf();
            }
            if (i8 > 0) {
                setRight(this.right.remove(i8), this.right.right);
                int i9 = this.relativePosition;
                if (i9 < 0) {
                    this.relativePosition = i9 + 1;
                }
            } else {
                setLeft(this.left.remove(i8), this.left.left);
                int i10 = this.relativePosition;
                if (i10 > 0) {
                    this.relativePosition = i10 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        void setValue(E e8) {
            this.value = e8;
        }

        void toArray(Object[] objArr, int i7) {
            objArr[i7] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i7);
            }
            if (getRightSubTree() != null) {
                AVLNode<E> aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i7 + aVLNode2.relativePosition);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AVLNode(");
            sb.append(this.relativePosition);
            sb.append(',');
            sb.append(this.left != null);
            sb.append(',');
            sb.append(this.value);
            sb.append(',');
            sb.append(getRightSubTree() != null);
            sb.append(", faedelung ");
            sb.append(this.rightIsNext);
            sb.append(" )");
            return sb.toString();
        }

        private AVLNode(int i7, E e8, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            this.relativePosition = i7;
            this.value = e8;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        private AVLNode(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
        }

        private AVLNode(Iterator<? extends E> it, int i7, int i8, int i9, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            int i10 = i7 + ((i8 - i7) / 2);
            if (i7 < i10) {
                this.left = new AVLNode<>(it, i7, i10 - 1, i10, aVLNode, this);
            } else {
                this.leftIsPrevious = true;
                this.left = aVLNode;
            }
            this.value = it.next();
            this.relativePosition = i10 - i9;
            if (i10 < i8) {
                this.right = new AVLNode<>(it, i10 + 1, i8, i10, this, aVLNode2);
            } else {
                this.rightIsNext = true;
                this.right = aVLNode2;
            }
            recalcHeight();
        }
    }

    public TreeList(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.root = new AVLNode<>(collection);
        this.size = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i7) {
        checkInterval(i7, 0, size());
        return new TreeListIterator(this, i7);
    }
}
