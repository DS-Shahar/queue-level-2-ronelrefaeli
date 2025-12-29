public class Main 
{

    public static Queue<Integer> EX1(Queue<Character> q) 
  {
        Queue<Integer> out = new Queue<Integer>();
        if (q.isEmpty()) 
          return out;
        char prev = q.remove();
        int count = 1;
        while (!q.isEmpty()) 
        {
            char c = q.remove();
            if (c == prev) 
              count++;
            else 
            {
                out.insert(count);
                prev = c;
                count = 1;
            }
        }
        out.insert(count);
        return out;
    }

    public static boolean isIn(Queue<String> q, String x) 
  {
        Queue<String> help = new Queue<String>();
        boolean ans = false;
        while (!q.isEmpty()) 
        {
            String s = q.remove();
            if (s.equals(x)) ans = true;
            help.insert(s);
        }
        while (!help.isEmpty()) 
          q.insert(help.remove());
        return ans;
    }

    public static boolean EX2(Queue<String> q)
  {
        Queue<String> help = new Queue<String>();
        boolean ans = false;
        while (!q.isEmpty() && !ans) 
        {
            String s = q.remove();
            if (isIn(help, s)) ans = true;
            help.insert(s);
        }
        while (!help.isEmpty()) 
          q.insert(help.remove());
        return ans;
    }

    public static void EX3(Queue<Integer> q) 
  {
        Queue<Integer> help = new Queue<Integer>();
        while (!q.isEmpty()) {
            int x = q.remove();
            if (!isInInt(help, x))
              help.insert(x);
        }
        while (!help.isEmpty())
          q.insert(help.remove());
    }

    public static boolean isInInt(Queue<Integer> q, int x)
  {
        Queue<Integer> h = new Queue<Integer>();
        boolean ans = false;
        while (!q.isEmpty()) {
            int y = q.remove();
            if (y == x) ans = true;
            h.insert(y);
        }
        while (!h.isEmpty()) q.insert(h.remove());
        return ans;
    }

    public static void EX4(Queue<Integer> q)
  {
    
        Queue<Integer> h1 = new Queue<Integer>();
        Queue<Integer> h2 = new Queue<Integer>();
        while (!q.isEmpty()) {
            int min = findMin(q, h1);
            h2.insert(min);
            while (!h1.isEmpty()) 
              q.insert(h1.remove());
        }
        while (!h2.isEmpty()) 
          q.insert(h2.remove());
    }

    public static int findMin(Queue<Integer> q, Queue<Integer> h)
  {
        int min = q.remove();
        h.insert(min);
        while (!q.isEmpty())
          {
            int x = q.remove();
            if (x < min)
              min = x;
            h.insert(x);
        }
        Queue<Integer> t = new Queue<Integer>();
        boolean removed = false;
        while (!h.isEmpty()) {
            int x = h.remove();
            if (x === min && !removed)
              removed = true;
            else t.insert(x);
        }
        while (!t.isEmpty()) 
          q.insert(t.remove());
        return min;
    }

    public static Queue<Integer> EX5(Queue<Integer> q1, Queue<Integer> q2)
  {
        Queue<Integer> out = new Queue<Integer>();
        while (!q1.isEmpty() && !q2.isEmpty()) 
        {
            if (q1.head() <= q2.head()) 
              out.insert(q1.remove());
            else 
              out.insert(q2.remove());

  
        }
        while (!q1.isEmpty()) 
          out.insert(q1.remove());
        while (!q2.isEmpty()) 
          out.insert(q2.remove());
        return out;
    }

    public static int EX6(Queue<Integer> q)
  {
        Queue<Integer> help = new Queue<Integer>();
        int maxLen = 0;
        int maxSum = 0;
        int curLen = 0;
        int curSum = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            help.insert(x);
            if (x % 2 == 0) {
                curLen++;
                curSum += x;
                if (curLen > maxLen)
                {
                    maxLen = curLen;
                    maxSum = curSum;
                }
            } else {
                curLen = 0;
                curSum = 0;
            }
        }
        while (!help.isEmpty()) 
          q.insert(help.remove());
        return maxSum;
    }

    public static void main(String[] args) 
  {
        Queue<Character> qc = new Queue<Character>();
        qc.insert('c'); 
        qc.insert('c'); 
        qc.insert('a'); 
        qc.insert('c');
        Queue<Integer> r1 = EX1(qc);

        Queue<String> qs = new Queue<String>();
        qs.insert("a"); qs.insert("b"); qs.insert("a");
        boolean r2 = EX2(qs);

        Queue<Integer> q3 = new Queue<Integer>();
        q3.insert(1); q3.insert(2); q3.insert(1); q3.insert(3);
        EX3(q3);

        Queue<Integer> q4 = new Queue<Integer>();
        q4.insert(4); q4.insert(1); q4.insert(3); q4.insert(2);
        EX4(q4);

        Queue<Integer> a = new Queue<Integer>();
        Queue<Integer> b = new Queue<Integer>();
        a.insert(1); a.insert(3); a.insert(5);
        b.insert(2); b.insert(4); b.insert(6);
        Queue<Integer> r5 = EX5(a, b);

        Queue<Integer> q6 = new Queue<Integer>();
        q6.insert(2); q6.insert(4); q6.insert(1); q6.insert(6); q6.insert(8);
        int r6 = EX6(q6);
    }
}
