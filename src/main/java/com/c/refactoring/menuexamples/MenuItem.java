package com.c.refactoring.menuexamples;

import java.util.List;

public class MenuItem {

    String access;
    List<MenuItem> childMenus;
    String name;
    //Other fields which are not needed for this example..
    String readAccessRole;
    boolean visible;
    String writeAccessRole;

    public MenuItem(String name ,
            boolean visible , List<MenuItem> childMenus) {
        super();
        this.name = name;
        this.visible = visible;
        this.childMenus = childMenus;
    }

    public MenuItem(String name , String readAccessRole , String writeAccessRole) {
        super();
        this.name = name;
        this.readAccessRole = readAccessRole;
        this.writeAccessRole = writeAccessRole;
    }

    public String getAccess() {
        return access;
    }

    public List<MenuItem> getChildMenus() {
        return childMenus;
    }

    public String getName() {
        return name;
    }

    public String getReadAccessRole() {
        return readAccessRole;
    }

    public String getWriteAccessRole() {
        return writeAccessRole;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void setChildMenus(List<MenuItem> childMenus) {
        this.childMenus = childMenus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReadAccessRole(String readAccessRole) {
        this.readAccessRole = readAccessRole;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setWriteAccessRole(String writeAccessRole) {
        this.writeAccessRole = writeAccessRole;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MenuItem [readAccessRole=").append(readAccessRole)
                .append(", writeAccessRole=").append(writeAccessRole)
                .append(", access=").append(access).append(", visible=")
                .append(visible).append(", childMenus=").append(childMenus)
                .append("]");
        return builder.toString();
    }

}
