package com.adem.readingisgood.repository;

import com.adem.readingisgood.dto.StatisticsDto;
import com.adem.readingisgood.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findByOrderId(Long orderId);

    @Query(value = "select new com.adem.readingisgood.dto.StatisticsDto(extract('month' from o.createdDate), count(distinct o.order.id), sum(o.count), sum(b.price * o.count)) " +
            "from OrderItems o left join Book b on o.book.id = b.id group by extract('month' from o.createdDate)")
    List<StatisticsDto> statistics();

}
