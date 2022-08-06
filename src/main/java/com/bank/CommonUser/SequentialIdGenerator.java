package com.bank.CommonUser;

/**
 * For generating id automatically in sequential order
 */
public class SequentialIdGenerator implements IdGenerator{
    public int initialValue;

    public SequentialIdGenerator(int initialValue) {
        this.initialValue = initialValue;
    }

    @Override
    public int currentId() {
        return initialValue;
    }

    @Override
    public int nextId() {
        return ++ this.initialValue;
    }
}
