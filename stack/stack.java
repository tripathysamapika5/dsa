public class Stack{
    private int capacity, top;
    private int stack[];
    Stack(int capacity){
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[capacity];
    }
    public Boolean isEmpty(){
        return this.top == -1;
    }
    public Boolean isFull() {
        return this.top + 1 == this.capacity;
    }
    public void push(int item) {
        if (this.isFull()) {
            System.out.println("The stack is full. Push operation cant be performed...");
            System.exit(1);
        } else {
            this.stack[++this.top] = item;
        }
    }
    public int pop(){
        if (this.isEmpty()) {
            System.out.println("The stack is Empty. Pop operation cant be performed...");
            System.exit(1);
        }
        return this.stack[this.top--];

    }
    public int size(){
        return this.top +1;
    }
    public int peek(){
        if (this.isEmpty()){
            System.out.println("Stack is empty nothing to peek");
            System.exit(1);
        }
        return this.stack[this.top];
    }
    public void printStack(){
        for (int item : this.stack){
            System.out.println(item);
        }
    }
    public static void main(String args[]){
        Stack stk = new Stack(5);
        System.out.println(stk.peek());
        System.out.println("pop "+ stk.pop());
        stk.push(-2);
        stk.push(5);
        stk.printStack();
        System.out.println(stk.peek());
        stk.pop();
        stk.printStack();
        stk.push(10);
        stk.push(15);
        stk.push(20);
        stk.push(25);
        stk.printStack();
        System.out.println(stk.peek());
        stk.push(30);
        System.out.println(stk.size());

    }
}
