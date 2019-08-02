package com.plietnov.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetArrayList<T> extends ArrayList<T> {

    private static final String EXCEPTION_ARGUMENT_ALREADY_EXIST = "Argument already exist";

    @Override
    public boolean add(T o) {
        if (contains(o)) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        return super.add(o);
    }

    @Override
    public void add(int index, T element) {
        if (contains(element)) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (checkDuplicate(c) || checkCrossing(this, c)) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        return super.addAll(c);
    }

    @Override
    public T set(int index, T element) {
        if (contains(element) && !element.equals(get(index))) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        return super.set(index, element);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (checkDuplicate(c) || checkCrossing(this, c)) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        return super.addAll(index, c);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        List<T> copyList = new ArrayList<>();
        this.forEach(o -> copyList.add(operator.apply(o)));
        if (checkDuplicate(copyList)) {
            throw new IllegalArgumentException(EXCEPTION_ARGUMENT_ALREADY_EXIST);
        }
        clear();
        addAll(copyList);
    }

    private boolean checkDuplicate(Collection<? extends T> c) {
        HashSet<T> unique = new HashSet<>(c);
        return unique.size() != c.size();
    }

    private boolean checkCrossing(Collection<? extends T> firstList, Collection<? extends T> secondList) {
        for (T t : firstList) {
            if (secondList.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
