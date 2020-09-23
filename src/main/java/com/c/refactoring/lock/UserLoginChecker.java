package com.c.refactoring.lock;

import java.util.Date;
import java.util.List;

public class UserLoginChecker {

    /**
     * {@inheritDoc}.
     */
    public Lock isUserAllowedToLogin(long id, String status,
            boolean firstScreen, User user, List list) {
        Date time = new Date();
        Lock lck = new Lock();
        if (list.size() > 0 && list.get(0) != null) {
            Object[] object = (Object[]) list.get(0);
            String userId = (String) object[0];
            Date lockTimestamp = (Date) object[1];
            if (userId != null) {
                // message which is shown to the user 
                String lockMsg = Constants.LOCK_TEXT.replaceAll("@@USER@@",
                        userId);
                //if userID is present, the Lock time stamp will also be present
                //4800000 milliseconds equals to 1 1/2 hours.
                if (time.getTime() - lockTimestamp.getTime() > 3600000) {
                    //New user gets lock only on first screen 
                    //If 1 1/2 hours expires when user is not on 1st screen then for same user lock can be refreshed.
                    if (firstScreen
                            || userId.equalsIgnoreCase(user.getUserId())) {
                        //to set the  access to write mode
                        lck.setRead(false);
                        return lck;
                    }
                    lck.setRead(true);
                    //Only read access is permitted to other user
                    lck.setLockReason(lockMsg);
                    return lck;
                } else if (userId.equalsIgnoreCase(user.getUserId())) {
                    // Locked By Same User, Write access
                    lck.setRead(false);
                    return lck;
                } else {
                    lck.setRead(true);
                    //Only Read Access is Permitted
                    lck.setLockReason(lockMsg);
                    return lck;
                }
            }
        }
        lck.setRead(false);
        return lck;
    }
}