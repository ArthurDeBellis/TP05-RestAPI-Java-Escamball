package com.Escamball.Escamball.Controllers;

import com.Escamball.Escamball.Entity.TimeEntity;
import com.Escamball.Escamball.Models.LoginModel;
import com.Escamball.Escamball.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/Time")
public class TimeController {

    @Autowired
    TimeService timeService;

    @GetMapping("/Times")
    public List<TimeEntity> listTimes()
    {
        return timeService.findAllTimes();
    }

    @GetMapping("/GetTimePorId/{timeId}")
    public TimeEntity getTimePorId(@PathVariable(value = "timeId") int timeId)
    {
        return timeService.findTimeById(timeId);
    }

    @PostMapping("/ConfereLogin")
    public TimeEntity confereLogin(@RequestBody LoginModel login)
    {
        return timeService.confereLogin(login.getLogin(), login.getSenha());
    }

    @PostMapping("/InsereTime")
    public ResponseEntity<TimeEntity> novoTime(@RequestBody TimeEntity timeEntity)
    {
        return timeService.createTime(timeEntity);
    }

    @PutMapping("/AtualizaTime/{timeId}")
    public String atualizaTime(@PathVariable(value = "timeId") int timeId, @RequestBody TimeEntity time)
    {
        return timeService.updateTime(timeId, time);
    }

    @DeleteMapping("/DeleteTime/{timeId}")
    public String deleteTime(@PathVariable(value = "timeId") int timeId)
    {
        return timeService.deleteTime(timeId);
    }

}
