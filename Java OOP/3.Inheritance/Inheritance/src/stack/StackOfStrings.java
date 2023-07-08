package stack;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        data.add(item);
    }

    public String peek(){
        return this.data.get(this.data.size() - 1);
    }

    public String pop(){
        var result = this.peek();
        this.data.remove(this.data.size() - 1);
        return result;
    }

    public boolean isEmpty(){
        return this.data.size() == 0;
    }
}