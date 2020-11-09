package com.learnMVP.todolist.module.create;

import com.learnMVP.todolist.base.BaseFragmentHolderActivity;

public class AddTaskActivity extends BaseFragmentHolderActivity {

    AddTaskFragment addTaskFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        addTaskFragment = new AddTaskFragment();
        AddTaskPresenter presenter = new AddTaskPresenter(addTaskFragment);
        addTaskFragment.setPresenter(presenter);

        setCurrentFragment(addTaskFragment, true);
    }
}
