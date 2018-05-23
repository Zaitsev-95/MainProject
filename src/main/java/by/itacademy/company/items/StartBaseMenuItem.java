package by.itacademy.company.items;

import by.itacademy.company.Company.Data;

public abstract class StartBaseMenuItem extends BaseMenuItem {
    private final MenuItem startMenuItem;

    protected StartBaseMenuItem(Data data, MenuItem startMenuItem) {
        super(data);
        this.startMenuItem = startMenuItem;
    }

    protected MenuItem startMenuItem() {
        return startMenuItem;
    }

    @Override
    public void execute() {
        baseExecute();
        startMenuItem().execute();
    }

    protected abstract void baseExecute();

    public abstract String name();
}