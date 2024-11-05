package main.java.com.example.designpatterns.chp9_iterator_and_composite.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
    private final Stack iteratorStack;

    // 최상위 복합 객체의 반복자가 매개변수로 전달 됨
    public CompositeIterator(final Iterator<MenuComponent> iterator) {
        iteratorStack = new Stack();
        iteratorStack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (iteratorStack.isEmpty()) { // 스택이 비어있으면
            return false; // 다음 원소는 없다.
        } else { // 스택이 비어있지 않으면
            final var iterator = (Iterator) iteratorStack.peek(); // 최신 반복자를 꺼내서
            if (!iterator.hasNext()) { // 다음 원소가 없으면
                iteratorStack.pop(); // 이터레이터를 스택에서 꺼내고
                return hasNext();
            } else { // 다음 원소가 있으면
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()) { // 다음 원소가 남아 있으면
            final var iterator = (Iterator) iteratorStack.peek(); // 최산 반복자를 꺼내서
            final var component = iterator.next(); // 다음 값을 꺼내오고

            if (component instanceof Menu) { // 다음 값이 메뉴이면
                iteratorStack.push(((Menu) component).createIterator()); // 이터레이터 스택에 넣고
            }
            return component; // 리턴
        } else { // 다음 원소가 남아 있지 않으면
            return null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
