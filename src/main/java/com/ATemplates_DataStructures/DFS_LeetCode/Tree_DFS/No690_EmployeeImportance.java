package com.ATemplates_DataStructures.DFS_LeetCode.Tree_DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No690_EmployeeImportance {
    private static final Logger logger = LoggerFactory.getLogger(No690_EmployeeImportance.class);

    public static void main(String[] args) {
        testNo690_EmployeeImportance();
    }

    private static void testNo690_EmployeeImportance() {
        No690_EmployeeImportance No690_EmployeeImportance = new No690_EmployeeImportance();
        LinkedList<Employee> employees = new LinkedList<>();
        LinkedList<Integer> subordinates = new LinkedList<>();
        subordinates.add(2);
        subordinates.add(3);
        employees.add(new Employee(1, 5, subordinates));
        employees.add(new Employee(2, 3, new LinkedList<>()));
        employees.add(new Employee(3, 3, new LinkedList<>()));
        MyLogger.info("result 11 v.s. " + No690_EmployeeImportance.getImportance(employees, 1));
//        MyLogger.info("result 1 v.s. " + No690_EmployeeImportance.getImportance("10"));
    }

    /**
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        // filter abnormal inputs
        if (employees == null || employees.size() < 1) {
            return 0;
        }

        // DFS and Memoisation
        lookupById.clear();
        importanceCache.clear();
        for (Employee employee : employees) {
            lookupById.put(employee.id, employee);
        }

        int importance = getImportanceHelper(employees, id);

        // Wrap up
        return importance;
    }

    HashMap<Integer, Employee> lookupById = new HashMap<>();
    HashMap<Integer, Integer> importanceCache = new HashMap<>();

    private int getImportanceHelper(List<Employee> employees, int id) {
        Employee currentEmployee = lookupById.get(id);
        int importance = currentEmployee.importance;
        if (currentEmployee.subordinates.size() > 0) {
            for (Integer subordinateId : currentEmployee.subordinates) {
                if (!importanceCache.containsKey(subordinateId)) {
                    importanceCache.put(subordinateId, getImportanceHelper(employees, subordinateId));
                }
                importance += importanceCache.get(subordinateId);
            }
        }
        return importance;
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }


    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
