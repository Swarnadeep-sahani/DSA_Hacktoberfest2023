import java.util.Queue;
import java.util.*;

class BinaryTree{
    private treeNode root;
    private class treeNode{
        private int data;
        private treeNode left;
        private treeNode right;
     treeNode(int data){
            this.data=data;
        }
    }
    void create()
        {
            treeNode first=new treeNode(9);
            treeNode second=new treeNode(2);
            treeNode third=new treeNode(3);
            treeNode forth=new treeNode(4);
            treeNode fifth=new treeNode(5);
            treeNode sixth=new treeNode(11);
            treeNode seven=new treeNode(12);

            root=first;
            first.left=second;
            first.right=third;   
            second.left=forth;
            second.right=fifth;
            third.left=sixth;
            third.right=seven;
        }
    void preOrder(treeNode root)
        {
            if (root==null) {
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
  void inorder(treeNode root)
        {
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right); 
        }
   void postOrder(treeNode root)
        {
            if(root==null)
            {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        void levelWise(treeNode root)
        {
            if(root==null)
            {
                return;
            }
            Queue<treeNode>queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty())
            {
                treeNode temp=queue.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                {
                    queue.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.offer(temp.right);
                }
            }
        }
        Vector<Integer>rightview(treeNode root)
        {
            Vector<Integer>ans=new Vector<>();
            Queue<treeNode>q=new LinkedList<>();
            q.offer(root);
            if(root==null) {return ans;} 
            while (true) {
                int size=q.size();
                if(size==0) return ans;
                int val=0;
                while (size>0) {
                    treeNode temp=q.peek();
                    q.poll();
                    val=temp.data;
                    if(temp.left!=null)
                       q.offer(temp.left);
                    if(temp.right!=null)
                        q.offer(temp.right);
                    size--;       
                }
                ans.add(val);
            }
        }
       public static ArrayList<ArrayList<Integer>>levelOrder(treeNode root)
        {
            ArrayList<ArrayList<Integer>>ans=new ArrayList<ArrayList<Integer>>();
            if(root==null) return ans;
            Queue<treeNode>q=new LinkedList<>();
            q.offer(root);
            while(true)
            {
                int n=q.size();
                if(n==0) return ans;
                ArrayList<Integer>val=new ArrayList<>();
                while (n>0) {
                    treeNode temp=q.poll();
                    q.poll();
                    val.add(temp.data);
                    if(temp.left!=null) q.offer(temp.left);
                    if(temp.right!=null) q.offer(temp.right);
                    n--;
                }
                ans.add(val);
            }
        }
    public static void main(String[] args) {
            BinaryTree bt=new BinaryTree();
            bt.create();
            // bt.preOrder(bt.root);
            // System.out.println("Inorder:");
            // bt.inorder(bt.root);
            // System.out.println("Postorder:");
            // bt.postOrder(bt.root);
            // System.out.println("Level order:");
            // bt.levelWise(bt.root);
            // Vector<Integer>view=bt.rightview(bt.root);
            // System.out.println(view);
           // bt.levelWise(bt.root);
           ArrayList<ArrayList<Integer>>ans=levelOrder(bt.root);
           System.out.print(ans);
        }

}
