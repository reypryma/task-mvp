package com.learnMVP.todolist.module.update;

import com.learnMVP.todolist.data.model.Task;

public class UpdateTaskPresenter implements UpdateTaskContract.Presenter {

    private final UpdateTaskContract.View view;
    private String id;

    public UpdateTaskPresenter(UpdateTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        loadData(id);
    }

    @Override
    public void saveData(String name, String time) {
        view.redirectToTaskList();
    }

    @Override
    public void loadData(String id) {
        Task task = new Task(id, "Your Task", "Today");
        view.showData(task);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void deleteData() {
        view.redirectToTaskList();
    }
}
