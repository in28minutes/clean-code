package com.c.refactoring.menuexamples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MenuAccessTest {

    private MenuItem getMenuItem(List<MenuItem> menuItems, String name) {
        for (MenuItem item : menuItems) {
            if (name.equalsIgnoreCase(item.getName())) return item;
        }
        return null;
    }

    @Test
    public void testRemoveUnAuthorizedMenus() {

        MenuItem[] childMenuItemsA = new MenuItem[] {
                new MenuItem("A1", true, null),
                new MenuItem("A2", true, null),
        };

        MenuItem[] chileMenuItemsB = new MenuItem[] {
                new MenuItem("B1", true, null),
                new MenuItem("B2", false, null),
        };

        MenuItem[] chileMenuItemsC = new MenuItem[] {
                new MenuItem("C1", false, null),
                new MenuItem("C2", false, null),
        };

        MenuItem[] chileMenuItemsD = new MenuItem[] {
                new MenuItem("D1", false, null),
                new MenuItem("D2", true, null),
        };

        MenuItem[] menuItemsArray = {
                new MenuItem("A", true, new ArrayList<MenuItem>(
                        Arrays.asList(childMenuItemsA))),
                new MenuItem("B", true, new ArrayList<MenuItem>(
                        Arrays.asList(chileMenuItemsB))),
                new MenuItem("C", true, new ArrayList<MenuItem>(
                        Arrays.asList(chileMenuItemsC))),
                new MenuItem("D", true, new ArrayList<MenuItem>(
                        Arrays.asList(chileMenuItemsD))),
                new MenuItem("E", true, null)
        };

        List<MenuItem> menuItems = new ArrayList<MenuItem>(
                Arrays.asList(menuItemsArray));
        MenuAccess menuAccess = new MenuAccess();
        menuAccess.removeUnAuthorizedMenus(menuItems);

        assertEquals(4, menuItems.size());

        MenuItem menuItemA = getMenuItem(menuItems, "A");
        assertEquals(2, menuItemA.getChildMenus().size());

        MenuItem menuItemB = getMenuItem(menuItems, "B");
        assertEquals(1, menuItemB.getChildMenus().size());

        MenuItem menuItemC = getMenuItem(menuItems, "C");
        assertEquals(null, menuItemC);

        MenuItem menuItemD = getMenuItem(menuItems, "D");
        assertEquals(1, menuItemD.getChildMenus().size());

        MenuItem menuItemE = getMenuItem(menuItems, "E");
        assertEquals(null, menuItemE.getChildMenus());
    }

    @Test
    public void testSetAuthorizationsInEachMenus() {

        Role[] userRoles = { new Role("MenuARead"), new Role("MenuBWrite"),
                new Role("MenuCRead"), new Role("MenuCWrite") };

        MenuItem[] menuItemsArray = {
                new MenuItem("A", "MenuARead", "MenuAWrite"),
                new MenuItem("B", "MenuBRead", "MenuBWrite"),
                new MenuItem("C", "MenuCRead", "MenuCWrite"),
                new MenuItem("D", "MenuDRead", "MenuDWrite")
        };

        List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

        MenuAccess menuAccess = new MenuAccess();

        menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

        MenuItem menuItemA = menuItems.get(0);
        assertEquals(Constants.READ, menuItemA.getAccess());
        assertEquals(true, menuItemA.isVisible());

        MenuItem menuItemB = menuItems.get(1);
        assertEquals(Constants.WRITE, menuItemB.getAccess());
        assertEquals(true, menuItemB.isVisible());

        MenuItem menuItemC = menuItems.get(2);
        assertEquals(Constants.WRITE, menuItemC.getAccess());
        assertEquals(true, menuItemC.isVisible());

        MenuItem menuItemD = menuItems.get(3);
        assertEquals(null, menuItemD.getAccess());
        assertEquals(false, menuItemD.isVisible());

    }
}
