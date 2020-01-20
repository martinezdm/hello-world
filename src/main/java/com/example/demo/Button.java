package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="button")
public class Button {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false)
    private String cmd;
    
    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getCmd(){
        return cmd;
    }
    public Integer getId(){
        return id;
    }
    @Override
    public String toString(){
        return String.format("(%d-%s)", id, cmd);
    }
}
