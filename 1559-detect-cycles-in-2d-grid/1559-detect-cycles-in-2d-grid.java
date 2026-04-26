class Solution {
    static class Pair{
        int r,c,pr,pc;
        Pair(int r,int c,int pr,int pc)
        {
            this.r=r;
            this.c=c;
            this.pr=pr;
            this.pc=pc;
        }
    }
    public static boolean bfs(int i,int j,int n,int m,char[][] grid,boolean[][] visited,int[] row,int[] col)
    {
        visited[i][j]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j,-1,-1));
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            int r=t.r;
            int c=t.c;
            int pr=t.pr;
            int pc=t.pc;
            for(int k=0;k<4;k++)
            {
                int nr=row[k]+r;
                int nc=col[k]+c;
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[r][c]==grid[nr][nc])
                {
                    if(!visited[nr][nc])
                    {
                        visited[nr][nc]=true;
                        q.add(new Pair(nr,nc,r,c));
                    }
                   else if (nr != pr || nc != pc) {
                        return true;
                    }
                }
            }
        }
            return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!visited[i][j])
                {
                    if(bfs(i,j,n,m,grid,visited,row,col))
                    return true;
                }
            }
        }
        return false;
    }
}