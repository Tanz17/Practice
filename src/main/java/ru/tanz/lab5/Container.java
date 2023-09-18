package ru.tanz.lab5;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Container {
    List<Integer> list;

    public Container() {
        this.list = new ArrayList<>();
    }
    public int get(int index){
        return list.get(index);
    }
    public int getSize(){
        return list.size();
    }
    public void add(int value) {
        list.add(value);
    }
    public Container add(Container container){
        Container result = new Container();
        for (int i = 0; i < getSize(); i++) {
            result.add(get(i) + container.get(i));
        }
        return result;
    }
    public void shiftLeft(int n) {
        for (int i = 0; i < n; i++) {
            list.remove(0);
            list.add(list.get(0));
        }
    }
}
