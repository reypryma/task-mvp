package com.learnMVP.todolist.module.update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.learnMVP.todolist.R;
import com.learnMVP.todolist.base.BaseFragment;
import com.learnMVP.todolist.data.model.Task;

import java.util.Objects;

public class UpdateTaskFragment extends BaseFragment<UpdateTaskActivity, UpdateTaskContract.Presenter> implements UpdateTaskContract.View {

    TextInputEditText tietTaskName;
    TextInputEditText tietTaskTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_edit_task, container, false);

        final TextView taskTitle = fragmentView.findViewById(R.id.tv_task_title);
        final Button btnEditTask = fragmentView.findViewById(R.id.btn_edit_task);
        final Button btnDeleteTask = fragmentView.findViewById(R.id.btn_delete_task);
        tietTaskName = fragmentView.findViewById(R.id.tiet_task_name);
        tietTaskTime = fragmentView.findViewById(R.id.tiet_task_time);

        setTitle(getResources().getString(R.string.task_title_edit));
        taskTitle.setText(R.string.task_title_edit);
        btnEditTask.setVisibility(View.VISIBLE);
        btnEditTask.setOnClickListener(v -> this.setBtnEditClick());
        btnDeleteTask.setOnClickListener(v -> this.setBtnDeleteClick());
        btnDeleteTask.setVisibility(View.VISIBLE);

        presenter.start();

        return fragmentView;
    }

    private void setBtnEditClick() {
        String name = Objects.requireNonNull(tietTaskName.getText()).toString();
        String time = Objects.requireNonNull(tietTaskTime.getText()).toString();
        presenter.saveData(name, time);
    }

    private void setBtnDeleteClick() {
        presenter.deleteData();
    }

    @Override
    public void setPresenter(UpdateTaskContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
        activity.finish();
    }

    @Override
    public void showData(Task task) {
        tietTaskName.setText(task.getName());
        tietTaskTime.setText(task.getDueDate());
    }
}
