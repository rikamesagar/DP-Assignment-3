/**
 *Class to create log messages and write log
 */

package util;

public class MyLogger {
    public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR,NOOUTPUT
    };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
            case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
            case 0: debugLevel = DebugLevel.NOOUTPUT; break;
            default: debugLevel = DebugLevel.NOOUTPUT; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage (String message,DebugLevel levelIn) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    public String toString() {

        return "The debug level has been set to the following " + debugLevel;
    }
}