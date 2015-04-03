import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=274&page=show_problem&problem=3609
Background

Where was the Kingdom of Prester John? There are many maps showing the way to it, but unfortunately it seems hard to establish a sensible agreement. India? Ethiopia? Mongolia? Syria? Puzzling… Well, what would one expect from the descendant of the Three Wise Men?

An idea is to follow the directions in two maps at the same time, and if the directions lead to the same place, we can find Prester. Well, “information technology” may help here. Write a program that, given two medieval maps of the world indicating the location of the Mythical Kingdom, finds the length of the common shortest path to the location where the Prester was seen.
Problem

Given two maps, compute the minimum length of a common path to the Prester location.
Input
Input consists of multiple test cases the first line of the input contains the number of test cases. There is a blank line before each dataset.

The input for each dataset contains the description of a pair of maps, in sequence. Each map is given by a positive integer L, not greater than 1,000, in a single line, indicating the number of locations in the map. Next, there is an integer in the range [0, L-1] indicating the location, in a single line, where the Prester was seen. Next, there is a positive integer P, not greater than 10,000, in a single line, indicating the number of paths in the description of the map. Then, the description of the map follows. Each path in the map is listed in a separate line, and has the form

L1 description L2

where L1 and L2 are integers in the range [0, L-1] indicating a location, and description is a string with no more than 8 characters, indicating the name of a path from location L1 to location L2. It is known that location 0 represents the same place in all maps.
Output

An integer in a single line indicating the length of the shortest sequence of path descriptions that is common to both maps, and that, in both maps, lead to a location of the Prester. If there is no common path leading to the Prester location, your program should write -1 as result. Print a blank line between datasets.

Sample Input

1

2  -- number of locations
1  -- target location
2  -- number of paths
0 tunnel 1
1 bridge 1
3
2
3
0 tunnel 1
1 bridge 2
2 river 2

Sample Output
2
 */
public class PresterJohn {
    public static void main(String[] args) throws IOException {
        final LineInputStream fis = new LineInputStream(new FileInputStream("inputPresterJohn.txt"));
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
        System.out.println(fis.nextLine());
    }
}

class LineInputStream extends InputStream {
    private static final Pattern COMPILE = Pattern.compile("\n");
    private final InputStream inputStream;
    private final List<String> lines = new ArrayList<>();
    private long bytesToSkip;

    LineInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public String nextLine() throws IOException {
        if (lines.size() > 1) {
            return lines.remove(0);
        }
        if (bytesToSkip == -1) {
            return lines.size() == 1 ? lines.remove(0) : null;
        }
        inputStream.skip(bytesToSkip);
        final int length = 1024;
        final byte[] buffer = new byte[length];
        final StringBuilder builder = new StringBuilder();
        int read;
        while ((read = inputStream.read(buffer, 0, length)) != -1) {
            bytesToSkip += read;
            String s = new String(buffer);
            builder.append(s);
            if (s.contains("\n")) {
                break;
            }
        }
        if (read == -1) {
            bytesToSkip = -1;
            inputStream.close();
            return lines.isEmpty() ? null : lines.remove(0);
        }
        if (builder.length() > 0) {
            final String s1 = builder.toString();
            final String[] split = COMPILE.split(s1);
            final String retVal = lines.isEmpty() ? split[0] : lines.remove(lines.size() - 1) + split[0];
            lines.addAll(Arrays.asList(split).subList(1, split.length));
            return retVal;
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        super.close();
        inputStream.close();
    }
}
