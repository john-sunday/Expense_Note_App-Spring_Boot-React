package com.johnsunday.app.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.johnsunday.app.entity.BaseEntity;

//@NoRepositoryBean
@Repository
public interface IBaseDao <E extends BaseEntity, ID extends Serializable> extends JpaRepository<E, ID> {

}
