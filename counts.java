package GetPassword;

/**
 * Created by deadboy on 09.11.15.
 */
public class counts {
    private static int pswrds = 0, pswl = 0;
    counts(int len) {
        ++pswrds;
        pswl+=len;
    }

    String GetCounts() {
        return pswrds + " " + pswl;
    }
}
