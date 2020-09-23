package com.c.refactoring.menuexamples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MenuAccessTestRefactored {

	private static final MenuItem MENU_A = new MenuItem("A", "MenuARead", "MenuAWrite");
	private static final Role MENU_A_WRITE_ROLE = new Role("MenuAWrite");
	private static final Role MENU_A_READ_ROLE = new Role("MenuARead");

	MenuAccess menuAccess = new MenuAccess();

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasReadAndWriteRoles() {

		Role[] userRoles = { MENU_A_READ_ROLE, MENU_A_WRITE_ROLE };

		List<MenuItem> menuItems = Arrays.asList(MENU_A);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		assertMenuItemIsWritable(menuItems.get(0));
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasOnlyReadRole() {

		Role[] userRoles = { MENU_A_READ_ROLE };

		List<MenuItem> menuItems = Arrays.asList(MENU_A);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		assertMenuItemIsReadable(menuItems.get(0));
	}

	@Test
	public void testSetAuthorizationsInEachMenus_UserHasOnlyWriteRole() {

		Role[] userRoles = { MENU_A_WRITE_ROLE };

		List<MenuItem> menuItems = Arrays.asList(MENU_A);

		menuAccess.setAuthorizationsInEachMenus(menuItems, userRoles);

		MenuItem actual = menuItems.get(0);
		assertMenuItemIsWritable(actual);
	}

	private void assertMenuItemIsWritable(MenuItem actual) {
		assertEquals(Constants.WRITE, actual.getAccess());
		assertEquals(true, actual.isVisible());
	}

	private void assertMenuItemIsReadable(MenuItem actual) {
		assertEquals(Constants.READ, actual.getAccess());
		assertEquals(true, actual.isVisible());
	}

}
