package com.plietnov.task;

import java.util.Objects;

public class KeyHashLength {

    private String key;

    public KeyHashLength(String key) {
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
        KeyHashLength that = (KeyHashLength) o;
        return Objects.equals(this.key, that.key);
    }

    @Override
    public int hashCode() {
        return key != null ? key.length() : 0;
    }

    @Override
    public String toString() {
        return key;
    }
}