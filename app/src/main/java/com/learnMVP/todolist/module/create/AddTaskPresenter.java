package com.learnMVP.todolist.module.create;

import com.learnMVP.todolist.data.model.Task;

public class AddTaskPresenter implements AddTaskContract.Presenter {

    private final AddTaskContract.View view;

    public AddTaskPresenter(AddTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void saveData(String name, String time) {
        new Task("3", name, time);
        view.redirectToTaskList();
    }
}
