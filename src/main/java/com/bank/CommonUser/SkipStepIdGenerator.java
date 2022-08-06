package com.bank.CommonUser;

/**
 * For generating id automatically in a specific pattern, skipStep refers the interval
 */
public class SkipStepIdGenerator implements IdGenerator{
    public int initialValue;
    public int skipStep;

    public SkipStepIdGenerator(int initialValue, int skipStep) {
        this.initialValue = initialValue;
        this.skipStep = skipStep;
    }

    @Override
    public int currentId() {
            return initialValue;
    }

    @Override
    public int nextId() {
        initialValue+=skipStep;
       // System.out.println("Your Account number"+initialValue);
        return initialValue;
    }
}
