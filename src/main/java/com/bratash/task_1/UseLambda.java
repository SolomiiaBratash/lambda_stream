package com.bratash.task_1;

public class UseLambda {
    public static void main(String[] args) {
        Operationable op;
        op =(a,b,c)->{
            if(a > b && a >c )
                return a;
            else if (b > a && b > c)
                return b;
            else
                return c;
        };
        System.out.println("Max value: " + op.operation(7,8,2));

        op=(a,b,c)->(a+b+c)/3;
        System.out.println("Average " + op.operation(7,7,1));
    }
}
