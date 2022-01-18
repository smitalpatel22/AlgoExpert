package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class b18ShortenPath {

    //Time: 4n~n || Space: 4n~n
    public static String shortenPath(String path) {
        boolean startsWithPath = path.charAt(0) == '/';
        String[] tokensArr = path.split("/");
        List<String> tokenList = Arrays.asList(tokensArr);

        List<String> filteredTokens = tokenList.stream().filter(token -> isImportantToken(token)).collect(Collectors.toList());

        List<String> stack = new ArrayList<>();
        if(startsWithPath) stack.add("");

        for(String token : filteredTokens) {
            if(token.equals("..")) {
                if(stack.size()==0 || stack.get(stack.size()-1).equals("..")) {     //relative path & not starting with / ==> root dir or previous added is //
                    stack.add(token);                                               //add .. in case not root present or .. previously too
                } else if(!stack.get(stack.size()-1).equals("")) {                  //not the root directory
                    stack.remove(stack.size() - 1);                            //foo/.. ==> pop foo
                }
            } else {
                stack.add(token);
            }
        }

        if(stack.size()==1 && stack.get(0).equals(""))
            return "/";

        return String.join("/", stack);
    }

    public static boolean isImportantToken(String token) {
        return token.length()>0 && !token.equals(".");
    }

    public static void main(String[] args) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(shortenPath("/foo/bar/baz"));
        System.out.println(shortenPath("foo/bar/baz"));
        System.out.println(shortenPath("/../../foo/bar/baz"));
        System.out.println(shortenPath("../../foo/bar/baz"));
        System.out.println(shortenPath("/../../foo/../../bar/baz"));
        System.out.println(shortenPath("../../foo/../../bar/baz"));
        System.out.println(shortenPath("/foo/./././bar/./baz///////////test/../../../kappa"));
        System.out.println(shortenPath("./.."));
    }
}
