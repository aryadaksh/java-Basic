package com.setexample.hashsetUtreefit;

import java.util.HashSet;
import java.util.Set;

class Employee {
    String name;
    Employee(String name) { this.name = name; }

    @Override
    public int hashCode() {
        return 1; // force all into same bucket
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        return name.equals(((Employee)o).name);
    }

    @Override
    public String toString() { return name; }
}

public class TreefiyExample {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>(64);

        // Add 9 elements → treeify
        for (int i = 1; i <= 9; i++) {
            set.add(new Employee("Daksh" + i));
        }

        // Remove until <6 → untreeify
        for (int i = 9; i >= 4; i--) {
            set.remove(new Employee("Daksh" + i));
        }
    }
}
