package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b11LowestCommonManager {

    //Time : n || Space : d   ==> n = number of people in the org & d=depth or height of org chart
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
    }

    private static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int numImportantReports = 0;

        for(OrgChart report : manager.directReports) {
            OrgInfo orgInfo = getOrgInfo(report, reportOne, reportTwo);
            if(orgInfo.lowestCommonManager != null) {
                return orgInfo;
            }
            numImportantReports += orgInfo.numImportantReportCount;
        }
        if(manager == reportOne || manager == reportTwo)  numImportantReports++;
        OrgChart lowestCommonManager = numImportantReports==2 ? manager : null;
        return new OrgInfo(lowestCommonManager, numImportantReports);
    }

    static class OrgInfo {
        public OrgChart lowestCommonManager;
        public int numImportantReportCount;

        public OrgInfo(OrgChart lowestCommonManager, int numImportantReportCount) {
            this.lowestCommonManager = lowestCommonManager;
            this.numImportantReportCount = numImportantReportCount;
        }
    }



        static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    public static void main(String[] args) {
        testCase1();
    }
        public static HashMap<Character, OrgChart> getOrgCharts() {
        HashMap<Character, OrgChart> orgCharts = new HashMap<Character, OrgChart>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            orgCharts.put(a, new OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new OrgChart[] {orgCharts.get('Z')});
        return orgCharts;
    }

    public static void testCase1() {
        HashMap<Character, OrgChart>  orgCharts = getOrgCharts();
        orgCharts
                .get('A')
                .addDirectReports(new OrgChart[] {orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
                .get('B')
                .addDirectReports(new OrgChart[] {orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
                .get('C')
                .addDirectReports(new OrgChart[] {orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
                .get('D')
                .addDirectReports(new OrgChart[] {orgCharts.get('H'), orgCharts.get('I')});

        OrgChart lcm =
                getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I'));
        System.out.println(lcm == orgCharts.get('B'));

    }


}
