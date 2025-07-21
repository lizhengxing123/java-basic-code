package com.lzx.extendsDemo;

public class LiHua extends Cat{
    public LiHua(){
        super();
    }

    public LiHua(String name, int type){
        super(name, type);
    }

    public String toString() {
        return "LiHua{}" + name + type;
    }
}
