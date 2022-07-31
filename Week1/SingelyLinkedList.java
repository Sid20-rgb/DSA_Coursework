package Week1;
public class SingelyLinkedList {

    public static class Node //class to create a node
    {
        Node next; //initializing the next node
        int data; //initializing the data integer
        Node(int data) //constructor
        {
            this.data= data; //setting the data integer
            this.next= null; //setting the next node to null
        }
    }
    Node head= null; //initializing the head node to null
    Node tail= null; //initializing the tail node to null
    int size = 0; //initializing the size integer to 0

    public void addNode(int data) //method to add a node
    {
        size++; //incrementing the size integer
        Node newnode = new Node(data); //creating a new node
        if(head == null) //if the head is null, then set the head to the new node
        {
            head = tail= newnode; //setting the head and tail to the new node
        }
        else //if the head is not null, then set the tail to the new node
        {
            tail.next = newnode; //setting the next node of the tail to the new node
            tail = newnode; //setting the tail to the new node
        }

    }

    public int getSize() //method to get the size of the linked list
    {
        return size; //returning the size integer
    }

    public void printSinglyLinkedList() //method to print the linked list
    {
        if (!isEmpty()) //if the linked list is not empty, then print the linked list
        {
            Node current = head; //setting the current node to the head node

            while (current.next != null) //loop through the linked list
            {
                System.out.print(current.data + " -> "); //print the data of the current node
                current = current.next; //set the current node to the next node
            }
            System.out.print(current.data); //print the data of the current node
            System.out.println(); //print a new line
        }
    }


    boolean isEmpty() //method to check if the linked list is empty
    {
        return head == null; //returning true if the head is null, otherwise return false
    }

    public int getDataAtAnyPos(int pos) //method to get the data at a certain position
    {
        Node current = head; //setting the current node to the head node
        for(int i=1; i<=pos; i++) //loop through the linked list
        {
            current = current.next; //set the current node to the next node
        }
        return current.data; //return the data of the current node  
    }
    
}
