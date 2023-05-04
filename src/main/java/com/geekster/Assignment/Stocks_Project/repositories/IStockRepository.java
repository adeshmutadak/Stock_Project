package com.geekster.Assignment.Stocks_Project.repositories;

import com.geekster.Assignment.Stocks_Project.models.Stock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface IStockRepository extends CrudRepository<Stock, Integer> {
    //This is custom finder  Custom finder Used when some method are not predefined in CRUD Repository
public List<Stock>findByStockType(String stockType);
public List<Stock>findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockName(Double price, LocalDateTime data);


//custom Query :Native  when we are using a native query used the Databases names
    @Query(value = "select * from STOCK where  Stock_Market_Cap >:capPercentage ", nativeQuery = true)
    public List<Stock>getAllStocksAboveMarketCap(Double capPercentage);

    //update using a custom query  and used to MOdifying ANnotation
    @Modifying  // use to reflect the changes in database
    @Query(value = "update Stock set Stock_Market_Cap =:capPercentage where Stock_Id=:id ",nativeQuery = true)
    public void updateMarketByID(Double capPercentage, Integer id);


 @Modifying
    @Query(value = "Delete from Stock where Stock_owner_count<=:userCount ", nativeQuery = true)
    public  void deleteStockBasedOnCount(Integer userCount);
}
