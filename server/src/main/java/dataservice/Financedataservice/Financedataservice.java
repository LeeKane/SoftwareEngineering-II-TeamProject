package dataservice.Financedataservice;

public interface Financedataservice {
public ResultMessage BalanceMan   (FinancePO po) ;
   
public ResultMessage CostMan   (BAccount ba，costchartPO po,);

public ResultMessage StatisticalChart  (statisticalchartPO po);

public ResultMessage BaccountReview(Baccount ba);

public ResultMessage BaccountInit  (BaccountPO po);

}
