package com.LL.springApp.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LL.springApp.model.*;
public interface DataRepository extends JpaRepository<Data, Long>{
	 @Query(value = "SELECT max(id) FROM data ", nativeQuery = true)
    Long getInsertedId();
	 
}
