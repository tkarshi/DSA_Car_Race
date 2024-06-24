public class winner_list {
    
    int SIZE = 6;
    car myCars [] = new car[SIZE];
    int front, rear;

    winner_list(){
        front = -1;
        rear = -1;
    }

    // check if the winner_list is full
    boolean isFull(){
        if(front == 0 && rear == SIZE - 1){
            return true;

        }
        return false;
    }

    // check if the winnerlist is empty
    boolean isEmpty(){
        if(front== -1){
            return true;
        }
        else
             return false;
    }

    //insert elements to the winnerList
    void addWinner(car c){

        //if winnerList is full
        if(isFull()){
            commancode.println("winnerList is full");
        }
        else{
            if(front == -1){
                //mark front denote first element of winnerList
                front = 0;
            }

            rear++;

            //insert element at the rear
            myCars[rear] = c;
            commancode.println("Insert" + c.getCar_ID());
        }
    }

    //delete element from the winnerList

    car getWinner(){
        car c;

        //if winnerList is empty
        if(isEmpty()){
            commancode.println("WinnerList is empty");
            return null;
        }else{

            //remove element from the front of winnerList
            c = myCars[front];

            //if the winnerList has only one element
            if(front>=rear){
                front = -1;
                rear = -1;
            }
            else{
                //mark next element as the front
                front++;
            }
            return(c);
        
        }
    }

    //display element of the winnerlist
    void display(){
        int i;
        if(isEmpty()){
            commancode.println("Empty winnerList");
        }
        else{
            commancode.println("winner list");
            commancode.println("================");
            for (i = front; i<=rear ; i++) {
                myCars[i].display();
                
            }
        }
    }
    

}
