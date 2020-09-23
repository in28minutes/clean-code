package com.c.refactoring.menuexamples;

import java.util.List;

public class MenuAccess {

    public void setAuthorizationsInEachMenus(
            List<MenuItem> menuItemsList, Role[] roles) {
        for (int i = 0; i < menuItemsList.size(); i++) {
            MenuItem menuItem = menuItemsList.get(i);
            if (roles != null) {
                for (int j = 0; j < roles.length; j++) {
                    if (roles[j].getName().equals(menuItem
                            .getReadAccessRole())
                            && !Constants.WRITE.equals(
                                    menuItem
                                            .getAccess())) {
                        menuItem.setAccess(Constants.READ);
                        menuItem.setVisible(true);
                    } else if (roles[j].getName().equals(
                            menuItem
                                    .getWriteAccessRole())) {
                        menuItem.setAccess(Constants.WRITE);
                        menuItem.setVisible(true);
                    }
                }

            }

        }

    }

}
