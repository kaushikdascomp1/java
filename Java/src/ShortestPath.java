import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("abc");
        set.add("ayc");
        set.add("adf");
        set.add("aee");
        set.add("aff");
        set.add("zyz");
        set.add("ayz");
        set.add("abe");
        set.add("aef");
        set.add("acz");
        System.out.println(getShortestPath("abc", "aee", set));
    }


    private static boolean isAdjacent(String s1, String s2) {
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int count = 0;
        for(int i = 0 ; i < s1.length() ; i++)
        {
            if(c1[i] != c2[i])
                count++;
        }
        if(count == 1)
            return true;
        else
            return false;
    }

    private static int getShortestPath(String source, String target, HashSet<String> strings) {
        Queue<String> q = new LinkedList<>();
        q.add(source);
        int count = 0;
        strings.remove(source);
        while(!q.isEmpty())
        {
            String current = q.remove();
            for(Iterator<String> it = strings.iterator(); it.hasNext() ;)
            {
                String s = it.next();

                if(isAdjacent(current , s))
                {
                    count++;
                    q.add(s);
                    if(s == target)
                        return count-1;
                    it.remove();
                }
            }
        }

        return 0;
    }
}
