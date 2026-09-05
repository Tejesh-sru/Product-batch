import java.util.*;

class avl{
    static class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }
    public static Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        updateHeight(root);
        int balance=getBalance(root);
        if(balance>1 && data<root.left.data){
            return rightRotate(root);
        }
        if(balance<-1 && data>root.right.data){
            return leftRotate(root);
        }
        if(balance>1 && data>root.left.data){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && data<root.right.data){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public static Node rightRotate(Node root){
        Node a=root.left;
        Node b=a.right;
        a.right=root;
        root.left=b;
        updateHeight(root);
        return a;
    }
    public static Node leftRotate(Node root){
        Node a=root.right;
        Node b=a.left;
        a.left=root;
        root.right=b;
        updateHeight(a);
        return a;
    }
    public static void updateHeight(Node root){
        root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return getHeight(root.left)-getHeight(root.right);
    }
    public static Node deleteNode(Node root,int data){
        if(root==null){
            return root;
        }
        if(data<root.data){
            root.left=deleteNode(root.left,data);
        }
        else if(data>root.data){
            root.right=deleteNode(root.right,data);
        }
        else{
            if(root.left==null || root.right==null){
                Node temp=null;
                if(temp==root.left){
                    temp=root.right;
                }
                else{
                    temp=root.left;
                }
                if(temp==null){
                    root=null;
                }
                else{
                    root=temp;
                }
            }
            else{
                Node temp=root.right;
                while(temp.left!=null){
                    temp=temp.left;
                }
                root.data=temp.data;
                root.right=deleteNode(root.right,temp.data);
            }
        }
        if(root==null){
            return root;
        }
        updateHeight(root);
        int balance=getBalance(root);
        if(balance>1 && getBalance(root.left)>=0){
            return rightRotate(root);
        }
        if(balance>1 && getBalance(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && getBalance(root.right)<=0){
            return leftRotate(root);
        }
        if(balance<-1 && getBalance(root.right)>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+"");
        inorder(root.right);
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+"");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+"");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Node root=null;
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int data=i+1;
            root=insert(root,data);
        }
        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println("\nPreorder Traversal:");
        preorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }
}