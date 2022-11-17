package com.adem.readingisgood.controller;

import com.adem.readingisgood.dto.StatisticsDto;
import com.adem.readingisgood.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping
    public List<StatisticsDto> statisticsDtoList() {
        return statisticsService.statisticsDtoList();
    }
}
