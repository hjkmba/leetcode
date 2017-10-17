package tag.depthFirstSearch;

import java.util.*;

/**
 * Created by he.dong on 10/13/2017.
 */
public class _690_EmployeeImportance {
    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getImportanceAt(map, id);
    }

    public int getImportanceAt(HashMap<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        if (e == null)
            return 0;
        if (e.subordinates == null || e.subordinates.size() == 0)
            return e.importance;
        else {
            int sum = e.importance;
            for (int subId : e.subordinates) {
                sum += getImportanceAt(map, subId);
            }
            return sum;
        }
    }

    public int getImportanceByDfsLoop(HashMap<Integer, Employee> map, int id) {
        Stack<Employee> stack = new Stack<>();
        stack.push(map.get(id));
        int sum = 0;
        while (!stack.isEmpty()) {
            Employee e = stack.pop();
            if (e != null) {
                sum += e.importance;
                for (int subId : e.subordinates) {
                    stack.push(map.get(subId));
                }
            }
        }

        return sum;
    }

    public int getImportanceByBfsLoop(HashMap<Integer, Employee> map, int id) {
//        LinkedList<Employee> queue = new LinkedList<>();
        Queue<Employee> queue = new LinkedList<>();
        int sum = 0;
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            if (e != null){
                sum += e.importance;
                for (int subId : e.subordinates) {
                    queue.offer(map.get(subId));
                }
            }
        }
        return sum;
    }
}
