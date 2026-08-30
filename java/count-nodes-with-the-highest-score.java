class Solution {
public HashMap<Long,Integer> hash;
public int dfs(int i,List<Integer>[] adj,int totalNodes)
{
    int sumOfNodes=0;
    long product=1l;
    for(int curr : adj[i])
    {
        int currNodes=dfs(curr,adj,totalNodes);
        sumOfNodes+=currNodes;
        product*=currNodes;
    }
    int upNodes=(totalNodes-sumOfNodes-1);
    if(upNodes>0) product*=upNodes;
    hash.put(product,hash.getOrDefault(product,0)+1);
    return sumOfNodes+1;
}
public int countHighestScoreNodes(int[] parents) 
{
    List<Integer>[] adj=new ArrayList[parents.length];
    for(int i=0;i<parents.length;i++)  adj[i]=new ArrayList();
    for(int i=1;i<parents.length;i++)
    {
        adj[parents[i]].add(i);
    }
    hash=new HashMap<>();
    dfs(0,adj,parents.length);
    long max=0;
    for(long i : hash.keySet()) max=Math.max(max,i);
    return hash.get(max);
}
}