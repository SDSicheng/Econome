package com.xust.ffms.service.impl;


import com.xust.ffms.dao.CuraccountMapper;
import com.xust.ffms.entity.Curaccount;
import com.xust.ffms.service.CuraccountService;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;
import com.xust.ffms.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CuraccountServiceImpl implements CuraccountService {
    @Resource
    CuraccountMapper mapper;
    @Override
    public Result<Curaccount> findByWhere(PageModel model) {

        List<Curaccount> bills = mapper.findByWhere(model);
        if (bills.size()>=0){
            Result<Curaccount> result = ResultUtil.success(bills);
            result.setTotal(mapper.getTotalByWhere(model));
            if (result.getTotal() == 0) {
                result.setMsg("No data was found");
            } else {
                result.setMsg("Data acquisition success");
            }
            return result;
        }else {
            return ResultUtil.unSuccess("Data acquisition failure！");
        }
    }

    @Override
    public int add(Curaccount curaccount) {
        return mapper.add(curaccount);
    }

    @Override
    public int update(Curaccount curaccount) {
        return mapper.update(curaccount);
    }

    @Override
    public int del(int id) {
        return mapper.del(id);
    }

    @Override
    public Result<Curaccount> findByWhereNoPage(Curaccount curaccount) {
        List<Curaccount> bills = mapper.findByWhereNoPage(curaccount);
        if (bills.size()>=0){
            Result<Curaccount> result = ResultUtil.success(bills);
            result.setMsg("Data acquisition success");
            return result;
        }else {
            return ResultUtil.unSuccess("No matching attribute was found！");
        }
    }

    @Override
    public String getMoney(Integer userid) {
        return mapper.getMoney(userid);
    }

}