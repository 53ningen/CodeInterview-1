package Datastructure;
import sun.plugin.dom.exception.InvalidStateException;

import java.io.Serializable;
public class ListQueue {
	Node head=null;
	Node tail=null;

	public class Node{
		int d;
		Node next;
		
		public Node(int d){
			this.d = d;
			this.next = null;
		}

		public int getItem(){
			return this.d;
		}

		@Override
		public boolean equals(Object obj){
			if(this == obj){
				return true;
			}
			if(!(obj instanceof Node)){
				return false;
			}
			Node node = (Node)obj; 
			if(this.d == node.d){
				return true;
			}
			return false;	  
		}
	}

	public void enqueue(int d){
		if(this.isQueueEmpty()) {
            this.addHead(d);
        }
		else{
            this.addTail(d);
		}
	}

    public void addHead(int d){
        this.head = new Node(d);
        this.tail = this.head;
    }

    public void addTail(int d){
        Node tail_tmp = this.tail;
        tail_tmp.next = new Node(d);
        this.tail = tail_tmp.next;
    }

	public int dequeue(){
        if(this.isQueueEmpty())
            throw new InvalidStateException("queue is empty");

		Node tmp_head = this.head;
        this.head = tmp_head.next;

        if(tmp_head == this.tail)
            this.tail = null;

        return tmp_head.getItem();
    }

    public boolean isQueueEmpty(){
        return tail == null;
    }
	
}