package com.c.refactoring.menuexamples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MenuAccessTestRefactored {

	MenuAccess menuAccess = new MenuAccess();

	@Test
	public void testRemoveUnAuthorizedMenus_AllChildrenVisible() {

		MenuItem[] childMenuItems = new MenuItem[] {
				new MenuItem("A1", true, null),
				new MenuItem("A2", true, null), };

		MenuItem[] menuItemsArray = { new MenuItem("A", true,
				new ArrayList<MenuItem>(Arrays.asList(childMenuItems))), };

		List<MenuItem> menuItems = new ArrayList<MenuItem>(
				Arrays.asList(menuItemsArray));

		menuAccess.removeUnAuthorizedMenus(menuItems);

		final List<MenuItem> childMenus = menuItems.get(0).childMenus;

		assertEquals(2, childMenus.size());

		assertEquals("A1", childMenus.get(0).name);
		assertEquals("A2", childMenus.get(1).name);

	}

	@Test
	public void testRemoveUnAuthorizedMenus_SomeChildrenVisible() {

		MenuItem[] childMenuItems = new MenuItem[] {
				new MenuItem("A1", false, null),
				new MenuItem("A2", true, null), };

		MenuItem[] menuItemsArray = { new MenuItem("A", true,
				new ArrayList<MenuItem>(Arrays.asList(childMenuItems))), };

		List<MenuItem> menuItems = new ArrayList<MenuItem>(
				Arrays.asList(menuItemsArray));

		menuAccess.removeUnAuthorizedMenus(menuItems);

		final List<MenuItem> childMenus = menuItems.get(0).childMenus;

		assertEquals(1, childMenus.size());

		assertEquals("A2", childMenus.get(0).name);
	}

	@Test
	public void testRemoveUnAuthorizedMenus_NoChildrenVisible_MenuItemIsRemoved() {

		MenuItem[] childMenuItems = new MenuItem[] {
				new MenuItem("A1", false, null),
				new MenuItem("A2", false, null), };

		MenuItem[] menuItemsArray = { new MenuItem("A", true,
				new ArrayList<MenuItem>(Arrays.asList(childMenuItems))), };

		List<MenuItem> menuItems = new ArrayList<MenuItem>(
				Arrays.asList(menuItemsArray));

		menuAccess.removeUnAuthorizedMenus(menuItems);

		assertEquals(0, menuItems.size());

	}

	@Test
	public void testRemoveUnAuthorizedMenus_NoChildren_MenuItemRemains() {

		MenuItem[] menuItemsArray = { new MenuItem("A", true, null), };

		List<MenuItem> menuItems = new ArrayList<MenuItem>(
				Arrays.asList(menuItemsArray));

		menuAccess.removeUnAuthorizedMenus(menuItems);

		assertEquals(1, menuItems.size());
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasReadAndWriteRoles() {

		Role[] userRoles = { new Role("MenuARead"), new Role("MenuAWrite") };

		MenuItem[] menuItemsArray = {
				new MenuItem("A", "MenuARead", "MenuAWrite") };

		List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		MenuItem menuItem = menuItems.get(0);
		assertEquals(Constants.WRITE, menuItem.getAccess());
		assertEquals(true, menuItem.isVisible());
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasOnlyReadRole() {

		Role[] userRoles = { new Role("MenuARead") };

		MenuItem[] menuItemsArray = {
				new MenuItem("A", "MenuARead", "MenuAWrite") };

		List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		MenuItem menuItem = menuItems.get(0);
		assertEquals(Constants.READ, menuItem.getAccess());
		assertEquals(true, menuItem.isVisible());
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasOnlyWriteRole() {

		Role[] userRoles = { new Role("MenuAWrite") };

		MenuItem[] menuItemsArray = {
				new MenuItem("A", "MenuARead", "MenuAWrite") };

		List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		MenuItem menuItem = menuItems.get(0);
		assertEquals(Constants.WRITE, menuItem.getAccess());
		assertEquals(true, menuItem.isVisible());
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasNoRoles() {

		Role[] userRoles = {};

		MenuItem[] menuItemsArray = {
				new MenuItem("A", "MenuARead", "MenuAWrite") };

		List<MenuItem> menuItems = Arrays.asList(menuItemsArray);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		MenuItem menuItem = menuItems.get(0);
		assertEquals(null, menuItem.getAccess());
		assertEquals(false, menuItem.isVisible());
	}
}
