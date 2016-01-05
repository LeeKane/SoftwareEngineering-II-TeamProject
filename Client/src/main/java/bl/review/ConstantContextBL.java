package bl.review;

import java.util.ArrayList;
import java.util.Iterator;

import blservice.reviewblservice.ConstantBLService;
import po.AccountPO;
import vo.ConstantVO;

public class ConstantContextBL {
	private ConstantBLService cons;

	public ConstantContextBL(ConstantBLService cons) {
		this.cons = cons;
	}

	public void setStrategy(ConstantBLService cons) {
		this.cons = cons;
	}

	public Iterator<ConstantVO> findAll() {
		return this.cons.findAll();
	}

	public boolean addConstant(ArrayList<ConstantVO> list) {
		return this.cons.addConstant(list);
	}
	
	public AccountPO getPo(){
		return this.cons.getPo();
	}
}
