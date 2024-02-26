public class LL_Chiu<T> implements LinkedListInterface<T> {
  LLNode_Chiu<T> first;
  public LL_Chiu() {
    first = null;
  }

  public boolean contains(T element) {
    if (first == null) {
      return false;
    }
    LLNode_Chiu<T> current;
    current = first;
    while (current != null) {
      if (current.getData().equals(element)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public int indexOf(T element) {
    if (first == null) {
      return -1;
    }
    LLNode_Chiu<T> current;
    current = first;
    int index = 0;
    while (!(current.getData().equals(element))) {
      if (current.getNext() == null) {
        return -1;
      }
      current = current.getNext();
      index++;
    }
    return index;
  }

  public int lastIndexOf(T element) {
    if (first == null) {
      return -1;
    }
    LLNode_Chiu<T> current;
    current = first;
    int index = 0;
    int lastIndex = 0;
    while (current.getNext() != null) {
      if (current.getData().equals(element)) {
        lastIndex = index;
      }
      current = current.getNext();
      index++;
    }
    if(current.getData() == element) {
      lastIndex = index;
    }
    return lastIndex;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    int count = 0;
    LLNode_Chiu<T> current;
    current = first;
    if (first != null) {
      count++;
      while (current.getNext() != null) {
        current = current.getNext();
        count++;
      }
    }
    return count;
  }

  public void clear() {
    first = null;
  }

  public T get(int index) {
    if (first == null) {
      throw new IndexOutOfBoundsException();
    }
    if ((index + 1 > size()) || (index < 0)) {
      throw new IndexOutOfBoundsException();
    }
    LLNode_Chiu<T> current = first;
    int currentIndex = 0;
    while (currentIndex != index) {
      current = current.getNext();
      currentIndex++;
    }
    return current.getData();
  }

  public T set(int index, T element) {
    LLNode_Chiu<T> current;
    T data;
    current = first;
    int currentIndex = 0;
    if (first == null) {
      throw new IndexOutOfBoundsException();
    }
    if ((index + 1 > size()) || (index < 0)) {
      throw new IndexOutOfBoundsException();
    }
    while (currentIndex != index) {
      current = current.getNext();
      currentIndex++;
    }
    data = current.getData();
    current.setData(element);
    return data;
  }

  public void add(T element) {
    LLNode_Chiu newNode = new LLNode_Chiu(element);
    LLNode_Chiu <T> nextNode;
    if (first == null) {
      first = newNode;
    } else {
      nextNode = first;
      while (nextNode.getNext() != null)
        nextNode = nextNode.getNext();
      nextNode.setNext(newNode);
    }
    
  }

  public void add(int index, T element) {
    if ((index > size()) || (index < 0)) {
      throw new IndexOutOfBoundsException();
    }

    LLNode_Chiu<T> prevNode, nextNode;
    prevNode = null;
    nextNode = first;
    LLNode_Chiu<T> newNode = new LLNode_Chiu<T>(element);
    int currentIndex = 0;

    if(first == null) {
      first = newNode;
    }
    if(index == 0) {
      newNode.setNext(first);
      first = newNode;
    } else {
      while(nextNode != null) {
        if(currentIndex == index) {
          prevNode.setNext(newNode);
          newNode.setNext(nextNode);
          break;
        }
        prevNode = nextNode;
        nextNode = nextNode.getNext();
        currentIndex++;
      }
    }
  }

  public boolean remove(T element) {
    LLNode_Chiu<T> prevNode, nextNode;
    if (first == null) {
      return false;
    }
    prevNode = first;
    nextNode = first;
    if(first.getNext() == null) {
      if(first.getData().equals(element)) {
        first = null;
        return true;
      }
    }

    while (!(nextNode.getData().equals(element))) {
      if(nextNode.getNext() == null) {
        return false;
      }
        prevNode = nextNode;
        nextNode = nextNode.getNext();
      }
      prevNode.setNext(nextNode.getNext());
      return true;
  }

  public T remove(int index) {
    LLNode_Chiu<T> prevNode, nextNode;
    prevNode = null;
    nextNode = first;
    int currentIndex = 0;
    if (index == 0) {
      first = first.getNext();
    }

    if ((index < 0) || (index + 1 > size())) {
      throw new IndexOutOfBoundsException();
    }

    if ((index != 0) && (index > 0)) {
      while (index != currentIndex) {
        if(currentIndex == index) {
          prevNode.setNext(nextNode.getNext());
          return nextNode.getData();
        }
        prevNode = nextNode;
        nextNode = nextNode.getNext();
        currentIndex++;
      }
    }
    prevNode.setNext(nextNode.getNext());

    return nextNode.getData();
  }
}
