package com.kreitek.editor.commands;

import com.kreitek.editor.*;

public class CommandFactory {
    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    String text;
    private static final CommandParser commandParser = new CommandParser();
    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        ConsoleEditor console = new ConsoleEditor();
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand() {
        text = originator.getState();
        return new UndoCommand(text);


    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);


    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);

    }

    private Command createAppendCommand(String text) {
        originator.setState(text);
        caretaker.add(originator.saveStateToMemento());
        return new AppendCommand(text);
    }

}
