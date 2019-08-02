package com.plietnov.task;

import java.util.Objects;

public class KeyHashSum {

    private static final int LIMIT_HASH_SIZE = 4;
    private String key;

    public KeyHashSum(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        KeyHashSum that = (KeyHashSum) o;
        return Objects.equals(this.key, that.key);
    }

    @Override
    public int hashCode() {
        return key != null ? key.chars().limit(LIMIT_HASH_SIZE).sum() : 0;
    }

    @Override
    public String toString() {
        return key;
    }
}
