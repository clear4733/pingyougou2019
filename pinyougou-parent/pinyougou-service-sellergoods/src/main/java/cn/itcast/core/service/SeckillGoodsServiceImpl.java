package cn.itcast.core.service;

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.dao.good.GoodsDao;
import cn.itcast.core.dao.good.GoodsDescDao;
import cn.itcast.core.dao.item.ItemCatDao;
import cn.itcast.core.dao.item.ItemDao;
import cn.itcast.core.dao.seckill.SeckillGoodsDao;
import cn.itcast.core.dao.seller.SellerDao;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.Goods;
import cn.itcast.core.pojo.item.Item;
import cn.itcast.core.pojo.item.ItemCat;
import cn.itcast.core.pojo.seckill.SeckillGoods;
import cn.itcast.core.pojo.seller.Seller;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import vo.GoodsVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 秒杀商品保存
 */
@Service
@Transactional
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsDescDao goodsDescDao;
    @Autowired
    private SeckillGoodsDao seckillGoodsDao;

    @Override
    public void add(GoodsVo vo) {
        //1:商品表 主键
        //默认是0:未审核  1:审核通过  2:审核不通过 3:关闭
        vo.getGoods().setAuditStatus("0");
        //上班的时候  数据库 真删除吗 假删除  逻辑删除  is_delete = 1 表示删除  is_delete = null 不删除
        //保存
        goodsDao.insertSelective(vo.getGoods());

        //2:商品详情表
        //主键
        vo.getGoodsDesc().setGoodsId(vo.getGoods().getId());
        goodsDescDao.insertSelective(vo.getGoodsDesc());

        //秒杀商品id
        vo.getSeckillGoods().setGoodsId(vo.getGoods().getId());
        //秒杀商品表的标题
        vo.getSeckillGoods().setTitle(vo.getGoods().getGoodsName());
        //秒杀商品表图片
        vo.getSeckillGoods().setSmallPic(vo.getGoodsDesc().getItemImages());
        //秒杀商品表的价格
        vo.getSeckillGoods().setPrice(vo.getGoods().getPrice());
        //秒杀商品表的商家id
        vo.getSeckillGoods().setSellerId(vo.getGoods().getSellerId());
        //秒杀商品表的添加日期
        vo.getSeckillGoods().setCreateTime(new Date());
        //秒杀商品表的审核状态
        vo.getSeckillGoods().setStatus("0");
        //秒杀商品表的描述
        vo.getSeckillGoods().setIntroduction(vo.getGoodsDesc().getIntroduction());
        seckillGoodsDao.insertSelective(vo.getSeckillGoods());

    }
}
