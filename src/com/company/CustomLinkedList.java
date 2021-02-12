package com.company;

public class CustomLinkedList{
    CustomListNode first;
    CustomListNode last;
    CustomLinkedList(){}
    CustomLinkedList(MemberPlayer[] playerArray){
        for(MemberPlayer player:playerArray){
            add(player);
        }
    }
    public void add(MemberPlayer player){
        if(first==null) {
            first = new CustomListNode(player);
            last = first;
        }else{
            last.next = new CustomListNode(player);
            last = last.next;
        }
    }
    int size(){
        CustomListNode current = first;
        int size = 0;
        while (current!=null){
            size++;
            current=current.next;
        }
        return size;
    }
    //addAll er ny
    void addAll(CustomLinkedList newList){
        CustomListNode currentInNewList = newList.first;
        while(currentInNewList!=null){
            add(currentInNewList.value);
            currentInNewList=currentInNewList.next;
        }
    }
    //remove er ny
    void remove(MemberPlayer player) {
        CustomListNode current = first;
        CustomListNode beforeCurrent = null;
        while (current!=null){
            if(current.value==player){
                if(beforeCurrent==null){
                    first = first.next;
                }else{
                    beforeCurrent=current.next;
                }
                return;
            }
            beforeCurrent=current;
            current=current.next;
        }
    }
    @Override
    public String toString() {
        CustomListNode current= first;
        String output="";
        while (current!=null){
            output+=current.value+"\n";
            current=current.next;
        }
        return output;
    }
}
