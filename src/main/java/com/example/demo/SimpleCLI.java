/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

//import org.springframework.shell.core.annotation.CliCommand;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.ui.Model;

//import org.springframework.shell.core.annotation.CliOption;
//import org.springframework.stereotype.Component;
//import org.springframework.shell.core.CommandMarker;


/**
 *
 * @author vadim
 */
@ShellComponent
public class SimpleCLI {
  private final CLIService cliService;
  
  @Autowired
  public DeviceService deviceService;
  @Autowired
  public ButtonService buttonService;
  
  public SimpleCLI(CLIService cliService){
      this.cliService = cliService;
  }
  
  @ShellMethod(key = "switch", value="switch device_id on/off ex: switch 1 on")
  public String switch_device(@ShellOption({"device_id"}) Integer device_id){
      Device device = deviceService.getDevice(device_id);
      device.onOff();
      deviceService.saveDevice(device);
      return String.format("ok, new status = %s", device.getStatusString());
  }
  @ShellMethod(key = "volup", value="volume up device_id ex: volup 1")
  public String volup(@ShellOption({"device_id"}) Integer device_id){
      Device device = deviceService.getDevice(device_id);
      device.volUp();
      deviceService.saveDevice(device);
      return String.format("ok, new volume = %d", device.getVol());
  }
  @ShellMethod(key = "voldown", value="volume down device_id ex: voldown 1")
  public String voldown(@ShellOption({"device_id"}) Integer device_id){
      Device device = deviceService.getDevice(device_id);
      device.volDown();
      deviceService.saveDevice(device);
      return String.format("ok, new volume = %d", device.getVol());
  }
  @ShellMethod(key = "undo", value="undo device_id last operation if possible ex: undo 1")
  public String undo(@ShellOption({"device_id"}) Integer device_id){
      Device device = deviceService.getDevice(device_id);
      String res = device.undo();
      deviceService.saveDevice(device);
      return String.format("ok, undo = %s", res);
  }
  
  @ShellMethod(key = "create", value="create button with cmd ex: create act1")
  public String create_button(@ShellOption({"cmd"}) String cmd){
      buttonService.createButton(cmd);
      return "created";
  }
  @ShellMethod(key = "list", value="list buttons/devices ex: list buttons")
  public String list(@ShellOption({"object"}) String object){
      if (object.equals("buttons")){
          return buttonService.getList().toString();
      }
      if (object.equals("devices")){
          return deviceService.getList().toString();
      }
      return "unknown object";
  }
  @ShellMethod(key = "cmd", value="call cmd on device ex: cmd 1 action1")
  public String cmd(@ShellOption({"device_id"}) Integer device_id, @ShellOption({"cmd"}) String cmd){
      Device device = deviceService.getDevice(device_id);
      device.Cmd(cmd);
      deviceService.saveDevice(device);
      return "created";
  }
}
/*
@Component
public class SimpleCLI implements CommandMarker{
    @CliCommand(value={"web-get","wg"}, help="myhelp")
    public void webGet(@CliOption(key="url") String url){
        System.out.print("donwload url:"+url);
    }
}*/
