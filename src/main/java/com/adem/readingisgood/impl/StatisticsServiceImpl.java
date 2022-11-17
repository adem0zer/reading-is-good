package com.adem.readingisgood.impl;

import com.adem.readingisgood.dto.StatisticsDto;
import com.adem.readingisgood.repository.OrderItemRepository;
import com.adem.readingisgood.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private final OrderItemRepository orderItemRepository;

    @Override
    @Transactional
    public List<StatisticsDto> statisticsDtoList() {
        return orderItemRepository.statistics();
    }
}
