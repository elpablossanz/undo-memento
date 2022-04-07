package com.kreitek.editor;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    List<Memento> mementos = new ArrayList<>();
    public void add(Memento state){
        mementos.add(state);
    }

    public Memento get(){
        if(mementos.size() > 0){
            Memento memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);
            return memento;

        }
        return null;
    }
}
