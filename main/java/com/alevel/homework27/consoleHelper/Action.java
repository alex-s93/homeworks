package com.alevel.homework27.consoleHelper;

public enum Action {
    ACTION_CREATE_DIR ("create directory"),
    ACTION_CREATE_FILE ("create file"),
    ACTION_SHOW_TREE ("show tree of dir by name"),
    ACTION_SHOW_CURRENT_TREE ("show tree of current dir"),
    ACTION_CD ("change directory"),
    ACTION_CURRENT_DIR ("print current dir"),
    ACTION_FINISH_APPLICATION ("finish");

    private String actionName;

    Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    public static Action getActionName(String name) {
        Action action = null;
        for (Action actionName: Action.values()) {
            if (actionName.getActionName().equals(name)) {
                action = actionName;
            }
        }
        return action;
    }

    @Override
    public String toString() {
        return actionName;
    }
}

