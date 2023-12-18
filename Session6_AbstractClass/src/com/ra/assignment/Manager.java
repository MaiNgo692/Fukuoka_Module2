package com.ra.assignment;

import java.util.Arrays;

public class Manager {

    private BaseEntity[] entities;
    private int defaultEl = 5;
    private int index=0;

    public Manager(){
        this.entities = new BaseEntity[defaultEl];
    }

    public void add(BaseEntity item){
        if(index == entities.length){
            entities= Arrays.copyOf(entities,entities.length+defaultEl);
        }
        entities[index++] = item;
    }
    public void show(){
        for (int i=0; i<index;i++){
            entities[i].show();
        }
    }
    public BaseEntity findId(Object id){
        for (int i=0; i<index; i++){
            if(entities[i].checkId(id)){
                return entities[i];
            }
        }
        return null;
    }
    public BaseEntity findFirst(String select,Object searchEl){
        switch (select){
            case "id":
                for (int i=0; i<index; i++){
                    if(entities[i].checkId(searchEl)){
                        return entities[i];
                    }
                }
                break;
            case "name":
                for (int i=0; i<index; i++){
                    if(entities[i].checkName(searchEl)){
                        return entities[i];
                    }
                }
                break;
            case "className":
                for (int i=0; i<index; i++){
                    if(entities[i].checkClasName(searchEl)){
                        return entities[i];
                    }
                }
                break;
        }
        return null;
    }
}
