package com.mycompany.app;
import java.util.ArrayList;

public class Chat {
    private String rawChat = new String();
    public int xferGoal = -1;
    public int xferNum = -1;
    //private ArrayList<String[]> chatFlagToIndex = new ArrayList<String[]>();
    

    Chat(String rawChat) {
        //will, eventually, take and process a Slack JSON, rawChat is the text field
        //in a json
        this.rawChat = rawChat;
    }
    public void parseForXfer() {
        ArrayList<String[]> flags = getFlags();
        if (!flags.isEmpty()) {
            for (String[] flag : flags) {
                if (xferFlagIsValid(flag)) { //later iterations will have to determine flag type before validating
                    scrapeGoals(flag);
                }
            }
        }
    }
    private void scrapeGoals(String[] flag)  {
        //currently only works for single char integers
        //TODO implement regex to scrape better
        int index = Integer.valueOf(flag[1]);
        xferNum = Integer.valueOf(rawChat.substring(index - 1, index)); //preceding char as string
        xferGoal = Integer.valueOf(rawChat.substring(index + 1, index + 2)); //succeeding char as string
    }
    private boolean xferFlagIsValid(String[] flag) {
        //code only accepts xfer counting flags "/" for now
        //chats are generally in format "{int}/{int}"
        try {
            int index = Integer.valueOf(flag[1]);
            Integer.valueOf(rawChat.substring(index - 1, index)); //preceding char as string
            Integer.valueOf(rawChat.substring(index + 1, index + 2)); //succeeding char as string
            return true; 
        }
        catch (Exception e) {
            return false;
        }

    }

    private ArrayList<String[]> getFlags() {
        //Returns an array of found flags, empty if none found
        String[] validFlags = {"/"};
        ArrayList<String[]> chatFlagToIndex = new ArrayList<String[]>();
        for (String flag : validFlags) {
            int flagIndex = rawChat.indexOf(flag);
            if (flagIndex >= 0) {
                String[] flag_array = new String[2];
                flag_array[0] = flag;
                flag_array[1] = String.valueOf(flagIndex);
                chatFlagToIndex.add(flag_array);
            }
        }
        return chatFlagToIndex;
    }
    public String toString() {
        return rawChat;
    }
}