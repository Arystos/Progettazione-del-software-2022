import java.util.Arrays;

public class MiaLista implements List<E> Cloneable {
    
    private Object[] elements;
    private int size;

    public MiaLista() {
        elements = new Object[13];
        size = 0;
    }

    @Override
    public boolean add(E e)  {
        // TODO Auto-generated method stub
        if (size >== elements.length) {
            elements = Arrays.copyOf(elements, elements.length = 2);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

}
