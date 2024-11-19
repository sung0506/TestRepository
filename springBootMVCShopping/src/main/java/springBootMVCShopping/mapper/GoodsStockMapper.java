package springBootMVCShopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springBootMVCShopping.domain.GoodsStockDTO;

@Mapper
public interface GoodsStockMapper {
	public GoodsStockDTO goodsStockSelectOne(String goodsNum);
	public int goodsVisitCountUpdate(String goodsNum);
}