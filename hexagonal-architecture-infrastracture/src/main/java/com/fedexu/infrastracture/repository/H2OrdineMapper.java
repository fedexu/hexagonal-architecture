package com.fedexu.infrastracture.repository;

import com.fedexu.domain.ordine.Ordine;
import com.fedexu.domain.ordine.OrdineStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface H2OrdineMapper {

    @Select("SELECT * FROM ORDINI WHERE id = #{id}")
    Optional<Ordine> findById(@Param("id")UUID id);

    @Insert("INSERT INTO ORDINI (id,status,price) VALUES(#{id}, #{status}, #{price})")
    void save(@Param("id")UUID polizzaId, @Param("status") OrdineStatus status, @Param("price")BigDecimal price);

    @Insert("INSERT INTO ORDINI_ITEM (polizzaId,price,orderId) VALUES(#{polizzaId}, #{price}, #{orderId})")
    void saveItem(@Param("polizzaId")UUID polizzaId, @Param("price") BigDecimal price, @Param("orderId")UUID orderId);

}
