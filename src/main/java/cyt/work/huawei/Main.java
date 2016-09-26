package cyt.work.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @ClassName:
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * @version:
 * @Date: 2016/7/13
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
import java.util.*;
public class Main{
    public static void main(String args[]){
        countVote();
    }
    public static void countVote(){
        Scanner cin = new Scanner(System.in);
        int a, b;
        String[] inputLine;
        int errorVote=0;
       // Map<String,Integer> vote=new HashMap<String, Integer>();
        Map<String,Integer> vote=new LinkedHashMap<String, Integer>();
        while (cin.hasNext()){
            /*a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);*/
            inputLine=cin.nextLine().split(" ");
            if(inputLine.length==2){
                if(inputLine[0].matches("add")){
                    vote.put(inputLine[1],0);
                }else if(inputLine[0].matches("vote")){
                    if(vote.containsKey(inputLine[1])){
                        vote.put(inputLine[1],vote.get(inputLine[1])+1);
                    }else{
                        errorVote++;
                    }

                }
            }else if(inputLine[0].matches("getVoteResult")){
                for(String str : vote.keySet()){
                    System.out.println(str+ " "+vote.get(str));
                }
                System.out.println(errorVote);
                break;
            }

        }
    }


        private static boolean find=false;
        private static boolean[][] flag;

        public static void maze() {
            Scanner sc=new Scanner(System.in);
            int n,m;
            String word;
            char[][] maze;
            while(sc.hasNext()){
                n=sc.nextInt();
                m=sc.nextInt();
                maze=new char[n][m];
                flag=new boolean[n][m];
                word=sc.next();
                for(int i=0;i<n;i++){
                    maze[i]=sc.next().toCharArray();
                }
                startfind(n,m,word,maze);
                if(find){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            }
            sc.close();

        }

        private static void startfind(int n,int m,String word,char[][]maze){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(maze[i][j]==word.charAt(0)){
                        flag[i][j]=true;
                        next(word,1,i,j,maze);
                        if(find)
                            return;
                    }
                }
            }

        }

        private static void next(String word,int index,int row,int col,char[][] maze){
            int n=maze.length;
            int m=maze[0].length;
            if(index==word.length()){
                find=true;
                return;
            }
            int nextIndex=index+1;
            if(row-1>=0&&!flag[row-1][col]){
                if(maze[row-1][col]==word.charAt(index)){
                    flag[row-1][col]=true;
                    next(word,nextIndex,row-1,col,maze);
                }
            }
            if(row+1<n&&!flag[row+1][col]){
                if(maze[row+1][col]==word.charAt(index)){
                    flag[row+1][col]=true;
                    next(word,nextIndex,row+1,col,maze);
                }
            }
            if(col+1<m&&!flag[row][col+1]){
                if(maze[row][col+1]==word.charAt(index)){
                    flag[row][col+1]=true;
                    next(word,nextIndex,row,col+1,maze);
                }
            }
            if(col-1>=0&&!flag[row][col-1]){
                if(maze[row][col-1]==word.charAt(index)){
                    flag[row][col-1]=true;
                    next(word,nextIndex,row,col+1,maze);
                }
            }
            flag[row][col]=false;
        }


    }
