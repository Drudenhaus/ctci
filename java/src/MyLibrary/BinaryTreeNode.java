package MyLibrary;

public class BinaryTreeNode
{
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;

    public BinaryTreeNode(int data)
    {
        this.data = data;
    }

    public void setRightChild(BinaryTreeNode rightNode)
    {
        this.right = rightNode;
        rightNode.parent = this;
    }

    public void setLeftChild(BinaryTreeNode leftChild)
    {
        this.left = leftChild;
        leftChild.parent = this;
    }
}
