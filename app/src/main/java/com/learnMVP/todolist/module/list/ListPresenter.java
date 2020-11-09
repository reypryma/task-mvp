package com.learnMVP.todolist.module.list;

import com.learnMVP.todolist.data.model.Task;

import java.util.ArrayList;
import java.util.List;

public class ListPresenter implements ListContract.Presenter {

    private final ListContract.View view;

    public ListPresenter(ListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void addTask() {
        view.sendToAddTask();
    }

    @Override
    public void editTask(String id) {
        view.sendToEditTask(id);
    }

    @Override
    public List<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        return tasks;
    }
}
