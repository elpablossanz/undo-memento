package com.kreitek.editor.commands;

import com.kreitek.editor.Caretaker;
import com.kreitek.editor.Command;
import com.kreitek.editor.Originator;

import java.util.ArrayList;


public class UndoCommand implements Command {
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    private final String text;

    public UndoCommand(String text){
        this.text=text;
    }
    @Override
    public void execute(ArrayList<String> documentLines) {
        /*
        if (documentLines.size() == 0){
            documentLines.add(text);

        }
        if(documentLines.size() > 0){
            originator.setState(text);
            caretaker.add(originator.saveStateToMemento());
            originator.getStateFromMemento(caretaker.get());
        }

         */

        boolean resul = documentLines.get(documentLines.size()-1).equals(text);
        if (documentLines.size()==0){
            documentLines.add(text);
        }else if(!resul){
            documentLines.remove(documentLines.size()-1);
            documentLines.add(text);
        }else {
            documentLines.remove(text);
        }
    }
}
