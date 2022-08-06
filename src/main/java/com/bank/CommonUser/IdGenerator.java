package com.bank.CommonUser;


/**
 * This interface is used to take care about idGeneration, to make it testable
 */
public interface IdGenerator {

        int currentId();
        int nextId();
    }


