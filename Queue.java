public class Queue {

        QNode front, rear;
    
        public Queue(){
    
            this.front = this.rear = null;
        }
        
        void enqueue(car CAR){
            QNode temp = new QNode(CAR);
    
            if (this.rear == null){
                this.front = this.rear = temp;
                return;
            }
    
            this.rear.next = temp;
            this.rear = temp;
    
        }
    
        void dequeue(car CAR){
            if(this.front == null){
                return;
            }
                        
            this.front = this.front.next;
    
            if (this.front == null){
                this.rear = null;
            }
       }
    
}
