package com.LL.springApp.bussiness;
import com.LL.springApp.repository.*;

public interface AggrTemplate {
	double performAggr(DataRepository drp,String operation,String id) ;

}
