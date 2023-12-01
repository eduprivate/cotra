package br.eduprivate.problems_solving.longestcommonsubstring;

import java.io.*;

// see geeksforgeeks

class SpaceOptimizedLongestCommonSubstring
{

    // Function to find the length of the
    // longest LCS
    static int LCSubStr(String s,String t,
                        int n,int m)
    {

        // Create DP table
        int dp[][]=new int[2][m+1];
        int res=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                    if(dp[i%2][j]>res)
                        res=dp[i%2][j];
                }
                else dp[i%2][j]=0;
            }
        }
        return res;
    }

    // Driver Code
    public static void main (String[] args)
    {
        String X="OldSite:GeeksforGeeks.org";
        String Y="NewSite:GeeksQuiz.com";

        int m=X.length();
        int n=Y.length();

        // Function call
        System.out.println(LCSubStr(X,Y,m,n));

    }
}