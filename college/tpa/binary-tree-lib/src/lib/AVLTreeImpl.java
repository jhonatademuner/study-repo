package lib;

import java.util.Comparator;

public class AVLTreeImpl <T> extends BinaryTreeImpl<T>{

    public AVLTreeImpl(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected Node<T> adicionarRec(Node<T> currentNode, Node<T> newNode){  
        currentNode = super.adicionarRec(currentNode, newNode);
        return balanceNode(currentNode);
    }

    @Override
    protected Node<T> removerRec(Node<T> currentNode, T valor) {

        if (currentNode == null) return null;

        int comparisonResult = this.comparator.compare(currentNode.getValor(), valor);

        if (comparisonResult > 0) {
        currentNode.setFilhoEsquerda(removerRec(currentNode.getFilhoEsquerda(), valor));


        } else if (comparisonResult < 0) {
        currentNode.setFilhoDireita(removerRec(currentNode.getFilhoDireita(), valor));

        } else {


            if (currentNode.getFilhoEsquerda() == null) {
                return currentNode.getFilhoDireita();

            } else if (currentNode.getFilhoDireita() == null) {
                return currentNode.getFilhoEsquerda();
                
            } else {

                if (this.getNodeHeight(currentNode.getFilhoEsquerda()) > this.getNodeHeight(currentNode.getFilhoDireita())) {

                T successorValue = findMax(currentNode.getFilhoEsquerda()).getValor();
                currentNode.setValor(successorValue);

                currentNode.setFilhoEsquerda(removerRec(currentNode.getFilhoEsquerda(), successorValue));

                } else {

                T successorValue = findMin(currentNode.getFilhoDireita()).getValor();
                currentNode.setValor(successorValue);

                currentNode.setFilhoDireita(removerRec(currentNode.getFilhoDireita(), successorValue));
                }
            }
        }
        return balanceNode(currentNode);
    }

    public Node<T> rightRotate(Node<T> node){
        Node<T> childNode = node.getFilhoEsquerda();   
        node.setFilhoEsquerda(childNode.getFilhoDireita());  
        childNode.setFilhoDireita(node);
        return childNode;
    }

    public Node<T> leftRotate(Node<T> node){
        Node<T> childNode = node.getFilhoDireita();
        node.setFilhoDireita(childNode.getFilhoEsquerda());
        childNode.setFilhoEsquerda(node);
        return childNode;
    }

    public Node<T> rightLeftRotate(Node<T> node){
        node.setFilhoDireita(this.rightRotate(node.getFilhoDireita()));
        return this.leftRotate(node);
    }
                
    public Node<T> leftRightRotate(Node<T> node){
        node.setFilhoEsquerda(this.leftRotate(node.getFilhoEsquerda()));
        return this.rightRotate(node);
    }

    private int getNodeHeight(Node<T> node){
        if(node == null){
            return -1;
        } else {
            int rightHeight = this.getNodeHeight(node.getFilhoDireita());
            int leftHeight = this.getNodeHeight(node.getFilhoEsquerda());
            return rightHeight > leftHeight ? rightHeight + 1 : leftHeight + 1;
        }
    }
    
    private int getBalanceFactor(Node<T> node){
        return getNodeHeight(node.getFilhoDireita()) - getNodeHeight(node.getFilhoEsquerda());
    }

    private Node<T> balanceNode(Node<T> node) {
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1) {
            if(getBalanceFactor(node.getFilhoDireita()) < 0){
                node = rightLeftRotate(node);
            } else {
                node = leftRotate(node);
            }
        } else if(balanceFactor < -1){
            if(getBalanceFactor(node.getFilhoEsquerda()) > 0){
                node = leftRightRotate(node);
            } else {
                node = rightRotate(node);
            }
        }
        return node;
    }

}
