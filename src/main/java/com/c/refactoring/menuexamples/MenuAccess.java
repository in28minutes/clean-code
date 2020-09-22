package com.c.refactoring.menuexamples;

import java.util.List;

public class MenuAccess {

    /**
     * remove unauthorized menus from the list.
     * 
     * @param menuItemsList the menu base list
     */
    public void removeUnAuthorizedMenus(List<MenuItem> menuItemsList) {

        for (int i = 0; i < menuItemsList.size(); i++) {

            boolean isAtleastOneChildAuthorized = false;

            List<MenuItem> childMenuBaseList = menuItemsList.get(i)
                    .getChildMenus();

            if (childMenuBaseList == null) {
                continue;
            }

            for (int j = 0; j < childMenuBaseList.size(); j++) {

                if (!childMenuBaseList.get(j).isVisible()) {
                    childMenuBaseList.remove(j);
                    j--;
                } else {
                    isAtleastOneChildAuthorized = true;
                }

            }
            if (!isAtleastOneChildAuthorized) {
                menuItemsList.remove(i);
                i--;
            }

        }

    }

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
