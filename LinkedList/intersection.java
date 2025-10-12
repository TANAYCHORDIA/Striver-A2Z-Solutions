package LinkedList;

class intersection{
    public static void main(String[] args) {
        Node common = new Node(8);
        common.next = new Node(10);

        Node headA = new Node(3);
        headA.next = new Node(7);
        headA.next.next = common;

        Node headB = new Node(99);
        headB.next = new Node(1);
        headB.next.next = common;

        Node intersectionNode = getIntersectionNodeOptimal(headA, headB);
        if (intersectionNode != null) {
            System.out.println("Intersection at node with value: " + intersectionNode.data);
        } else {
            System.out.println("No intersection");
        }
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;
        int cntA= 0;
        int cntB = 0;
        while(tempA!= null){
            cntA++;
            tempA = tempA.next;
        }
        while(tempB!= null){
            cntB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        int cnt = (cntA>cntB)?cntA-cntB:cntB-cntA;
        if(cntA>cntB){
            for(int i=0;i<cnt;i++)tempA=tempA.next;
        }
        else{
            for(int i=0;i<cnt;i++)tempB=tempB.next;
        }
        while(tempA!=null && tempB!=null){
            if(tempA == tempB)return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
    public static Node getIntersectionNodeOptimal(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;
        while(tempA!= tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == tempB)return tempA;
            if(tempA == null)tempA = headB;
            else if(tempB == null)tempB = headA;
        }
        return tempA;
    }
}