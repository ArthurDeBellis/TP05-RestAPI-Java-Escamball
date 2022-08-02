package com.Escamball.Escamball.Controllers;

import com.Escamball.Escamball.Entity.TimeEntity;
import com.Escamball.Escamball.LightModel.TimeLightModel;
import com.Escamball.Escamball.Service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TimeController {

    @Autowired
    TimeService timeService;

    @GetMapping("/Times")
    public List<TimeEntity> listTimes()
    {
        return timeService.findAllTimes();
    }

    @PostMapping("/InsereTime")
    public String novoTime(@RequestBody TimeEntity timeEntity)
    {
        return timeService.createTime(timeEntity);
    }

    @PutMapping("/AtualizaTime/{timeId}")
    public String atualizaTime(@PathVariable(value = "timeId") int timeId, @RequestBody TimeLightModel timeLightModel)
    {
        return timeService.updateTime(timeId, timeLightModel);
    }

}
