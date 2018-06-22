import java.util.*;
import java.util.Map.Entry;
import javax.management.Query;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> cases = new ArrayList<>();
        cases.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        cases.add(Arrays.asList("John", "johnnybravo@mail.com"));
        cases.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        cases.add(Arrays.asList("Mary", "mary@mail.com"));


        //[[],[],[],[],[]]
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("David","David0@m.co","David1@m.co"));
        lists.add(Arrays.asList("David","David3@m.co","David4@m.co"));
        lists.add(Arrays.asList("David","David4@m.co","David5@m.co"));
        lists.add(Arrays.asList("David","David2@m.co","David3@m.co"));
        lists.add(Arrays.asList("David","David1@m.co","David2@m.co"));

        System.out.println(Arrays.toString(accountsMergeSolution(cases).toArray()));
        System.out.println(Arrays.toString(accountsMergeSolution(lists).toArray()));
    }

    private static String origin(Map<String, String> origins, String email) {
        while (email != origins.get(email)) {
            email = origins.get(email);
        }

        return email;
    }

    private static List<List<String>> accountsMergeSolution(List<List<String>> accounts) {
        Map<String, String> mapEmailToOrigin = new HashMap<>();
        Map<String, String> mapEmailToUser = new HashMap<>();

        for (List<String> entry : accounts) {
            String user = entry.get(0);
            for (int i = 1; i < entry.size(); i++) {
                String email = entry.get(i);
                if (!mapEmailToOrigin.containsKey(email)) {
                    mapEmailToOrigin.put(email, email);
                }
                mapEmailToUser.put(email, user);
            }

            for (int i = 1; i < entry.size(); i++) {
                String email = entry.get(i);
                mapEmailToOrigin.put(origin(mapEmailToOrigin, email), origin(mapEmailToOrigin, entry.get(1)));
            }
        }

        Map<String, List<String>> unionsEmail = new HashMap<>();
        for (Map.Entry<String, String> entry : mapEmailToOrigin.entrySet()) {
            String email = entry.getKey();
            String origin = origin(mapEmailToOrigin, email);
            if (!unionsEmail.containsKey(origin))
                unionsEmail.put(origin, new ArrayList<>());
            
            unionsEmail.get(origin).add(email);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : unionsEmail.entrySet()) {
            String origin = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            String user = mapEmailToUser.get(origin);
            emails.add(0, user);
            res.add(emails);
        }

        return res;
    }

    // My original solution. Works. But run out of time limit for the last test case on LeetCode.
    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<Queue<String>>> mapNameToEmails = new HashMap<>();
        boolean userExisted = false;
        boolean toMix = false;

        for (List<String> entry : accounts) {
            String name = entry.get(0);
            List<String> emails = entry.subList(1, entry.size());

            if (mapNameToEmails.containsKey(name)) {
                Set<Queue<String>> tempSet = mapNameToEmails.get(name);
                for (Queue<String> tempQueue : tempSet) {
                    for (String s : emails) {
                        if (userExisted == false && tempQueue.contains(s)) {
                            userExisted = true;
                        }

                        if (userExisted == true && tempQueue.contains(s)) {
                            for (Queue<String> qq : tempSet) {
                                if (!qq.equals(tempQueue)) {
                                    for (String ss : emails) {
                                        if (qq.contains(ss)) {
                                            while (!qq.isEmpty()) {
                                                tempQueue.offer(qq.poll());
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (userExisted == true) {
                        for (String s : emails) {
                            if (!tempQueue.contains(s)) tempQueue.offer(s);
                        }

                        break;
                    }
                }

                if (userExisted == false) {
                    Queue<String> q = new PriorityQueue<String>(((a, b) -> a.compareTo(b)));
                    for (String s : emails)
                        if (!q.contains(s)) q.offer(s);
                    tempSet.add(q);
                }

                userExisted = false;
                mapNameToEmails.put(name, tempSet);
            } else {
                Queue<String> q = new PriorityQueue<String>(((a, b) -> a.compareTo(b)));
                Set<Queue<String>> s = new HashSet<>();
                for (String email : emails) q.offer(email);
                s.add(q);
                mapNameToEmails.put(name, s);
            }
        }

        for (String key : mapNameToEmails.keySet()) {
            for (Queue<String> q : mapNameToEmails.get(key)) {
                if (q.size() > 0) {
                    List<String> list = new ArrayList<>();
                    list.add(key);
                    while(!q.isEmpty()) {
                        String e = q.poll();
                        if (!list.contains(e)) list.add(e);
                    }
    
                    res.add(list);
                }
            }
        }

        return res;
    }
}