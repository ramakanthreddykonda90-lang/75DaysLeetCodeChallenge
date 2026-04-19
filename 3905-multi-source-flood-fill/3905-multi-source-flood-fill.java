class Solution {
    static class Pair{
        int r,c,step,col;
        Pair(int r,int c,int col,int step)
        {
            this.r=r;
            this.c=c;
            this.col=col;
            this.step=step;
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid=new int[n][m];
        int[][] vis=new int[n][m];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.step!=b.step)
            return Integer.compare(a.step,b.step);
            return Integer.compare(b.col,a.col);
        });
        for(int[] a:sources)
        {
            int r=a[0];
            int c=a[1];
            int col=a[2];
            grid[r][c]=col;
            vis[r][c]=1;
            pq.add(new Pair(r,c,col,0));
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            int r=temp.r;
            int c=temp.c;
            int color=temp.col;
            int step=temp.step;
            for(int i=0;i<4;i++)
            {
                int nrow=r+row[i];
                int ncol=c+col[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0)
                {
                    grid[nrow][ncol]=color;
                    pq.add(new Pair(nrow,ncol,color,step+1));
                    vis[nrow][ncol]=1;
        //              for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
                }
            }
        }
        return grid;
    }
}