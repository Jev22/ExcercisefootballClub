package com.company;

public class CustomListNode{
    CustomListNode next;
    MemberPlayer value;
    CustomListNode(MemberPlayer v){
        value=v;
    }
    CustomListNode(MemberPlayer v, CustomListNode n) {
        next = n;
        value = v;
    }
}
