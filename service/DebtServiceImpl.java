package com.xust.ffms.service.impl;

import com.xust.ffms.dao.DebtMapper;
import com.xust.ffms.entity.Debt;
import com.xust.ffms.service.DebtService;
import com.xust.ffms.utils.PageModel;
import com.xust.ffms.utils.Result;
import com.xust.ffms.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DebtServiceImpl implements DebtService {
    @Resource
    DebtMapper mapper;
    @Override
    public Result<Debt> findByWhere(PageModel model) {

        List<Debt> bills = mapper.findByWhere(model);
        if (bills.size()>=0){
            Result<Debt> result = ResultUtil.success(bills);
            result.setTotal(mapper.getTotalByWhere(model));
            if (result.getTotal() == 0) {
                System.out.println("1");
                result.setMsg("No data was found");
            } else {
                System.out.println("2");
                result.setMsg("Data acquisition success");
            }
            return result;
        }else {
            System.out.println("3");
            return ResultUtil.unSuccess("Data acquisition failure！");
        }
    }

    @Override
    public int add(Debt debt) {
        return mapper.add(debt);
    }

    @Override
    public int update(Debt debt) {
        return mapper.update(debt);
    }

    @Override
    public int del(int id) {
        return mapper.del(id);
    }

    @Override
    public Result<Debt> findByWhereNoPage(Debt debt) {
        List<Debt> bills = mapper.findByWhereNoPage(debt);
        if (bills.size()>=0){
            Result<Debt> result = ResultUtil.success(bills);
            System.out.println("4");
            result.setMsg("Data acquisition success");
            return result;
        }else {
            System.out.println("5");
            return ResultUtil.unSuccess("No matching attribute was found！");
        }
    }

}