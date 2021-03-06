package com.cjm721.overloaded.storage;

/**
 * Created by CJ on 4/10/2017.
 */
public class LongEnergyStack implements IHyperType {

    public static final LongEnergyStack EMPTY_STACK = new LongEnergyStack(0L);

    public long amount;

    public LongEnergyStack(long amount) {
        this.amount = amount;
    }

    @Override
    public long getAmount() {
        return amount;
    }
}
