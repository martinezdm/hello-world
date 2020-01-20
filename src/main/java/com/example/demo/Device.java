package com.example.demo;
import javax.persistence.*;

@Entity
@Table(name="device")
public class Device {
    @Id
    @Column(nullable=false)
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private Integer vol;
    @Column(nullable=false)
    private Boolean status;
    @Column(nullable=false)
    private String cmd;
    
    public String undo(){
        String was = cmd;
        if (cmd.equals("switch")){
            onOff();
            cmd = "";
            return was;
        }
        if (cmd.equals("volup")){
            volDown();
            cmd = "";
            return was;
        }
        if (cmd.equals("voldown")){
            volUp();
            cmd = "";
            return was;
        }
        return "can't undo";
    }
    public void onOff(){
        this.status = !status;
        this.cmd = "switch";
    }
    public void volUp(){
        vol += 1;
        this.cmd = "volup";
    }
    public void volDown(){
        vol -= 1;
        this.cmd = "voldown";
    }
    public void Cmd(String cmd){
        this.cmd = cmd;
    }
    
    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setVol(int vol){
        this.vol = vol;
    }
    
    
    
    
    public String getCmd(){
        return cmd;
    }
    public String getName(){
        return name;
    }
    public Integer getVol(){
        return vol;
    }
    public Boolean getStatus(){
        return status;
    }
    public Integer getId(){
        return id;
    }
    public String getStatusString(){
        return status ? "on" : "off";
    }
    
    @Override
    public String toString(){
        return String.format("(%d-%s-%s, vol:%d, cmd:%s)", id, name, getStatusString(), vol, cmd);
    }
}
