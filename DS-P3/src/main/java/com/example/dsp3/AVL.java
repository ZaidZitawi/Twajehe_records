package com.example.dsp3;


public class AVL {
    public AVLNode rootNode;
    int h;
    String buffer = "";

    //default Const.
    public AVL() {
        rootNode = null;
        h=0;
    }


    public int getHeight(AVLNode node) {
        if (node == null)
            return -1;
        return node.height;
    }
    public int getheight(AVLNode node) {
        node.height=rootNode.height;
        return node.height;
    }
    private void updateHeight(AVLNode node) {
        int leftChildHeight = getHeight(node.left);
        int rightChildHeight = getHeight(node.right);
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    private int balanceFactor(AVLNode node) {
        return getHeight(node.right) - getHeight(node.left);
    }


    public int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    public Student Search(int seatNum){
        AVLNode curr = rootNode;
        while(curr != null)
            if(curr.student.getSeatNum() == seatNum){
                return curr.student;
            } else if (curr.student.getSeatNum() > seatNum) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        return null;
    }
    public void UpdateAVL(Student s, int seatnumber, String branch, double avg) {
//        Search(seatnumber);
        s.setSeatNum(seatnumber);
        s.setBranch(branch);
        s.setAverage(avg);

    }


    public Student searchNode(AVLNode node, int key) {
        if ( node== null) {
            return null;  // missing from tree
        } else if (key < node.seatNumber) {
            return searchNode(node.left, key);
        } else if (key > node.seatNumber) {
            return searchNode(node.right, key);
        } else {
            return node.student;  // found it
        }
    }
    //===============FOR AVL1 (SEAT NUMBER AVL)==========================================
    public void insertAVL1(Student student) {
        rootNode = insertReference(student, rootNode);
    }

    public AVLNode insertReference(Student student, AVLNode node) {
        if (node == null)
            node = new AVLNode(student);
        else if (student.getSeatNum() < node.seatNumber) {
            node.left = insertReference(student, node.left);
            if (getHeight(node.left) - getHeight(node.right) == 2)
                if (student.getSeatNum() < node.left.seatNumber)
                    node = rotateRight(node);
                else
                    node = rebalance(node);
        } else if (student.getSeatNum() > node.seatNumber) {
            node.right = insertReference(student, node.right);
            if (getHeight(node.right) - getHeight(node.left) == 2)
                if (student.getSeatNum() > node.right.seatNumber)
                    node = rotateLeft(node);
                else
                    node = rebalance(node);
        } else

        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;
        h++;

        return node;

    }

    //===============FOR AVL1 (SEAT NUMBER AVL)==========================================//


    private AVLNode rotateRight(AVLNode node) {
        AVLNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private AVLNode rebalance(AVLNode node) {
        int balanceFactor = balanceFactor(node);

        // when the right child if the root has left child, then we called this grandson left heavy
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {    // Case 1
                // Rotate right
                node = rotateRight(node);
            } else {                                // Case 2
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {    // Case 3
                // Rotate left
                node = rotateLeft(node);
            } else {                                 // Case 4
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    public void inorderSeatNumber() {
        inorderTraversalSeatNumber(rootNode);
    }

    public void inorderTraversalSeatNumber(AVLNode head) {
        if (head != null) {
            inorderTraversalSeatNumber(head.left);
            System.out.print(head.student + "\n");
            inorderTraversalSeatNumber(head.right);
        }
    }


    // ++++++++++++Inorder for setText Function++++++++++++
    public String PrintAVL1() {
        System.out.println("\n");
        String buffer = "";
        buffer = RecursivePrint(rootNode);
        return buffer;
    }

    public String RecursivePrint(AVLNode rootNode) {
        if (rootNode != null) {
            RecursivePrint(rootNode.left);
            buffer = buffer.concat(rootNode.student+ "\n");
            RecursivePrint(rootNode.right);

        }
        return buffer;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    //===============FOR AVL2 (Average AVL)==========================================//
    public void insertAVL2(double element) {
        rootNode = insertAverage(element, rootNode);
    }

    public AVLNode insertAverage(double element, AVLNode node) {
        if (node == null)
            node = new AVLNode(element);

        else if (element < node.avg) {
            node.left = insertAverage(element, node.left);
            if (getHeight(node.left) - getHeight(node.right) == 2)
                if (element < node.left.avg)
                    node = rotateRight(node);
                else
                    node = rebalance(node);
        } else if (element > node.avg) {
            node.right = insertAverage(element, node.right);
            if (getHeight(node.right) - getHeight(node.left) == 2)
                if (element > node.right.avg)
                    node = rotateLeft(node);
                else
                    node = rebalance(node);
        } else{
//              Student NewStudent = new Student(element);
//              Student curr =node.student;
//              while (curr!=null){
//                  curr=curr.next;
//              }
//              curr.next= NewStudent;
        }
        node.height = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;

        return node;

    }


    public void inorderAvg() {
        inorderTraversalAvg(rootNode);
    }

    public void inorderTraversalAvg(AVLNode head) {
        if (head != null) {
            inorderTraversalAvg(head.left);
            System.out.print(head.avg + " || ");
            inorderTraversalAvg(head.right);
        }
    }

    public String PrintAVL2() {
        System.out.println("\n");
        String buffer = "";
        buffer = RecursivePrintAverage(rootNode);
        return buffer;
    }

    public String RecursivePrintAverage(AVLNode rootNode) {
        if (rootNode != null) {
            RecursivePrintAverage(rootNode.left);
            buffer = buffer.concat(rootNode.avg + "\n");
            RecursivePrintAverage(rootNode.right);

        }
        return buffer;
    }

    public AVLNode deleteNode(AVLNode rootNode, Student student)
    {
        if (rootNode == null)
            return rootNode;

        if (student.getSeatNum() < rootNode.seatNumber)
            rootNode.left = deleteNode(rootNode.left, student);

        else if (student.getSeatNum() > rootNode.seatNumber)
            rootNode.right = deleteNode(rootNode.right, student);

        else
        {

            if ((rootNode.left == null) || (rootNode.right == null))
            {
                AVLNode temp = null;
                if (temp == rootNode.left)
                    temp = rootNode.right;
                else
                    temp = rootNode.left;

                if (temp == null)
                {
                    temp = rootNode;
                    rootNode = null;
                }
                else
                    rootNode = temp;
            }
            else
            {

                AVLNode temp = MinimumValueOfNods(rootNode.right);

                rootNode.seatNumber = temp.seatNumber;

                rootNode.right = deleteNode(rootNode.right, temp.student);
            }
        }

        if (rootNode == null)
            return rootNode;

        rootNode.height = getMaxHeight(getHeight(rootNode.left), getHeight(rootNode.right)) + 1;
        int balance = balanceFactor(rootNode);

        if (balance > 1 && balanceFactor(rootNode.left) >= 0)
            return rotateRight(rootNode);

        if (balance > 1 && balanceFactor(rootNode.left) < 0)
        {
            rootNode.left = rotateLeft(rootNode.left);
            return rotateRight(rootNode);
        }

        if (balance < -1 && balanceFactor(rootNode.right) <= 0)
            return rotateLeft(rootNode);

        if (balance < -1 && balanceFactor(rootNode.right) > 0)
        {
            rootNode.right = rotateRight(rootNode.right);
            return rotateLeft(rootNode);
        }

        return rootNode;
    }
    AVLNode MinimumValueOfNods(AVLNode node)
    {
        AVLNode temp=node;
        while (temp.left!=null)
            temp=temp.left;


        return temp;
    }

    //===============FOR AVL2 (Average AVL)==========================================//
}