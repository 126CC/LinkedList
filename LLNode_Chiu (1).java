public class LLNode_Chiu<T> implements NodeInterface<T> {
  private T data;
  private LLNode_Chiu<T> next;

  public LLNode_Chiu(T data) {
    this.data = data;
    next = null;
  }


public T getData() {
  return data;
}

public void setData(T data) {
  this.data = data;
}

public LLNode_Chiu<T> getNext() {
  return next;
}

public void setNext(LLNode_Chiu<T> newNext) {
  next = (LLNode_Chiu<T>)newNext;
}
}