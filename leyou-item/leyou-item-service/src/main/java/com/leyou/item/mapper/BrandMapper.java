package com.leyou.item.mapper;

import com.item.leyou.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


/**
 * Brand通用Mapper
 *
 * @author lc
 */
@Repository
public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand values(#{cid},#{bid})")
    void insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

}
