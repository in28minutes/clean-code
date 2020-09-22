package com.c.refactoring.lock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class UserLoginCheckerTestRefactored {
	private static final String SOME_STATUS = "NOT_USED";
	private static final int SOME_ID = 10;
	private static final boolean IS_FIRST_SCREEN_TRUE = true;
	private static final boolean IS_FIRST_SCREEN_FALSE = false;
	UserLoginChecker userLoginChecker = new UserLoginChecker();

	@Test
	public void testisUserAllowedToLogin_DifferentUserTriesImmediatelyAfter() {
		Object[] existingLocks = new Object[] { "TEST_USER_ID_1", new Date() };

		Lock lock = userLoginChecker.isUserAllowedToLogin(SOME_ID, SOME_STATUS, 
				IS_FIRST_SCREEN_TRUE, new User("TEST_USER_ID_2"), Arrays
				.asList(new Object[][] { existingLocks }));

		assertReadAccess(lock);
	}

	@Test
	public void testisUserAllowedToLogin_SameUserReturnsToFirstScreen() {
		Object[] existingLocks = new Object[] { "TEST_USER_ID", new Date() };

		Lock lock = userLoginChecker.isUserAllowedToLogin(SOME_ID, SOME_STATUS, 
				IS_FIRST_SCREEN_TRUE, new User("TEST_USER_ID"), Arrays
				.asList(new Object[][] { existingLocks }));

		assertWriteAccess(lock);
	}

	@Test
	public void testisUserAllowedToLogin_SameUserReturnsToSecondScreen() {
		Object[] existingLocks = new Object[] { "TEST_USER_ID", new Date() };

		Lock lock = userLoginChecker.isUserAllowedToLogin(SOME_ID, SOME_STATUS, 
				IS_FIRST_SCREEN_FALSE, new User("TEST_USER_ID"), Arrays
				.asList(new Object[][] { existingLocks }));

		assertWriteAccess(lock);
	}

	@Test
	public void testisUserAllowedToLogin_User2TriesToLoginToFirstScreen3hoursAfterUser1() {
		Object[] existingLocks = new Object[] { "TEST_USER_ID_1", threeHoursBefore() };

		Lock lock = userLoginChecker.isUserAllowedToLogin(SOME_ID, SOME_STATUS, 
				IS_FIRST_SCREEN_TRUE, new User("TEST_USER_ID_2"), Arrays
				.asList(new Object[][] { existingLocks }));

		assertWriteAccess(lock);

	}

	@Test
	public void testisUserAllowedToLogin_User2TriesToLoginToSecondScreen3hoursAfterUser1() {
		Object[] existingLocks = new Object[] { "TEST_USER_ID_1", threeHoursBefore() };

		Lock lock = userLoginChecker.isUserAllowedToLogin(SOME_ID, SOME_STATUS, 
				IS_FIRST_SCREEN_FALSE, new User("TEST_USER_ID_2"), Arrays
				.asList(new Object[][] { existingLocks }));

		assertReadAccess(lock);
	}

	public Date threeHoursBefore() {
		Date now = new Date();
		return new Date(now.getTime() - 3 * 60 * 60 * 1000);
	}

	private void assertReadAccess(Lock lock) {
		assertTrue(lock.isReadAccess());
		assertNotNull(lock.getLockReason());
	}

	private void assertWriteAccess(Lock lock) {
		assertFalse(lock.isReadAccess());
		assertNull(lock.getLockReason());
	}
}
